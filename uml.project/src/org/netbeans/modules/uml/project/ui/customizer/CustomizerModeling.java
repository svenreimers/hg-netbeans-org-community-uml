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

package org.netbeans.modules.uml.project.ui.customizer;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JLabel;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

import org.netbeans.modules.uml.project.UMLProject;
import org.netbeans.modules.uml.project.ui.common.ReferencedJavaProjectPanel;
import org.netbeans.modules.uml.project.ui.common.ReferencedJavaProjectModel;
import org.netbeans.modules.uml.project.ui.customizer.uiapi.CustomizerPane;


/**
 *
 * @author  Mike Frisino
 */
public class CustomizerModeling extends javax.swing.JPanel 
    implements HelpCtx.Provider
{
    UMLProjectProperties mUIProperties = null;
    
    public CustomizerModeling(UMLProjectProperties uiProperties)
    {
        mUIProperties = uiProperties;
        initComponents();
        addJavaProjectPanel(uiProperties);
        addMessageLabel(uiProperties);
        FileObject projectFolder = uiProperties.getProject().getProjectDirectory();
        File pf = FileUtil.toFile(projectFolder);
        projectLocation.setText(pf == null ? "" : pf.getPath()); // NOI18N
        String modelingMode = uiProperties.getCurrentProjectMode();
        
        if (modelingMode != null && modelingMode.equals(UMLProject.PROJECT_MODE_ANALYSIS_STR)) 
             disableAllComponents();
        
        testBroken();        
    }
    
    public HelpCtx getHelpCtx()
    {
        return new HelpCtx(CustomizerModeling.class);
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        projectLocation = new javax.swing.JTextField();
        jPanelCentral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
        jLabel1.setLabelFor(projectLocation);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/netbeans/modules/uml/project/ui/customizer/Bundle"); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, bundle.getString("LBL_ProjectFolderLabel")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 12);
        add(jLabel1, gridBagConstraints);
        jLabel1.getAccessibleContext().setAccessibleName("");
        jLabel1.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_ProjectFolderLabel")); // NOI18N

        projectLocation.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        add(projectLocation, gridBagConstraints);
        projectLocation.getAccessibleContext().setAccessibleName("");
        projectLocation.getAccessibleContext().setAccessibleDescription("");

        jPanelCentral.setLayout(new java.awt.BorderLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.45;
        add(jPanelCentral, gridBagConstraints);
        jPanelCentral.getAccessibleContext().setAccessibleName("");
        jPanelCentral.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setLayout(new java.awt.GridBagLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(jPanel1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void addJavaProjectPanel(UMLProjectProperties uiProperties)
    {
        javaProjectPanel = new ReferencedJavaProjectPanel(uiProperties);
        jPanelCentral.add(javaProjectPanel, java.awt.BorderLayout.CENTER);
        javaProjectPanel.addPropertyChangeListener(mChangeListener);
        
        javaProjectPanel.addPropertyChangeListener(
            ReferencedJavaProjectPanel.JAVA_PROJECT_CHANGED_PROP, 
            mChangeListener);
        
        javaProjectPanel.addPropertyChangeListener(
            ReferencedJavaProjectPanel.SOURCE_GROUP_CHANGED_PROP, 
            mChangeListener);
    }
    
    private void addMessageLabel(UMLProjectProperties uiProperties)
    {   
        //messageLabel = new JTextArea();
        messageLabel = new JLabel();
//        messageLabel.setLineWrap(true);
//        messageLabel.setWrapStyleWord(true);
        messageLabel.setOpaque(false);
//        messageLabel.setEditable(false);
//        messageLabel.setRows(2);
        jPanelCentral.add(messageLabel, java.awt.BorderLayout.SOUTH);
        
    }
    
    private void disablePanel (javax.swing.JPanel panel) 
    {
        Component[] components = panel.getComponents();
        for (Component comp : components)
        {
            if (!(comp instanceof javax.swing.JLabel)) 
            {
                if (comp.isEnabled())
                    comp.setEnabled(false);
            }
        }
    }
        
    private void disableAllComponents() {
//        disablePanel(codeGenPanel);
        disablePanel(javaProjectPanel);
    }
        
    private void testBroken()
    {
        boolean isBroken = false;
        
        if (mUIProperties.referencedJavaProjectModel.getRefStatus() == 
            ReferencedJavaProjectModel.ReferenceStatus.REF_STATUS_BROKEN)
        {
            isBroken = true;
        }
        
        if (isBroken == true)
        {
            messageLabel.setText(
                NbBundle.getMessage(
                CustomizerModeling.class, 
                "LBL_CustomizeModeling_Reference_Error"));
        }
        
        else
            messageLabel.setText(" ");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JTextField projectLocation;
    // End of variables declaration//GEN-END:variables
    
//    private PanelProjectMode projectModePanel;
//    private PanelCodeGen codeGenPanel;
    private ReferencedJavaProjectPanel javaProjectPanel;
    //private JTextArea messageLabel = null;
    private JLabel messageLabel = null;
    private ModeChangeListener mChangeListener = new ModeChangeListener();
    
    public class ModeChangeListener implements PropertyChangeListener
    {
        private boolean mIsEnabled = true;
        
        public void propertyChange(PropertyChangeEvent evt)
        {
            if (ReferencedJavaProjectPanel.ASSOCIATED_JAVA_PROJ_PROP
                .equals(evt.getPropertyName()) == true)
            {
                testBroken();
                
                firePropertyChange(
                    CustomizerPane.OK_ENABLE_PROPERTY, mIsEnabled, true);
                
                mIsEnabled = true;
            }
            
            else if (ReferencedJavaProjectPanel.SOURCE_GROUP_CHANGED_PROP
                .equals(evt.getPropertyName())) 
            {  
                String message = "";
                Object newVal = evt.getNewValue();
                boolean enabled = true;
                
                if (newVal instanceof Boolean) 
                    enabled = ((Boolean) newVal).booleanValue();
 
                if (!enabled) 
                {
                    message = NbBundle.getMessage(
                        CustomizerModeling.class, "SourceGroup_Warning"); //NOI18N 
                }
                
                messageLabel.setText(message); 
                
                firePropertyChange(
                    CustomizerPane.OK_ENABLE_PROPERTY, mIsEnabled, enabled);
                
                mIsEnabled = enabled;
            }
            
//            else if(ReferencedJavaProjectPanel.JAVA_PROJECT_CHANGED_PROP
//                .equals(evt.getPropertyName()))
//            {
//
//            }
        }
    }
}
