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




package org.netbeans.modules.uml.project.ui.nodes.actions;

import org.netbeans.modules.uml.core.metamodel.core.constructs.IEnumeration;
import org.netbeans.modules.uml.core.metamodel.core.constructs.IEnumerationLiteral;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IElement;
import org.netbeans.modules.uml.core.metamodel.core.foundation.INamespace;
import org.netbeans.modules.uml.core.metamodel.infrastructure.coreinfrastructure.IClassifier;
import org.netbeans.modules.uml.core.metamodel.infrastructure.coreinfrastructure.IOperation;
import org.netbeans.modules.uml.core.preferenceframework.IPreferenceAccessor;
import org.netbeans.modules.uml.core.preferenceframework.PreferenceAccessor;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.datatransfer.NewType;



public class NewLiteralType extends NewType implements INewTypeExt
{
	private Node node;
	
	public NewLiteralType(Node node)
	{
		this.node = node;
	}
	
	
	/**
	 *
	 *
	 */
	public String getName()
	{
		return NbBundle.getMessage(NewLiteralType.class, 
                      "NewType_Literal_Name"); // NOI18N
	}
	
        public String getIconResource()
	{
		return NbBundle.getMessage(NewLiteralType.class, 
                      "LITERAL_ICON"); // NOI18N
        }
	
	/**
	 *
	 *
	 */
	public HelpCtx getHelpCtx()
	{
		return HelpCtx.DEFAULT_HELP;
	}
	
	
	public void create() throws java.io.IOException
	{
		// code based on legacy code from in JProjectTree.NewOperationAction
		
		// this action supposed to be invoken on Enumeration only
		
		INamespace space = null;
		IElement element = (IElement)node.getCookie(IElement.class);
		
		try
		{
			if (element != null && element instanceof IEnumeration)
			{
				IEnumeration pEnu = (IEnumeration)element;
				IEnumerationLiteral pLi = pEnu.createLiteral(retrieveDefaultName());
				pEnu.addLiteral(pLi);
			}
		}
		
		catch (Exception ex)
		{
		}
	}
	
/**
	 *
	 * Retrieves the default name for use for model elements that are just
	 * being created.
	 *
	 * @return the default name of the model element
	 *
	 */
	protected String retrieveDefaultName() {
		String name = "";
		IPreferenceAccessor pref = PreferenceAccessor.instance();
		name = pref.getDefaultElementName();
		return name;
	}
}
