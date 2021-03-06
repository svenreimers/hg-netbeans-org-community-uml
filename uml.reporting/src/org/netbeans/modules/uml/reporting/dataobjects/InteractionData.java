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


package org.netbeans.modules.uml.reporting.dataobjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.modules.uml.core.metamodel.core.foundation.IElement;
import org.netbeans.modules.uml.core.metamodel.core.foundation.INamedElement;
import org.netbeans.modules.uml.core.metamodel.dynamics.CombinedFragment;
import org.netbeans.modules.uml.core.metamodel.dynamics.IInteraction;
import org.netbeans.modules.uml.core.metamodel.dynamics.IInteractionFragment;
import org.netbeans.modules.uml.core.metamodel.dynamics.ILifeline;
import org.netbeans.modules.uml.core.support.umlutils.ETList;
import org.openide.util.NbBundle;



public class InteractionData extends ElementDataObject
{
    private IInteraction element;
    /** Creates a new instance of InteractionData */
    public InteractionData()
    {
    }
    
    
    public void setElement(IElement e)
    {
        if (e instanceof IInteraction)
            this.element = (IInteraction)e;
    }
    
    
    public IInteraction getElement()
    {
        return this.element;
    }
    
    
    private String getSummaryTable(ETList list)
    {
        StringBuilder buff = new StringBuilder();
        
        for (int i=0; i<list.size(); i++)
        {
            INamedElement node = (INamedElement)list.get(i);
            buff.append("<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">\r\n");
            
            String doc = getBriefDocumentation(node.getDocumentation());
            
            if (doc == null || doc.trim().equals(""))
                doc = "&nbsp;";
            
            String name = node.getName();
            if (name==null || name.equals(""))
                name = NbBundle.getMessage(InteractionData.class, "unnamed");
            buff.append("<TR BGCOLOR=\"white\" CLASS=\"TableRowColor\">\r\n");
            buff.append("<TD WIDTH=\"15%\"><B><A HREF=\"" + getLinkTo(node) +
                    "\" title=\"" + node.getElementType() + " in " + node.getName() +
                    "\">" + name + "</A></B></TD>\r\n");
            buff.append("<TD>" + doc + "</TD>\r\n");
            buff.append("</TR>\r\n");
        }
        
        buff.append("</TABLE>\r\n&nbsp;\r\n");
        return buff.toString();
    }
    
    
    public boolean toReport(File file)
    {
        if (getElement()==null)
            return false;
        
        ETList<ILifeline> lifelines = getElement().getLifelines();
        
        boolean result = false;
        try
        {
            FileOutputStream fo = new FileOutputStream(file);
            OutputStreamWriter out = new OutputStreamWriter(fo, ENCODING);
            
            out.write(getHTMLHeader());
            out.write("<BODY BGCOLOR=\"white\">\r\n");
            out.write(getNavBar());
            out.write("<HR>\r\n");
            out.write("<H2>\r\n");
            out.write("<FONT SIZE=\"-1\">" + getOwningPackageName() + "</FONT>\r\n");
            out.write("<BR>\r\n");
            out.write(getElementType() + " " + getElement().getName() + "</H2>\r\n");
            
            out.write(getDocumentation());

            // diagram summary
            out.write(getDiagramSummary());
            // stereotype summary
            out.write(getStereoTypesSummary());
            
            // tagged value summary
            out.write(getTaggedValueSummary());
            
            // constraint summary
            out.write(getConstraintsSummary());
            
            // lifeline summary
            if (lifelines!=null && lifelines.size()>0)
            {
                out.write("<!-- =========== LIFELINE SUMMARY =========== -->\r\n\r\n");
                out.write(getSummaryHeader("lifeline_summary",
                        NbBundle.getMessage(InteractionData.class, "Lifeline_Summary")));
                
                out.write(getSummaryTable(lifelines));
            }
            
            // fragment summary
            
            ETList<IInteractionFragment> fragments = getElement().getFragments();
            ArrayList<IInteractionFragment> list = new ArrayList();
            for (int i=0; i<fragments.size(); i++)
            {
                IInteractionFragment f = fragments.get(i);
                
                if (! (f instanceof CombinedFragment))
                    list.add(f);
            }
            for (int i=0; i<list.size(); i++)
            {
                fragments.removeItem(list.get(i));
            }
            
            if (fragments.size()>0)
            {
                out.write("<!-- =========== FRAGMENT SUMMARY =========== -->\r\n\r\n");
                out.write(getSummaryHeader("combined_fragment_summary",
                        NbBundle.getMessage(InteractionData.class, "Combined_Fragment_Summary")));
                out.write(getSummaryTable(fragments));
                
            }
            
            out.write("<HR>\r\n");
            out.write(getNavBar());
            out.write("</BODY>\r\n</HTML>");
            out.close();
            result = true;
            
        }
        catch (Exception e)
        {
            Logger.getLogger(ElementDataObject.class.getName()).log(
                    Level.SEVERE, getElement().getElementType() + " - " +  getElement().getNameWithAlias(), e);
            result = false;
        }
        return result;
    }
}
