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

import org.netbeans.modules.uml.project.ui.UMLProjectSettings;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.ant.AntArtifact;
import org.netbeans.api.project.ant.AntArtifactQuery;
import org.netbeans.spi.project.ui.support.ProjectChooser;
import org.openide.DialogDisplayer;
import org.openide.ErrorManager;
import org.openide.NotifyDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;



public class AntArtifactChooser extends JPanel implements PropertyChangeListener {
    
    // XXX to become an array later
    private String artifactType;
    
    /** Creates new form JarArtifactChooser */
    public AntArtifactChooser( String artifactType, JFileChooser chooser ) {
        this.artifactType = artifactType;
        
        initComponents();
        jListArtifacts.setModel( new DefaultListModel() );
        chooser.addPropertyChangeListener( this );
    }
    
    
/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelJarFiles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListArtifacts = new javax.swing.JList();

        setLayout(new java.awt.GridBagLayout());

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
        jLabelName.setLabelFor(jTextFieldName);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 2, 0);
        add(jLabelName, gridBagConstraints);
        jLabelName.getAccessibleContext().setAccessibleName("");
        jLabelName.getAccessibleContext().setAccessibleDescription("");

        jTextFieldName.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 6, 0);
        add(jTextFieldName, gridBagConstraints);
        jTextFieldName.getAccessibleContext().setAccessibleName("");
        jTextFieldName.getAccessibleContext().setAccessibleDescription("");

        jLabelJarFiles.setLabelFor(jListArtifacts);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 2, 0);
        add(jLabelJarFiles, gridBagConstraints);
        jLabelJarFiles.getAccessibleContext().setAccessibleName("");
        jLabelJarFiles.getAccessibleContext().setAccessibleDescription("");

        jScrollPane1.setViewportView(jListArtifacts);
        jListArtifacts.getAccessibleContext().setAccessibleName("");
        jListArtifacts.getAccessibleContext().setAccessibleDescription("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(jScrollPane1, gridBagConstraints);
        jScrollPane1.getAccessibleContext().setAccessibleName("");
        jScrollPane1.getAccessibleContext().setAccessibleDescription("");

    }// </editor-fold>//GEN-END:initComponents
    
    
    public void propertyChange(PropertyChangeEvent e) {
        if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(e.getPropertyName())) {
            // We have to update the Accessory
            JFileChooser chooser = (JFileChooser) e.getSource();
            File dir = chooser.getSelectedFile(); // may be null (#46744)
            Project project = getProject(dir); // may be null
            populateAccessory(project);
        }
    }
    
    private Project getProject( File projectDir ) {
        
        if (projectDir == null) { // #46744
            return null;
        }
        
        try {            
            File normProjectDir = FileUtil.normalizeFile(projectDir);
            FileObject fo = FileUtil.toFileObject(normProjectDir);
            if (fo != null) {
                return ProjectManager.getDefault().findProject(fo);
            }
        } catch (IOException e) {
            ErrorManager.getDefault().notify(ErrorManager.INFORMATIONAL, e);
            // Return null
        }
        
        return null;
    }    
    
    
/**
     * Set up GUI fields according to the requested project.
     * @param project a subproject, or null
     */
    private void populateAccessory( Project project ) {
        
        DefaultListModel model = (DefaultListModel)jListArtifacts.getModel();
        model.clear();
        jTextFieldName.setText(project == null ? "" : ProjectUtils.getInformation(project).getDisplayName()); //NOI18N
        
        if ( project != null ) {
                        
            AntArtifact artifacts[] = AntArtifactQuery.findArtifactsByType( project, artifactType );
        
            for( int i = 0; i < artifacts.length; i++ ) {
                URI uris[] = artifacts[i].getArtifactLocations();
                for( int y = 0; y < uris.length; y++ ) {
                    model.addElement( new ArtifactItem(artifacts[i], uris[y]));
                }
            }
            jListArtifacts.setSelectionInterval(0, model.size());
        }
        
    }
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelJarFiles;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JList jListArtifacts;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    
    
/** Shows dialog with the artifact chooser 
     * @return null if canceled selected jars if some jars selected
     */
    public static ArtifactItem[] showDialog( String artifactType, Project master, Component parent ) {
        
        JFileChooser chooser = ProjectChooser.projectChooser();
        chooser.setDialogTitle( NbBundle.getMessage( AntArtifactChooser.class, "LBL_AACH_Title" ) ); // NOI18N
        chooser.setApproveButtonText( NbBundle.getMessage( AntArtifactChooser.class, "LBL_AACH_SelectProject" ) ); // NOI18N
        chooser.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage (AntArtifactChooser.class,"AD_AACH_SelectProject"));
        AntArtifactChooser accessory = new AntArtifactChooser( artifactType, chooser );
        chooser.setAccessory( accessory );
        chooser.setPreferredSize( new Dimension( 650, 380 ) );
        chooser.setCurrentDirectory (UMLProjectSettings.getDefault().getLastUsedArtifactFolder());

        int option = chooser.showOpenDialog( parent ); // Show the chooser
              
        if ( option == JFileChooser.APPROVE_OPTION ) {

            File dir = chooser.getSelectedFile();
            dir = FileUtil.normalizeFile (dir);
            Project selectedProject = accessory.getProject( dir );

            if ( selectedProject == null ) {
                return null;
            }
            
            if ( selectedProject.getProjectDirectory().equals( master.getProjectDirectory() ) ) {
                DialogDisplayer.getDefault().notify( new NotifyDescriptor.Message( 
                    NbBundle.getMessage( AntArtifactChooser.class, "MSG_AACH_RefToItself" ),
                    NotifyDescriptor.INFORMATION_MESSAGE ) );
                return null;
            }
            
            if ( ProjectUtils.hasSubprojectCycles( master, selectedProject ) ) {
                DialogDisplayer.getDefault().notify( new NotifyDescriptor.Message( 
                    NbBundle.getMessage( AntArtifactChooser.class, "MSG_AACH_Cycles" ),
                    NotifyDescriptor.INFORMATION_MESSAGE ) );
                return null;
            }
            
            UMLProjectSettings.getDefault().setLastUsedArtifactFolder (FileUtil.normalizeFile(chooser.getCurrentDirectory()));
            
            Object[] tmp = new Object[accessory.jListArtifacts.getModel().getSize()];
            int count = 0;
            for(int i = 0; i < tmp.length; i++) {
                if (accessory.jListArtifacts.isSelectedIndex(i)) {
                    tmp[count] = accessory.jListArtifacts.getModel().getElementAt(i);
                    count++;
                }
            }
            ArtifactItem artifactItems[] = new ArtifactItem[count];
            System.arraycopy(tmp, 0, artifactItems, 0, count);
            return artifactItems;
        }
        else {
            return null; 
        }
                
    }
       
    
/**
     * Pair of AntArtifact and one of jars it produces.
     */
    public static class ArtifactItem {
        
        private AntArtifact artifact;
        private URI artifactURI;
        
        public ArtifactItem(AntArtifact artifact, URI artifactURI) {
            this.artifact = artifact;
            this.artifactURI = artifactURI;
        }
        
        public AntArtifact getArtifact() {
            return artifact;
        }
        
        public URI getArtifactURI() {
            return artifactURI;
        }
        
        public String toString() {
            return artifactURI.toString();
        }
        
    }
}
