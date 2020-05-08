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



package org.netbeans.modules.uml.core.metamodel.core.primitivetypes;



public interface IInteractionOperator
{
    // Designates that the CombinedFragment represents a choice of behavior.
    public static final int IO_ALT = 0;

    // Designates a guard that is the negation of the conjunction of all other
    // guards in the enclosing CombinedFragment.
    public static final int IO_ELSE = 1;

    // Designates that the CombinedFragment represents a choice of behavior 
    // where either the (sole) operand happens or nothing happens.
    public static final int IO_OPT = 2;

    // Designates that the CombinedFragment represents a parallel merge between
    // the behaviors of the operands.
    public static final int IO_PAR = 3;

    // Designates that the CombinedFragment represents a loop.
    public static final int IO_LOOP = 4;

    // Designates that the CombinedFragment represents a critical region.
    public static final int IO_REGION = 5;

    // Designates that the CombinedFragment represents traces that are defined 
    // to be impossible.
    public static final int IO_NEG = 6;

    // Designates that the CombinedFragment represents an assertion.
    public static final int IO_ASSERT = 7;

    // Designates that the CombinedFragment represents a weak sequencing between
    // the behaviors of the operands.
    public static final int IO_SEQ = 8;

    // Designates that the CombinedFragment represents a strict sequencing 
    // between the behaviors of the operands.
    public static final int IO_STRICT = 9;

    // Designates that there are some message types that are not shown within 
    // this combined fragment.
    public static final int IO_FILTER = 10;
}
