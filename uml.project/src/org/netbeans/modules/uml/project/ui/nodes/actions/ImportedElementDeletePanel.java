/*
 * ImportedElementDeletePanel.java
 *
 * Created on October 11, 2007, 12:24 PM
 */

package org.netbeans.modules.uml.project.ui.nodes.actions;

import org.openide.nodes.Node;
import org.openide.util.NbBundle;

/**
 *
 */
public class ImportedElementDeletePanel extends javax.swing.JPanel {
    
    /** Creates new form ImportedElementDeletePanel */
    public ImportedElementDeletePanel(Node[] nodes) {
        initComponents();
        if (nodes.length == 1)
        {
            jLabel1.setText(NbBundle.getMessage(ImportedElementDeletePanel.class, 
                "ImportedElementDeletePanel.MSG_ConfirmDeleteObject", nodes[0].getName()));
        }
        else
        {
            jLabel1.setText(NbBundle.getMessage(ImportedElementDeletePanel.class, 
                "ImportedElementDeletePanel.MSG_ConfirmDeleteObjects", nodes.length));
        }
    }
    
    public boolean getDeleteFromOriginal()
    {
        return jCheckBox1.isSelected();
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

        jLabel1.setText(org.openide.util.NbBundle.getMessage(ImportedElementDeletePanel.class, "ImportedElementDeletePanel.MSG_ConfirmDeleteObject")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBox1, org.openide.util.NbBundle.getMessage(ImportedElementDeletePanel.class, "ImportedElementDeletePanel.MSG_AlsoDelete")); // NOI18N
        jCheckBox1.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel1))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ImportedElementDeletePanel.class, "ImportedElementDeletePanel.jLabel1.AccessibleContext.accessibleDescription")); // NOI18N
        jCheckBox1.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ImportedElementDeletePanel.class, "ImportedElementDeletePanel.jCheckBox1.AccessibleContext.accessibleDescription")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
