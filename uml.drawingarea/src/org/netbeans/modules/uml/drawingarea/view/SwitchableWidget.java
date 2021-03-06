/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 * 
 * Contributor(s):
 * 
 * Portions Copyrighted 2008 Sun Microsystems, Inc.
 */
package org.netbeans.modules.uml.drawingarea.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IElement;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IPresentationElement;
import org.netbeans.modules.uml.core.metamodel.profiles.IStereotype;
import org.netbeans.modules.uml.drawingarea.NodeWidgetFactory;
import org.netbeans.modules.uml.drawingarea.persistence.NodeWriter;
import org.netbeans.modules.uml.drawingarea.persistence.data.NodeInfo;
import org.netbeans.modules.uml.drawingarea.util.Util;
import org.openide.cookies.InstanceCookie;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;



public abstract class SwitchableWidget extends UMLNodeWidget
{
    public static final String DEFAULT = "DEFAULT_VIEW"; // NOI18N
    
    private String metaType = "DataType";
    private String viewName = "";
    private ArrayList < ViewInformation > avaliableViews = new ArrayList < ViewInformation >();
    
    public SwitchableWidget(Scene scene, String metatype)
    {
        super(scene);
        
        this.metaType = metatype;
        addToLookup(new SwitchableViewManger());
        buildViewInformation();
    }
    
    public SwitchableWidget(Scene scene, String metatype, boolean useNodeDefaultResources)
    {
        super(scene, useNodeDefaultResources);
        
        this.metaType = metatype;
        addToLookup(new SwitchableViewManger());
        buildViewInformation();
    }

    @Override
    public void initializeNode(IPresentationElement element)
    {
        super.initializeNode(element);
        switchTo(getDefaultViewName(), element);
    }

    
    public abstract Widget createDefaultWidget(IPresentationElement element);
    
    public abstract void removingView();
    
    public void switchTo(String view)
    {
        switchTo(view, getObject());
    }
    
    public void switchTo(String view, IPresentationElement element)
    {
        if(viewName.equals(view) == false)
        {
            Widget newView = null;
            if(DEFAULT.equals(view) == true)
            {
                newView = createDefaultWidget(element);
            }
            else
            {
                newView = getView(view);
            }

            if(newView != null)
            {
                Widget curView = getCurrentView();
                if (curView instanceof ContextViewWidget)
                {
                    ContextViewWidget contextView = (ContextViewWidget) curView;
                    contextView.removingView();
                }
                else if(DEFAULT.equals(viewName) == true)
                {
                    removingView();
                }

                viewName = view;

                setCurrentView(newView);
                
                if(newView instanceof ContextViewWidget)
                {
                    ContextViewWidget contextWidget = (ContextViewWidget)newView;
                    contextWidget.showingView(element);
                }
                
                if(getLookup().lookup(WidgetShape.class) != null)
                {
                    removeFromLookup(getLookup().lookup(WidgetShape.class));
                }
                
                if(newView.getLookup().lookup(WidgetShape.class) != null)
                {
                    addToLookup(newView.getLookup().lookup(WidgetShape.class));
                }
                
                switchEdgeViewTo(viewName, element);
            }
            getScene().validate();
        }
    }
    
    protected void switchEdgeViewTo(String view, IPresentationElement node)
    {
        if (getScene() instanceof GraphScene)
        {
            GraphScene scene2 = (GraphScene) getScene();
            
            if(scene2.findWidget(node) == null)
            {
                // We are in an initalization state.  We have been added to the
                // scene, but the node has not been added to the graph yet.
                return;
            }
            
            Collection < IPresentationElement > edges = scene2.findNodeEdges(node, true, true);
            if(edges != null)
            {
                for(IPresentationElement edge : edges)
                {
                    Widget edgeWidget = scene2.findWidget(edge);
                    if(edgeWidget != null)
                    {
                        Lookup lookup = edgeWidget.getLookup();
                        WidgetViewManager manager = (WidgetViewManager)lookup.lookup(WidgetViewManager.class);
                        if(manager != null)
                        {
                            manager.switchViewTo(view);
                        }
                    }
                }
            }
        }

    }
    
    
/**
     * Retreives the metatype of the model element.
     * 
     * @return The model elements name.
     */
    public String getMetaType()
    {
        return metaType;
    }

    protected Widget getView(String viewName)
    {
        Widget retVal = null;
        
        for(ViewInformation info : avaliableViews)
        {
            if(viewName.equals(info.getId()) == true)
            {
                retVal = info.getViewInstance();
                break;
            }
        }
        
        return retVal;
    }
    
    protected ViewInformation[] getAvaliableViews()
    {
        List < ViewInformation > views = new ArrayList < ViewInformation >();
        
        String defaultName = NbBundle.getMessage(SwitchableWidget.class, 
                                                 "LBL_DefaultViewName",
                                                 getMetaType());
        
        views.add(new ViewInformation(defaultName, "", DEFAULT));
        
        IElement element = getObject().getFirstSubject();
        List < Object > stereotypes = element.getAppliedStereotypes();
        
        for(ViewInformation info : avaliableViews)
        {
            for(Object obj : stereotypes)
            {
                IStereotype stereotype = (IStereotype)obj;
                if(info.appliesTo(stereotype.getName()) == true)
                {
                    views.add(info);
                    continue;
                }
            }
        }
        
        ViewInformation[] retVal = new ViewInformation[views.size()];
        views.toArray(retVal);
        return retVal;
    }
    
