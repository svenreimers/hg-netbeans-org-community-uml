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
 * Portions Copyrighted 2007 Sun Microsystems, Inc.
 */
package org.netbeans.modules.uml.diagrams.nodes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.netbeans.api.visual.border.Border;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IPresentationElement;
import org.netbeans.modules.uml.core.metamodel.structure.IArtifact;
import org.netbeans.modules.uml.drawingarea.palette.context.DefaultContextPaletteModel;
import org.netbeans.modules.uml.drawingarea.view.ResourceValue;
import org.netbeans.modules.uml.drawingarea.view.UMLLabelWidget;
import org.netbeans.modules.uml.drawingarea.view.UMLNodeWidget;



public class ArtifactWidget extends UMLNodeWidget implements PropertyChangeListener
{
    private UMLNameWidget nameWidget = null;
    private IPresentationElement pe = null;
   
    public ArtifactWidget(Scene scene)
    {
        super(scene, true);
        addToLookup(initializeContextPalette());
    }
    
    public ArtifactWidget(Scene scene, IPresentationElement pe)
    {
        this(scene);
        this.pe = pe;
        initializeNode(pe);
        addToLookup(initializeContextPalette());
    }

    protected DefaultContextPaletteModel initializeContextPalette()
    {
        DefaultContextPaletteModel paletteModel = new DefaultContextPaletteModel(this);
        paletteModel.initialize("UML/context-palette/Artifact");
        return paletteModel;
    }
    
    @Override
    public void initializeNode(IPresentationElement presentation)
    {
        IArtifact type = (IArtifact) presentation.getFirstSubject();
        setCurrentView(createArtifactView(type));
        setOpaque(true);
        ResourceValue.initResources(getResourcePath(), this);
        setFont(getCurrentView().getFont());
        super.initializeNode(presentation);
    }

    public Widget createArtifactView(IArtifact type)
    {
        Widget retVal = new Widget(getScene());
        retVal.setForeground((Color)null);
        retVal.setBackground((Paint)null);
        
        retVal.setLayout(LayoutFactory.createVerticalFlowLayout());
        
        LabelWidget keywordWidget = new UMLLabelWidget(getScene());
        keywordWidget.setBackground((Paint)null); 
        keywordWidget.setForeground((Color)null);
        keywordWidget.setLabel("<<artifact>>"); //NOI18N
        keywordWidget.setAlignment(LabelWidget.Alignment.CENTER);
        retVal.addChild(keywordWidget);
        
        nameWidget = new UMLNameWidget(getScene(), getWidgetID());
        nameWidget.initialize(type);
        retVal.addChild(nameWidget);
        
        Border lineBorder = BorderFactory.createLineBorder(1, Color.BLACK);
        Border emptyBorder = BorderFactory.createEmptyBorder(5);
        retVal.setBorder(BorderFactory.createCompositeBorder(lineBorder, emptyBorder));

        return retVal;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event)
    {
        nameWidget.propertyChange(event);
    }
 
    
    
    @Override
    protected void paintBackground()
    {
        if(nameWidget != null)
        {
            Paint bg = getBackground();

            // TODO: Need to test if gradient paint preference is set.
            if((bg instanceof Color) && (useGradient == true))
            {
                Rectangle bounds = getClientArea();
                float midX = bounds.width / 2;

                Color bgColor = (Color)bg;
                GradientPaint paint = new GradientPaint(midX, 0, Color.WHITE,
                                                        midX, getBounds().height, 
                                                        bgColor);
                Graphics2D g = getGraphics();
                g.setPaint(paint);
                g.fillRect(0, 0, bounds.width, bounds.height);
            }
            else
            {
                super.paintBackground();
            }
        }
    }
    
    @Override
    public String getWidgetID() {
        return UMLWidgetIDString.ARTIFACTWIDGET.toString();
    }
    
    @Override
     protected String getResourcePath()
    {
        return pe==null? super.getResourcePath() : pe.getFirstSubjectsType() + "." + super.getResourcePath();
    }
}
