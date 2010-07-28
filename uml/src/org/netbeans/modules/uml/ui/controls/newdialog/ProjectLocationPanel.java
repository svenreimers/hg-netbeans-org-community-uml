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

package org.netbeans.modules.uml.ui.controls.newdialog;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;


public class ProjectLocationPanel extends JPanel
    implements DocumentListener
{
    public ProjectLocationPanel()
    {
        initComponents();
		projectNameTextField.setText(NewDialogUtilities.getDefaultProjectName());
		projectNameTextField.selectAll();
		//set default Location text
		projectLocationTextField.setText(NewDialogUtilities.getWorkspaceLocation());

        // Register listener on the textFields to make the automatic updates
        projectNameTextField.getDocument().addDocumentListener(this);
        projectLocationTextField.getDocument().addDocumentListener(this);
    }
    
    
    public NewDialogProjectDetails getProjectDetails()
    {
        NewDialogProjectDetails details = new NewDialogProjectDetails();
		details.setName(projectNameTextField.getText().trim());
		details.setLocation(projectLocationTextField.getText().trim());
		return details;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        modelTypeButtonGroup = new javax.swing.ButtonGroup();
        projectNameLabel = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        projectLocationLabel = new javax.swing.JLabel();
        projectLocationTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();

        projectNameLabel.setLabelFor(projectNameTextField);
        org.openide.awt.Mnemonics.setLocalizedText(projectNameLabel, bundle.getString("LBL_ProjectName_Label"));
        projectNameLabel.getAccessibleContext().setAccessibleName("");
        projectNameLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ProjectLocationPanel.class, "ACSD_ProjectName"));

        projectNameTextField.getAccessibleContext().setAccessibleName("");
        projectNameTextField.getAccessibleContext().setAccessibleDescription("");

        projectLocationLabel.setLabelFor(projectLocationTextField);
        org.openide.awt.Mnemonics.setLocalizedText(projectLocationLabel, bundle.getString("LBL_ProjectLocation_Label"));
        projectLocationLabel.getAccessibleContext().setAccessibleName("");
        projectLocationLabel.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ProjectLocationPanel.class, "ACSD_ProjectLocation"));

        projectLocationTextField.getAccessibleContext().setAccessibleName("");
        projectLocationTextField.getAccessibleContext().setAccessibleDescription("");

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, bundle.getString("LBL_BrowseLocation_Button"));
        browseButton.setActionCommand("BROWSE");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseLocationAction(evt);
            }
        });

        browseButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ProjectLocationPanel.class, "ACSN_browseButton"));
        browseButton.getAccessibleContext().setAccessibleDescription(bundle.getString("ACSD_browseButton"));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(projectNameLabel)
                    .add(projectLocationLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(projectNameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .add(projectLocationTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(browseButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(projectNameLabel)
                    .add(projectNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(projectLocationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(projectLocationLabel)
                    .add(browseButton))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseLocationAction(java.awt.event.ActionEvent evt)//GEN-FIRST:event_browseLocationAction
    {//GEN-HEADEREND:event_browseLocationAction
       
		JFileChooser chooser = new JFileChooser();
		FileUtil.preventFileChooserSymlinkTraversal(chooser, null);

		chooser.setDialogTitle(
			bundle.getString("LBL_SelectProjectLocation")); // NOI18N

		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		String path = this.projectLocationTextField.getText();

		if (path.length() > 0)
		{
			File f = new File(path);

			if (f.exists())
				chooser.setSelectedFile(f);
		}

		if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this))
		{
			File projectDir = chooser.getSelectedFile();
			projectLocationTextField.setText(projectDir.getAbsolutePath());
		}
        
    }//GEN-LAST:event_browseLocationAction
    
   
    
    private static JFileChooser createChooser()
    {
        JFileChooser chooser = new JFileChooser();
        FileUtil.preventFileChooserSymlinkTraversal(chooser, null);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        chooser.setName(NbBundle.getMessage(
            ProjectLocationPanel.class,
            "LBL_SelectProjectLocation"));  // NOI18N
        
        return chooser;
    }
    

    public void changedUpdate(DocumentEvent event)
    {
      
    }
    
    public void insertUpdate( DocumentEvent event )
    {
       changedUpdate(event);
    }
    
    public void removeUpdate(DocumentEvent event)
    {
		changedUpdate(event);
    }
    
    


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.ButtonGroup modelTypeButtonGroup;
    private javax.swing.JLabel projectLocationLabel;
    private javax.swing.JTextField projectLocationTextField;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JTextField projectNameTextField;
    // End of variables declaration//GEN-END:variables
    
    private java.util.ResourceBundle bundle = 
        NbBundle.getBundle(ProjectLocationPanel.class);
    
}
