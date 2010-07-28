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
package org.netbeans.modules.uml.ui.support;

import org.openide.util.NbBundle;

/**
 *
 * @author  Sheryl Su
 */
public class ElementDeletePanel extends javax.swing.JPanel
{

    public ElementDeletePanel(boolean displayRemove)
    {
        initComponents();
        jCheckBox2.setVisible(displayRemove);
//        if (objects.size() > 1) {
//            jLabel1.setText(NbBundle.getMessage(ElementDeletePanel.class,
//                    "ElementDeletePanel.jLabel1.text_multi", objects.size()));
//        } else {
//            IElement e = TypeConversions.getElement(objects.get(0));
//            if (e.toString().length() > 0) {
//                jLabel1.setText(NbBundle.getMessage(ElementDeletePanel.class,
//                        "ElementDeletePanel.jLabel1.text_single", e.toString()));
//            } else {
//                jLabel1.setText(NbBundle.getMessage(ElementDeletePanel.class,
//                        "ElementDeletePanel.jLabel1.text_unnamed", e.getElementType()));
//            }
//        }
        jLabel1.setText(NbBundle.getMessage(ElementDeletePanel.class, "DELETE_GRAPH_OBJECTS_MESSAGE"));
    }

    public boolean getDeleteFromOriginal()
    {
        return jCheckBox1.isSelected();
    }

    public boolean getRemoveFromImport()
    {
        return jCheckBox2.isSelected();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(ElementDeletePanel.class, "ElementDeletePanel.jLabel1.text_single")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox1, org.openide.util.NbBundle.getMessage(ElementDeletePanel.class, "ElementDeletePanel.jCheckBox1.text")); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox2, org.openide.util.NbBundle.getMessage(ElementDeletePanel.class, "ElementDeletePanel.jCheckBox2.text")); // NOI18N
        jCheckBox2.setDoubleBuffered(true);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jCheckBox1)
                    .add(jCheckBox2))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(jCheckBox1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBox2))
        );

        jLabel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ElementDeletePanel.class, "ElementDeletePanel.jLabel1.AccessibleContext.accessibleName")); // NOI18N
        jLabel1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ElementDeletePanel.class, "ElementDeletePanel.jLabel1.AccessibleContext.accessibleDescription")); // NOI18N
        jCheckBox1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ElementDeletePanel.class, "ElementDeletePanel.jCheckBox1.AccessibleContext.accessibleDescription")); // NOI18N
        jCheckBox2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ElementDeletePanel.class, "ElementDeletePanel.jCheckBox2.AccessibleContext.accessibleDescription")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected())
        {
            jCheckBox2.setEnabled(false);
            jCheckBox2.setSelected(true);
        } else
        {
            jCheckBox2.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
