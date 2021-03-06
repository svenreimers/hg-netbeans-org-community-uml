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


package org.netbeans.modules.uml.designpattern;

import org.netbeans.modules.uml.core.metamodel.core.foundation.IElement;
import org.netbeans.modules.uml.core.metamodel.core.foundation.INamespace;
import org.netbeans.modules.uml.core.metamodel.infrastructure.ICollaboration;
import org.netbeans.modules.uml.core.metamodel.structure.IProject;
import org.netbeans.modules.uml.core.support.umlutils.ETList;

public interface IDesignPatternDetails
{
	public IProject getProject();
	public void setProject(IProject newVal);
	public boolean getShowOnDiagram();
	public void setShowOnDiagram(boolean newVal);
	public boolean getCreateDiagram();
	public void setCreateDiagram(boolean newVal);
	public INamespace getNamespace();
	public void setNamespace(INamespace newVal);
	public ICollaboration getCollaboration();
	public void setCollaboration(ICollaboration newVal);
	public ETList < IDesignPatternRole > getRoles();
	public void setRoles(ETList < IDesignPatternRole > newVal);
	public String getDiagramName();
	public void setDiagramName(String newVal);
	public boolean getRemoveOnPromote();
	public void setRemoveOnPromote(boolean newVal);

	public void addRole(IDesignPatternRole pRole);
	public void addParticipantName(String roleID, String partName);
	public ETList < String > getParticipantNames(String roleID);
	public void clearParticipantNames();
	public void addParticipantRole(String participantID, String roleID);
	public ETList < String > getParticipantRoles(String participantID);
	public void addParticipantInstance(String roleID, IElement pElement);
	public ETList < IElement > getParticipantInstances(String roleID);

}
