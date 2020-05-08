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

/*
 * CLD_Package.java
 *
 * Created on May 13, 2005, 3:34 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package org.netbeans.test.uml.classdiagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.netbeans.jemmy.JemmyProperties;
import org.netbeans.jemmy.TestOut;
import org.netbeans.junit.NbTestSuite;
import org.netbeans.test.uml.classdiagram.utils.CLDUtils;
import org.netbeans.test.umllib.ElementTypes;
import org.netbeans.test.umllib.LinkTypes;
import org.netbeans.test.umllib.NewDiagramWizardOperator;
import org.netbeans.test.umllib.exceptions.NotFoundException;
import org.netbeans.test.umllib.vrf.DiagramElementVerifier;



public class CLD_PackageElementTests extends ClassDiagramTestCase {

    private static String prName = "UMLProjectForPackage";
    private static String dpdName = "ClassDiagramForPackage";
    private static final String workDir = System.getProperty("nbjunit.workdir");
    private static String OUT_LOG_FILE = "";
    private static String ERR_LOG_FILE = "";
    private static PrintStream myOut = null;
    private static PrintStream myErr = null;
    private static BufferedReader myIn = null;

    /** Need to be defined because of JUnit */
    public CLD_PackageElementTests(String name) {
        super(name);
    }

    public static NbTestSuite suite() {
        //NbTestSuite suite = new NbTestSuite(org.netbeans.test.uml.classdiagram.CLD_PackageElementTests.class);
        NbTestSuite suite = new NbTestSuite();

        suite.addTest(new CLD_PackageElementTests("testCopyAndPasteByPopup"));
        suite.addTest(new CLD_PackageElementTests("testCopyAndPasteByShortcut"));
        // 6.5 Cut is not working
        //suite.addTest(new CLD_PackageElementTests("testCutAndPasteByPopup"));
        //suite.addTest(new CLD_PackageElementTests("testCutAndPasteByShortcut"));
        suite.addTest(new CLD_PackageElementTests("testDeleteByPopup"));
        suite.addTest(new CLD_PackageElementTests("testDeleteByShortcut"));
        // 6.5  Lock edit not yet implemented
        //suite.addTest(new CLD_ClassElementTests("testLockEdit"));
        suite.addTest(new CLD_PackageElementTests("testSelectAllByPopup"));
        suite.addTest(new CLD_PackageElementTests("testSelectAllByShortcut"));
        suite.addTest(new CLD_PackageElementTests("testSelectAllSimilar"));
        suite.addTest(new CLD_PackageElementTests("testInvertSelection"));
        // 6.5 Hide/Show not yet implemented
        
