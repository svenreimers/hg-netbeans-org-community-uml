// $ANTLR 2.7.2: "java15.g" -> "JavaRecognizer.java"$

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

package org.netbeans.modules.uml.parser.java;

import org.netbeans.modules.uml.core.reverseengineering.reframework.parsingframework.ParserEventController;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;



public class JavaRecognizer extends antlr.LLkParser       implements JavaTokenTypes
 {


   public void setEventController(ParserEventController newVal)
   {
      mController = newVal;
   }

   
/** 
    * Parser error-reporting function can be overridden in subclass.
    * @param ex The exception that occured.
    */
   public void reportError(RecognitionException ex) 
   {
      mController.errorFound(ex.getMessage(), 
                             ex.getLine(), 
                             ex.getColumn(), 
                             ex.getFilename()); 
   }

      void ParseOperations(boolean flag )
      {
         m_ParseOperations = flag;
      }
      
   
      
/**
       * CheckForScarf handles token consumption within 
       * operations when doing normal reverse engineering.
       * This operation will have no effect if being called
       * during the reverse engineering of an operation directly.
       */
     protected boolean CheckForScarf(boolean inMethod )
      {
         boolean scarfed = false;
         try
	 {
         	if( inMethod && !m_ParseOperations )
         	{
            		ParserSharedInputState state =  getInputState();
            
            		long index = 1;
	            	TokenBuffer buffer = state.getInput();
        	    
            		boolean consume = true;
            
           	 	int tokenType = LA( 1 );
            
            		while( index != 0 && (!(tokenType == Token.EOF_TYPE)))
            		{
	               	if(tokenType == LCURLY)
               		{
                		index++;
               		}
               		else if(tokenType == RCURLY)
               		{
                		index--;
                  		if( index == 0 )
                  		{
                     			consume = false;
                  		}
               		}
               
               		if( consume )
               		{
              	  		buffer.consume();
			        tokenType = LA( 1 );
               		}
            	}
            
            	scarfed = true;
	     }
	 }
	 catch(Exception e)
	 {  
	     e.printStackTrace();
	 }
         return scarfed;
   }


   private ParserEventController mController;
   private boolean m_ParseOperations;

   // The following was supplied by the ANTLR web site.
   
/**
     * Counts the number of LT seen in the typeArguments production.
     * It is used in semantic predicates to ensure we have seen
     * enough closing '>' characters; which actually may have been
     * either GT, SR or BSR tokens.
     */
   private int ltCounter = 0;

protected JavaRecognizer(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public JavaRecognizer(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected JavaRecognizer(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public JavaRecognizer(TokenStream lexer) {
  this(lexer,2);
}

public JavaRecognizer(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void compilationUnit() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compilationUnit_AST = null;
		
		{
		boolean synPredMatched4 = false;
		if (((LA(1)==LITERAL_package||LA(1)==AT) && (LA(2)==IDENT))) {
			int _m4 = mark();
			synPredMatched4 = true;
			inputState.guessing++;
			try {
				{
				annotations();
				match(LITERAL_package);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched4 = false;
			}
			rewind(_m4);
			inputState.guessing--;
		}
		if ( synPredMatched4 ) {
			packageDefinition();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		{
		_loop6:
		do {
			if ((LA(1)==LITERAL_import)) {
				importDefinition();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop6;
			}
			
		} while (true);
		}
		{
		_loop8:
		do {
			if ((_tokenSet_2.member(LA(1)))) {
				typeDefinition();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop8;
			}
			
		} while (true);
		}
		match(Token.EOF_TYPE);
		compilationUnit_AST = (AST)currentAST.root;
		returnAST = compilationUnit_AST;
	}
	
	public final void annotations() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotations_AST = null;
		
		{
		_loop62:
		do {
			if ((LA(1)==AT)) {
				annotation();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop62;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			annotations_AST = (AST)currentAST.root;
			annotations_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ANNOTATIONS,"ANNOTATIONS")).add(annotations_AST));
			currentAST.root = annotations_AST;
			currentAST.child = annotations_AST!=null &&annotations_AST.getFirstChild()!=null ?
				annotations_AST.getFirstChild() : annotations_AST;
			currentAST.advanceChildToEnd();
		}
		annotations_AST = (AST)currentAST.root;
		returnAST = annotations_AST;
	}
	
	public final void packageDefinition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST packageDefinition_AST = null;
		Token  p = null;
		AST p_AST = null;
		
		try {      // for error handling
			annotations();
			astFactory.addASTChild(currentAST, returnAST);
			p = LT(1);
			p_AST = astFactory.create(p);
			astFactory.makeASTRoot(currentAST, p_AST);
			match(LITERAL_package);
			if ( inputState.guessing==0 ) {
				p_AST.setType(PACKAGE_DEF);
			}
			identifier();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp2_AST = null;
			tmp2_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp2_AST);
			match(SEMI);
			packageDefinition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = packageDefinition_AST;
	}
	
	public final void importDefinition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST importDefinition_AST = null;
		Token  i = null;
		AST i_AST = null;
		boolean isStatic = false;
		
		try {      // for error handling
			i = LT(1);
			i_AST = astFactory.create(i);
			astFactory.makeASTRoot(currentAST, i_AST);
			match(LITERAL_import);
			if ( inputState.guessing==0 ) {
				i_AST.setType(IMPORT);
			}
			{
			switch ( LA(1)) {
			case LITERAL_static:
			{
				match(LITERAL_static);
				if ( inputState.guessing==0 ) {
					i_AST.setType(STATIC_IMPORT);
				}
				break;
			}
			case IDENT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			identifierStar();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp4_AST = null;
			tmp4_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp4_AST);
			match(SEMI);
			importDefinition_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = importDefinition_AST;
	}
	
	public final void typeDefinition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeDefinition_AST = null;
		AST m_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
			case LITERAL_static:
			case LITERAL_private:
			case LITERAL_public:
			case LITERAL_protected:
			case LITERAL_transient:
			case LITERAL_native:
			case LITERAL_threadsafe:
			case LITERAL_synchronized:
			case LITERAL_volatile:
			case AT:
			case LITERAL_class:
			case LITERAL_interface:
			case LITERAL_enum:
			{
				modifiers();
				m_AST = (AST)returnAST;
				typeDefinitionInternal(m_AST);
				astFactory.addASTChild(currentAST, returnAST);
				typeDefinition_AST = (AST)currentAST.root;
				break;
			}
			case SEMI:
			{
				match(SEMI);
				typeDefinition_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				consume();
				consumeUntil(_tokenSet_3);
			} else {
			  throw ex;
			}
		}
		returnAST = typeDefinition_AST;
	}
	
	public final void methodCompilationUnit() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST methodCompilationUnit_AST = null;
		m_ParseOperations = true;
		
		{
		_loop11:
		do {
			if ((_tokenSet_4.member(LA(1)))) {
				classField();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop11;
			}
			
		} while (true);
		}
		match(Token.EOF_TYPE);
		methodCompilationUnit_AST = (AST)currentAST.root;
		returnAST = methodCompilationUnit_AST;
	}
	
	public final void classField() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classField_AST = null;
		AST mods_AST = null;
		AST td_AST = null;
		AST tp_AST = null;
		AST h_AST = null;
		AST s_AST = null;
		AST t_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST param_AST = null;
		AST rt_AST = null;
		AST tc_AST = null;
		AST s2_AST = null;
		Token  sm = null;
		AST sm_AST = null;
		AST v_AST = null;
		Token  vs = null;
		AST vs_AST = null;
		AST s3_AST = null;
		AST s4_AST = null;
		
		if ((_tokenSet_5.member(LA(1))) && (_tokenSet_6.member(LA(2)))) {
			modifiers();
			mods_AST = (AST)returnAST;
			{
			switch ( LA(1)) {
			case AT:
			case LITERAL_class:
			case LITERAL_interface:
			case LITERAL_enum:
			{
				typeDefinitionInternal(mods_AST);
				td_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					classField_AST = (AST)currentAST.root;
					classField_AST = td_AST;
					currentAST.root = classField_AST;
					currentAST.child = classField_AST!=null &&classField_AST.getFirstChild()!=null ?
						classField_AST.getFirstChild() : classField_AST;
					currentAST.advanceChildToEnd();
				}
				break;
			}
			case LT:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			{
				{
				switch ( LA(1)) {
				case LT:
				{
					typeParameters();
					tp_AST = (AST)returnAST;
					break;
				}
				case LITERAL_void:
				case LITERAL_boolean:
				case LITERAL_byte:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_float:
				case LITERAL_long:
				case LITERAL_double:
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				if ((LA(1)==IDENT) && (LA(2)==LPAREN)) {
					ctorHead();
					h_AST = (AST)returnAST;
					constructorBody();
					s_AST = (AST)returnAST;
					if ( inputState.guessing==0 ) {
						classField_AST = (AST)currentAST.root;
						classField_AST = (AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(CTOR_DEF,"CTOR_DEF")).add(mods_AST).add(tp_AST).add(h_AST).add(s_AST));
						currentAST.root = classField_AST;
						currentAST.child = classField_AST!=null &&classField_AST.getFirstChild()!=null ?
							classField_AST.getFirstChild() : classField_AST;
						currentAST.advanceChildToEnd();
					}
				}
				else if (((LA(1) >= LITERAL_void && LA(1) <= IDENT)) && (_tokenSet_7.member(LA(2)))) {
					typeSpec(false);
					t_AST = (AST)returnAST;
					{
					if ((LA(1)==IDENT) && (LA(2)==LPAREN)) {
						id = LT(1);
						id_AST = astFactory.create(id);
						match(IDENT);
						match(LPAREN);
						parameterDeclarationList();
						param_AST = (AST)returnAST;
						match(RPAREN);
						declaratorBrackets(t_AST);
						rt_AST = (AST)returnAST;
						{
						switch ( LA(1)) {
						case LITERAL_throws:
						{
							throwsClause();
							tc_AST = (AST)returnAST;
							break;
						}
						case SEMI:
						case LCURLY:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						{
						switch ( LA(1)) {
						case LCURLY:
						{
							compoundStatement();
							s2_AST = (AST)returnAST;
							if ( inputState.guessing==0 ) {
								classField_AST = (AST)currentAST.root;
								classField_AST = (AST)astFactory.make( (new ASTArray(8)).add(astFactory.create(METHOD_DEF,"METHOD_DEF")).add(mods_AST).add(tp_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(rt_AST))).add(id_AST).add(param_AST).add(tc_AST).add(s2_AST));
								currentAST.root = classField_AST;
								currentAST.child = classField_AST!=null &&classField_AST.getFirstChild()!=null ?
									classField_AST.getFirstChild() : classField_AST;
								currentAST.advanceChildToEnd();
							}
							break;
						}
						case SEMI:
						{
							sm = LT(1);
							sm_AST = astFactory.create(sm);
							match(SEMI);
							if ( inputState.guessing==0 ) {
								classField_AST = (AST)currentAST.root;
								classField_AST = (AST)astFactory.make( (new ASTArray(8)).add(astFactory.create(METHOD_DEF,"METHOD_DEF")).add(mods_AST).add(tp_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(rt_AST))).add(id_AST).add(param_AST).add(tc_AST).add(sm_AST));
								currentAST.root = classField_AST;
								currentAST.child = classField_AST!=null &&classField_AST.getFirstChild()!=null ?
									classField_AST.getFirstChild() : classField_AST;
								currentAST.advanceChildToEnd();
							}
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
					}
					else if ((LA(1)==IDENT) && (_tokenSet_8.member(LA(2)))) {
						variableDefinitions(mods_AST,t_AST);
						v_AST = (AST)returnAST;
						vs = LT(1);
						vs_AST = astFactory.create(vs);
						match(SEMI);
						if ( inputState.guessing==0 ) {
							classField_AST = (AST)currentAST.root;
							classField_AST = v_AST; v_AST.addChild(vs_AST);
							currentAST.root = classField_AST;
							currentAST.child = classField_AST!=null &&classField_AST.getFirstChild()!=null ?
								classField_AST.getFirstChild() : classField_AST;
							currentAST.advanceChildToEnd();
						}
					}
					else {
						throw new NoViableAltException(LT(1), getFilename());
					}
					
					}
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		else if ((LA(1)==LITERAL_static) && (LA(2)==LCURLY)) {
			match(LITERAL_static);
			compoundStatement();
			s3_AST = (AST)returnAST;
			if ( inputState.guessing==0 ) {
				classField_AST = (AST)currentAST.root;
				classField_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(STATIC_INIT,"STATIC_INIT")).add(s3_AST));
				currentAST.root = classField_AST;
				currentAST.child = classField_AST!=null &&classField_AST.getFirstChild()!=null ?
					classField_AST.getFirstChild() : classField_AST;
				currentAST.advanceChildToEnd();
			}
		}
		else if ((LA(1)==LCURLY)) {
			compoundStatement();
			s4_AST = (AST)returnAST;
			if ( inputState.guessing==0 ) {
				classField_AST = (AST)currentAST.root;
				classField_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INSTANCE_INIT,"INSTANCE_INIT")).add(s4_AST));
				currentAST.root = classField_AST;
				currentAST.child = classField_AST!=null &&classField_AST.getFirstChild()!=null ?
					classField_AST.getFirstChild() : classField_AST;
				currentAST.advanceChildToEnd();
			}
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = classField_AST;
	}
	
	public final void identifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identifier_AST = null;
		
		AST tmp10_AST = null;
		tmp10_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp10_AST);
		match(IDENT);
		{
		_loop48:
		do {
			if ((LA(1)==DOT)) {
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp11_AST);
				match(DOT);
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(IDENT);
			}
			else {
				break _loop48;
			}
			
		} while (true);
		}
		identifier_AST = (AST)currentAST.root;
		returnAST = identifier_AST;
	}
	
	public final void identifierStar() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identifierStar_AST = null;
		
		AST tmp13_AST = null;
		tmp13_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp13_AST);
		match(IDENT);
		{
		_loop51:
		do {
			if ((LA(1)==DOT) && (LA(2)==IDENT)) {
				AST tmp14_AST = null;
				tmp14_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp14_AST);
				match(DOT);
				AST tmp15_AST = null;
				tmp15_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp15_AST);
				match(IDENT);
			}
			else {
				break _loop51;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case DOT:
		{
			AST tmp16_AST = null;
			tmp16_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp16_AST);
			match(DOT);
			AST tmp17_AST = null;
			tmp17_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp17_AST);
			match(STAR);
			break;
		}
		case SEMI:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		identifierStar_AST = (AST)currentAST.root;
		returnAST = identifierStar_AST;
	}
	
	public final void modifiers() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST modifiers_AST = null;
		
		{
		_loop55:
		do {
			if ((_tokenSet_9.member(LA(1)))) {
				modifier();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if (((LA(1)==AT) && (LA(2)==IDENT))&&(LA(1)==AT && !LT(2).getText().equals("interface"))) {
				annotation();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop55;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			modifiers_AST = (AST)currentAST.root;
			modifiers_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MODIFIERS,"MODIFIERS")).add(modifiers_AST));
			currentAST.root = modifiers_AST;
			currentAST.child = modifiers_AST!=null &&modifiers_AST.getFirstChild()!=null ?
				modifiers_AST.getFirstChild() : modifiers_AST;
			currentAST.advanceChildToEnd();
		}
		modifiers_AST = (AST)currentAST.root;
		returnAST = modifiers_AST;
	}
	
	protected final void typeDefinitionInternal(
		AST mods
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeDefinitionInternal_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_class:
		{
			classDefinition(mods);
			astFactory.addASTChild(currentAST, returnAST);
			typeDefinitionInternal_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_interface:
		{
			interfaceDefinition(mods);
			astFactory.addASTChild(currentAST, returnAST);
			typeDefinitionInternal_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_enum:
		{
			enumDefinition(mods);
			astFactory.addASTChild(currentAST, returnAST);
			typeDefinitionInternal_AST = (AST)currentAST.root;
			break;
		}
		case AT:
		{
			annotationDefinition(mods);
			astFactory.addASTChild(currentAST, returnAST);
			typeDefinitionInternal_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = typeDefinitionInternal_AST;
	}
	
	public final void classDefinition(
		AST modifiers
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classDefinition_AST = null;
		Token  kw = null;
		AST kw_AST = null;
		AST tp_AST = null;
		AST sc_AST = null;
		AST ic_AST = null;
		AST cb_AST = null;
		
		kw = LT(1);
		kw_AST = astFactory.create(kw);
		match(LITERAL_class);
		AST tmp18_AST = null;
		tmp18_AST = astFactory.create(LT(1));
		match(IDENT);
		{
		switch ( LA(1)) {
		case LT:
		{
			typeParameters();
			tp_AST = (AST)returnAST;
			break;
		}
		case LITERAL_extends:
		case LCURLY:
		case LITERAL_implements:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		superClassClause();
		sc_AST = (AST)returnAST;
		implementsClause();
		ic_AST = (AST)returnAST;
		classBlock();
		cb_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			classDefinition_AST = (AST)currentAST.root;
			classDefinition_AST = (AST)astFactory.make( (new ASTArray(8)).add(astFactory.create(CLASS_DEF,"CLASS_DEF")).add(kw_AST).add(modifiers).add(tmp18_AST).add(tp_AST).add(sc_AST).add(ic_AST).add(cb_AST));
			currentAST.root = classDefinition_AST;
			currentAST.child = classDefinition_AST!=null &&classDefinition_AST.getFirstChild()!=null ?
				classDefinition_AST.getFirstChild() : classDefinition_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = classDefinition_AST;
	}
	
	public final void interfaceDefinition(
		AST modifiers
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interfaceDefinition_AST = null;
		Token  kw = null;
		AST kw_AST = null;
		AST tp_AST = null;
		AST ie_AST = null;
		AST ib_AST = null;
		
		kw = LT(1);
		kw_AST = astFactory.create(kw);
		match(LITERAL_interface);
		AST tmp19_AST = null;
		tmp19_AST = astFactory.create(LT(1));
		match(IDENT);
		{
		switch ( LA(1)) {
		case LT:
		{
			typeParameters();
			tp_AST = (AST)returnAST;
			break;
		}
		case LITERAL_extends:
		case LCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		interfaceExtends();
		ie_AST = (AST)returnAST;
		interfaceBlock();
		ib_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			interfaceDefinition_AST = (AST)currentAST.root;
			interfaceDefinition_AST = (AST)astFactory.make( (new ASTArray(7)).add(astFactory.create(INTERFACE_DEF,"INTERFACE_DEF")).add(kw_AST).add(modifiers).add(tmp19_AST).add(tp_AST).add(ie_AST).add(ib_AST));
			currentAST.root = interfaceDefinition_AST;
			currentAST.child = interfaceDefinition_AST!=null &&interfaceDefinition_AST.getFirstChild()!=null ?
				interfaceDefinition_AST.getFirstChild() : interfaceDefinition_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = interfaceDefinition_AST;
	}
	
	public final void enumDefinition(
		AST modifiers
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumDefinition_AST = null;
		Token  kw = null;
		AST kw_AST = null;
		AST ic_AST = null;
		AST eb_AST = null;
		
		kw = LT(1);
		kw_AST = astFactory.create(kw);
		match(LITERAL_enum);
		AST tmp20_AST = null;
		tmp20_AST = astFactory.create(LT(1));
		match(IDENT);
		implementsClause();
		ic_AST = (AST)returnAST;
		enumBlock();
		eb_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			enumDefinition_AST = (AST)currentAST.root;
			enumDefinition_AST = (AST)astFactory.make( (new ASTArray(6)).add(astFactory.create(ENUM_DEF,"ENUM_DEF")).add(kw_AST).add(modifiers).add(tmp20_AST).add(ic_AST).add(eb_AST));
			currentAST.root = enumDefinition_AST;
			currentAST.child = enumDefinition_AST!=null &&enumDefinition_AST.getFirstChild()!=null ?
				enumDefinition_AST.getFirstChild() : enumDefinition_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = enumDefinition_AST;
	}
	
	public final void annotationDefinition(
		AST modifiers
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationDefinition_AST = null;
		AST ab_AST = null;
		
		AST tmp21_AST = null;
		tmp21_AST = astFactory.create(LT(1));
		match(AT);
		match(LITERAL_interface);
		AST tmp23_AST = null;
		tmp23_AST = astFactory.create(LT(1));
		match(IDENT);
		annotationBlock();
		ab_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			annotationDefinition_AST = (AST)currentAST.root;
			annotationDefinition_AST = (AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(ANNOTATION_DEF,"ANNOTATION_DEF")).add(modifiers).add(tmp23_AST).add(ab_AST));
			currentAST.root = annotationDefinition_AST;
			currentAST.child = annotationDefinition_AST!=null &&annotationDefinition_AST.getFirstChild()!=null ?
				annotationDefinition_AST.getFirstChild() : annotationDefinition_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = annotationDefinition_AST;
	}
	
	public final void declaration() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaration_AST = null;
		AST m_AST = null;
		AST t_AST = null;
		AST v_AST = null;
		
		modifiers();
		m_AST = (AST)returnAST;
		typeSpec(false);
		t_AST = (AST)returnAST;
		variableDefinitions(m_AST,t_AST);
		v_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			declaration_AST = (AST)currentAST.root;
			declaration_AST = v_AST;
			currentAST.root = declaration_AST;
			currentAST.child = declaration_AST!=null &&declaration_AST.getFirstChild()!=null ?
				declaration_AST.getFirstChild() : declaration_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = declaration_AST;
	}
	
	public final void typeSpec(
		boolean addImagNode
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeSpec_AST = null;
		
		switch ( LA(1)) {
		case IDENT:
		{
			classTypeSpec(addImagNode);
			astFactory.addASTChild(currentAST, returnAST);
			typeSpec_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		{
			builtInTypeSpec(addImagNode);
			astFactory.addASTChild(currentAST, returnAST);
			typeSpec_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = typeSpec_AST;
	}
	
	public final void variableDefinitions(
		AST mods, AST t
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variableDefinitions_AST = null;
		
		variableDeclarator(getASTFactory().dupTree(mods),
							getASTFactory().dupList(t));
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop155:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				variableDeclarator(getASTFactory().dupTree(mods),
							getASTFactory().dupList(t));
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop155;
			}
			
		} while (true);
		}
		variableDefinitions_AST = (AST)currentAST.root;
		returnAST = variableDefinitions_AST;
	}
	
	public final void classTypeSpec(
		boolean addImagNode
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classTypeSpec_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		classOrInterfaceType(false);
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop21:
		do {
			if ((LA(1)==LBRACK) && (LA(2)==RBRACK)) {
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if ( inputState.guessing==0 ) {
					lb_AST.setType(ARRAY_DECLARATOR);
				}
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(RBRACK);
			}
			else {
				break _loop21;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			classTypeSpec_AST = (AST)currentAST.root;
			
						if ( addImagNode ) {
							classTypeSpec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(classTypeSpec_AST));
						}
					
			currentAST.root = classTypeSpec_AST;
			currentAST.child = classTypeSpec_AST!=null &&classTypeSpec_AST.getFirstChild()!=null ?
				classTypeSpec_AST.getFirstChild() : classTypeSpec_AST;
			currentAST.advanceChildToEnd();
		}
		classTypeSpec_AST = (AST)currentAST.root;
		returnAST = classTypeSpec_AST;
	}
	
	public final void builtInTypeSpec(
		boolean addImagNode
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST builtInTypeSpec_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		builtInType();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop43:
		do {
			if ((LA(1)==LBRACK)) {
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if ( inputState.guessing==0 ) {
					lb_AST.setType(ARRAY_DECLARATOR);
				}
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(RBRACK);
			}
			else {
				break _loop43;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			builtInTypeSpec_AST = (AST)currentAST.root;
			
						if ( addImagNode ) {
							builtInTypeSpec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(builtInTypeSpec_AST));
						}
					
			currentAST.root = builtInTypeSpec_AST;
			currentAST.child = builtInTypeSpec_AST!=null &&builtInTypeSpec_AST.getFirstChild()!=null ?
				builtInTypeSpec_AST.getFirstChild() : builtInTypeSpec_AST;
			currentAST.advanceChildToEnd();
		}
		builtInTypeSpec_AST = (AST)currentAST.root;
		returnAST = builtInTypeSpec_AST;
	}
	
	public final void classOrInterfaceType(
		boolean addImagNode
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classOrInterfaceType_AST = null;
		AST t_AST = null;
		
		identifier();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LT:
		{
			typeArguments();
			t_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case SEMI:
		case LBRACK:
		case RBRACK:
		case QUESTION:
		case LITERAL_extends:
		case LITERAL_super:
		case COMMA:
		case GT:
		case SR:
		case BSR:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case RPAREN:
		case ASSIGN:
		case LCURLY:
		case RCURLY:
		case BAND:
		case LITERAL_implements:
		case LITERAL_this:
		case TRIPLE_DOT:
		case COLON:
		case PLUS_ASSIGN:
		case MINUS_ASSIGN:
		case STAR_ASSIGN:
		case DIV_ASSIGN:
		case MOD_ASSIGN:
		case SR_ASSIGN:
		case BSR_ASSIGN:
		case SL_ASSIGN:
		case BAND_ASSIGN:
		case BXOR_ASSIGN:
		case BOR_ASSIGN:
		case LOR:
		case LAND:
		case BOR:
		case BXOR:
		case NOT_EQUAL:
		case EQUAL:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			classOrInterfaceType_AST = (AST)currentAST.root;
			
			
			boolean generic = ((t_AST == null) ? false : true);
						if ( addImagNode ) {
			if(generic == false) {
							classOrInterfaceType_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(classOrInterfaceType_AST));
			}
			else {
			classOrInterfaceType_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERIC_TYPE,"GENERIC_TYPETYPE")).add(classOrInterfaceType_AST));
			}
						}
			else if(generic == true)
			{
			classOrInterfaceType_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(GENERIC_TYPE,"GENERIC_TYPETYPE")).add(classOrInterfaceType_AST));
			}
					
			currentAST.root = classOrInterfaceType_AST;
			currentAST.child = classOrInterfaceType_AST!=null &&classOrInterfaceType_AST.getFirstChild()!=null ?
				classOrInterfaceType_AST.getFirstChild() : classOrInterfaceType_AST;
			currentAST.advanceChildToEnd();
		}
		classOrInterfaceType_AST = (AST)currentAST.root;
		returnAST = classOrInterfaceType_AST;
	}
	
	public final void typeArguments() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeArguments_AST = null;
		int currentLtLevel = 0;
		
		if ( inputState.guessing==0 ) {
			currentLtLevel = ltCounter;
		}
		match(LT);
		if ( inputState.guessing==0 ) {
			ltCounter++;
		}
		typeArgument();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop33:
		do {
			if (((LA(1)==COMMA) && (_tokenSet_10.member(LA(2))))&&(inputState.guessing !=0 || ltCounter == currentLtLevel + 1)) {
				match(COMMA);
				typeArgument();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop33;
			}
			
		} while (true);
		}
		{
		if (((LA(1) >= GT && LA(1) <= BSR)) && (_tokenSet_11.member(LA(2)))) {
			typeArgumentsOrParametersEnd();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_11.member(LA(1))) && (_tokenSet_12.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		if (!((currentLtLevel != 0) || ltCounter == currentLtLevel))
		  throw new SemanticException("(currentLtLevel != 0) || ltCounter == currentLtLevel");
		if ( inputState.guessing==0 ) {
			typeArguments_AST = (AST)currentAST.root;
			typeArguments_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_ARGUMENTS,"TYPE_ARGUMENTS")).add(typeArguments_AST));
			currentAST.root = typeArguments_AST;
			currentAST.child = typeArguments_AST!=null &&typeArguments_AST.getFirstChild()!=null ?
				typeArguments_AST.getFirstChild() : typeArguments_AST;
			currentAST.advanceChildToEnd();
		}
		typeArguments_AST = (AST)currentAST.root;
		returnAST = typeArguments_AST;
	}
	
	public final void typeArgumentSpec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeArgumentSpec_AST = null;
		
		switch ( LA(1)) {
		case IDENT:
		{
			classTypeSpec(true);
			astFactory.addASTChild(currentAST, returnAST);
			typeArgumentSpec_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		{
			builtInTypeArraySpec(true);
			astFactory.addASTChild(currentAST, returnAST);
			typeArgumentSpec_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = typeArgumentSpec_AST;
	}
	
	public final void builtInTypeArraySpec(
		boolean addImagNode
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST builtInTypeArraySpec_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		builtInType();
		astFactory.addASTChild(currentAST, returnAST);
		{
		int _cnt40=0;
		_loop40:
		do {
			if ((LA(1)==LBRACK) && (LA(2)==RBRACK)) {
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if ( inputState.guessing==0 ) {
					lb_AST.setType(ARRAY_DECLARATOR);
				}
				AST tmp29_AST = null;
				tmp29_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(RBRACK);
			}
			else {
				if ( _cnt40>=1 ) { break _loop40; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt40++;
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			builtInTypeArraySpec_AST = (AST)currentAST.root;
			
						if ( addImagNode ) {
							builtInTypeArraySpec_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(builtInTypeArraySpec_AST));
						}
					
			currentAST.root = builtInTypeArraySpec_AST;
			currentAST.child = builtInTypeArraySpec_AST!=null &&builtInTypeArraySpec_AST.getFirstChild()!=null ?
				builtInTypeArraySpec_AST.getFirstChild() : builtInTypeArraySpec_AST;
			currentAST.advanceChildToEnd();
		}
		builtInTypeArraySpec_AST = (AST)currentAST.root;
		returnAST = builtInTypeArraySpec_AST;
	}
	
	public final void typeArgument() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeArgument_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		{
			typeArgumentSpec();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case QUESTION:
		{
			wildcardType();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			typeArgument_AST = (AST)currentAST.root;
			typeArgument_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_ARGUMENT,"TYPE_ARGUMENT")).add(typeArgument_AST));
			currentAST.root = typeArgument_AST;
			currentAST.child = typeArgument_AST!=null &&typeArgument_AST.getFirstChild()!=null ?
				typeArgument_AST.getFirstChild() : typeArgument_AST;
			currentAST.advanceChildToEnd();
		}
		typeArgument_AST = (AST)currentAST.root;
		returnAST = typeArgument_AST;
	}
	
	public final void wildcardType() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST wildcardType_AST = null;
		Token  q = null;
		AST q_AST = null;
		
		q = LT(1);
		q_AST = astFactory.create(q);
		astFactory.makeASTRoot(currentAST, q_AST);
		match(QUESTION);
		if ( inputState.guessing==0 ) {
			q_AST.setType(WILDCARD_TYPE);
		}
		{
		boolean synPredMatched30 = false;
		if (((LA(1)==LITERAL_extends||LA(1)==LITERAL_super) && (LA(2)==IDENT))) {
			int _m30 = mark();
			synPredMatched30 = true;
			inputState.guessing++;
			try {
				{
				switch ( LA(1)) {
				case LITERAL_extends:
				{
					match(LITERAL_extends);
					break;
				}
				case LITERAL_super:
				{
					match(LITERAL_super);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			catch (RecognitionException pe) {
				synPredMatched30 = false;
			}
			rewind(_m30);
			inputState.guessing--;
		}
		if ( synPredMatched30 ) {
			typeArgumentBounds();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_11.member(LA(1))) && (_tokenSet_13.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		wildcardType_AST = (AST)currentAST.root;
		returnAST = wildcardType_AST;
	}
	
	public final void typeArgumentBounds() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeArgumentBounds_AST = null;
		boolean isUpperBounds = false;
		
		{
		switch ( LA(1)) {
		case LITERAL_extends:
		{
			match(LITERAL_extends);
			if ( inputState.guessing==0 ) {
				isUpperBounds=true;
			}
			break;
		}
		case LITERAL_super:
		{
			match(LITERAL_super);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		classOrInterfaceType(false);
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			typeArgumentBounds_AST = (AST)currentAST.root;
			
						if (isUpperBounds)
						{
							typeArgumentBounds_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_UPPER_BOUNDS,"TYPE_UPPER_BOUNDS")).add(typeArgumentBounds_AST));
						}
						else
						{
							typeArgumentBounds_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_LOWER_BOUNDS,"TYPE_LOWER_BOUNDS")).add(typeArgumentBounds_AST));
						}
					
			currentAST.root = typeArgumentBounds_AST;
			currentAST.child = typeArgumentBounds_AST!=null &&typeArgumentBounds_AST.getFirstChild()!=null ?
				typeArgumentBounds_AST.getFirstChild() : typeArgumentBounds_AST;
			currentAST.advanceChildToEnd();
		}
		typeArgumentBounds_AST = (AST)currentAST.root;
		returnAST = typeArgumentBounds_AST;
	}
	
	protected final void typeArgumentsOrParametersEnd() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeArgumentsOrParametersEnd_AST = null;
		
		switch ( LA(1)) {
		case GT:
		{
			match(GT);
			if ( inputState.guessing==0 ) {
				ltCounter-=1;
			}
			typeArgumentsOrParametersEnd_AST = (AST)currentAST.root;
			break;
		}
		case SR:
		{
			match(SR);
			if ( inputState.guessing==0 ) {
				ltCounter-=2;
			}
			typeArgumentsOrParametersEnd_AST = (AST)currentAST.root;
			break;
		}
		case BSR:
		{
			match(BSR);
			if ( inputState.guessing==0 ) {
				ltCounter-=3;
			}
			typeArgumentsOrParametersEnd_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = typeArgumentsOrParametersEnd_AST;
	}
	
	public final void builtInType() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST builtInType_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_void:
		{
			AST tmp35_AST = null;
			tmp35_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp35_AST);
			match(LITERAL_void);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_boolean:
		{
			AST tmp36_AST = null;
			tmp36_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp36_AST);
			match(LITERAL_boolean);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_byte:
		{
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(LITERAL_byte);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char:
		{
			AST tmp38_AST = null;
			tmp38_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp38_AST);
			match(LITERAL_char);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_short:
		{
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(LITERAL_short);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_int:
		{
			AST tmp40_AST = null;
			tmp40_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp40_AST);
			match(LITERAL_int);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_float:
		{
			AST tmp41_AST = null;
			tmp41_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp41_AST);
			match(LITERAL_float);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_long:
		{
			AST tmp42_AST = null;
			tmp42_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp42_AST);
			match(LITERAL_long);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_double:
		{
			AST tmp43_AST = null;
			tmp43_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp43_AST);
			match(LITERAL_double);
			builtInType_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = builtInType_AST;
	}
	
	public final void type() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST type_AST = null;
		
		switch ( LA(1)) {
		case IDENT:
		{
			classOrInterfaceType(false);
			astFactory.addASTChild(currentAST, returnAST);
			type_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		{
			builtInType();
			astFactory.addASTChild(currentAST, returnAST);
			type_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = type_AST;
	}
	
	public final void modifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST modifier_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_private:
		{
			AST tmp44_AST = null;
			tmp44_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp44_AST);
			match(LITERAL_private);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_public:
		{
			AST tmp45_AST = null;
			tmp45_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp45_AST);
			match(LITERAL_public);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_protected:
		{
			AST tmp46_AST = null;
			tmp46_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp46_AST);
			match(LITERAL_protected);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_static:
		{
			AST tmp47_AST = null;
			tmp47_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp47_AST);
			match(LITERAL_static);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_transient:
		{
			AST tmp48_AST = null;
			tmp48_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp48_AST);
			match(LITERAL_transient);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case FINAL:
		{
			AST tmp49_AST = null;
			tmp49_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp49_AST);
			match(FINAL);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case ABSTRACT:
		{
			AST tmp50_AST = null;
			tmp50_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp50_AST);
			match(ABSTRACT);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_native:
		{
			AST tmp51_AST = null;
			tmp51_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp51_AST);
			match(LITERAL_native);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_threadsafe:
		{
			AST tmp52_AST = null;
			tmp52_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp52_AST);
			match(LITERAL_threadsafe);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_synchronized:
		{
			AST tmp53_AST = null;
			tmp53_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp53_AST);
			match(LITERAL_synchronized);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_volatile:
		{
			AST tmp54_AST = null;
			tmp54_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp54_AST);
			match(LITERAL_volatile);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		case STRICTFP:
		{
			AST tmp55_AST = null;
			tmp55_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp55_AST);
			match(STRICTFP);
			modifier_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = modifier_AST;
	}
	
	public final void annotation() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotation_AST = null;
		AST i_AST = null;
		AST args_AST = null;
		
		match(AT);
		identifier();
		i_AST = (AST)returnAST;
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_super:
			case LT:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			case AT:
			case LPAREN:
			case LCURLY:
			case LITERAL_this:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BNOT:
			case LNOT:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_null:
			case LITERAL_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_LONG:
			case NUM_DOUBLE:
			{
				annotationArguments();
				args_AST = (AST)returnAST;
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			break;
		}
		case FINAL:
		case ABSTRACT:
		case STRICTFP:
		case LITERAL_package:
		case SEMI:
		case LITERAL_static:
		case LT:
		case COMMA:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LITERAL_private:
		case LITERAL_public:
		case LITERAL_protected:
		case LITERAL_transient:
		case LITERAL_native:
		case LITERAL_threadsafe:
		case LITERAL_synchronized:
		case LITERAL_volatile:
		case AT:
		case RPAREN:
		case RCURLY:
		case LITERAL_class:
		case LITERAL_interface:
		case LITERAL_enum:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			annotation_AST = (AST)currentAST.root;
			annotation_AST = (AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(ANNOTATION,"ANNOTATION")).add(i_AST).add(args_AST));
			currentAST.root = annotation_AST;
			currentAST.child = annotation_AST!=null &&annotation_AST.getFirstChild()!=null ?
				annotation_AST.getFirstChild() : annotation_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = annotation_AST;
	}
	
	public final void annotationArguments() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationArguments_AST = null;
		
		if ((_tokenSet_14.member(LA(1))) && (_tokenSet_15.member(LA(2)))) {
			annotationMemberValueInitializer();
			astFactory.addASTChild(currentAST, returnAST);
			annotationArguments_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==IDENT) && (LA(2)==ASSIGN)) {
			anntotationMemberValuePairs();
			astFactory.addASTChild(currentAST, returnAST);
			annotationArguments_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = annotationArguments_AST;
	}
	
	public final void annotationMemberValueInitializer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationMemberValueInitializer_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			conditionalExpression();
			astFactory.addASTChild(currentAST, returnAST);
			annotationMemberValueInitializer_AST = (AST)currentAST.root;
			break;
		}
		case AT:
		{
			annotation();
			astFactory.addASTChild(currentAST, returnAST);
			annotationMemberValueInitializer_AST = (AST)currentAST.root;
			break;
		}
		case LCURLY:
		{
			annotationMemberArrayInitializer();
			astFactory.addASTChild(currentAST, returnAST);
			annotationMemberValueInitializer_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = annotationMemberValueInitializer_AST;
	}
	
	public final void anntotationMemberValuePairs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST anntotationMemberValuePairs_AST = null;
		
		annotationMemberValuePair();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop66:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				annotationMemberValuePair();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop66;
			}
			
		} while (true);
		}
		anntotationMemberValuePairs_AST = (AST)currentAST.root;
		returnAST = anntotationMemberValuePairs_AST;
	}
	
	public final void annotationMemberValuePair() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationMemberValuePair_AST = null;
		Token  i = null;
		AST i_AST = null;
		AST v_AST = null;
		
		i = LT(1);
		i_AST = astFactory.create(i);
		match(IDENT);
		match(ASSIGN);
		annotationMemberValueInitializer();
		v_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			annotationMemberValuePair_AST = (AST)currentAST.root;
			annotationMemberValuePair_AST = (AST)astFactory.make( (new ASTArray(3)).add(astFactory.create(ANNOTATION_MEMBER_VALUE_PAIR,"ANNOTATION_MEMBER_VALUE_PAIR")).add(i_AST).add(v_AST));
			currentAST.root = annotationMemberValuePair_AST;
			currentAST.child = annotationMemberValuePair_AST!=null &&annotationMemberValuePair_AST.getFirstChild()!=null ?
				annotationMemberValuePair_AST.getFirstChild() : annotationMemberValuePair_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = annotationMemberValuePair_AST;
	}
	
	public final void conditionalExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conditionalExpression_AST = null;
		
		logicalOrExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case QUESTION:
		{
			AST tmp61_AST = null;
			tmp61_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp61_AST);
			match(QUESTION);
			assignmentExpression();
			astFactory.addASTChild(currentAST, returnAST);
			match(COLON);
			conditionalExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case SEMI:
		case RBRACK:
		case COMMA:
		case RPAREN:
		case ASSIGN:
		case RCURLY:
		case COLON:
		case PLUS_ASSIGN:
		case MINUS_ASSIGN:
		case STAR_ASSIGN:
		case DIV_ASSIGN:
		case MOD_ASSIGN:
		case SR_ASSIGN:
		case BSR_ASSIGN:
		case SL_ASSIGN:
		case BAND_ASSIGN:
		case BXOR_ASSIGN:
		case BOR_ASSIGN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		conditionalExpression_AST = (AST)currentAST.root;
		returnAST = conditionalExpression_AST;
	}
	
	public final void annotationMemberArrayInitializer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationMemberArrayInitializer_AST = null;
		Token  lc = null;
		AST lc_AST = null;
		
		lc = LT(1);
		lc_AST = astFactory.create(lc);
		astFactory.makeASTRoot(currentAST, lc_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			lc_AST.setType(ANNOTATION_ARRAY_INIT);
		}
		{
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case AT:
		case LPAREN:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			annotationMemberArrayValueInitializer();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop72:
			do {
				if ((LA(1)==COMMA) && (_tokenSet_16.member(LA(2)))) {
					match(COMMA);
					annotationMemberArrayValueInitializer();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop72;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				break;
			}
			case RCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(RCURLY);
		annotationMemberArrayInitializer_AST = (AST)currentAST.root;
		returnAST = annotationMemberArrayInitializer_AST;
	}
	
	public final void annotationMemberArrayValueInitializer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationMemberArrayValueInitializer_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			conditionalExpression();
			astFactory.addASTChild(currentAST, returnAST);
			annotationMemberArrayValueInitializer_AST = (AST)currentAST.root;
			break;
		}
		case AT:
		{
			annotation();
			astFactory.addASTChild(currentAST, returnAST);
			annotationMemberArrayValueInitializer_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = annotationMemberArrayValueInitializer_AST;
	}
	
	public final void superClassClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST superClassClause_AST = null;
		AST c_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_extends:
		{
			match(LITERAL_extends);
			classOrInterfaceType(false);
			c_AST = (AST)returnAST;
			break;
		}
		case LCURLY:
		case LITERAL_implements:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			superClassClause_AST = (AST)currentAST.root;
			superClassClause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXTENDS_CLAUSE,"EXTENDS_CLAUSE")).add(c_AST));
			currentAST.root = superClassClause_AST;
			currentAST.child = superClassClause_AST!=null &&superClassClause_AST.getFirstChild()!=null ?
				superClassClause_AST.getFirstChild() : superClassClause_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = superClassClause_AST;
	}
	
	public final void typeParameters() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeParameters_AST = null;
		int currentLtLevel = 0;
		
		if ( inputState.guessing==0 ) {
			currentLtLevel = ltCounter;
		}
		match(LT);
		if ( inputState.guessing==0 ) {
			ltCounter++;
		}
		typeParameter();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop85:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				typeParameter();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop85;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case GT:
		case SR:
		case BSR:
		{
			typeArgumentsOrParametersEnd();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_extends:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LCURLY:
		case LITERAL_implements:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if (!((currentLtLevel != 0) || ltCounter == currentLtLevel))
		  throw new SemanticException("(currentLtLevel != 0) || ltCounter == currentLtLevel");
		if ( inputState.guessing==0 ) {
			typeParameters_AST = (AST)currentAST.root;
			typeParameters_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_PARAMETERS,"TYPE_PARAMETERS")).add(typeParameters_AST));
			currentAST.root = typeParameters_AST;
			currentAST.child = typeParameters_AST!=null &&typeParameters_AST.getFirstChild()!=null ?
				typeParameters_AST.getFirstChild() : typeParameters_AST;
			currentAST.advanceChildToEnd();
		}
		typeParameters_AST = (AST)currentAST.root;
		returnAST = typeParameters_AST;
	}
	
	public final void implementsClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST implementsClause_AST = null;
		Token  i = null;
		AST i_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_implements:
		{
			i = LT(1);
			i_AST = astFactory.create(i);
			match(LITERAL_implements);
			classOrInterfaceType(false);
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop133:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					classOrInterfaceType(false);
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop133;
				}
				
			} while (true);
			}
			break;
		}
		case LCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			implementsClause_AST = (AST)currentAST.root;
			implementsClause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(IMPLEMENTS_CLAUSE,"IMPLEMENTS_CLAUSE")).add(implementsClause_AST));
			currentAST.root = implementsClause_AST;
			currentAST.child = implementsClause_AST!=null &&implementsClause_AST.getFirstChild()!=null ?
				implementsClause_AST.getFirstChild() : implementsClause_AST;
			currentAST.advanceChildToEnd();
		}
		implementsClause_AST = (AST)currentAST.root;
		returnAST = implementsClause_AST;
	}
	
	public final void classBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST classBlock_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  r = null;
		AST r_AST = null;
		
		l = LT(1);
		l_AST = astFactory.create(l);
		astFactory.addASTChild(currentAST, l_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			l_AST.setType(START_CLASS_BODY);
		}
		{
		_loop95:
		do {
			switch ( LA(1)) {
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
			case LITERAL_static:
			case LT:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			case LITERAL_private:
			case LITERAL_public:
			case LITERAL_protected:
			case LITERAL_transient:
			case LITERAL_native:
			case LITERAL_threadsafe:
			case LITERAL_synchronized:
			case LITERAL_volatile:
			case AT:
			case LCURLY:
			case LITERAL_class:
			case LITERAL_interface:
			case LITERAL_enum:
			{
				classField();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				match(SEMI);
				break;
			}
			default:
			{
				break _loop95;
			}
			}
		} while (true);
		}
		r = LT(1);
		r_AST = astFactory.create(r);
		astFactory.addASTChild(currentAST, r_AST);
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			r_AST.setType(END_CLASS_BODY);
		}
		if ( inputState.guessing==0 ) {
			classBlock_AST = (AST)currentAST.root;
			classBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(OBJBLOCK,"OBJBLOCK")).add(classBlock_AST));
			currentAST.root = classBlock_AST;
			currentAST.child = classBlock_AST!=null &&classBlock_AST.getFirstChild()!=null ?
				classBlock_AST.getFirstChild() : classBlock_AST;
			currentAST.advanceChildToEnd();
		}
		classBlock_AST = (AST)currentAST.root;
		returnAST = classBlock_AST;
	}
	
	public final void interfaceExtends() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interfaceExtends_AST = null;
		Token  e = null;
		AST e_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_extends:
		{
			e = LT(1);
			e_AST = astFactory.create(e);
			match(LITERAL_extends);
			classOrInterfaceType(false);
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop129:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					classOrInterfaceType(false);
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop129;
				}
				
			} while (true);
			}
			break;
		}
		case LCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			interfaceExtends_AST = (AST)currentAST.root;
			interfaceExtends_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXTENDS_CLAUSE,"EXTENDS_CLAUSE")).add(interfaceExtends_AST));
			currentAST.root = interfaceExtends_AST;
			currentAST.child = interfaceExtends_AST!=null &&interfaceExtends_AST.getFirstChild()!=null ?
				interfaceExtends_AST.getFirstChild() : interfaceExtends_AST;
			currentAST.advanceChildToEnd();
		}
		interfaceExtends_AST = (AST)currentAST.root;
		returnAST = interfaceExtends_AST;
	}
	
	public final void interfaceBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interfaceBlock_AST = null;
		Token  l = null;
		AST l_AST = null;
		Token  r = null;
		AST r_AST = null;
		
		l = LT(1);
		l_AST = astFactory.create(l);
		astFactory.addASTChild(currentAST, l_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			l_AST.setType(START_CLASS_BODY);
		}
		{
		_loop98:
		do {
			switch ( LA(1)) {
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
			case LITERAL_static:
			case LT:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			case LITERAL_private:
			case LITERAL_public:
			case LITERAL_protected:
			case LITERAL_transient:
			case LITERAL_native:
			case LITERAL_threadsafe:
			case LITERAL_synchronized:
			case LITERAL_volatile:
			case AT:
			case LITERAL_class:
			case LITERAL_interface:
			case LITERAL_enum:
			{
				interfaceField();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				match(SEMI);
				break;
			}
			default:
			{
				break _loop98;
			}
			}
		} while (true);
		}
		r = LT(1);
		r_AST = astFactory.create(r);
		astFactory.addASTChild(currentAST, r_AST);
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			r_AST.setType(END_CLASS_BODY);
		}
		if ( inputState.guessing==0 ) {
			interfaceBlock_AST = (AST)currentAST.root;
			interfaceBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(OBJBLOCK,"OBJBLOCK")).add(interfaceBlock_AST));
			currentAST.root = interfaceBlock_AST;
			currentAST.child = interfaceBlock_AST!=null &&interfaceBlock_AST.getFirstChild()!=null ?
				interfaceBlock_AST.getFirstChild() : interfaceBlock_AST;
			currentAST.advanceChildToEnd();
		}
		interfaceBlock_AST = (AST)currentAST.root;
		returnAST = interfaceBlock_AST;
	}
	
	public final void enumBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumBlock_AST = null;
		Token  l = null;
		AST l_AST = null;
		AST ec_AST = null;
		Token  cm1 = null;
		AST cm1_AST = null;
		AST ec1_AST = null;
		Token  cm = null;
		AST cm_AST = null;
		Token  r = null;
		AST r_AST = null;
		AST enumConst = null;
		
		l = LT(1);
		l_AST = astFactory.create(l);
		astFactory.addASTChild(currentAST, l_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			l_AST.setType(START_CLASS_BODY);
		}
		{
		switch ( LA(1)) {
		case IDENT:
		case AT:
		{
			enumConstant();
			ec_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				enumConst=ec_AST;
			}
			{
			_loop105:
			do {
				if ((LA(1)==COMMA) && (LA(2)==IDENT||LA(2)==AT)) {
					cm1 = LT(1);
					cm1_AST = astFactory.create(cm1);
					match(COMMA);
					if ( inputState.guessing==0 ) {
						if (enumConst != null) { enumConst.addChild(cm1_AST); }
					}
					enumConstant();
					ec1_AST = (AST)returnAST;
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						enumConst=ec1_AST;
					}
				}
				else {
					break _loop105;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case COMMA:
			{
				cm = LT(1);
				cm_AST = astFactory.create(cm);
				match(COMMA);
				if ( inputState.guessing==0 ) {
					if (enumConst != null) { enumConst.addChild(cm_AST); }
				}
				break;
			}
			case SEMI:
			case RCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case SEMI:
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case SEMI:
		{
			AST tmp73_AST = null;
			tmp73_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp73_AST);
			match(SEMI);
			{
			_loop109:
			do {
				switch ( LA(1)) {
				case FINAL:
				case ABSTRACT:
				case STRICTFP:
				case LITERAL_static:
				case LT:
				case LITERAL_void:
				case LITERAL_boolean:
				case LITERAL_byte:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_float:
				case LITERAL_long:
				case LITERAL_double:
				case IDENT:
				case LITERAL_private:
				case LITERAL_public:
				case LITERAL_protected:
				case LITERAL_transient:
				case LITERAL_native:
				case LITERAL_threadsafe:
				case LITERAL_synchronized:
				case LITERAL_volatile:
				case AT:
				case LCURLY:
				case LITERAL_class:
				case LITERAL_interface:
				case LITERAL_enum:
				{
					classField();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case SEMI:
				{
					match(SEMI);
					break;
				}
				default:
				{
					break _loop109;
				}
				}
			} while (true);
			}
			break;
		}
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		r = LT(1);
		r_AST = astFactory.create(r);
		astFactory.addASTChild(currentAST, r_AST);
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			r_AST.setType(END_CLASS_BODY);
		}
		if ( inputState.guessing==0 ) {
			enumBlock_AST = (AST)currentAST.root;
			enumBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(OBJBLOCK,"OBJBLOCK")).add(enumBlock_AST));
			currentAST.root = enumBlock_AST;
			currentAST.child = enumBlock_AST!=null &&enumBlock_AST.getFirstChild()!=null ?
				enumBlock_AST.getFirstChild() : enumBlock_AST;
			currentAST.advanceChildToEnd();
		}
		enumBlock_AST = (AST)currentAST.root;
		returnAST = enumBlock_AST;
	}
	
	public final void annotationBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationBlock_AST = null;
		
		match(LCURLY);
		{
		_loop101:
		do {
			switch ( LA(1)) {
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
			case LITERAL_static:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			case LITERAL_private:
			case LITERAL_public:
			case LITERAL_protected:
			case LITERAL_transient:
			case LITERAL_native:
			case LITERAL_threadsafe:
			case LITERAL_synchronized:
			case LITERAL_volatile:
			case AT:
			case LITERAL_class:
			case LITERAL_interface:
			case LITERAL_enum:
			{
				annotationField();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				match(SEMI);
				break;
			}
			default:
			{
				break _loop101;
			}
			}
		} while (true);
		}
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			annotationBlock_AST = (AST)currentAST.root;
			annotationBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(OBJBLOCK,"OBJBLOCK")).add(annotationBlock_AST));
			currentAST.root = annotationBlock_AST;
			currentAST.child = annotationBlock_AST!=null &&annotationBlock_AST.getFirstChild()!=null ?
				annotationBlock_AST.getFirstChild() : annotationBlock_AST;
			currentAST.advanceChildToEnd();
		}
		annotationBlock_AST = (AST)currentAST.root;
		returnAST = annotationBlock_AST;
	}
	
	public final void typeParameter() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeParameter_AST = null;
		Token  id = null;
		AST id_AST = null;
		
		{
		id = LT(1);
		id_AST = astFactory.create(id);
		astFactory.addASTChild(currentAST, id_AST);
		match(IDENT);
		}
		{
		if ((LA(1)==LITERAL_extends) && (LA(2)==IDENT)) {
			typeParameterBounds();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_17.member(LA(1))) && (_tokenSet_18.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		if ( inputState.guessing==0 ) {
			typeParameter_AST = (AST)currentAST.root;
			typeParameter_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_PARAMETER,"TYPE_PARAMETER")).add(typeParameter_AST));
			currentAST.root = typeParameter_AST;
			currentAST.child = typeParameter_AST!=null &&typeParameter_AST.getFirstChild()!=null ?
				typeParameter_AST.getFirstChild() : typeParameter_AST;
			currentAST.advanceChildToEnd();
		}
		typeParameter_AST = (AST)currentAST.root;
		returnAST = typeParameter_AST;
	}
	
	public final void typeParameterBounds() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST typeParameterBounds_AST = null;
		
		match(LITERAL_extends);
		classOrInterfaceType(false);
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop92:
		do {
			if ((LA(1)==BAND)) {
				match(BAND);
				classOrInterfaceType(false);
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop92;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			typeParameterBounds_AST = (AST)currentAST.root;
			typeParameterBounds_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE_UPPER_BOUNDS,"TYPE_UPPER_BOUNDS")).add(typeParameterBounds_AST));
			currentAST.root = typeParameterBounds_AST;
			currentAST.child = typeParameterBounds_AST!=null &&typeParameterBounds_AST.getFirstChild()!=null ?
				typeParameterBounds_AST.getFirstChild() : typeParameterBounds_AST;
			currentAST.advanceChildToEnd();
		}
		typeParameterBounds_AST = (AST)currentAST.root;
		returnAST = typeParameterBounds_AST;
	}
	
	public final void interfaceField() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST interfaceField_AST = null;
		AST mods_AST = null;
		AST td_AST = null;
		AST tp_AST = null;
		AST t_AST = null;
		AST param_AST = null;
		AST rt_AST = null;
		AST tc_AST = null;
		Token  sm = null;
		AST sm_AST = null;
		AST v_AST = null;
		Token  vs = null;
		AST vs_AST = null;
		
		modifiers();
		mods_AST = (AST)returnAST;
		{
		switch ( LA(1)) {
		case AT:
		case LITERAL_class:
		case LITERAL_interface:
		case LITERAL_enum:
		{
			typeDefinitionInternal(mods_AST);
			td_AST = (AST)returnAST;
			if ( inputState.guessing==0 ) {
				interfaceField_AST = (AST)currentAST.root;
				interfaceField_AST = td_AST;
				currentAST.root = interfaceField_AST;
				currentAST.child = interfaceField_AST!=null &&interfaceField_AST.getFirstChild()!=null ?
					interfaceField_AST.getFirstChild() : interfaceField_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		{
			{
			switch ( LA(1)) {
			case LT:
			{
				typeParameters();
				tp_AST = (AST)returnAST;
				break;
			}
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			typeSpec(false);
			t_AST = (AST)returnAST;
			{
			if ((LA(1)==IDENT) && (LA(2)==LPAREN)) {
				AST tmp80_AST = null;
				tmp80_AST = astFactory.create(LT(1));
				match(IDENT);
				match(LPAREN);
				parameterDeclarationList();
				param_AST = (AST)returnAST;
				match(RPAREN);
				declaratorBrackets(t_AST);
				rt_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case LITERAL_throws:
				{
					throwsClause();
					tc_AST = (AST)returnAST;
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				sm = LT(1);
				sm_AST = astFactory.create(sm);
				match(SEMI);
				if ( inputState.guessing==0 ) {
					interfaceField_AST = (AST)currentAST.root;
					interfaceField_AST = (AST)astFactory.make( (new ASTArray(8)).add(astFactory.create(METHOD_DEF,"METHOD_DEF")).add(mods_AST).add(tp_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(rt_AST))).add(tmp80_AST).add(param_AST).add(tc_AST).add(sm_AST));
					currentAST.root = interfaceField_AST;
					currentAST.child = interfaceField_AST!=null &&interfaceField_AST.getFirstChild()!=null ?
						interfaceField_AST.getFirstChild() : interfaceField_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else if ((LA(1)==IDENT) && (_tokenSet_8.member(LA(2)))) {
				variableDefinitions(mods_AST,t_AST);
				v_AST = (AST)returnAST;
				vs = LT(1);
				vs_AST = astFactory.create(vs);
				match(SEMI);
				if ( inputState.guessing==0 ) {
					interfaceField_AST = (AST)currentAST.root;
					interfaceField_AST = v_AST; v_AST.addChild(vs_AST);
					currentAST.root = interfaceField_AST;
					currentAST.child = interfaceField_AST!=null &&interfaceField_AST.getFirstChild()!=null ?
						interfaceField_AST.getFirstChild() : interfaceField_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		returnAST = interfaceField_AST;
	}
	
	public final void annotationField() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST annotationField_AST = null;
		AST mods_AST = null;
		AST td_AST = null;
		AST t_AST = null;
		Token  i = null;
		AST i_AST = null;
		AST rt_AST = null;
		AST amvi_AST = null;
		AST v_AST = null;
		Token  vs = null;
		AST vs_AST = null;
		
		modifiers();
		mods_AST = (AST)returnAST;
		{
		switch ( LA(1)) {
		case AT:
		case LITERAL_class:
		case LITERAL_interface:
		case LITERAL_enum:
		{
			typeDefinitionInternal(mods_AST);
			td_AST = (AST)returnAST;
			if ( inputState.guessing==0 ) {
				annotationField_AST = (AST)currentAST.root;
				annotationField_AST = td_AST;
				currentAST.root = annotationField_AST;
				currentAST.child = annotationField_AST!=null &&annotationField_AST.getFirstChild()!=null ?
					annotationField_AST.getFirstChild() : annotationField_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		{
			typeSpec(false);
			t_AST = (AST)returnAST;
			{
			if ((LA(1)==IDENT) && (LA(2)==LPAREN)) {
				i = LT(1);
				i_AST = astFactory.create(i);
				match(IDENT);
				match(LPAREN);
				match(RPAREN);
				declaratorBrackets(t_AST);
				rt_AST = (AST)returnAST;
				{
				switch ( LA(1)) {
				case LITERAL_default:
				{
					match(LITERAL_default);
					annotationMemberValueInitializer();
					amvi_AST = (AST)returnAST;
					break;
				}
				case SEMI:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp86_AST = null;
				tmp86_AST = astFactory.create(LT(1));
				match(SEMI);
				if ( inputState.guessing==0 ) {
					annotationField_AST = (AST)currentAST.root;
					annotationField_AST =
										(AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(ANNOTATION_FIELD_DEF,"ANNOTATION_FIELD_DEF")).add(mods_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(rt_AST))).add(i_AST).add(amvi_AST));
					currentAST.root = annotationField_AST;
					currentAST.child = annotationField_AST!=null &&annotationField_AST.getFirstChild()!=null ?
						annotationField_AST.getFirstChild() : annotationField_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else if ((LA(1)==IDENT) && (_tokenSet_8.member(LA(2)))) {
				variableDefinitions(mods_AST,t_AST);
				v_AST = (AST)returnAST;
				vs = LT(1);
				vs_AST = astFactory.create(vs);
				match(SEMI);
				if ( inputState.guessing==0 ) {
					annotationField_AST = (AST)currentAST.root;
					annotationField_AST = v_AST; v_AST.addChild(vs_AST);
					currentAST.root = annotationField_AST;
					currentAST.child = annotationField_AST!=null &&annotationField_AST.getFirstChild()!=null ?
						annotationField_AST.getFirstChild() : annotationField_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		returnAST = annotationField_AST;
	}
	
	public final void enumConstant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumConstant_AST = null;
		AST an_AST = null;
		Token  i = null;
		AST i_AST = null;
		AST a_AST = null;
		Token  rp = null;
		AST rp_AST = null;
		AST b_AST = null;
		
		annotations();
		an_AST = (AST)returnAST;
		i = LT(1);
		i_AST = astFactory.create(i);
		match(IDENT);
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			argList();
			a_AST = (AST)returnAST;
			rp = LT(1);
			rp_AST = astFactory.create(rp);
			match(RPAREN);
			break;
		}
		case SEMI:
		case COMMA:
		case LCURLY:
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case LCURLY:
		{
			enumConstantBlock();
			b_AST = (AST)returnAST;
			break;
		}
		case SEMI:
		case COMMA:
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			enumConstant_AST = (AST)currentAST.root;
			enumConstant_AST = (AST)astFactory.make( (new ASTArray(6)).add(astFactory.create(ENUM_CONSTANT_DEF,"ENUM_CONSTANT_DEF")).add(an_AST).add(i_AST).add(a_AST).add(rp_AST).add(b_AST));
			currentAST.root = enumConstant_AST;
			currentAST.child = enumConstant_AST!=null &&enumConstant_AST.getFirstChild()!=null ?
				enumConstant_AST.getFirstChild() : enumConstant_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = enumConstant_AST;
	}
	
	public final void declaratorBrackets(
		AST typ
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST declaratorBrackets_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		if ( inputState.guessing==0 ) {
			declaratorBrackets_AST = (AST)currentAST.root;
			declaratorBrackets_AST=typ;
			currentAST.root = declaratorBrackets_AST;
			currentAST.child = declaratorBrackets_AST!=null &&declaratorBrackets_AST.getFirstChild()!=null ?
				declaratorBrackets_AST.getFirstChild() : declaratorBrackets_AST;
			currentAST.advanceChildToEnd();
		}
		{
		_loop159:
		do {
			if ((LA(1)==LBRACK)) {
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if ( inputState.guessing==0 ) {
					lb_AST.setType(ARRAY_DECLARATOR);
				}
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
				match(RBRACK);
			}
			else {
				break _loop159;
			}
			
		} while (true);
		}
		declaratorBrackets_AST = (AST)currentAST.root;
		returnAST = declaratorBrackets_AST;
	}
	
	public final void argList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST argList_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			expressionList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case RPAREN:
		{
			if ( inputState.guessing==0 ) {
				argList_AST = (AST)currentAST.root;
				argList_AST = astFactory.create(ELIST,"ELIST");
				currentAST.root = argList_AST;
				currentAST.child = argList_AST!=null &&argList_AST.getFirstChild()!=null ?
					argList_AST.getFirstChild() : argList_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		argList_AST = (AST)currentAST.root;
		returnAST = argList_AST;
	}
	
	public final void enumConstantBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumConstantBlock_AST = null;
		
		match(LCURLY);
		{
		_loop119:
		do {
			switch ( LA(1)) {
			case FINAL:
			case ABSTRACT:
			case STRICTFP:
			case LITERAL_static:
			case LT:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			case LITERAL_private:
			case LITERAL_public:
			case LITERAL_protected:
			case LITERAL_transient:
			case LITERAL_native:
			case LITERAL_threadsafe:
			case LITERAL_synchronized:
			case LITERAL_volatile:
			case AT:
			case LCURLY:
			case LITERAL_class:
			case LITERAL_interface:
			case LITERAL_enum:
			{
				enumConstantField();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				match(SEMI);
				break;
			}
			default:
			{
				break _loop119;
			}
			}
		} while (true);
		}
		AST tmp91_AST = null;
		tmp91_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp91_AST);
		match(RCURLY);
		if ( inputState.guessing==0 ) {
			enumConstantBlock_AST = (AST)currentAST.root;
			enumConstantBlock_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(OBJBLOCK,"OBJBLOCK")).add(enumConstantBlock_AST));
			currentAST.root = enumConstantBlock_AST;
			currentAST.child = enumConstantBlock_AST!=null &&enumConstantBlock_AST.getFirstChild()!=null ?
				enumConstantBlock_AST.getFirstChild() : enumConstantBlock_AST;
			currentAST.advanceChildToEnd();
		}
		enumConstantBlock_AST = (AST)currentAST.root;
		returnAST = enumConstantBlock_AST;
	}
	
	public final void enumConstantField() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST enumConstantField_AST = null;
		AST mods_AST = null;
		AST td_AST = null;
		AST tp_AST = null;
		AST t_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST param_AST = null;
		AST rt_AST = null;
		AST tc_AST = null;
		AST s2_AST = null;
		Token  sm = null;
		AST sm_AST = null;
		AST v_AST = null;
		Token  vs = null;
		AST vs_AST = null;
		AST s4_AST = null;
		
		switch ( LA(1)) {
		case FINAL:
		case ABSTRACT:
		case STRICTFP:
		case LITERAL_static:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LITERAL_private:
		case LITERAL_public:
		case LITERAL_protected:
		case LITERAL_transient:
		case LITERAL_native:
		case LITERAL_threadsafe:
		case LITERAL_synchronized:
		case LITERAL_volatile:
		case AT:
		case LITERAL_class:
		case LITERAL_interface:
		case LITERAL_enum:
		{
			modifiers();
			mods_AST = (AST)returnAST;
			{
			switch ( LA(1)) {
			case AT:
			case LITERAL_class:
			case LITERAL_interface:
			case LITERAL_enum:
			{
				typeDefinitionInternal(mods_AST);
				td_AST = (AST)returnAST;
				if ( inputState.guessing==0 ) {
					enumConstantField_AST = (AST)currentAST.root;
					enumConstantField_AST = td_AST;
					currentAST.root = enumConstantField_AST;
					currentAST.child = enumConstantField_AST!=null &&enumConstantField_AST.getFirstChild()!=null ?
						enumConstantField_AST.getFirstChild() : enumConstantField_AST;
					currentAST.advanceChildToEnd();
				}
				break;
			}
			case LT:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			{
				{
				switch ( LA(1)) {
				case LT:
				{
					typeParameters();
					tp_AST = (AST)returnAST;
					break;
				}
				case LITERAL_void:
				case LITERAL_boolean:
				case LITERAL_byte:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_float:
				case LITERAL_long:
				case LITERAL_double:
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				typeSpec(false);
				t_AST = (AST)returnAST;
				{
				if ((LA(1)==IDENT) && (LA(2)==LPAREN)) {
					id = LT(1);
					id_AST = astFactory.create(id);
					match(IDENT);
					match(LPAREN);
					parameterDeclarationList();
					param_AST = (AST)returnAST;
					match(RPAREN);
					declaratorBrackets(t_AST);
					rt_AST = (AST)returnAST;
					{
					switch ( LA(1)) {
					case LITERAL_throws:
					{
						throwsClause();
						tc_AST = (AST)returnAST;
						break;
					}
					case SEMI:
					case LCURLY:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					{
					switch ( LA(1)) {
					case LCURLY:
					{
						compoundStatement();
						s2_AST = (AST)returnAST;
						if ( inputState.guessing==0 ) {
							enumConstantField_AST = (AST)currentAST.root;
							enumConstantField_AST = (AST)astFactory.make( (new ASTArray(8)).add(astFactory.create(METHOD_DEF,"METHOD_DEF")).add(mods_AST).add(tp_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(rt_AST))).add(id_AST).add(param_AST).add(tc_AST).add(s2_AST));
							currentAST.root = enumConstantField_AST;
							currentAST.child = enumConstantField_AST!=null &&enumConstantField_AST.getFirstChild()!=null ?
								enumConstantField_AST.getFirstChild() : enumConstantField_AST;
							currentAST.advanceChildToEnd();
						}
						break;
					}
					case SEMI:
					{
						sm = LT(1);
						sm_AST = astFactory.create(sm);
						match(SEMI);
						if ( inputState.guessing==0 ) {
							enumConstantField_AST = (AST)currentAST.root;
							enumConstantField_AST = (AST)astFactory.make( (new ASTArray(8)).add(astFactory.create(METHOD_DEF,"METHOD_DEF")).add(mods_AST).add(tp_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(rt_AST))).add(id_AST).add(param_AST).add(tc_AST).add(sm_AST));
							currentAST.root = enumConstantField_AST;
							currentAST.child = enumConstantField_AST!=null &&enumConstantField_AST.getFirstChild()!=null ?
								enumConstantField_AST.getFirstChild() : enumConstantField_AST;
							currentAST.advanceChildToEnd();
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
				}
				else if ((LA(1)==IDENT) && (_tokenSet_8.member(LA(2)))) {
					variableDefinitions(mods_AST,t_AST);
					v_AST = (AST)returnAST;
					vs = LT(1);
					vs_AST = astFactory.create(vs);
					match(SEMI);
					if ( inputState.guessing==0 ) {
						enumConstantField_AST = (AST)currentAST.root;
						enumConstantField_AST = v_AST; v_AST.addChild(vs_AST);
						currentAST.root = enumConstantField_AST;
						currentAST.child = enumConstantField_AST!=null &&enumConstantField_AST.getFirstChild()!=null ?
							enumConstantField_AST.getFirstChild() : enumConstantField_AST;
						currentAST.advanceChildToEnd();
					}
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case LCURLY:
		{
			compoundStatement();
			s4_AST = (AST)returnAST;
			if ( inputState.guessing==0 ) {
				enumConstantField_AST = (AST)currentAST.root;
				enumConstantField_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(INSTANCE_INIT,"INSTANCE_INIT")).add(s4_AST));
				currentAST.root = enumConstantField_AST;
				currentAST.child = enumConstantField_AST!=null &&enumConstantField_AST.getFirstChild()!=null ?
					enumConstantField_AST.getFirstChild() : enumConstantField_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = enumConstantField_AST;
	}
	
	public final void parameterDeclarationList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterDeclarationList_AST = null;
		
		{
		boolean synPredMatched176 = false;
		if (((_tokenSet_19.member(LA(1))) && (_tokenSet_20.member(LA(2))))) {
			int _m176 = mark();
			synPredMatched176 = true;
			inputState.guessing++;
			try {
				{
				parameterDeclaration();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched176 = false;
			}
			rewind(_m176);
			inputState.guessing--;
		}
		if ( synPredMatched176 ) {
			parameterDeclaration();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop180:
			do {
				boolean synPredMatched179 = false;
				if (((LA(1)==COMMA) && (_tokenSet_19.member(LA(2))))) {
					int _m179 = mark();
					synPredMatched179 = true;
					inputState.guessing++;
					try {
						{
						match(COMMA);
						parameterDeclaration();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched179 = false;
					}
					rewind(_m179);
					inputState.guessing--;
				}
				if ( synPredMatched179 ) {
					match(COMMA);
					parameterDeclaration();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop180;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				variableLengthParameterDeclaration();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_21.member(LA(2)))) {
			variableLengthParameterDeclaration();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((LA(1)==RPAREN)) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		if ( inputState.guessing==0 ) {
			parameterDeclarationList_AST = (AST)currentAST.root;
			parameterDeclarationList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PARAMETERS,"PARAMETERS")).add(parameterDeclarationList_AST));
			currentAST.root = parameterDeclarationList_AST;
			currentAST.child = parameterDeclarationList_AST!=null &&parameterDeclarationList_AST.getFirstChild()!=null ?
				parameterDeclarationList_AST.getFirstChild() : parameterDeclarationList_AST;
			currentAST.advanceChildToEnd();
		}
		parameterDeclarationList_AST = (AST)currentAST.root;
		returnAST = parameterDeclarationList_AST;
	}
	
	public final void throwsClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST throwsClause_AST = null;
		
		AST tmp96_AST = null;
		tmp96_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp96_AST);
		match(LITERAL_throws);
		identifier();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop172:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				identifier();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop172;
			}
			
		} while (true);
		}
		throwsClause_AST = (AST)currentAST.root;
		returnAST = throwsClause_AST;
	}
	
	public final void compoundStatement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compoundStatement_AST = null;
		Token  lc = null;
		AST lc_AST = null;
		Token  rc = null;
		AST rc_AST = null;
		
		lc = LT(1);
		lc_AST = astFactory.create(lc);
		astFactory.makeASTRoot(currentAST, lc_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			lc_AST.setType(SLIST);
		}
		{
		_loop192:
		do {
			if ((_tokenSet_22.member(LA(1)))) {
				statement();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop192;
			}
			
		} while (true);
		}
		rc = LT(1);
		rc_AST = astFactory.create(rc);
		astFactory.addASTChild(currentAST, rc_AST);
		match(RCURLY);
		compoundStatement_AST = (AST)currentAST.root;
		returnAST = compoundStatement_AST;
	}
	
	public final void ctorHead() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST ctorHead_AST = null;
		
		AST tmp98_AST = null;
		tmp98_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp98_AST);
		match(IDENT);
		match(LPAREN);
		parameterDeclarationList();
		astFactory.addASTChild(currentAST, returnAST);
		match(RPAREN);
		{
		switch ( LA(1)) {
		case LITERAL_throws:
		{
			throwsClause();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		ctorHead_AST = (AST)currentAST.root;
		returnAST = ctorHead_AST;
	}
	
	public final void constructorBody() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constructorBody_AST = null;
		Token  lc = null;
		AST lc_AST = null;
		Token  rc = null;
		AST rc_AST = null;
		
		lc = LT(1);
		lc_AST = astFactory.create(lc);
		astFactory.makeASTRoot(currentAST, lc_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			lc_AST.setType(SLIST);
		}
		{
		if ((_tokenSet_23.member(LA(1))) && (_tokenSet_24.member(LA(2)))) {
			explicitConstructorInvocation();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_25.member(LA(1))) && (_tokenSet_26.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		{
		_loop149:
		do {
			if ((_tokenSet_22.member(LA(1)))) {
				statement();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop149;
			}
			
		} while (true);
		}
		rc = LT(1);
		rc_AST = astFactory.create(rc);
		astFactory.addASTChild(currentAST, rc_AST);
		match(RCURLY);
		constructorBody_AST = (AST)currentAST.root;
		returnAST = constructorBody_AST;
	}
	
/** Catch obvious constructor calls, but not the expr.super(...) calls */
	public final void explicitConstructorInvocation() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST explicitConstructorInvocation_AST = null;
		Token  lp1 = null;
		AST lp1_AST = null;
		Token  lp2 = null;
		AST lp2_AST = null;
		
		{
		switch ( LA(1)) {
		case LT:
		{
			typeArguments();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_super:
		case LITERAL_this:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case LITERAL_this:
		{
			match(LITERAL_this);
			lp1 = LT(1);
			lp1_AST = astFactory.create(lp1);
			astFactory.makeASTRoot(currentAST, lp1_AST);
			match(LPAREN);
			argList();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				lp1_AST.setType(CTOR_CALL);
			}
			break;
		}
		case LITERAL_super:
		{
			match(LITERAL_super);
			lp2 = LT(1);
			lp2_AST = astFactory.create(lp2);
			astFactory.makeASTRoot(currentAST, lp2_AST);
			match(LPAREN);
			argList();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				lp2_AST.setType(SUPER_CTOR_CALL);
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		explicitConstructorInvocation_AST = (AST)currentAST.root;
		returnAST = explicitConstructorInvocation_AST;
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		AST m_AST = null;
		Token  c = null;
		AST c_AST = null;
		Token  s = null;
		AST s_AST = null;
		
		switch ( LA(1)) {
		case LCURLY:
		{
			compoundStatement();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_if:
		{
			AST tmp107_AST = null;
			tmp107_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp107_AST);
			match(LITERAL_if);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			statement();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==LITERAL_else) && (_tokenSet_22.member(LA(2)))) {
				AST tmp110_AST = null;
				tmp110_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp110_AST);
				match(LITERAL_else);
				statement();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_27.member(LA(1))) && (_tokenSet_28.member(LA(2)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_for:
		{
			forStatement();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_while:
		{
			AST tmp111_AST = null;
			tmp111_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp111_AST);
			match(LITERAL_while);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			statement();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_do:
		{
			AST tmp114_AST = null;
			tmp114_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp114_AST);
			match(LITERAL_do);
			statement();
			astFactory.addASTChild(currentAST, returnAST);
			match(LITERAL_while);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			match(SEMI);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_break:
		{
			AST tmp119_AST = null;
			tmp119_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp119_AST);
			match(LITERAL_break);
			{
			switch ( LA(1)) {
			case IDENT:
			{
				AST tmp120_AST = null;
				tmp120_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp120_AST);
				match(IDENT);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_continue:
		{
			AST tmp122_AST = null;
			tmp122_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp122_AST);
			match(LITERAL_continue);
			{
			switch ( LA(1)) {
			case IDENT:
			{
				AST tmp123_AST = null;
				tmp123_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp123_AST);
				match(IDENT);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_return:
		{
			AST tmp125_AST = null;
			tmp125_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp125_AST);
			match(LITERAL_return);
			{
			switch ( LA(1)) {
			case LITERAL_super:
			case LT:
			case LITERAL_void:
			case LITERAL_boolean:
			case LITERAL_byte:
			case LITERAL_char:
			case LITERAL_short:
			case LITERAL_int:
			case LITERAL_float:
			case LITERAL_long:
			case LITERAL_double:
			case IDENT:
			case LPAREN:
			case LITERAL_this:
			case PLUS:
			case MINUS:
			case INC:
			case DEC:
			case BNOT:
			case LNOT:
			case LITERAL_true:
			case LITERAL_false:
			case LITERAL_null:
			case LITERAL_new:
			case NUM_INT:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case NUM_FLOAT:
			case NUM_LONG:
			case NUM_DOUBLE:
			{
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_switch:
		{
			AST tmp127_AST = null;
			tmp127_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp127_AST);
			match(LITERAL_switch);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			match(LCURLY);
			{
			_loop201:
			do {
				if ((LA(1)==LITERAL_default||LA(1)==LITERAL_case)) {
					casesGroup();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop201;
				}
				
			} while (true);
			}
			match(RCURLY);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_try:
		{
			tryBlock();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_throw:
		{
			AST tmp132_AST = null;
			tmp132_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp132_AST);
			match(LITERAL_throw);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(SEMI);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_assert:
		{
			AST tmp134_AST = null;
			tmp134_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp134_AST);
			match(LITERAL_assert);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case SEMI:
		{
			s = LT(1);
			s_AST = astFactory.create(s);
			astFactory.addASTChild(currentAST, s_AST);
			match(SEMI);
			if ( inputState.guessing==0 ) {
				s_AST.setType(EMPTY_STAT);
			}
			statement_AST = (AST)currentAST.root;
			break;
		}
		default:
			boolean synPredMatched195 = false;
			if (((_tokenSet_29.member(LA(1))) && (_tokenSet_30.member(LA(2))))) {
				int _m195 = mark();
				synPredMatched195 = true;
				inputState.guessing++;
				try {
					{
					declaration();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched195 = false;
				}
				rewind(_m195);
				inputState.guessing--;
			}
			if ( synPredMatched195 ) {
				declaration();
				astFactory.addASTChild(currentAST, returnAST);
				match(SEMI);
				statement_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_31.member(LA(1))) && (_tokenSet_32.member(LA(2)))) {
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				match(SEMI);
				statement_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_33.member(LA(1))) && (_tokenSet_34.member(LA(2)))) {
				modifiers();
				m_AST = (AST)returnAST;
				classDefinition(m_AST);
				astFactory.addASTChild(currentAST, returnAST);
				statement_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==IDENT) && (LA(2)==COLON)) {
				AST tmp139_AST = null;
				tmp139_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp139_AST);
				match(IDENT);
				c = LT(1);
				c_AST = astFactory.create(c);
				astFactory.makeASTRoot(currentAST, c_AST);
				match(COLON);
				if ( inputState.guessing==0 ) {
					c_AST.setType(LABELED_STAT);
				}
				statement();
				astFactory.addASTChild(currentAST, returnAST);
				statement_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==LITERAL_synchronized) && (LA(2)==LPAREN)) {
				AST tmp140_AST = null;
				tmp140_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp140_AST);
				match(LITERAL_synchronized);
				match(LPAREN);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				compoundStatement();
				astFactory.addASTChild(currentAST, returnAST);
				statement_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = statement_AST;
	}
	

/** Declaration of a variable. This can be a class/instance variable,
 *  or a local variable in a method
 *  It can also include possible initialization.
 */
	public final void variableDeclarator(
		AST mods, AST t
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variableDeclarator_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST d_AST = null;
		AST v_AST = null;
		
		id = LT(1);
		id_AST = astFactory.create(id);
		match(IDENT);
		declaratorBrackets(t);
		d_AST = (AST)returnAST;
		varInitializer();
		v_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			variableDeclarator_AST = (AST)currentAST.root;
			variableDeclarator_AST = (AST)astFactory.make( (new ASTArray(5)).add(astFactory.create(VARIABLE_DEF,"VARIABLE_DEF")).add(mods).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(d_AST))).add(id_AST).add(v_AST));
			currentAST.root = variableDeclarator_AST;
			currentAST.child = variableDeclarator_AST!=null &&variableDeclarator_AST.getFirstChild()!=null ?
				variableDeclarator_AST.getFirstChild() : variableDeclarator_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = variableDeclarator_AST;
	}
	
	public final void varInitializer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST varInitializer_AST = null;
		
		{
		switch ( LA(1)) {
		case ASSIGN:
		{
			AST tmp143_AST = null;
			tmp143_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp143_AST);
			match(ASSIGN);
			initializer();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case SEMI:
		case COMMA:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		varInitializer_AST = (AST)currentAST.root;
		returnAST = varInitializer_AST;
	}
	
	public final void initializer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST initializer_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			initializer_AST = (AST)currentAST.root;
			break;
		}
		case LCURLY:
		{
			arrayInitializer();
			astFactory.addASTChild(currentAST, returnAST);
			initializer_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = initializer_AST;
	}
	
	public final void arrayInitializer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arrayInitializer_AST = null;
		Token  lc = null;
		AST lc_AST = null;
		
		lc = LT(1);
		lc_AST = astFactory.create(lc);
		astFactory.makeASTRoot(currentAST, lc_AST);
		match(LCURLY);
		if ( inputState.guessing==0 ) {
			lc_AST.setType(ARRAY_INIT);
		}
		{
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LCURLY:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			initializer();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop165:
			do {
				if ((LA(1)==COMMA) && (_tokenSet_35.member(LA(2)))) {
					match(COMMA);
					initializer();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop165;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case COMMA:
			{
				match(COMMA);
				break;
			}
			case RCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case RCURLY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		AST tmp146_AST = null;
		tmp146_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp146_AST);
		match(RCURLY);
		arrayInitializer_AST = (AST)currentAST.root;
		returnAST = arrayInitializer_AST;
	}
	
	public final void expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;
		
		assignmentExpression();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			expression_AST = (AST)currentAST.root;
			expression_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXPR,"EXPR")).add(expression_AST));
			currentAST.root = expression_AST;
			currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
				expression_AST.getFirstChild() : expression_AST;
			currentAST.advanceChildToEnd();
		}
		expression_AST = (AST)currentAST.root;
		returnAST = expression_AST;
	}
	
	public final void parameterDeclaration() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterDeclaration_AST = null;
		AST pm_AST = null;
		AST t_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST pd_AST = null;
		
		parameterModifier();
		pm_AST = (AST)returnAST;
		typeSpec(false);
		t_AST = (AST)returnAST;
		id = LT(1);
		id_AST = astFactory.create(id);
		match(IDENT);
		declaratorBrackets(t_AST);
		pd_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			parameterDeclaration_AST = (AST)currentAST.root;
			parameterDeclaration_AST = (AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(PARAMETER_DEF,"PARAMETER_DEF")).add(pm_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(pd_AST))).add(id_AST));
			currentAST.root = parameterDeclaration_AST;
			currentAST.child = parameterDeclaration_AST!=null &&parameterDeclaration_AST.getFirstChild()!=null ?
				parameterDeclaration_AST.getFirstChild() : parameterDeclaration_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = parameterDeclaration_AST;
	}
	
	public final void variableLengthParameterDeclaration() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST variableLengthParameterDeclaration_AST = null;
		AST pm_AST = null;
		AST t_AST = null;
		Token  id = null;
		AST id_AST = null;
		AST pd_AST = null;
		
		parameterModifier();
		pm_AST = (AST)returnAST;
		typeSpec(false);
		t_AST = (AST)returnAST;
		match(TRIPLE_DOT);
		id = LT(1);
		id_AST = astFactory.create(id);
		match(IDENT);
		declaratorBrackets(t_AST);
		pd_AST = (AST)returnAST;
		if ( inputState.guessing==0 ) {
			variableLengthParameterDeclaration_AST = (AST)currentAST.root;
			variableLengthParameterDeclaration_AST = (AST)astFactory.make( (new ASTArray(4)).add(astFactory.create(VARIABLE_PARAMETER_DEF,"VARIABLE_PARAMETER_DEF")).add(pm_AST).add((AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TYPE,"TYPE")).add(pd_AST))).add(id_AST));
			currentAST.root = variableLengthParameterDeclaration_AST;
			currentAST.child = variableLengthParameterDeclaration_AST!=null &&variableLengthParameterDeclaration_AST.getFirstChild()!=null ?
				variableLengthParameterDeclaration_AST.getFirstChild() : variableLengthParameterDeclaration_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = variableLengthParameterDeclaration_AST;
	}
	
	public final void parameterModifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameterModifier_AST = null;
		Token  f = null;
		AST f_AST = null;
		
		{
		_loop186:
		do {
			if ((LA(1)==AT) && (LA(2)==IDENT)) {
				annotation();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop186;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case FINAL:
		{
			f = LT(1);
			f_AST = astFactory.create(f);
			astFactory.addASTChild(currentAST, f_AST);
			match(FINAL);
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case AT:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		_loop189:
		do {
			if ((LA(1)==AT)) {
				annotation();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop189;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			parameterModifier_AST = (AST)currentAST.root;
			parameterModifier_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(MODIFIERS,"MODIFIERS")).add(parameterModifier_AST));
			currentAST.root = parameterModifier_AST;
			currentAST.child = parameterModifier_AST!=null &&parameterModifier_AST.getFirstChild()!=null ?
				parameterModifier_AST.getFirstChild() : parameterModifier_AST;
			currentAST.advanceChildToEnd();
		}
		parameterModifier_AST = (AST)currentAST.root;
		returnAST = parameterModifier_AST;
	}
	
	public final void forStatement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forStatement_AST = null;
		Token  f = null;
		AST f_AST = null;
		
		f = LT(1);
		f_AST = astFactory.create(f);
		astFactory.makeASTRoot(currentAST, f_AST);
		match(LITERAL_for);
		match(LPAREN);
		{
		boolean synPredMatched206 = false;
		if (((_tokenSet_36.member(LA(1))) && (_tokenSet_37.member(LA(2))))) {
			int _m206 = mark();
			synPredMatched206 = true;
			inputState.guessing++;
			try {
				{
				forInit();
				match(SEMI);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched206 = false;
			}
			rewind(_m206);
			inputState.guessing--;
		}
		if ( synPredMatched206 ) {
			traditionalForClause();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_19.member(LA(1))) && (_tokenSet_20.member(LA(2)))) {
			forEachClause();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		match(RPAREN);
		statement();
		astFactory.addASTChild(currentAST, returnAST);
		forStatement_AST = (AST)currentAST.root;
		returnAST = forStatement_AST;
	}
	
	public final void casesGroup() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST casesGroup_AST = null;
		
		{
		int _cnt211=0;
		_loop211:
		do {
			if ((LA(1)==LITERAL_default||LA(1)==LITERAL_case) && (_tokenSet_38.member(LA(2)))) {
				aCase();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				if ( _cnt211>=1 ) { break _loop211; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt211++;
		} while (true);
		}
		caseSList();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			casesGroup_AST = (AST)currentAST.root;
			casesGroup_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CASE_GROUP,"CASE_GROUP")).add(casesGroup_AST));
			currentAST.root = casesGroup_AST;
			currentAST.child = casesGroup_AST!=null &&casesGroup_AST.getFirstChild()!=null ?
				casesGroup_AST.getFirstChild() : casesGroup_AST;
			currentAST.advanceChildToEnd();
		}
		casesGroup_AST = (AST)currentAST.root;
		returnAST = casesGroup_AST;
	}
	
	public final void tryBlock() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tryBlock_AST = null;
		
		AST tmp150_AST = null;
		tmp150_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp150_AST);
		match(LITERAL_try);
		compoundStatement();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop227:
		do {
			if ((LA(1)==LITERAL_catch)) {
				handler();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop227;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case LITERAL_finally:
		{
			finallyClause();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case FINAL:
		case ABSTRACT:
		case STRICTFP:
		case SEMI:
		case LITERAL_static:
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LITERAL_private:
		case LITERAL_public:
		case LITERAL_protected:
		case LITERAL_transient:
		case LITERAL_native:
		case LITERAL_threadsafe:
		case LITERAL_synchronized:
		case LITERAL_volatile:
		case AT:
		case LPAREN:
		case LCURLY:
		case RCURLY:
		case LITERAL_class:
		case LITERAL_default:
		case LITERAL_this:
		case LITERAL_if:
		case LITERAL_else:
		case LITERAL_while:
		case LITERAL_do:
		case LITERAL_break:
		case LITERAL_continue:
		case LITERAL_return:
		case LITERAL_switch:
		case LITERAL_throw:
		case LITERAL_assert:
		case LITERAL_for:
		case LITERAL_case:
		case LITERAL_try:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		tryBlock_AST = (AST)currentAST.root;
		returnAST = tryBlock_AST;
	}
	
	public final void forInit() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forInit_AST = null;
		
		{
		boolean synPredMatched220 = false;
		if (((_tokenSet_29.member(LA(1))) && (_tokenSet_30.member(LA(2))))) {
			int _m220 = mark();
			synPredMatched220 = true;
			inputState.guessing++;
			try {
				{
				declaration();
				}
			}
			catch (RecognitionException pe) {
				synPredMatched220 = false;
			}
			rewind(_m220);
			inputState.guessing--;
		}
		if ( synPredMatched220 ) {
			declaration();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_31.member(LA(1))) && (_tokenSet_39.member(LA(2)))) {
			expressionList();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((LA(1)==SEMI)) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		if ( inputState.guessing==0 ) {
			forInit_AST = (AST)currentAST.root;
			forInit_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_INIT,"FOR_INIT")).add(forInit_AST));
			currentAST.root = forInit_AST;
			currentAST.child = forInit_AST!=null &&forInit_AST.getFirstChild()!=null ?
				forInit_AST.getFirstChild() : forInit_AST;
			currentAST.advanceChildToEnd();
		}
		forInit_AST = (AST)currentAST.root;
		returnAST = forInit_AST;
	}
	
	public final void traditionalForClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST traditionalForClause_AST = null;
		
		forInit();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp151_AST = null;
		tmp151_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp151_AST);
		match(SEMI);
		forCond();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp152_AST = null;
		tmp152_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp152_AST);
		match(SEMI);
		forIter();
		astFactory.addASTChild(currentAST, returnAST);
		traditionalForClause_AST = (AST)currentAST.root;
		returnAST = traditionalForClause_AST;
	}
	
	public final void forEachClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forEachClause_AST = null;
		AST p_AST = null;
		
		parameterDeclaration();
		p_AST = (AST)returnAST;
		astFactory.addASTChild(currentAST, returnAST);
		match(COLON);
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		if ( inputState.guessing==0 ) {
			forEachClause_AST = (AST)currentAST.root;
			forEachClause_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_EACH_CLAUSE,"FOR_EACH_CLAUSE")).add(forEachClause_AST));
			currentAST.root = forEachClause_AST;
			currentAST.child = forEachClause_AST!=null &&forEachClause_AST.getFirstChild()!=null ?
				forEachClause_AST.getFirstChild() : forEachClause_AST;
			currentAST.advanceChildToEnd();
		}
		forEachClause_AST = (AST)currentAST.root;
		returnAST = forEachClause_AST;
	}
	
	public final void forCond() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forCond_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case SEMI:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			forCond_AST = (AST)currentAST.root;
			forCond_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_CONDITION,"FOR_CONDITION")).add(forCond_AST));
			currentAST.root = forCond_AST;
			currentAST.child = forCond_AST!=null &&forCond_AST.getFirstChild()!=null ?
				forCond_AST.getFirstChild() : forCond_AST;
			currentAST.advanceChildToEnd();
		}
		forCond_AST = (AST)currentAST.root;
		returnAST = forCond_AST;
	}
	
	public final void forIter() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST forIter_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case PLUS:
		case MINUS:
		case INC:
		case DEC:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			expressionList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case RPAREN:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		if ( inputState.guessing==0 ) {
			forIter_AST = (AST)currentAST.root;
			forIter_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FOR_ITERATOR,"FOR_ITERATOR")).add(forIter_AST));
			currentAST.root = forIter_AST;
			currentAST.child = forIter_AST!=null &&forIter_AST.getFirstChild()!=null ?
				forIter_AST.getFirstChild() : forIter_AST;
			currentAST.advanceChildToEnd();
		}
		forIter_AST = (AST)currentAST.root;
		returnAST = forIter_AST;
	}
	
	public final void aCase() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aCase_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_case:
		{
			AST tmp154_AST = null;
			tmp154_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp154_AST);
			match(LITERAL_case);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_default:
		{
			AST tmp155_AST = null;
			tmp155_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp155_AST);
			match(LITERAL_default);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(COLON);
		aCase_AST = (AST)currentAST.root;
		returnAST = aCase_AST;
	}
	
	public final void caseSList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST caseSList_AST = null;
		
		{
		_loop216:
		do {
			if ((_tokenSet_22.member(LA(1)))) {
				statement();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop216;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			caseSList_AST = (AST)currentAST.root;
			caseSList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SLIST,"SLIST")).add(caseSList_AST));
			currentAST.root = caseSList_AST;
			currentAST.child = caseSList_AST!=null &&caseSList_AST.getFirstChild()!=null ?
				caseSList_AST.getFirstChild() : caseSList_AST;
			currentAST.advanceChildToEnd();
		}
		caseSList_AST = (AST)currentAST.root;
		returnAST = caseSList_AST;
	}
	
	public final void expressionList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expressionList_AST = null;
		
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop234:
		do {
			if ((LA(1)==COMMA)) {
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop234;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			expressionList_AST = (AST)currentAST.root;
			expressionList_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ELIST,"ELIST")).add(expressionList_AST));
			currentAST.root = expressionList_AST;
			currentAST.child = expressionList_AST!=null &&expressionList_AST.getFirstChild()!=null ?
				expressionList_AST.getFirstChild() : expressionList_AST;
			currentAST.advanceChildToEnd();
		}
		expressionList_AST = (AST)currentAST.root;
		returnAST = expressionList_AST;
	}
	
	public final void handler() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST handler_AST = null;
		
		AST tmp158_AST = null;
		tmp158_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp158_AST);
		match(LITERAL_catch);
		match(LPAREN);
		parameterDeclaration();
		astFactory.addASTChild(currentAST, returnAST);
		match(RPAREN);
		compoundStatement();
		astFactory.addASTChild(currentAST, returnAST);
		handler_AST = (AST)currentAST.root;
		returnAST = handler_AST;
	}
	
	public final void finallyClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST finallyClause_AST = null;
		
		AST tmp161_AST = null;
		tmp161_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp161_AST);
		match(LITERAL_finally);
		compoundStatement();
		astFactory.addASTChild(currentAST, returnAST);
		finallyClause_AST = (AST)currentAST.root;
		returnAST = finallyClause_AST;
	}
	
	public final void assignmentExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST assignmentExpression_AST = null;
		
		conditionalExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case ASSIGN:
		case PLUS_ASSIGN:
		case MINUS_ASSIGN:
		case STAR_ASSIGN:
		case DIV_ASSIGN:
		case MOD_ASSIGN:
		case SR_ASSIGN:
		case BSR_ASSIGN:
		case SL_ASSIGN:
		case BAND_ASSIGN:
		case BXOR_ASSIGN:
		case BOR_ASSIGN:
		{
			{
			switch ( LA(1)) {
			case ASSIGN:
			{
				AST tmp162_AST = null;
				tmp162_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp162_AST);
				match(ASSIGN);
				break;
			}
			case PLUS_ASSIGN:
			{
				AST tmp163_AST = null;
				tmp163_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp163_AST);
				match(PLUS_ASSIGN);
				break;
			}
			case MINUS_ASSIGN:
			{
				AST tmp164_AST = null;
				tmp164_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp164_AST);
				match(MINUS_ASSIGN);
				break;
			}
			case STAR_ASSIGN:
			{
				AST tmp165_AST = null;
				tmp165_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp165_AST);
				match(STAR_ASSIGN);
				break;
			}
			case DIV_ASSIGN:
			{
				AST tmp166_AST = null;
				tmp166_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp166_AST);
				match(DIV_ASSIGN);
				break;
			}
			case MOD_ASSIGN:
			{
				AST tmp167_AST = null;
				tmp167_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp167_AST);
				match(MOD_ASSIGN);
				break;
			}
			case SR_ASSIGN:
			{
				AST tmp168_AST = null;
				tmp168_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp168_AST);
				match(SR_ASSIGN);
				break;
			}
			case BSR_ASSIGN:
			{
				AST tmp169_AST = null;
				tmp169_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp169_AST);
				match(BSR_ASSIGN);
				break;
			}
			case SL_ASSIGN:
			{
				AST tmp170_AST = null;
				tmp170_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp170_AST);
				match(SL_ASSIGN);
				break;
			}
			case BAND_ASSIGN:
			{
				AST tmp171_AST = null;
				tmp171_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp171_AST);
				match(BAND_ASSIGN);
				break;
			}
			case BXOR_ASSIGN:
			{
				AST tmp172_AST = null;
				tmp172_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp172_AST);
				match(BXOR_ASSIGN);
				break;
			}
			case BOR_ASSIGN:
			{
				AST tmp173_AST = null;
				tmp173_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp173_AST);
				match(BOR_ASSIGN);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			assignmentExpression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case SEMI:
		case RBRACK:
		case COMMA:
		case RPAREN:
		case RCURLY:
		case COLON:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		assignmentExpression_AST = (AST)currentAST.root;
		returnAST = assignmentExpression_AST;
	}
	
	public final void logicalOrExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logicalOrExpression_AST = null;
		
		logicalAndExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop242:
		do {
			if ((LA(1)==LOR)) {
				AST tmp174_AST = null;
				tmp174_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp174_AST);
				match(LOR);
				logicalAndExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop242;
			}
			
		} while (true);
		}
		logicalOrExpression_AST = (AST)currentAST.root;
		returnAST = logicalOrExpression_AST;
	}
	
	public final void logicalAndExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logicalAndExpression_AST = null;
		
		inclusiveOrExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop245:
		do {
			if ((LA(1)==LAND)) {
				AST tmp175_AST = null;
				tmp175_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp175_AST);
				match(LAND);
				inclusiveOrExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop245;
			}
			
		} while (true);
		}
		logicalAndExpression_AST = (AST)currentAST.root;
		returnAST = logicalAndExpression_AST;
	}
	
	public final void inclusiveOrExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST inclusiveOrExpression_AST = null;
		
		exclusiveOrExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop248:
		do {
			if ((LA(1)==BOR)) {
				AST tmp176_AST = null;
				tmp176_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp176_AST);
				match(BOR);
				exclusiveOrExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop248;
			}
			
		} while (true);
		}
		inclusiveOrExpression_AST = (AST)currentAST.root;
		returnAST = inclusiveOrExpression_AST;
	}
	
	public final void exclusiveOrExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exclusiveOrExpression_AST = null;
		
		andExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop251:
		do {
			if ((LA(1)==BXOR)) {
				AST tmp177_AST = null;
				tmp177_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp177_AST);
				match(BXOR);
				andExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop251;
			}
			
		} while (true);
		}
		exclusiveOrExpression_AST = (AST)currentAST.root;
		returnAST = exclusiveOrExpression_AST;
	}
	
	public final void andExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST andExpression_AST = null;
		
		equalityExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop254:
		do {
			if ((LA(1)==BAND)) {
				AST tmp178_AST = null;
				tmp178_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp178_AST);
				match(BAND);
				equalityExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop254;
			}
			
		} while (true);
		}
		andExpression_AST = (AST)currentAST.root;
		returnAST = andExpression_AST;
	}
	
	public final void equalityExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equalityExpression_AST = null;
		
		relationalExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop258:
		do {
			if ((LA(1)==NOT_EQUAL||LA(1)==EQUAL)) {
				{
				switch ( LA(1)) {
				case NOT_EQUAL:
				{
					AST tmp179_AST = null;
					tmp179_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp179_AST);
					match(NOT_EQUAL);
					break;
				}
				case EQUAL:
				{
					AST tmp180_AST = null;
					tmp180_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp180_AST);
					match(EQUAL);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				relationalExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop258;
			}
			
		} while (true);
		}
		equalityExpression_AST = (AST)currentAST.root;
		returnAST = equalityExpression_AST;
	}
	
	public final void relationalExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST relationalExpression_AST = null;
		
		shiftExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case SEMI:
		case RBRACK:
		case QUESTION:
		case LT:
		case COMMA:
		case GT:
		case RPAREN:
		case ASSIGN:
		case RCURLY:
		case BAND:
		case COLON:
		case PLUS_ASSIGN:
		case MINUS_ASSIGN:
		case STAR_ASSIGN:
		case DIV_ASSIGN:
		case MOD_ASSIGN:
		case SR_ASSIGN:
		case BSR_ASSIGN:
		case SL_ASSIGN:
		case BAND_ASSIGN:
		case BXOR_ASSIGN:
		case BOR_ASSIGN:
		case LOR:
		case LAND:
		case BOR:
		case BXOR:
		case NOT_EQUAL:
		case EQUAL:
		case LE:
		case GE:
		{
			{
			_loop263:
			do {
				if ((_tokenSet_40.member(LA(1)))) {
					{
					switch ( LA(1)) {
					case LT:
					{
						AST tmp181_AST = null;
						tmp181_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp181_AST);
						match(LT);
						break;
					}
					case GT:
					{
						AST tmp182_AST = null;
						tmp182_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp182_AST);
						match(GT);
						break;
					}
					case LE:
					{
						AST tmp183_AST = null;
						tmp183_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp183_AST);
						match(LE);
						break;
					}
					case GE:
					{
						AST tmp184_AST = null;
						tmp184_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp184_AST);
						match(GE);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					shiftExpression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop263;
				}
				
			} while (true);
			}
			break;
		}
		case LITERAL_instanceof:
		{
			AST tmp185_AST = null;
			tmp185_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp185_AST);
			match(LITERAL_instanceof);
			typeSpec(true);
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		relationalExpression_AST = (AST)currentAST.root;
		returnAST = relationalExpression_AST;
	}
	
	public final void shiftExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST shiftExpression_AST = null;
		
		additiveExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop267:
		do {
			if ((_tokenSet_41.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case SL:
				{
					AST tmp186_AST = null;
					tmp186_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp186_AST);
					match(SL);
					break;
				}
				case SR:
				{
					AST tmp187_AST = null;
					tmp187_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp187_AST);
					match(SR);
					break;
				}
				case BSR:
				{
					AST tmp188_AST = null;
					tmp188_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp188_AST);
					match(BSR);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				additiveExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop267;
			}
			
		} while (true);
		}
		shiftExpression_AST = (AST)currentAST.root;
		returnAST = shiftExpression_AST;
	}
	
	public final void additiveExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST additiveExpression_AST = null;
		
		multiplicativeExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop271:
		do {
			if ((LA(1)==PLUS||LA(1)==MINUS)) {
				{
				switch ( LA(1)) {
				case PLUS:
				{
					AST tmp189_AST = null;
					tmp189_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp189_AST);
					match(PLUS);
					break;
				}
				case MINUS:
				{
					AST tmp190_AST = null;
					tmp190_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp190_AST);
					match(MINUS);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				multiplicativeExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop271;
			}
			
		} while (true);
		}
		additiveExpression_AST = (AST)currentAST.root;
		returnAST = additiveExpression_AST;
	}
	
	public final void multiplicativeExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST multiplicativeExpression_AST = null;
		
		unaryExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop275:
		do {
			if ((_tokenSet_42.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case STAR:
				{
					AST tmp191_AST = null;
					tmp191_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp191_AST);
					match(STAR);
					break;
				}
				case DIV:
				{
					AST tmp192_AST = null;
					tmp192_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp192_AST);
					match(DIV);
					break;
				}
				case MOD:
				{
					AST tmp193_AST = null;
					tmp193_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp193_AST);
					match(MOD);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				unaryExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop275;
			}
			
		} while (true);
		}
		multiplicativeExpression_AST = (AST)currentAST.root;
		returnAST = multiplicativeExpression_AST;
	}
	
	public final void unaryExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unaryExpression_AST = null;
		
		switch ( LA(1)) {
		case INC:
		{
			AST tmp194_AST = null;
			tmp194_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp194_AST);
			match(INC);
			unaryExpression();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case DEC:
		{
			AST tmp195_AST = null;
			tmp195_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp195_AST);
			match(DEC);
			unaryExpression();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp196_AST = null;
			tmp196_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp196_AST);
			match(MINUS);
			if ( inputState.guessing==0 ) {
				tmp196_AST.setType(UNARY_MINUS);
			}
			unaryExpression();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case PLUS:
		{
			AST tmp197_AST = null;
			tmp197_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp197_AST);
			match(PLUS);
			if ( inputState.guessing==0 ) {
				tmp197_AST.setType(UNARY_PLUS);
			}
			unaryExpression();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case BNOT:
		case LNOT:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			unaryExpressionNotPlusMinus();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = unaryExpression_AST;
	}
	
	public final void unaryExpressionNotPlusMinus() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unaryExpressionNotPlusMinus_AST = null;
		Token  lpb = null;
		AST lpb_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		
		switch ( LA(1)) {
		case BNOT:
		{
			AST tmp198_AST = null;
			tmp198_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp198_AST);
			match(BNOT);
			unaryExpression();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpressionNotPlusMinus_AST = (AST)currentAST.root;
			break;
		}
		case LNOT:
		{
			AST tmp199_AST = null;
			tmp199_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp199_AST);
			match(LNOT);
			unaryExpression();
			astFactory.addASTChild(currentAST, returnAST);
			unaryExpressionNotPlusMinus_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_super:
		case LT:
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		case LPAREN:
		case LITERAL_this:
		case LITERAL_true:
		case LITERAL_false:
		case LITERAL_null:
		case LITERAL_new:
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			{
			boolean synPredMatched280 = false;
			if (((LA(1)==LPAREN) && ((LA(2) >= LITERAL_void && LA(2) <= LITERAL_double)))) {
				int _m280 = mark();
				synPredMatched280 = true;
				inputState.guessing++;
				try {
					{
					match(LPAREN);
					builtInTypeSpec(true);
					match(RPAREN);
					unaryExpression();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched280 = false;
				}
				rewind(_m280);
				inputState.guessing--;
			}
			if ( synPredMatched280 ) {
				lpb = LT(1);
				lpb_AST = astFactory.create(lpb);
				astFactory.makeASTRoot(currentAST, lpb_AST);
				match(LPAREN);
				if ( inputState.guessing==0 ) {
					lpb_AST.setType(TYPECAST);
				}
				builtInTypeSpec(true);
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp200_AST = null;
				tmp200_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp200_AST);
				match(RPAREN);
				unaryExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				boolean synPredMatched282 = false;
				if (((LA(1)==LPAREN) && (LA(2)==IDENT))) {
					int _m282 = mark();
					synPredMatched282 = true;
					inputState.guessing++;
					try {
						{
						match(LPAREN);
						classTypeSpec(true);
						match(RPAREN);
						unaryExpressionNotPlusMinus();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched282 = false;
					}
					rewind(_m282);
					inputState.guessing--;
				}
				if ( synPredMatched282 ) {
					lp = LT(1);
					lp_AST = astFactory.create(lp);
					astFactory.makeASTRoot(currentAST, lp_AST);
					match(LPAREN);
					if ( inputState.guessing==0 ) {
						lp_AST.setType(TYPECAST);
					}
					classTypeSpec(true);
					astFactory.addASTChild(currentAST, returnAST);
					AST tmp201_AST = null;
					tmp201_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp201_AST);
					match(RPAREN);
					unaryExpressionNotPlusMinus();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_43.member(LA(1))) && (_tokenSet_44.member(LA(2)))) {
					postfixExpression();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				unaryExpressionNotPlusMinus_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			returnAST = unaryExpressionNotPlusMinus_AST;
		}
		
	public final void postfixExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST postfixExpression_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		Token  lp3 = null;
		AST lp3_AST = null;
		Token  lps = null;
		AST lps_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		Token  in = null;
		AST in_AST = null;
		Token  de = null;
		AST de_AST = null;
		
		primaryExpression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop291:
		do {
			if ((LA(1)==DOT) && (_tokenSet_45.member(LA(2)))) {
				AST tmp202_AST = null;
				tmp202_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp202_AST);
				match(DOT);
				{
				switch ( LA(1)) {
				case LT:
				{
					typeArguments();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_super:
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case IDENT:
				{
					AST tmp203_AST = null;
					tmp203_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp203_AST);
					match(IDENT);
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						lp = LT(1);
						lp_AST = astFactory.create(lp);
						astFactory.makeASTRoot(currentAST, lp_AST);
						match(LPAREN);
						if ( inputState.guessing==0 ) {
							lp_AST.setType(METHOD_CALL);
						}
						argList();
						astFactory.addASTChild(currentAST, returnAST);
						AST tmp204_AST = null;
						tmp204_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp204_AST);
						match(RPAREN);
						break;
					}
					case SEMI:
					case LBRACK:
					case RBRACK:
					case QUESTION:
					case LT:
					case COMMA:
					case GT:
					case SR:
					case BSR:
					case DOT:
					case STAR:
					case RPAREN:
					case ASSIGN:
					case RCURLY:
					case BAND:
					case COLON:
					case PLUS_ASSIGN:
					case MINUS_ASSIGN:
					case STAR_ASSIGN:
					case DIV_ASSIGN:
					case MOD_ASSIGN:
					case SR_ASSIGN:
					case BSR_ASSIGN:
					case SL_ASSIGN:
					case BAND_ASSIGN:
					case BXOR_ASSIGN:
					case BOR_ASSIGN:
					case LOR:
					case LAND:
					case BOR:
					case BXOR:
					case NOT_EQUAL:
					case EQUAL:
					case LE:
					case GE:
					case LITERAL_instanceof:
					case SL:
					case PLUS:
					case MINUS:
					case DIV:
					case MOD:
					case INC:
					case DEC:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				case LITERAL_super:
				{
					AST tmp205_AST = null;
					tmp205_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp205_AST);
					match(LITERAL_super);
					{
					switch ( LA(1)) {
					case LPAREN:
					{
						lp3 = LT(1);
						lp3_AST = astFactory.create(lp3);
						astFactory.makeASTRoot(currentAST, lp3_AST);
						match(LPAREN);
						argList();
						astFactory.addASTChild(currentAST, returnAST);
						match(RPAREN);
						if ( inputState.guessing==0 ) {
							lp3_AST.setType(SUPER_CTOR_CALL);
						}
						break;
					}
					case DOT:
					{
						AST tmp207_AST = null;
						tmp207_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp207_AST);
						match(DOT);
						{
						switch ( LA(1)) {
						case LT:
						{
							typeArguments();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						case IDENT:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						AST tmp208_AST = null;
						tmp208_AST = astFactory.create(LT(1));
						astFactory.addASTChild(currentAST, tmp208_AST);
						match(IDENT);
						{
						switch ( LA(1)) {
						case LPAREN:
						{
							lps = LT(1);
							lps_AST = astFactory.create(lps);
							astFactory.makeASTRoot(currentAST, lps_AST);
							match(LPAREN);
							if ( inputState.guessing==0 ) {
								lps_AST.setType(METHOD_CALL);
							}
							argList();
							astFactory.addASTChild(currentAST, returnAST);
							AST tmp209_AST = null;
							tmp209_AST = astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp209_AST);
							match(RPAREN);
							break;
						}
						case SEMI:
						case LBRACK:
						case RBRACK:
						case QUESTION:
						case LT:
						case COMMA:
						case GT:
						case SR:
						case BSR:
						case DOT:
						case STAR:
						case RPAREN:
						case ASSIGN:
						case RCURLY:
						case BAND:
						case COLON:
						case PLUS_ASSIGN:
						case MINUS_ASSIGN:
						case STAR_ASSIGN:
						case DIV_ASSIGN:
						case MOD_ASSIGN:
						case SR_ASSIGN:
						case BSR_ASSIGN:
						case SL_ASSIGN:
						case BAND_ASSIGN:
						case BXOR_ASSIGN:
						case BOR_ASSIGN:
						case LOR:
						case LAND:
						case BOR:
						case BXOR:
						case NOT_EQUAL:
						case EQUAL:
						case LE:
						case GE:
						case LITERAL_instanceof:
						case SL:
						case PLUS:
						case MINUS:
						case DIV:
						case MOD:
						case INC:
						case DEC:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			else if ((LA(1)==DOT) && (LA(2)==LITERAL_this)) {
				AST tmp210_AST = null;
				tmp210_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp210_AST);
				match(DOT);
				AST tmp211_AST = null;
				tmp211_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp211_AST);
				match(LITERAL_this);
			}
			else if ((LA(1)==DOT) && (LA(2)==LITERAL_new)) {
				AST tmp212_AST = null;
				tmp212_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp212_AST);
				match(DOT);
				newExpression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((LA(1)==LBRACK)) {
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if ( inputState.guessing==0 ) {
					lb_AST.setType(INDEX_OP);
				}
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				match(RBRACK);
			}
			else {
				break _loop291;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case INC:
		{
			in = LT(1);
			in_AST = astFactory.create(in);
			astFactory.makeASTRoot(currentAST, in_AST);
			match(INC);
			if ( inputState.guessing==0 ) {
				in_AST.setType(POST_INC);
			}
			break;
		}
		case DEC:
		{
			de = LT(1);
			de_AST = astFactory.create(de);
			astFactory.makeASTRoot(currentAST, de_AST);
			match(DEC);
			if ( inputState.guessing==0 ) {
				de_AST.setType(POST_DEC);
			}
			break;
		}
		case SEMI:
		case RBRACK:
		case QUESTION:
		case LT:
		case COMMA:
		case GT:
		case SR:
		case BSR:
		case STAR:
		case RPAREN:
		case ASSIGN:
		case RCURLY:
		case BAND:
		case COLON:
		case PLUS_ASSIGN:
		case MINUS_ASSIGN:
		case STAR_ASSIGN:
		case DIV_ASSIGN:
		case MOD_ASSIGN:
		case SR_ASSIGN:
		case BSR_ASSIGN:
		case SL_ASSIGN:
		case BAND_ASSIGN:
		case BXOR_ASSIGN:
		case BOR_ASSIGN:
		case LOR:
		case LAND:
		case BOR:
		case BXOR:
		case NOT_EQUAL:
		case EQUAL:
		case LE:
		case GE:
		case LITERAL_instanceof:
		case SL:
		case PLUS:
		case MINUS:
		case DIV:
		case MOD:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		postfixExpression_AST = (AST)currentAST.root;
		returnAST = postfixExpression_AST;
	}
	
	public final void primaryExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST primaryExpression_AST = null;
		Token  lbt = null;
		AST lbt_AST = null;
		
		switch ( LA(1)) {
		case LT:
		case IDENT:
		{
			identPrimary();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==DOT) && (LA(2)==LITERAL_class)) {
				AST tmp214_AST = null;
				tmp214_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp214_AST);
				match(DOT);
				AST tmp215_AST = null;
				tmp215_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp215_AST);
				match(LITERAL_class);
			}
			else if ((_tokenSet_46.member(LA(1))) && (_tokenSet_47.member(LA(2)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case NUM_INT:
		case CHAR_LITERAL:
		case STRING_LITERAL:
		case NUM_FLOAT:
		case NUM_LONG:
		case NUM_DOUBLE:
		{
			constant();
			astFactory.addASTChild(currentAST, returnAST);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_true:
		{
			AST tmp216_AST = null;
			tmp216_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp216_AST);
			match(LITERAL_true);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_false:
		{
			AST tmp217_AST = null;
			tmp217_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp217_AST);
			match(LITERAL_false);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_null:
		{
			AST tmp218_AST = null;
			tmp218_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp218_AST);
			match(LITERAL_null);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_new:
		{
			newExpression();
			astFactory.addASTChild(currentAST, returnAST);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_this:
		{
			AST tmp219_AST = null;
			tmp219_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp219_AST);
			match(LITERAL_this);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_super:
		{
			AST tmp220_AST = null;
			tmp220_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp220_AST);
			match(LITERAL_super);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			AST tmp221_AST = null;
			tmp221_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp221_AST);
			match(LPAREN);
			assignmentExpression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp222_AST = null;
			tmp222_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp222_AST);
			match(RPAREN);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		{
			builtInType();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop296:
			do {
				if ((LA(1)==LBRACK)) {
					lbt = LT(1);
					lbt_AST = astFactory.create(lbt);
					astFactory.makeASTRoot(currentAST, lbt_AST);
					match(LBRACK);
					if ( inputState.guessing==0 ) {
						lbt_AST.setType(ARRAY_DECLARATOR);
					}
					AST tmp223_AST = null;
					tmp223_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp223_AST);
					match(RBRACK);
				}
				else {
					break _loop296;
				}
				
			} while (true);
			}
			AST tmp224_AST = null;
			tmp224_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp224_AST);
			match(DOT);
			AST tmp225_AST = null;
			tmp225_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp225_AST);
			match(LITERAL_class);
			primaryExpression_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = primaryExpression_AST;
	}
	

/** object instantiation.
 *  Trees are built as illustrated by the following input/tree pairs:
 *
 *  new T()
 *
 *  new
 *   |
 *   T --  ELIST
 *		   |
 *		  arg1 -- arg2 -- .. -- argn
 *
 *  new int[]
 *
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR
 *
 *  new int[] {1,2}
 *
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR -- ARRAY_INIT
 *								  |
 *								EXPR -- EXPR
 *								  |	  |
 *								  1	  2
 *
 *  new int[3]
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR
 *				|
 *			  EXPR
 *				|
 *				3
 *
 *  new int[1][2]
 *
 *  new
 *   |
 *  int -- ARRAY_DECLARATOR
 *			   |
 *		 ARRAY_DECLARATOR -- EXPR
 *			   |			  |
 *			 EXPR			 1
 *			   |
 *			   2
 *
 */
	public final void newExpression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST newExpression_AST = null;
		
		AST tmp226_AST = null;
		tmp226_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp226_AST);
		match(LITERAL_new);
		{
		switch ( LA(1)) {
		case LT:
		{
			typeArguments();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_void:
		case LITERAL_boolean:
		case LITERAL_byte:
		case LITERAL_char:
		case LITERAL_short:
		case LITERAL_int:
		case LITERAL_float:
		case LITERAL_long:
		case LITERAL_double:
		case IDENT:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		type();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LPAREN:
		{
			AST tmp227_AST = null;
			tmp227_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp227_AST);
			match(LPAREN);
			argList();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp228_AST = null;
			tmp228_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp228_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case LCURLY:
			{
				classBlock();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LBRACK:
			case RBRACK:
			case QUESTION:
			case LT:
			case COMMA:
			case GT:
			case SR:
			case BSR:
			case DOT:
			case STAR:
			case RPAREN:
			case ASSIGN:
			case RCURLY:
			case BAND:
			case COLON:
			case PLUS_ASSIGN:
			case MINUS_ASSIGN:
			case STAR_ASSIGN:
			case DIV_ASSIGN:
			case MOD_ASSIGN:
			case SR_ASSIGN:
			case BSR_ASSIGN:
			case SL_ASSIGN:
			case BAND_ASSIGN:
			case BXOR_ASSIGN:
			case BOR_ASSIGN:
			case LOR:
			case LAND:
			case BOR:
			case BXOR:
			case NOT_EQUAL:
			case EQUAL:
			case LE:
			case GE:
			case LITERAL_instanceof:
			case SL:
			case PLUS:
			case MINUS:
			case DIV:
			case MOD:
			case INC:
			case DEC:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case LBRACK:
		{
			newArrayDeclarator();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LCURLY:
			{
				arrayInitializer();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case SEMI:
			case LBRACK:
			case RBRACK:
			case QUESTION:
			case LT:
			case COMMA:
			case GT:
			case SR:
			case BSR:
			case DOT:
			case STAR:
			case RPAREN:
			case ASSIGN:
			case RCURLY:
			case BAND:
			case COLON:
			case PLUS_ASSIGN:
			case MINUS_ASSIGN:
			case STAR_ASSIGN:
			case DIV_ASSIGN:
			case MOD_ASSIGN:
			case SR_ASSIGN:
			case BSR_ASSIGN:
			case SL_ASSIGN:
			case BAND_ASSIGN:
			case BXOR_ASSIGN:
			case BOR_ASSIGN:
			case LOR:
			case LAND:
			case BOR:
			case BXOR:
			case NOT_EQUAL:
			case EQUAL:
			case LE:
			case GE:
			case LITERAL_instanceof:
			case SL:
			case PLUS:
			case MINUS:
			case DIV:
			case MOD:
			case INC:
			case DEC:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		newExpression_AST = (AST)currentAST.root;
		returnAST = newExpression_AST;
	}
	

/** Match a, a.b.c refs, a.b.c(...) refs, a.b.c[], a.b.c[].class,
 *  and a.b.c.class refs. Also this(...) and super(...). Match
 *  this or super.
 */
	public final void identPrimary() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identPrimary_AST = null;
		AST ta1_AST = null;
		AST ta2_AST = null;
		Token  lp = null;
		AST lp_AST = null;
		Token  lbc = null;
		AST lbc_AST = null;
		
		{
		switch ( LA(1)) {
		case LT:
		{
			typeArguments();
			ta1_AST = (AST)returnAST;
			break;
		}
		case IDENT:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		AST tmp229_AST = null;
		tmp229_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp229_AST);
		match(IDENT);
		{
		_loop304:
		do {
			boolean synPredMatched302 = false;
			if (((LA(1)==DOT) && (LA(2)==LT||LA(2)==IDENT))) {
				int _m302 = mark();
				synPredMatched302 = true;
				inputState.guessing++;
				try {
					{
					match(DOT);
					{
					switch ( LA(1)) {
					case LT:
					{
						typeArguments();
						break;
					}
					case IDENT:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(IDENT);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched302 = false;
				}
				rewind(_m302);
				inputState.guessing--;
			}
			if ( synPredMatched302 ) {
				AST tmp230_AST = null;
				tmp230_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp230_AST);
				match(DOT);
				{
				switch ( LA(1)) {
				case LT:
				{
					typeArguments();
					ta2_AST = (AST)returnAST;
					break;
				}
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp231_AST = null;
				tmp231_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp231_AST);
				match(IDENT);
			}
			else if (((_tokenSet_48.member(LA(1))) && (_tokenSet_47.member(LA(2))))&&(false)) {
			}
			else {
				break _loop304;
			}
			
		} while (true);
		}
		{
		if ((LA(1)==LPAREN)) {
			{
			lp = LT(1);
			lp_AST = astFactory.create(lp);
			astFactory.makeASTRoot(currentAST, lp_AST);
			match(LPAREN);
			if ( inputState.guessing==0 ) {
				lp_AST.setType(METHOD_CALL);
			}
			if ( inputState.guessing==0 ) {
				if (ta2_AST != null) astFactory.addASTChild(currentAST, ta2_AST);
			}
			if ( inputState.guessing==0 ) {
				if (ta2_AST == null) astFactory.addASTChild(currentAST, ta1_AST);
			}
			argList();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp232_AST = null;
			tmp232_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp232_AST);
			match(RPAREN);
			}
		}
		else if ((LA(1)==LBRACK) && (LA(2)==RBRACK)) {
			{
			int _cnt308=0;
			_loop308:
			do {
				if ((LA(1)==LBRACK) && (LA(2)==RBRACK)) {
					lbc = LT(1);
					lbc_AST = astFactory.create(lbc);
					astFactory.makeASTRoot(currentAST, lbc_AST);
					match(LBRACK);
					if ( inputState.guessing==0 ) {
						lbc_AST.setType(ARRAY_DECLARATOR);
					}
					AST tmp233_AST = null;
					tmp233_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp233_AST);
					match(RBRACK);
				}
				else {
					if ( _cnt308>=1 ) { break _loop308; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt308++;
			} while (true);
			}
		}
		else if ((_tokenSet_46.member(LA(1))) && (_tokenSet_47.member(LA(2)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		identPrimary_AST = (AST)currentAST.root;
		returnAST = identPrimary_AST;
	}
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1)) {
		case NUM_INT:
		{
			AST tmp234_AST = null;
			tmp234_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp234_AST);
			match(NUM_INT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case CHAR_LITERAL:
		{
			AST tmp235_AST = null;
			tmp235_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp235_AST);
			match(CHAR_LITERAL);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case STRING_LITERAL:
		{
			AST tmp236_AST = null;
			tmp236_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp236_AST);
			match(STRING_LITERAL);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NUM_FLOAT:
		{
			AST tmp237_AST = null;
			tmp237_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp237_AST);
			match(NUM_FLOAT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NUM_LONG:
		{
			AST tmp238_AST = null;
			tmp238_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp238_AST);
			match(NUM_LONG);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NUM_DOUBLE:
		{
			AST tmp239_AST = null;
			tmp239_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp239_AST);
			match(NUM_DOUBLE);
			constant_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = constant_AST;
	}
	
	public final void newArrayDeclarator() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST newArrayDeclarator_AST = null;
		Token  lb = null;
		AST lb_AST = null;
		
		{
		int _cnt319=0;
		_loop319:
		do {
			if ((LA(1)==LBRACK) && (_tokenSet_49.member(LA(2)))) {
				lb = LT(1);
				lb_AST = astFactory.create(lb);
				astFactory.makeASTRoot(currentAST, lb_AST);
				match(LBRACK);
				if ( inputState.guessing==0 ) {
					lb_AST.setType(ARRAY_DECLARATOR);
				}
				{
				switch ( LA(1)) {
				case LITERAL_super:
				case LT:
				case LITERAL_void:
				case LITERAL_boolean:
				case LITERAL_byte:
				case LITERAL_char:
				case LITERAL_short:
				case LITERAL_int:
				case LITERAL_float:
				case LITERAL_long:
				case LITERAL_double:
				case IDENT:
				case LPAREN:
				case LITERAL_this:
				case PLUS:
				case MINUS:
				case INC:
				case DEC:
				case BNOT:
				case LNOT:
				case LITERAL_true:
				case LITERAL_false:
				case LITERAL_null:
				case LITERAL_new:
				case NUM_INT:
				case CHAR_LITERAL:
				case STRING_LITERAL:
				case NUM_FLOAT:
				case NUM_LONG:
				case NUM_DOUBLE:
				{
					expression();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case RBRACK:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				AST tmp240_AST = null;
				tmp240_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp240_AST);
				match(RBRACK);
			}
			else {
				if ( _cnt319>=1 ) { break _loop319; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt319++;
		} while (true);
		}
		newArrayDeclarator_AST = (AST)currentAST.root;
		returnAST = newArrayDeclarator_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"BLOCK",
		"MODIFIERS",
		"OBJBLOCK",
		"SLIST",
		"CTOR_DEF",
		"METHOD_DEF",
		"VARIABLE_DEF",
		"INSTANCE_INIT",
		"STATIC_INIT",
		"TYPE",
		"CLASS_DEF",
		"INTERFACE_DEF",
		"PACKAGE_DEF",
		"ARRAY_DECLARATOR",
		"EXTENDS_CLAUSE",
		"IMPLEMENTS_CLAUSE",
		"PARAMETERS",
		"PARAMETER_DEF",
		"LABELED_STAT",
		"TYPECAST",
		"INDEX_OP",
		"POST_INC",
		"POST_DEC",
		"METHOD_CALL",
		"EXPR",
		"ARRAY_INIT",
		"IMPORT",
		"UNARY_MINUS",
		"UNARY_PLUS",
		"CASE_GROUP",
		"ELIST",
		"FOR_INIT",
		"FOR_CONDITION",
		"FOR_ITERATOR",
		"EMPTY_STAT",
		"\"final\"",
		"\"abstract\"",
		"\"strictfp\"",
		"SUPER_CTOR_CALL",
		"CTOR_CALL",
		"VARIABLE_PARAMETER_DEF",
		"STATIC_IMPORT",
		"ENUM_DEF",
		"ENUM_CONSTANT_DEF",
		"FOR_EACH_CLAUSE",
		"ANNOTATION_DEF",
		"ANNOTATIONS",
		"ANNOTATION",
		"ANNOTATION_MEMBER_VALUE_PAIR",
		"ANNOTATION_FIELD_DEF",
		"ANNOTATION_ARRAY_INIT",
		"TYPE_ARGUMENTS",
		"TYPE_ARGUMENT",
		"TYPE_PARAMETERS",
		"TYPE_PARAMETER",
		"WILDCARD_TYPE",
		"TYPE_UPPER_BOUNDS",
		"TYPE_LOWER_BOUNDS",
		"GENERIC_TYPE",
		"START_CLASS_BODY",
		"END_CLASS_BODY",
		"\"package\"",
		"SEMI",
		"\"import\"",
		"\"static\"",
		"LBRACK",
		"RBRACK",
		"QUESTION",
		"\"extends\"",
		"\"super\"",
		"LT",
		"COMMA",
		"GT",
		"SR",
		"BSR",
		"\"void\"",
		"\"boolean\"",
		"\"byte\"",
		"\"char\"",
		"\"short\"",
		"\"int\"",
		"\"float\"",
		"\"long\"",
		"\"double\"",
		"IDENT",
		"DOT",
		"STAR",
		"\"private\"",
		"\"public\"",
		"\"protected\"",
		"\"transient\"",
		"\"native\"",
		"\"threadsafe\"",
		"\"synchronized\"",
		"\"volatile\"",
		"AT",
		"LPAREN",
		"RPAREN",
		"ASSIGN",
		"LCURLY",
		"RCURLY",
		"\"class\"",
		"\"interface\"",
		"\"enum\"",
		"BAND",
		"\"default\"",
		"\"implements\"",
		"\"this\"",
		"\"throws\"",
		"TRIPLE_DOT",
		"COLON",
		"\"if\"",
		"\"else\"",
		"\"while\"",
		"\"do\"",
		"\"break\"",
		"\"continue\"",
		"\"return\"",
		"\"switch\"",
		"\"throw\"",
		"\"assert\"",
		"\"for\"",
		"\"case\"",
		"\"try\"",
		"\"finally\"",
		"\"catch\"",
		"PLUS_ASSIGN",
		"MINUS_ASSIGN",
		"STAR_ASSIGN",
		"DIV_ASSIGN",
		"MOD_ASSIGN",
		"SR_ASSIGN",
		"BSR_ASSIGN",
		"SL_ASSIGN",
		"BAND_ASSIGN",
		"BXOR_ASSIGN",
		"BOR_ASSIGN",
		"LOR",
		"LAND",
		"BOR",
		"BXOR",
		"NOT_EQUAL",
		"EQUAL",
		"LE",
		"GE",
		"\"instanceof\"",
		"SL",
		"PLUS",
		"MINUS",
		"DIV",
		"MOD",
		"INC",
		"DEC",
		"BNOT",
		"LNOT",
		"\"true\"",
		"\"false\"",
		"\"null\"",
		"\"new\"",
		"NUM_INT",
		"CHAR_LITERAL",
		"STRING_LITERAL",
		"NUM_FLOAT",
		"NUM_LONG",
		"NUM_DOUBLE",
		"WS",
		"SL_COMMENT",
		"ML_COMMENT",
		"ESC",
		"HEX_DIGIT",
		"VOCAB",
		"IDENT_LETTER",
		"EXPONENT",
		"FLOAT_SUFFIX"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 3848290697218L, 15461748047900L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 3848290697218L, 15461764825108L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 3848290697216L, 15461748047892L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 3848290697218L, 15461748047892L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 3848290697216L, 16011537384464L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 3848290697216L, 15461781570576L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 3848290697216L, 15530534601776L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 0L, 50332704L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 0L, 274877909028L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 3848290697216L, 34225520656L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 0L, 33521792L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 0L, 1919678616173540L, 524284L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 3848290697218L, -281474976710666L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 3848290697216L, 1935140464885748L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 0L, 141390356907520L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = { 0L, 159669838411424L, 2199023247360L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = { 0L, 140840601093632L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = { 0L, 70918533544192L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = { 3848290697216L, 87548546221364L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 549755813888L, 34393260032L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 0L, 34426815520L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = { 0L, 562984380236832L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = { 3848290697216L, -4618297794262759916L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = { 0L, 140737488356864L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = { 0L, 68752998528L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = { 3848290697216L, -4618296694751132140L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = { 3848290697218L, -4617139733540112716L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = { 3848290697216L, -2071892324284908L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 3848290697218L, -914931113265484L, 2199023255551L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 3848290697216L, 68618780688L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = { 3848290697216L, 68652336176L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = { 0L, 140806241355264L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = { 0L, 158673405998756L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = { 3848290697216L, 2267608514576L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = { 3848290697216L, 2267625291792L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = { 0L, 141355997169152L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = { 3848290697216L, 140874826614292L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = { 3848290697216L, 158741991259828L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = { 0L, 1266706148197888L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = { 0L, 158673406000804L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = { 0L, 5120L, 1572864L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = { 0L, 24576L, 4194304L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = { 0L, 67108864L, 100663296L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = { 0L, 140806241355264L, 2196875771904L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = { 0L, 1285810263424740L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = { 0L, 16778752L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = { 0L, 1145004022070500L, 536870908L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = { 3848290697218L, -914793674309898L, 2199023255548L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = { 0L, 1145072741547236L, 536870908L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = { 0L, 140806241355328L, 2198914203648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	
	}