    protected void buildViewInformation()
    {
        FileObject fo = FileUtil.getConfigFile("UML/Nodes/" + getMetaType() + "/Views");
        DataFolder df = fo != null ? DataFolder.findFolder(fo) : null;
        if (df != null)
        {
            DataObject[] viewObjects = df.getChildren();
            for (int i = 0; i < viewObjects.length; i++)
            {
                DataObject dObj = viewObjects[i];
                FileObject fObj = dObj.getPrimaryFile();

                String name = dObj.getNodeDelegate().getDisplayName();
                String stereotypes = (String)fObj.getAttribute("stereotypes");
                String id = (String)fObj.getAttribute("id");

                ViewInformation info = new ViewInformation(name, stereotypes, id);
                avaliableViews.add(info);

                InstanceCookie cookie = dObj.getCookie(InstanceCookie.class);
                info.setInstanceCookie(cookie);

            }
        }
    }
    
    
    protected String getDefaultViewName()
    {
        FileObject fo = FileUtil.getConfigFile("UML/Nodes/" + getMetaType() + "/Views");
        DataFolder df = fo != null ? DataFolder.findFolder(fo) : null;
        if (df != null)
        {
            DataObject[] views = df.getChildren();
            for (DataObject view: views)
            {
                if (this.getObject().getFirstSubject().getAppliedStereotypesList().equals(view.getPrimaryFile().getAttribute("stereotypes")))
                {
                    return (String)view.getPrimaryFile().getAttribute("id");
                }
            }
        }
        return DEFAULT;
    }
    

    @Override
    public void save(NodeWriter nodeWriter) {
        HashMap map = nodeWriter.getProperties();
        map.put(NodeInfo.VIEW_NAME, this.viewName);
        nodeWriter.setProperties(map);
        super.save(nodeWriter);
    }       
    
    public class SwitchableViewManger implements WidgetViewManager
    {

        @Override
        public Action[] getViewActions()
        {
            ViewInformation[] viewNames = getAvaliableViews();
            //Return an empty array if you get invalid values
            Action[] retVal = new Action[1];
            if (viewNames.length > 0) {
                // Since I do not want to include the view that is currently showing
                // the retVal will be one less then the viewNames
                retVal = new Action[viewNames.length - 1];

                int rIndex = 0;
                for (int index = 0; index < viewNames.length; index++) {
                    ViewInformation info = viewNames[index];
                    if (viewName.equals(info.getId()) == false) {
                        retVal[rIndex] = new SwitchViewAction(info);
                        rIndex++;
                    }
                }
            }
            return retVal;
        }
        
        @Override
        public void switchViewTo(String view)
        {
            switchTo(view);
        }
    }
    
    public class SwitchViewAction extends AbstractAction
    {
        private ViewInformation info = null;;
        
        public SwitchViewAction(ViewInformation info)
        {
            this.info = info;
            String displayName = NbBundle.getMessage(SwitchableWidget.class, 
                                                     "LBL_ViewActionName",
                                                     info.getName());
            putValue(NAME, displayName);
        }
        
        @Override
        public void actionPerformed(ActionEvent event)
        {
            switchTo(info.getId());
        }
    }
    
    public class ViewInformation
    {
        private String name = "";
        private String id = "";
        private ArrayList < String > stereotypeList = new ArrayList < String >();
        private InstanceCookie cookie = null;
        
        public ViewInformation(String name, String stereotypes, String id)
        {
            this.name = name;
            this.id = id;
            
            if((stereotypes != null) && (stereotypes.length() > 0))
            {
                String[] stereotypeArray = stereotypes.split(",");
                for(String stereotype : stereotypeArray)
                {
                    stereotypeList.add(stereotype.trim());
                }
            }
        }

        public String getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public Widget getViewInstance()
        {
            Widget retVal = null;
            
            if(cookie != null)
            {
                try
                {
                    Object instance = cookie.instanceCreate();
                    if (instance instanceof NodeWidgetFactory)
                    {
                        NodeWidgetFactory factory = (NodeWidgetFactory) instance;
                        retVal = factory.createNode(scene);
                    }
                }
                catch (Exception e)
                {
                    Exceptions.printStackTrace(e);
                }
            }
            
            return retVal;
        }

        public void setInstanceCookie(InstanceCookie cookie)
        {
            this.cookie = cookie;
        }

        private boolean appliesTo(String name)
        {
            return stereotypeList.contains(name);
        }
        
        
    }
    
    @Override
    public void refresh(boolean resizetocontent)
    {
        String oldViewName = viewName;
        
        removingView();
        viewName = "";
   
        initializeNode(getObject());
        //Rectangle bounds = getBounds();
        switchTo(oldViewName);
        //setPreferredBounds(bounds);
        scene.validate();
        if(resizetocontent)Util.resizeNodeToContents(this);
    }
    
    @Override
    public void duplicate(boolean setBounds, Widget target)
    {
        super.duplicate(setBounds, target);        
        if (target instanceof SwitchableWidget)
        {
            IPresentationElement pElt = (IPresentationElement) scene.findObject(target);
            if (pElt == null)
            {
                pElt = (IPresentationElement) ((GraphScene) target.getScene()).findObject(target);
            }
            if (pElt != null)
            {
                ((SwitchableWidget)target).switchTo(viewName,pElt);
            }            
        }
    }
        
}
