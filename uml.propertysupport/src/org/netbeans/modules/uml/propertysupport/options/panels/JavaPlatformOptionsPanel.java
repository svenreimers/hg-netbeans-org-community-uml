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
 * Portions Copyrighted 2008 Sun Microsystems, Inc.
 */

package org.netbeans.modules.uml.propertysupport.options.panels;

import java.util.prefs.Preferences;
import org.netbeans.modules.uml.util.DummyCorePreference;
import org.openide.util.NbPreferences;



public class JavaPlatformOptionsPanel extends javax.swing.JPanel {
    
    /** Creates new form JavaPlatformOptionsPanel */
    public JavaPlatformOptionsPanel() {
        initComponents();
    }
    
    
/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        removePrefixCB = new javax.swing.JCheckBox();
        capitalizeCB = new javax.swing.JCheckBox();
        collectionsUseGenCB = new javax.swing.JCheckBox();
        displayDupCB = new javax.swing.JCheckBox();
        nameNavEndsCB = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        createAccCB = new javax.swing.JCheckBox();
        createConCB = new javax.swing.JCheckBox();
        createFinCB = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.jLabel1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(removePrefixCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.removePrefixCB.text")); // NOI18N
        removePrefixCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        capitalizeCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(capitalizeCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.capitalizeCB.text")); // NOI18N
        capitalizeCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        collectionsUseGenCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(collectionsUseGenCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.collectionsUseGenCB.text")); // NOI18N
        collectionsUseGenCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        displayDupCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(displayDupCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.displayDupCB.text")); // NOI18N
        displayDupCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        nameNavEndsCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(nameNavEndsCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.nameNavEndsCB.text")); // NOI18N
        nameNavEndsCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel14.setLabelFor(jTextField4);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "jLabel14.text_1")); // NOI18N

        jLabel13.setLabelFor(jTextField2);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "jLabel13.text_1")); // NOI18N

        jLabel12.setLabelFor(jTextField3);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "jLabel12.text_1")); // NOI18N

        jLabel11.setLabelFor(jTextField1);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "jLabel11.text_1")); // NOI18N

        jTextField4.setText("set"); // NOI18N

        jTextField2.setText("get"); // NOI18N

        jTextField3.setText("m"); // NOI18N

        jTextField1.setText("java.util.ArrayList"); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(178, 21));

        jLabel3.setText(org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.jLabel3.text")); // NOI18N

        createAccCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(createAccCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.createAccCB.text")); // NOI18N
        createAccCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        createConCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(createConCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.createConCB.text")); // NOI18N
        createConCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.openide.awt.Mnemonics.setLocalizedText(createFinCB, org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "JavaPlatformOptionsPanel.createFinCB.text")); // NOI18N
        createFinCB.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel4.setText(org.openide.util.NbBundle.getMessage(JavaPlatformOptionsPanel.class, "jLabel4.text_3")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createAccCB, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(createFinCB, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                            .addComponent(createConCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removePrefixCB, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(capitalizeCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                        .addGap(155, 155, 155))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(collectionsUseGenCB))
                        .addContainerGap(182, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayDupCB)
                        .addContainerGap(312, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameNavEndsCB)
                        .addContainerGap(372, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(createAccCB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createConCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createFinCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removePrefixCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(capitalizeCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(collectionsUseGenCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayDupCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameNavEndsCB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        removePrefixCB.getAccessibleContext().setAccessibleDescription(removePrefixCB.getText());
        capitalizeCB.getAccessibleContext().setAccessibleDescription(capitalizeCB.getText());
        collectionsUseGenCB.getAccessibleContext().setAccessibleDescription(collectionsUseGenCB.getText());
        displayDupCB.getAccessibleContext().setAccessibleDescription(displayDupCB.getText());
        nameNavEndsCB.getAccessibleContext().setAccessibleDescription(nameNavEndsCB.getText());
        jTextField4.getAccessibleContext().setAccessibleDescription(jLabel14.getText());
        jTextField2.getAccessibleContext().setAccessibleDescription(jLabel13.getText());
        jTextField3.getAccessibleContext().setAccessibleDescription(jLabel12.getText());
        jTextField1.getAccessibleContext().setAccessibleDescription(jLabel1.getText());
        createAccCB.getAccessibleContext().setAccessibleDescription(createAccCB.getText());
        createConCB.getAccessibleContext().setAccessibleDescription(createConCB.getText());
        createFinCB.getAccessibleContext().setAccessibleDescription(createFinCB.getText());
    }// </editor-fold>//GEN-END:initComponents

        
    
/**
     * Setting all the ui elements to match their respective prefences.
     * This is called in the corresponding UMLOptionsPanel's update method.
     */
    public void load() {
        
        Preferences prefs = NbPreferences.forModule(DummyCorePreference.class) ;
        
        if (prefs.getBoolean("UML_CAP_ON_ACCESSORS", true)) {// NOI18N
            this.capitalizeCB.setSelected(true);
        } else {
            capitalizeCB.setSelected(false);
        }
        
        if (prefs.getBoolean("UML_USE_GENERICS_DEFAULT", true)) {// NOI18N
            this.collectionsUseGenCB.setSelected(true);
        }else {
            collectionsUseGenCB.setSelected(false);
        }
        
        if (prefs.getBoolean("UML_ADD_ACCESSORS", true)) {// NOI18N
            this.createAccCB.setSelected(true);
        }else {
            createAccCB.setSelected(false);
        }
        
        if (prefs.getBoolean("UML_ADD_CTORS", true)) {// NOI18N
            this.createConCB.setSelected(true);
        }else {
            createConCB.setSelected(false);
        }
        
        if (prefs.getBoolean("UML_ADD_DTORS", false)) {// NOI18N
            this.createFinCB.setSelected(true);
        }else {
            createFinCB.setSelected(false);
        }
        
        if (prefs.getBoolean("UML_SHOW_DUPE_OP_DIALOG", true)) {// NOI18N
            this.displayDupCB.setSelected(true);
        }else {
            displayDupCB.setSelected(false);
        }
        
        if (prefs.getBoolean("UML_SET_NAVIGABLE_END_ROLE_NAME", true)) {// NOI18N
            this.nameNavEndsCB.setSelected(true);
        }else {
            nameNavEndsCB.setSelected(false);
        }
        
        if (prefs.getBoolean("NO_PREFIX_ON_ACCESSORS", false)) {// NOI18N
            this.removePrefixCB.setSelected(true);
        }else {
            removePrefixCB.setSelected(false);
        }
        
        String s = prefs.get("UML_COLLECTION_OVERRIDE_DEFAULT", "java.util.ArrayList"); // NOI18N
        jTextField1.setText(s);
        
        s = prefs.get("UML_READ_ACCESSOR_PREFIX", "get");// NOI18N
        jTextField2.setText(s);
        
        s = prefs.get("UML_ATTRIBUTE_PREFIX", "m");// NOI18N
        jTextField3.setText(s);
        
        s = prefs.get("UML_WRITE_ACCESSOR_PREFIX", "set");// NOI18N
        jTextField4.setText(s);
        
    }
    
    public void store() {
        
        Preferences prefs = NbPreferences.forModule(DummyCorePreference.class) ;
        
        prefs.putBoolean("UML_CAP_ON_ACCESSORS", this.capitalizeCB.isSelected());
        prefs.putBoolean("UML_USE_GENERICS_DEFAULT", this.collectionsUseGenCB.isSelected());
        prefs.putBoolean("UML_ADD_ACCESSORS", this.createAccCB.isSelected());
        prefs.putBoolean("UML_ADD_CTORS", this.createConCB.isSelected());
        prefs.putBoolean("UML_ADD_DTORS", this.createFinCB.isSelected());
        prefs.putBoolean("UML_SHOW_DUPE_OP_DIALOG", this.displayDupCB.isSelected());
        prefs.putBoolean("UML_SET_NAVIGABLE_END_ROLE_NAME", this.nameNavEndsCB.isSelected());
        prefs.putBoolean("NO_PREFIX_ON_ACCESSORS", this.removePrefixCB.isSelected());
        
        prefs.put("UML_COLLECTION_OVERRIDE_DEFAULT", jTextField1.getText());
        prefs.put("UML_READ_ACCESSOR_PREFIX", jTextField2.getText());
        prefs.put("UML_ATTRIBUTE_PREFIX", jTextField3.getText());
        prefs.put("UML_WRITE_ACCESSOR_PREFIX", jTextField4.getText());
        
    }
        
    public void cancel() {
        // do nothing ;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox capitalizeCB;
    private javax.swing.JCheckBox collectionsUseGenCB;
    private javax.swing.JCheckBox createAccCB;
    private javax.swing.JCheckBox createConCB;
    private javax.swing.JCheckBox createFinCB;
    private javax.swing.JCheckBox displayDupCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JCheckBox nameNavEndsCB;
    private javax.swing.JCheckBox removePrefixCB;
    // End of variables declaration//GEN-END:variables
    
}
