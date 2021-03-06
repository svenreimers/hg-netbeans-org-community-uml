/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2010 Oracle and/or its affiliates. All rights reserved.
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
package org.netbeans.modules.uml.drawingarea.actions;

import java.util.Collections;
import org.netbeans.api.visual.action.CycleFocusProvider;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.model.ObjectScene;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modules.uml.drawingarea.palette.context.ContextPaletteManager;
import org.netbeans.modules.uml.drawingarea.util.Util;



public class CycleObjectSceneSelectProvider implements CycleFocusProvider
{

    public boolean switchPreviousFocus(Widget widget)
    {
            Scene scene = widget.getScene();
        return scene instanceof ObjectScene && switchFocus((ObjectScene) scene, false);
    }

    public boolean switchNextFocus(Widget widget)
    {
        Scene scene = widget.getScene();
        return scene instanceof ObjectScene && switchFocus((ObjectScene) scene, true);
    }

    @SuppressWarnings("unchecked")
    private boolean switchFocus(ObjectScene scene, boolean forwardDirection)
    {
        GraphScene graphScene = (GraphScene)scene;
        
        Object object = scene.getFocusedObject();
        Comparable identityCode = scene.getIdentityCode(object);

        Object bestObject = null;
        Comparable bestIdentityCode = null;

        if (identityCode != null)
        {
            for (Object o : scene.getObjects())
            {
                // This way I make sure only nodes and edges are processed.  I 
                // do not want things like labels processed.
                if((graphScene.isNode(o) == true) || (graphScene.isEdge(o) == true))
                {
                    Comparable ic = scene.getIdentityCode(o);
                    if (forwardDirection)
                    {
                        if (identityCode.compareTo(ic) < 0)
                        {
                            if (bestIdentityCode == null || bestIdentityCode.compareTo(ic) > 0)
                            {
                                bestObject = o;
                                bestIdentityCode = ic;
                            }
                        }
                    }
                    else
                    {
                        if (identityCode.compareTo(ic) > 0)
                        {
                            if (bestIdentityCode == null || bestIdentityCode.compareTo(ic) < 0)
                            {
                                bestObject = o;
                                bestIdentityCode = ic;
                            }
                        }
                    }
                }
            }
        }

        if (bestIdentityCode == null)
        {
            for (Object o : scene.getObjects())
            {
                // Fix issue 147878. Made sure that we only select nodes and edges
                if ((graphScene.isNode(o) == true) || (graphScene.isEdge(o) == true))
                {
                    Comparable ic = scene.getIdentityCode(o);
                    if (forwardDirection)
                    {
                        if (bestIdentityCode == null || bestIdentityCode.compareTo(ic) > 0)
                        {
                            bestObject = o;
                            bestIdentityCode = ic;
                        }
                    } else
                    {
                        if (bestIdentityCode == null || bestIdentityCode.compareTo(ic) < 0)
                        {
                            bestObject = o;
                            bestIdentityCode = ic;
                        }
                    }
                }
            }
        }
        
        ContextPaletteManager manager = scene.getLookup().lookup(ContextPaletteManager.class);
        if(manager != null)
        {
            manager.cancelPalette();
        }
        
        Util.makeSureWidgetIsVisible(scene.findWidget(bestObject));
        scene.setFocusedObject(bestObject);
        scene.userSelectionSuggested(Collections.singleton(bestObject), false);
        return true;
    }
}
