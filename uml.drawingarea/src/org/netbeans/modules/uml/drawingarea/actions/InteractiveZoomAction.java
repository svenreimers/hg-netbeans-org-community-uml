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
package org.netbeans.modules.uml.drawingarea.actions;

import java.awt.Point;
import java.awt.event.MouseEvent;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modules.uml.drawingarea.SQDDiagramTopComponent;
import org.netbeans.modules.uml.drawingarea.ZoomManager;
import org.netbeans.modules.uml.drawingarea.view.DesignerScene;

/**
 *
 */
public class InteractiveZoomAction extends WidgetAction.Adapter
{

    private Scene scene;
    private Point lastLocation;
    private double zoomMultiplier;

    @Override
    public State mousePressed(Widget widget, WidgetMouseEvent event)
    {
        if (event.getButton() == MouseEvent.BUTTON1)
        {
            scene = widget.getScene();
            lastLocation = event.getPoint();
            lastLocation = widget.getScene().convertSceneToView(lastLocation);
            
            return State.CONSUMED;
        }
        return State.REJECTED;
    }

    @Override
    public State mouseReleased(Widget widget, WidgetMouseEvent event)
    {
        return State.REJECTED;
    }

    @Override
    public State mouseDragged(Widget widget, WidgetMouseEvent event)
    {
        if (scene != widget.getScene())
        {
            return State.REJECTED;
        }

        Point newLocation = event.getPoint();
        newLocation = widget.getScene().convertSceneToView(newLocation);

        int amount = lastLocation.y - newLocation.y;

        double zoom = scene.getZoomFactor();
        zoomMultiplier = 1 + Math.abs(amount)/(zoom*100)/5;
        if (amount > 0 && zoom < (double)ZoomManager.MAX_ZOOM_PERCENT/100)
        {        
            zoom *= zoomMultiplier;
            zoom = Math.min(zoom, (double)ZoomManager.MAX_ZOOM_PERCENT/100);
        } else if (amount < 0 && zoom > (double)ZoomManager.MIN_ZOOM_PERCENT/100)
        {
            zoom /= zoomMultiplier;
            zoom = Math.max(zoom, (double)ZoomManager.MIN_ZOOM_PERCENT/100);
        }
        
        if(scene instanceof DesignerScene)
        {
            DesignerScene ds=(DesignerScene) scene;
            if(ds.getTopComponent() instanceof SQDDiagramTopComponent)
            {
                SQDDiagramTopComponent tc=(SQDDiagramTopComponent) ds.getTopComponent();
                tc.getTrackBar().onPostScrollZoom();
            }
        }
        
        if (zoom != scene.getZoomFactor())
        {                      
            scene.setZoomFactor(zoom);           
        }
        
        lastLocation = newLocation;
        return State.CONSUMED;
    }
}
