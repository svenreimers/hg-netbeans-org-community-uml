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





package org.netbeans.test.umllib;

import org.netbeans.jellytools.NewProjectNameLocationStepOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JComboBoxOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTableOperator ;



public class NewUMLProjectStepOperator extends NewProjectNameLocationStepOperator{
    private JButtonOperator _btAddJavaProject = null;
    
    /** Creates a new instance of NewUMLProjectWizardOperator */
    public NewUMLProjectStepOperator() {
    }
    
    
/** Returns operator of "Add Java Project..." button.
     * @return  JButtonOperator instance of "Add Java Project..." button
     */
    
/*public JButtonOperator btAddJavaProject() {
        if (_btAddJavaProject == null) {
            _btAddJavaProject = new JButtonOperator(this, LabelsAndTitles.UML_WIZARD_ADD_JAVA_PROJECT_CAPTION);
        }
        return _btAddJavaProject;
    }*/
    
    
/**
     * Pushes "Add Java Project..." button.
     * @return 
     */
    
/*public void addJavaProject() {
        btAddJavaProject().push();
    }
    
    public void addJavaProjectNoBlock() {
        btAddJavaProject().pushNoBlock();
    }*/
    
    public JTextFieldOperator txtRoseModelFile(){
        return new JTextFieldOperator(this, 3);
    }
    
    
/**
     * 
     * @return 
     */
    public JComboBoxOperator cbMode(){
        return new JComboBoxOperator(this);
    }
     
    
/**
     * 
     * @param folderName 
     */
    public void selectJavaSourcePackageFolder(String folderName) {
        JTableOperator oper = new JTableOperator(this);
        oper.setAutoscrolls(true);
        // check each row
        for(int i=0;i<oper.getRowCount();i++) {
            // if second column's folder matches then select that row
            if(oper.getValueAt(i, 2).toString().endsWith(folderName)) {
                oper.clickOnCell(i, 0);
                break ;
            }
            
        }
        
    }
}
