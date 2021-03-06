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

package org.netbeans.modules.uml.diagrams.actions.sqd;

import java.awt.Point;
import org.netbeans.api.visual.action.MoveProvider;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modules.uml.diagrams.edges.sqd.MessageWidget;
import org.netbeans.modules.uml.diagrams.engines.SequenceDiagramEngine;
import org.netbeans.modules.uml.diagrams.nodes.sqd.ExecutionSpecificationThinWidget;
import org.netbeans.modules.uml.diagrams.nodes.sqd.MessagePinWidget;
import org.netbeans.modules.uml.drawingarea.UMLDiagramTopComponent;
import org.netbeans.modules.uml.drawingarea.actions.AfterValidationExecutor;
import org.netbeans.modules.uml.drawingarea.view.DesignerScene;
import org.openide.windows.TopComponent;



public class ThinExecutionSpecificationMoveProvider implements MoveProvider {

    private Point original;
    private ArrangeMoveWithBumping moveHelper;
    private MessageWidget message=null;

    public void movementStarted(Widget widget) {
        ExecutionSpecificationThinWidget eSpec=(ExecutionSpecificationThinWidget) widget;
        original=eSpec.getPreferredLocation();
        //find opposite execution specification and MessageWidget
        for(Widget i: eSpec.getChildren())
        {
            if(i instanceof MessagePinWidget)// first one always main one?
            {
                MessagePinWidget tmp=(MessagePinWidget) i;//use first one, may be TBD to check later if there is different messages from one ex specification
                message=(MessageWidget) tmp.getConnection(0);
                break;
            }
        }
        moveHelper=new ArrangeMoveWithBumping(message,null,null);
    }

    public void movementFinished(Widget widget) {
        widget.getScene().revalidate();
        original=null;
        message=null;
        DesignerScene scene=(DesignerScene) widget.getScene();
        SequenceDiagramEngine engine=(SequenceDiagramEngine) scene.getEngine();
        engine.normalizeLifelines(true, false, null);//move messages are always considered down, to avoid collaps of manually expanded lifelines
        if (widget.getScene() instanceof DesignerScene)
        {
            TopComponent topComp = ((DesignerScene) widget.getScene()).getTopComponent();
            if (topComp instanceof UMLDiagramTopComponent)
            {
                ((UMLDiagramTopComponent) topComp).setDiagramDirty(true);
            }
        }
        //new AfterValidationExecutor(new UpdateMessagesInModel(moveHelper.getAllMovedMessages()),widget.getScene());
        moveHelper=null;
    }

    public Point getOriginalLocation(Widget widget) {
        return original;
    }

    public void setNewLocation(Widget widget, Point location) {
        int dy=location.y-original.y;
        //original.y=location.y;//usage of moveHelper requires delta
        int shifted=0;
        //
        if(dy<0)
        {
            //move up
            shifted=moveHelper.moveUp(dy);
        }
        else if(dy>0)
        {
            shifted=moveHelper.moveDown(dy);
        }
        widget.getScene().validate();
        original.y+=shifted;
    }

}
