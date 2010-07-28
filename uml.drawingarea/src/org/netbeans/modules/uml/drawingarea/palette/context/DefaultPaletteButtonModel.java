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
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
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
 */
package org.netbeans.modules.uml.drawingarea.palette.context;

import java.awt.Image;
import java.util.ArrayList;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.modules.uml.drawingarea.actions.ConnectAction;
import org.netbeans.modules.uml.drawingarea.actions.SceneConnectProvider;
import org.netbeans.modules.uml.drawingarea.dataobject.ContextPaletteItem;
import org.netbeans.modules.uml.drawingarea.palette.NodeInitializer;
import org.netbeans.modules.uml.drawingarea.palette.RelationshipFactory;
import org.netbeans.modules.uml.drawingarea.view.DesignerScene;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataShadow;


/**
 *
 * @author treyspiva
 */
public class DefaultPaletteButtonModel implements ContextPaletteButtonModel
{
    private Image image = null;
    private String name = "";
    private String connectionType = "";
    private String defaultTargetType = "";
    private String tooltip = "";
    private RelationshipFactory factory = null;
    private ContextPaletteModel paletteModel = null;
    private String stereotype = "";
    private NodeInitializer defaulttargetInitializer;
        
    public DefaultPaletteButtonModel()
    {
        
    }
    
    public DefaultPaletteButtonModel(Image  image,
                                  String tooltip)
    {
        setImage(image);
        this.tooltip = tooltip;
    }
    
    public void initialize(DataObject dObj)
    {
        FileObject fo = dObj.getPrimaryFile();
        
        connectionType = (String)fo.getAttribute("element_type");
        
        if((connectionType == null) || (connectionType.length() <= 0))
        {
            ContextPaletteItem item = dObj.getLookup().lookup(ContextPaletteItem.class);
            connectionType = item.getElementType();
        }
        
        defaultTargetType = (String)fo.getAttribute("default-node");
        defaulttargetInitializer=(NodeInitializer)fo.getAttribute("default-node-initializer");
        factory = (RelationshipFactory) fo.getAttribute("factory");
        stereotype = (String)fo.getAttribute("stereotype");
        
        // If the factory does not exist it may because we have a shadow.
        if((factory == null) && (dObj instanceof DataShadow))
        {
            DataObject original = ((DataShadow)dObj).getOriginal();
            FileObject originalFO = original.getPrimaryFile();
            factory = (RelationshipFactory) originalFO.getAttribute("factory");
        }
    }
    
    public WidgetAction[] createActions(Scene scene)
    {
        WidgetAction[] retVal = new WidgetAction[0];
        
        if(scene instanceof DesignerScene)
        {
            DesignerScene designScene = (DesignerScene)scene;
            SceneConnectProvider connector = new SceneConnectProvider(getDefaultTargetType(),
                                                                      getStereotype());
            connector.setRelationshipFactory(getFactory());
            connector.setDefaultNodeInitializer(getDefaultNodeInitializer());
            
            LayerWidget layer = designScene.getInterractionLayer();
            WidgetAction action = new ConnectAction(new ContextPaletteConnectDecorator(),
                                                                    layer, 
                                                                    connector);
            
            retVal = new WidgetAction[] {action};
        }

        return retVal; 
    }
    
    public boolean isGroup()
    {
        return false;
    }
    
    public ArrayList<ContextPaletteButtonModel> getChildren()
    {
        return new ArrayList<ContextPaletteButtonModel>();
    }
    
    public void setPaletteModel(ContextPaletteModel model)
    {
        paletteModel = model;
    }
    
    public ContextPaletteModel getPaletteModel()
    {
        return paletteModel;
    }
    
    ///////////////////////////////////////////////////////////////
    // Data Accessors
    
    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getConnectionType()
    {
        return connectionType;
    }

    public String getDefaultTargetType()
    {
        return defaultTargetType;
    }

    public String getTooltip()
    {
        return tooltip;
    }

    public void setTooltip(String tooltip)
    {
        this.tooltip = tooltip;
    }

    public RelationshipFactory getFactory()
    {
        return factory;
    }

    public void setFactory(RelationshipFactory factory)
    {
        this.factory = factory;
    }

    public String getStereotype()
    {
        return stereotype;
    }

    public void setStereotype(String stereotype)
    {
        this.stereotype = stereotype;
    }

    private NodeInitializer getDefaultNodeInitializer() {
        return defaulttargetInitializer;
    }
    
    
}
