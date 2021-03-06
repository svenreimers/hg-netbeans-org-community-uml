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




package org.netbeans.modules.uml.ui.support.projecttreesupport;

import org.netbeans.modules.uml.core.metamodel.core.foundation.IElement;



public interface ITreeFolder extends ITreeItem
{

   
/**
    * @param value The ID of the element
    */
   public void setID(String value);

   
/**
    *
    * @return value The ID of the element
    */
   public String getID();

   
/**
    * @param value
    */
   public void setName(String value);

   public String getName();

   
/**
    * Sets display Name of the property definition.
    * 
    * @param value the display name.
    */
   public void setDisplayName(String value);

   
/**
    * Sets display Name of the property definition.
    * 
    * @param value the display name.
    * @param initializing specifing that we are actually initalizing the node
    */
   public void setDisplayName(String value, boolean initializing);

   
/**
    * Retrieves display Name of the property definition.
    * 
    * @return the display name.
    */
   public String getDisplayName();
   
   
/**
    * Set the method to use to populate the children.
    * 
    * @param name The name of the method to be invoked.
    */
   public void setGetMethod(String name);

   
/**
    * Retrieve the method to use to populate the children.
    * 
    * @return The name of the method to be invoked. 
    */
   public String getGetMethod();
   
   
/**
    * Sets the element this folder represents.
    * 
    * @param pEle The model element.
    */
   public void setElement(IElement pEle);

   
/**
    * Retrieves the element this folder represents.
    * 
    * @return  The model element.
    */
   public IElement getElement();
   
   
/**
    * @param defPath
    */
   public void setPath(ITreeItem[] defPath);
   
   
/**
    * Is the get method the one used to get imported packages or elements?
    * 
    * @return <b>true</b> if the get method is an import, <b>false</b>
    *         if the get method is not an import.
    */
   public boolean isGetMethodAnImport();
   
   
/**
    * Is the get method the one used to get imported elements?
    * 
    * @return <b>true</b> if the get method is an import, <b>false</b>
    *         if the get method is not an import.
    */
   public boolean isGetMethodAnImportElement();
   
   
/**
    * Is the get method the one used to get imported packages?
    * 
    * @return <b>true</b> if the get method is an import, <b>false</b>
    *         if the get method is not an import.
    */
   public boolean isGetMethodAnImportPackage();
   
   
/**
	* The type of the tree element.
	* 
	* @return The type.
	*/
   public String getType();
   
}
