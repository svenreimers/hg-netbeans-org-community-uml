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


package org.netbeans.modules.uml.core.workspacemanagement;

import org.netbeans.modules.uml.common.ETSystem;
import org.netbeans.modules.uml.core.support.umlsupport.IResultCell;



public class TestWSProjectListener implements IWSProjectEventsSink
{
    
   
/* (non-Javadoc)
    */
    public void onWSProjectPreCreate( IWorkspace space, String projectName, IResultCell cell )
    {
        ETSystem.out.println("onWSProjectPreCreate: " + space.getName() + " Project Name: " + projectName);
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectCreated( IWSProject project, IResultCell cell )
    {
        ETSystem.out.println("onWSProjectCreated: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectPreOpen(IWorkspace space, String projName, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectPreOpen: " + space.getName() + " Project Name: " + projName);
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectOpened(IWSProject project, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectOpened: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectPreRemove(IWSProject project, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectPreRemove: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectRemoved(IWSProject project, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectRemoved: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectPreInsert(IWorkspace space, String projectName, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectPreInsert: " + space.getName() + " Project Name: " + projectName);
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectInserted(IWSProject project, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectInserted: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectPreRename(IWSProject project, String newName, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectPreRename: " + project.getName() + " New Project Name: " + newName);
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectRenamed( IWSProject project, String oldName, IResultCell cell )
    {
        ETSystem.out.println("onWSProjectRenamed: " + project.getName() + " Project Old Name: " + oldName);
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectPreClose( IWSProject project, IResultCell cell )
    {
        ETSystem.out.println("onWSProjectPreClose: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectClosed( IWSProject project, IResultCell cell )
    {
        ETSystem.out.println("onWSProjectClosed: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectPreSave(IWSProject project, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectPreSave: " + project.getName());
        
    }
    
   
/* (non-Javadoc)
    */
    public void onWSProjectSaved(IWSProject project, IResultCell cell)
    {
        ETSystem.out.println("onWSProjectSaved: " + project.getName());
        
    }
    
}
