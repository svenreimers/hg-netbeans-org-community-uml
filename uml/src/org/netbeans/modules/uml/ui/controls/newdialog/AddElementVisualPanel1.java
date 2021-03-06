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

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.modules.uml.common.Util;
import org.netbeans.modules.uml.common.generics.ETPairT;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IConfigManager;
import org.netbeans.modules.uml.core.metamodel.core.foundation.INamespace;
import org.netbeans.modules.uml.core.roundtripframework.requestprocessors.javarpcomponent.JavaRequestProcessor;
import org.netbeans.modules.uml.core.support.umlsupport.ProductRetriever;
import org.netbeans.modules.uml.core.support.umlsupport.XMLManip;
import org.netbeans.modules.uml.ui.support.NewElementKind;
import org.netbeans.modules.uml.ui.support.commonresources.CommonResourceManager;
import org.openide.WizardDescriptor;
import org.openide.util.NbBundle;

public final class AddElementVisualPanel1 extends JPanel 
      implements DocumentListener, ListSelectionListener, ItemListener, INewUMLFileTemplates {
    
    private AddElementWizardPanel1 panel;
    private INewDialogElementDetails mDetails = null;
    private static HashMap elementTypeNameMap = new HashMap();
    private static org.dom4j.Document m_doc = null;
    private java.util.ResourceBundle bundle =
            NbBundle.getBundle(NewUMLDiagVisualPanel1.class);
    private boolean valid = true;
    private int errorType = -1;
    static final int INVALID_NAME = 0;
    static final int NAME_CONFLICT = 1;
    static final int ENTER_NAME = 2;
    
    
/** Creates new form AddElementVisualPanel1 
     * @param panel 
     */
    public AddElementVisualPanel1(AddElementWizardPanel1 panel) {
        this.panel = panel;
        getElementListFromConfigFile();
        initComponents();
        elementTypeList.addListSelectionListener(this);
        nameSpaceComboBox.addItemListener(this);
        // Register listener on the textFields to validate entered text
        elementNameTextField.getDocument().addDocumentListener(this);
    }
    
    public String getName() {
        return org.openide.util.NbBundle.getBundle(AddElementVisualPanel1.class).getString("IDS_NEWELEMENT");
    }
    
    
/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        elementTypeList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        elementNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameSpaceComboBox = new javax.swing.JComboBox();

        jLabel1.setLabelFor(elementTypeList);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getBundle(AddElementVisualPanel1.class).getString("IDS_ELEMENTTYPE")); // NOI18N

        elementTypeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        elementTypeList.setCellRenderer(new ElementListCellRenderer());
        jScrollPane1.setViewportView(elementTypeList);
        elementTypeList.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(AddElementVisualPanel1.class).getString("ACSD_NEW_ELEMENT_WIZARD_ELEMENTTYPE_LIST")); // NOI18N

        jLabel2.setLabelFor(elementNameTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getBundle(AddElementVisualPanel1.class).getString("IDS_ELEMENTNAME")); // NOI18N

        elementNameTextField.setText(NewDialogUtilities.getDefaultElementName());
        elementNameTextField.selectAll();
        elementNameTextField.requestFocus();

        jLabel3.setLabelFor(nameSpaceComboBox);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getBundle(AddElementVisualPanel1.class).getString("IDS_NAMESPACE")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(elementNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(nameSpaceComboBox, 0, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(elementNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameSpaceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        elementNameTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(AddElementVisualPanel1.class).getString("ACSD_NEW_ELEMENT_WIZARD_ELEMENTNAME_TEXTFIELD")); // NOI18N
        nameSpaceComboBox.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getBundle(AddElementVisualPanel1.class).getString("ACSD_NEW_ELEMENT_WIZARD_ELEMENTNAMESPACE_COMBOBOX")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

   public void read(WizardDescriptor wizDesc) {
        mDetails = (INewDialogElementDetails) wizDesc.getProperty(this.ELEMENT_DETAILS);
        
        populateList();
        populateCombobox();
    }
   
   void store(WizardDescriptor wizDesc)
   {
      String elemName = (String)getSelectedListElement();
      String elemType = (String) elementTypeNameMap.get(elemName);
      
      // CR#6263225 cvc
      //  added arrays to NewElementKind to make the
      //  maintenance of adding/changing/removing elements much easier
      //	switch/case logic no longer needed
      List eleNameList = Arrays.asList(NewElementKind.ELEMENT_NAMES);
      int index = eleNameList.indexOf(elemType);
      
      if (index == -1)
         // "None" element type, default to the 1st element in the list
         mDetails.setElementKind(
               NewElementKind.ELEMENT_NUMBERS[0].intValue());
      else
         mDetails.setElementKind(
               NewElementKind.ELEMENT_NUMBERS[index].intValue());
      
      //get the name
      mDetails.setName(getElementName());
      
      // Get the namespace
      INamespace pSelectedNamespace = NewDialogUtilities.getNamespace(
            (String) getSelectedNamespace());
      mDetails.setNamespace(pSelectedNamespace);
      
      // store the element Details
      wizDesc.putProperty(this.ELEMENT_DETAILS, mDetails);
   }
   
   private void getElementListFromConfigFile()
   {
      if (elementTypeNameMap == null || elementTypeNameMap.size() == 0)
      {
         if (elementTypeNameMap == null)
         {
            elementTypeNameMap = new HashMap();
         }
         ETPairT typeNamePair = null;
         IConfigManager conMan = ProductRetriever.retrieveProduct().getConfigManager();
         String fileName = conMan.getDefaultConfigLocation();
         fileName += "NewDialogDefinitions.etc"; // NOI18N
         m_doc = XMLManip.getDOMDocument(fileName);
         org.dom4j.Node node = m_doc.selectSingleNode(
               "//PropertyDefinitions/PropertyDefinition"); // NOI18N
         
         if (node != null)
         {
            String displName ="";
            org.dom4j.Element elem = (org.dom4j.Element)node;
            String name = elem.attributeValue("name"); // NOI18N
            List nodeList = m_doc.selectNodes(
                  "//PropertyDefinition/aDefinition[@name='" // NOI18N
                  + "Element" + "']/aDefinition"); // NOI18N
            
            int count = nodeList.size();
            for (int i=0; i<count; i++)
            {
               org.dom4j.Element subNode = (org.dom4j.Element)nodeList.get(i);
               displName = subNode.attributeValue("displayName"); // NOI18N
               elementTypeNameMap.put(bundle.getString(displName), subNode.attributeValue("name")); // NOI18N
            }
         }
      }
   }
   
    private void populateList()
    {
       getElementListFromConfigFile();
       if (elementTypeList != null)
       {
          // fixed #107312. Use TreeSet to have the set sorted
          Set elemDisplaySet = new TreeSet(elementTypeNameMap.keySet());
          if (elemDisplaySet != null)
          {
             elementTypeList.setListData(elemDisplaySet.toArray());
          }
          // select the 1st element in the list by default
          elementTypeList.setSelectedIndex(0);
       }
    }

    private void populateCombobox() {        
        if ((nameSpaceComboBox != null) && (mDetails != null)) {   
            NewDialogUtilities.loadNamespace(nameSpaceComboBox, mDetails.getNamespace());
        }
    }
    
    protected String getElementName() {
        return elementNameTextField.getText().trim();
    }
    
    protected Object getSelectedNamespace() {
        return nameSpaceComboBox.getSelectedItem();
    }
    
    protected Object getSelectedListElement() {
        return elementTypeList.getSelectedValue();
    }
    
    protected int getSelectedListIndex() {
        return elementTypeList.getSelectedIndex();        
    }
    
    public boolean isValid(WizardDescriptor wizDesc)
    {
        String msg = "";
        String msg_type = WizardDescriptor.PROP_ERROR_MESSAGE;

        if (!valid)
        {
            switch (errorType)
            {
                case ENTER_NAME:
                    msg = NbBundle.getMessage(AddPackageVisualPanel1.class,
                            "IDS_PLEASEENTERELEMENTNAME");
                    msg_type = WizardDescriptor.PROP_INFO_MESSAGE;
                    break;
                case INVALID_NAME:
                    msg = NbBundle.getMessage(AddPackageVisualPanel1.class,
                            "MSG_Invalid_Element_Name");
                    break;
                case NAME_CONFLICT:
                    msg = NbBundle.getMessage(
                            NewElementUI.class, "IDS_NAMESPACECOLLISION");
            }
        }
        wizDesc.putProperty(msg_type, msg);
        return valid;
    }
    
    class ElementListCellRenderer extends JLabel implements ListCellRenderer {
        public Icon getImageIcon(String elemName) {
            Icon retIcon = null;
            String displayName = NewDialogResources.getStringKey(elemName);
            String str = "//PropertyDefinition/aDefinition[@name='" + // NOI18N
                    "Element" + "']/aDefinition[@displayName='" +  // NOI18N
                    displayName + "']"; // NOI18N
            
            org.dom4j.Node node = m_doc.selectSingleNode(str);
            if (node.getNodeType() == org.dom4j.Element.ELEMENT_NODE) {
                org.dom4j.Element elem = (org.dom4j.Element)node;
                String fileName = elem.attributeValue("image"); // NOI18N
                File file = new File(fileName);
                retIcon = CommonResourceManager.instance().getIconForFile(fileName);
            }
            return retIcon;
        }
        
        public Component getListCellRendererComponent(
                JList list,
                Object value,            // value to display
                int index,               // cell index
                boolean isSelected,      // is the cell selected
                boolean cellHasFocus)    // the list and the cell have the focus
        {
            String s = value.toString();
            setText(s);
            setIcon(getImageIcon(s));
            
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            
            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);
            return this;
        }
    }
    
    // implementing abstact methods in DocumentListener
    public void changedUpdate(DocumentEvent event)
    {
        validateElementName();
        if (panel != null)
        {
            panel.fireChangeEvent();
        }
    }
    
    public void insertUpdate( DocumentEvent event )
    {
        changedUpdate(event);
    }
    
    public void removeUpdate(DocumentEvent event)
    {
        changedUpdate(event);
    }
    
    // methods in ListSelectionListener
    public void valueChanged(ListSelectionEvent e) {
        //fire change event to validate the selection
        validateElementName();
        if (panel != null) {
            panel.fireChangeEvent();
        }
    }
    
    
    public void itemStateChanged(ItemEvent e)
    {
        validateElementName();
        if (panel != null) {
            panel.fireChangeEvent();
        }
    }
    
    private void validateElementName()
    {
        valid = true;

        if (getElementName().length() == 0)
        {
            errorType = ENTER_NAME;
            valid = false;
        } else
        {
            JavaRequestProcessor p = new JavaRequestProcessor();
            if (!p.checkIfCorrectLanguage(mDetails.getNamespace()))
            {
                return;
            }
            String selectedElemType = (String) this.getSelectedListElement();

            if (selectedElemType != null && (selectedElemType.equals("Class") ||
                    selectedElemType.equals("Interface") || selectedElemType.equals("Enumeration")))
            {
                if (p.invalidClass(getElementName()))
                {
                    errorType = INVALID_NAME;
                    valid = false;
                    return;
                }
            }  
            // check for naming collision              
            
            INamespace selectedNamespace = NewDialogUtilities.getNamespace(
                    (String) getSelectedNamespace());

            if (selectedNamespace != null)
            {
                String selectedElem = (String) getSelectedListElement();
                String elemType = (String) elementTypeNameMap.get(selectedElem);

                if (Util.hasNameCollision(selectedNamespace, getElementName(), elemType, null))
                {
                    errorType = NAME_CONFLICT;
                    valid = false;
                }
            }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField elementNameTextField;
    private javax.swing.JList elementTypeList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox nameSpaceComboBox;
    // End of variables declaration//GEN-END:variables
}

