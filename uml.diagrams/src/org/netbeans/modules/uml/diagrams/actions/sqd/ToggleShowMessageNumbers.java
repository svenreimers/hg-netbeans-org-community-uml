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

import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import org.netbeans.modules.uml.diagrams.engines.SequenceDiagramEngine;
import org.netbeans.modules.uml.drawingarea.actions.SceneNodeAction;
import org.netbeans.modules.uml.drawingarea.actions.WidgetContext;
import org.netbeans.modules.uml.drawingarea.view.DesignerScene;
import org.openide.awt.Actions;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;



public class ToggleShowMessageNumbers extends SceneNodeAction
{
    private WidgetContext context = null;
    private DesignerScene scene;
    
    public ToggleShowMessageNumbers()
    {
        super();
    }
    
    @Override
    public Action createContextAwareInstance(Lookup actionContext)
    {
        context = actionContext.lookup(WidgetContext.class);
        scene = actionContext.lookup(DesignerScene.class);
        return this;
    }
    
    protected void performAction(Node[] activatedNodes)
    {
        SequenceDiagramEngine engine=(SequenceDiagramEngine) scene.getEngine();
        engine.setSettingValue(SequenceDiagramEngine.SHOW_MESSAGE_NUMBERS, engine.getSettingValue(SequenceDiagramEngine.SHOW_MESSAGE_NUMBERS)==Boolean.FALSE);
    }

    
    protected boolean enable(Node[] activatedNodes)
    {
        boolean retVal = false;
        
        if(super.enable(activatedNodes) == true && activatedNodes.length == 1)
        {
            scene = activatedNodes[0].getLookup().lookup(DesignerScene.class);
            
            if(scene != null)
            {
                 retVal=true;
            }
        }
        return retVal;
    }

    public String getName()
    {
        return NbBundle.getMessage(ToggleShowMessageNumbers.class, "LBL_SHOW_MESSAGE_NUMBERS");
    }

    public HelpCtx getHelpCtx()
    {
        return null;
    }

    @Override
    public JMenuItem getPopupPresenter()
    {   
        JCheckBoxMenuItem item=new JCheckBoxMenuItem(getName());
        SequenceDiagramEngine engine=(SequenceDiagramEngine) scene.getEngine();
        item.setSelected(engine.getSettingValue(SequenceDiagramEngine.SHOW_MESSAGE_NUMBERS)==Boolean.TRUE);
        
        Actions.connect(item, (Action)this, true);
        
        return item;
    }

    @Override
    public JMenuItem getMenuPresenter()
    {
        return super.getMenuPresenter();
    }
   
}
