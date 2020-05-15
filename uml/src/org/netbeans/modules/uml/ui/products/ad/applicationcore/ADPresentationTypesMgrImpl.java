/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.

 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 */


package org.netbeans.modules.uml.ui.products.ad.applicationcore;

import org.dom4j.Element;

import org.netbeans.modules.uml.core.metamodel.diagrams.IDiagramKind;
import org.netbeans.modules.uml.core.support.umlsupport.XMLManip;
//import org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl;
//import org.netbeans.modules.uml.ui.support.applicationmanager.TSGraphObjectKind;

/**
 *
 */ //TODO
public class ADPresentationTypesMgrImpl //TODO extends PresentationTypesMgrImpl
{

   
/**
    * Create the Invalid DrawEngines Section.
    *
    * This provides the draw engines that are invalid on the various diagrams.
    *
    * @param pParent[in] The parent DOM node for this section
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl#createInvalidDrawEnginesOnDiagramsSection(org.dom4j.Element)
    */
   protected void createInvalidDrawEnginesOnDiagramsSection(Element rootElement)
   {
      if(rootElement != null)
      {         
//         Element node = XMLManip.createElement(rootElement, getInvalidDrawEnginesSectionName());
//         if(node != null)
//         {     
//            createInvalidDrawEnginesEntry(node,
//                                          CLASS_DIAGRAM,
//                                          "CombinedFragmentDrawEngine");     
//            createInvalidDrawEnginesEntry(node,
//                                          CLASS_DIAGRAM,
//                                          "LifelineDrawEngine");     
//            createInvalidDrawEnginesEntry(node,
//                                          CLASS_DIAGRAM,
//                                          "MessageEdgeDrawEngine"); 
//            createInvalidDrawEnginesEntry(node,
//                                          CLASS_DIAGRAM,
//                                          "NodeDrawEngine"); 
//            createInvalidDrawEnginesEntry(node,
//                                          SEQUENCE_DIAGRAM,
//                                          "InterfaceDrawEngine"); 
//            createInvalidDrawEnginesEntry(node,
//                                          SEQUENCE_DIAGRAM,
//                                          "ClassDrawEngine"); 
//            createInvalidDrawEnginesEntry(node,
//                                          SEQUENCE_DIAGRAM,
//                                          "PackageDrawEngine"); 
//            createInvalidDrawEnginesEntry(node,
//                                          SEQUENCE_DIAGRAM,
//                                          "NodeDrawEngine");        
//         }
      }
   }

   

/**
    * Create the InitStrings Section.
    *
    * This maps an initialization string to the metatype, engine and type 
    * (ie node or edge) the TSObjectView should create.
    *
    * @param rootElement The parent DOM node for this section
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl#createInitStringsSection(org.dom4j.Element)
    */
   protected void createInitStringsSection(Element rootElement)
   {
      if(rootElement != null)
      {         //TODO
//         Element node = XMLManip.createElement(rootElement, getInitStringsSectionName());
//         if(node != null)
//         {  
//            ///////////////////////////////
//            // Pure Presentation Elements
//            ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Graphic",
//                                   "GraphicDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//
//             // Nested Link
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge NestedLink", 
//                                   "",
//                                   "NestedLinkDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//
//             // Comment Link
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge CommentEdge", 
//                                   "",
//                                   "CommentEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//
//             // Qualifiers
//            createInitStringsEntry(node,

//                                   "AssociationEnd",
//                                   "QualifierDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//
//             ///////////////////////////////
//             // Bridges
//             ///////////////////////////////
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssociationClassInitialEdge", 
//                                   "",
//                                   "BridgeEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssemblyConnectorInitialEdge", 
//                                   "",
//                                   "BridgeEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge", 
//                                   "",
//                                   "BridgeEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,

//                                   "",
//                                   "BridgeNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//
//             ///////////////////////////////
//             // NodeDecorators
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "SelfMessage",
//                                   "LifelineDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_DECORATOR,
//                                        SEQUENCE_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "Destroy",
//                                   "LifelineDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_DECORATOR,
//                                        SEQUENCE_DIAGRAM );
//
//             ///////////////////////////////
//             // Comment Nodes
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "Comment",
//                                   "CommentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//
//             ///////////////////////////////
//             // Classifier Nodes
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "AssociationClass",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "AssociationClass",
//                                   "AssociationClassConnectorDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Class",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Class",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Lifeline",
//                                   "LifelineDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        SEQUENCE_DIAGRAM);
//            createInitStringsEntry(node,

//                                   "Actor",
//                                   "ActorDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Lifeline",
//                                   "LifelineDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        SEQUENCE_DIAGRAM);
//            createInitStringsEntry(node,

//                                   "Lifeline",
//                                   "CollaborationLifelineDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        COLLABORATION_DIAGRAM);
//            createInitStringsEntry(node,

//                                   "Class",
//                                   "ClassRobustnessDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Class",
//                                   "ClassRobustnessDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Class",
//                                   "ClassRobustnessDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Class",
//                                   "ClassRobustnessDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Interface",
//                                   "InterfaceDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Interface",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "DataType",
//                                   "DataTypeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "AliasedType",
//                                   "DataTypeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Class",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Enumeration",
//                                   "EnumerationDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "DerivationClassifier",
//                                   "DerivationClassifierDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE );
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Derivation", 
//                                   "Derivation",
//                                   "DerivationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE );
//             ///////////////////////////////
//             // Package Nodes
//             ///////////////////////////////
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.Package", 
//                                   "Package",
//                                   "PackageDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//             ///////////////////////////////
//             // Interaction Fragment Nodes
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "CombinedFragment",
//                                   "CombinedFragmentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        SEQUENCE_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "InteractionOccurrence",
//                                   "InteractionFragmentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        SEQUENCE_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "InteractionOccurrence",
//                                   "InteractionFragmentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        COLLABORATION_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "InteractionOccurrence",
//                                   "InteractionFragmentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "Interaction",
//                                   "InteractionFragmentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        SEQUENCE_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "Interaction",
//                                   "InteractionFragmentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        COLLABORATION_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "Interaction",
//                                   "InteractionFragmentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        ACTIVITY_DIAGRAM );
//             ///////////////////////////////
//             // Activity Diagram Nodes & Edges
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "ParameterUsageNode",
//                                   "ObjectNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "DataStoreNode",
//                                   "ObjectNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "SignalNode",
//                                   "ObjectNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "InitialNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "ActivityFinalNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "FlowFinalNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "DecisionMergeNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "DecisionMergeNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "JoinForkNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "JoinForkNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "JoinForkNode",
//                                   "ControlNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "InvocationNode",
//                                   "InvocationNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge ActivityEdge", 
//                                   "ActivityEdge",
//                                   "ActivityEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,

//                                   "InterruptibleActivityRegion",
//                                   "ActivityGroupDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "IterationActivityGroup",
//                                   "ActivityGroupDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "StructuredActivityGroup",
//                                   "ActivityGroupDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "ComplexActivityGroup",
//                                   "ActivityGroupDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "Activity",
//                                   "ActivityNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE,
//                                        ACTIVITY_DIAGRAM );
//            createInitStringsEntry(node,

//                                   "ActivityPartition",
//                                   "PartitionDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//
//             ///////////////////////////////
//             // UseCase Diagram Nodes
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "UseCase",
//                                   "UseCaseDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Include", 
//                                   "Include",
//                                   "IncludeEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Extend", 
//                                   "Extend",
//                                   "ExtendEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//
//             ///////////////////////////////
//             // Deployment Diagram Nodes
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "Artifact",
//                                   "ArtifactDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Node",
//                                   "ClassNodeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "DeploymentSpecification",
//                                   "DeploymentSpecDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//
//             ///////////////////////////////
//             // Component Diagram Nodes & Edges
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "Component",
//                                   "ComponentDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "Port",
//                                   "PortDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge PortProvidedInterface", 
//                                   "Interface",
//                                   "PortProvidedInterfaceEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//
//             ///////////////////////////////
//             // State Diagram Nodes & Edges
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PseudoState",
//                                   "PseudoStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Transition", 
//                                   "Transition",
//                                   "TransitionEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,

//                                   "State",
//                                   "StateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "State",
//                                   "StateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "State",
//                                   "StateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "FinalState",
//                                   "FinalStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "FinalState",
//                                   "FinalStateDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "StateMachine",
//                                   "StateMachineDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//
//             ///////////////////////////////
//             // Edges
//             ///////////////////////////////
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association", 
//                                   "Association",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssociationEnd", 
//                                   "AssociationEnd",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation", 
//                                   "Aggregation",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association NN NN", 
//                                   "Association",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation CO NN", 
//                                   "Aggregation",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation AG NN", 
//                                   "Aggregation",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association NN NA", 
//                                   "Association",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation CO NA", 
//                                   "Aggregation",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation AG NA", 
//                                   "Aggregation",
//                                   "AssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Generalization", 
//                                   "Generalization",
//                                   "GeneralizationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message", 
//                                   "Message",
//                                   "MessageEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message asynchronous", 
//                                   "Message",
//                                   "MessageEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message create", 
//                                   "Message",
//                                   "MessageEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message result", 
//                                   "Message",
//                                   "MessageEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Dependency", 
//                                   "Dependency",
//                                   "DependencyEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge BinaryAssociation", 
//                                   "BinaryAssociation",
//                                   "BinaryAssociationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Implementation", 
//                                   "Implementation",
//                                   "ImplementationEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Realization", 
//                                   "Realization",
//                                   "DependencyEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Usage", 
//                                   "Usage",
//                                   "DependencyEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Delegate", 
//                                   "Delegate",
//                                   "DependencyEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Permission", 
//                                   "Permission",
//                                   "DependencyEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Abstraction", 
//                                   "Abstraction",
//                                   "DependencyEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//
//             ///////////////////////////////
//             // Collaboration Diagram Nodes & Edges
//             ///////////////////////////////
//            createInitStringsEntry(node,

//                                   "Lifeline",
//                                   "CollaborationLifelineDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "Collaboration",
//                                   "CollaborationDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE_RESIZE);
//            createInitStringsEntry(node,

//                                   "PartFacade",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PartFacade",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PartFacade",
//                                   "UseCaseDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PartFacade",
//                                   "ActorDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,

//                                   "PartFacade",
//                                   "ClassDrawEngine",
//                                   TSGraphObjectKind.TSGOK_NODE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge PartFacade", 
//                                   "PartFacade",
//                                   "PartFacadeEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE);
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Connector", 
//                                   "Connector",
//                                   "ConnectorEdgeDrawEngine",
//                                   TSGraphObjectKind.TSGOK_EDGE,
//                                        COLLABORATION_DIAGRAM);
//
//             ///////////////////////////////
//             // Labels
//             ///////////////////////////////
//            createInitStringsEntry(node,
//                                   "org.netbeans.modules.uml.ui.products.ad.viewfactory.LabelView", 
//                                   "",
//                                   "ADLabelDrawEngine",
//                                   TSGraphObjectKind.TSGOK_LABEL);
//         }
      }
   }

   

/**
    * Create the MetaTypes Section.
    *
    * This maps a metatype to a specific initialization string.
    *
    * @param rootElement The parent DOM node for this section
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl#createPresentationSection(org.dom4j.Element)
    */
   protected void createPresentationSection(Element rootElement)
   {
      if(rootElement != null)
      {         
//         Element node = XMLManip.createElement(rootElement, getPresentationSectionName());
//         if(node != null)
//         {            
//            createPresentationEntry(node,"AssociationEnd","AssociationEdgePresentation");
//            createPresentationEntry(node,"AssociationClass","AssociationEdgePresentation");
//            createPresentationEntry(node,"Association","AssociationEdgePresentation");
//            createPresentationEntry(node,"Aggregation","AggregationEdgePresentation");
//            createPresentationEntry(node,"Implementation","ImplementationEdgePresentation");
//            createPresentationEntry(node,"Dependency","DependencyEdgePresentation");
//            createPresentationEntry(node,"Abstraction","DependencyEdgePresentation");
//            createPresentationEntry(node,"Usage","DependencyEdgePresentation");
//            createPresentationEntry(node,"Permission","DependencyEdgePresentation");
//            createPresentationEntry(node,"Realization","DependencyEdgePresentation");
//            createPresentationEntry(node,"Generalization","GeneralizationEdgePresentation");
//            createPresentationEntry(node,"Message","MessageEdgePresentation");
//            createPresentationEntry(node,"Comment","CommentEdgePresentation");
//            createPresentationEntry(node,"ActivityEdge","ActivityEdgePresentation");
//            createPresentationEntry(node,"ControlFlow","ActivityEdgePresentation");
//            createPresentationEntry(node,"ObjectFlow","ActivityEdgePresentation");
//            createPresentationEntry(node,"MultiFlow","ActivityEdgePresentation");
//            createPresentationEntry(node,"Transition","TransitionEdgePresentation");
//            createPresentationEntry(node,"Include","IncludeEdgePresentation");
//            createPresentationEntry(node,"Extend","ExtendEdgePresentation");
//            createPresentationEntry(node,"Derivation","DerivationEdgePresentation");
//            createPresentationEntry(node,"Delegate","DependencyEdgePresentation");
//            createPresentationEntry(node,"Connector","ConnectorEdgePresentation");
//            createPresentationEntry(node,"Interface","InterfaceEdgePresentation");
//            createPresentationEntry(node,"AssociationEnd","AssociationEdgePresentation");
//         }
      }
   }

   

   protected void createMetaTypesSection(Element rootElement)
   {
      if(rootElement != null)
      {         
//         Element node = XMLManip.createElement(rootElement, getMetaTypesSectionName());
//         if(node != null)
//         {
//            ////////////////////////////////////////////////////////////////////////////////

//            // These are used if there is not a specific initialization string for the diagram.
//            ////////////////////////////////////////////////////////////////////////////////
//
//            createMetaTypesEntry(node,"Abstraction","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Abstraction" );


//            createMetaTypesEntry(node,"Aggregation","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation CO NN");
//            createMetaTypesEntry(node,"Association","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association NN NN");

//            createMetaTypesEntry(node,"BinaryAssociation","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge BinaryAssociation" );






//            createMetaTypesEntry(node,"Delegate","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Delegate" );
//            createMetaTypesEntry(node,"Dependency","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Dependency" );


//            createMetaTypesEntry(node,"Extend","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Extend" );
//            createMetaTypesEntry(node,"Generalization","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Generalization" );
//            createMetaTypesEntry(node,"Implementation","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Implementation" );
//            createMetaTypesEntry(node,"Include","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Include" );

//            createMetaTypesEntry(node,"Message","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message" );

//            createMetaTypesEntry(node,"Package","org.netbeans.modules.uml.ui.products.ad.viewfactory.Package" );





//            createMetaTypesEntry(node,"Permission","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Permission" );

//            createMetaTypesEntry(node,"Realization","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Realization" );
//            createMetaTypesEntry(node,"Usage","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Usage" );


//            createMetaTypesEntry(node,"Derivation","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Derivation" );
//
//             ////////////////////////////////////////////////////////////////////////////////
//             // Specific initialization strings (maintained alphabetical by diagram then element)
//             // These are used first, if none is found for the element,

//             ////////////////////////////////////////////////////////////////////////////////
//
//             // Activity Diagram Metatypes

//            createMetaTypesEntry(node,"ActivityEdge","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge ActivityEdge", ACTIVITY_DIAGRAM );
//            createMetaTypesEntry(node,"ControlFlow","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge ActivityEdge", ACTIVITY_DIAGRAM );
//            createMetaTypesEntry(node,"ObjectFlow","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge ActivityEdge", ACTIVITY_DIAGRAM );
//            createMetaTypesEntry(node,"MultiFlow","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge ActivityEdge", ACTIVITY_DIAGRAM );


















//
//             // Collaboration Diagram Metatypes





//            createMetaTypesEntry(node,"Connector","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Connector", COLLABORATION_DIAGRAM );
//            createMetaTypesEntry(node,"MessageConnector","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Connector", COLLABORATION_DIAGRAM );
//
//             // Component and Class diagram only Metatypes


//
//             // Sequence diagram only Metatypes





//
//             // State Diagram Metatypes








//            createMetaTypesEntry(node,"Transition","org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Transition", STATE_DIAGRAM );
//         }
      }
   }

   

/**
    * Create the Buttons Section.
    *
    * This maps a button to a specific initialization string.
    *
    * @param pParent[in] The parent DOM node for this section
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl#createButtonsSection(org.dom4j.Element)
    */
   protected void createButtonsSection(Element rootElement)
   {
      if(rootElement != null)
      {         
//         Element node = XMLManip.createElement(rootElement, getButtonSectionName());
//         if(node != null)
//         {
//            
//            ////////////////////////
//            // Pure Graphic buttons
//            ////////////////////////
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_RECTANGLE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ROUNDED_RECTANGLE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ELLIPSE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PENTAGON", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_HEXAGON1", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_HEXAGON2", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_OCTAGON", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_TRIANGLE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_TRIANGLE_DOWN", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_TRIANGLE_LEFT", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_TRIANGLE_RIGHT", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DIAMOND", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARALLELOGRAM", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_STAR", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CROSS", 

//
//             ////////////////////////
//             // Classifier buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CLASS", 

//                              SEQUENCE_DIAGRAM);
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CLASS", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_TEMPLATECLASS", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ACTOR",          

//                               SEQUENCE_DIAGRAM);
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ACTOR",          

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CLASS_BOUNDARYCONTROLLERORENTITY", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CLASS_BOUNDARY", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CLASS_CONTROL",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CLASS_ENTITY",   

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_INTERFACE",      

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_INTERFACE_AS_CLASS",      

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DATATYPE",       

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ALIASEDTYPE",       

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_UTILITYCLASS",   

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ENUMERATION",    

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_MESSAGE_SELF",       

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DESTROY_LIFELINE",       

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DERIVATIONCLASSIFIER",       

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DERIVATIONEDGE",       
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Derivation");
//   
//             // Nested Link
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_NESTEDLINK", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge NestedLink");
//   
//             // Comment Link
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMMENTLINK", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge CommentEdge");
//   
//             ////////////////////////
//             // Bridge buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ASSOCIATIONCLASS", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssociationClassInitialEdge");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ASSEMBLYCONNECTOR_INITIALEDGE", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssemblyConnectorInitialEdge");
//   
//             ////////////////////////
//             // Edge buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ASSOCIATION_NN_NN", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association NN NN");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_AGGREGATION_CO_NN", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation CO NN");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_AGGREGATION_AG_NN", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation AG NN");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ASSOCIATION_NN_NA", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association NN NA");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_AGGREGATION_CO_NA", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation CO NA");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_AGGREGATION_AG_NA", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation AG NA");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_GENERALIZATION", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Generalization");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_MESSAGE",       
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_MESSAGE_ASYNCHRONOUS",       
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message asynchronous");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_MESSAGE_CREATE",       
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message create");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_MESSAGE_CREATE",       
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message result");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DEPENDENCY", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Dependency");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_IMPLEMENTATION", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Implementation");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_REALIZATION", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Realization");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_USAGE", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Usage");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DELEGATE", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Delegate");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PERMISSION", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Permission");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ABSTRACTION", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Abstraction");
//   
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_BINARYASSOCIATION", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge BinaryAssociation");
//
//             ////////////////////////
//             // Comment buttons - this one is the same as the link
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMMENT", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge CommentEdge");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMMENTNODE", 

//   
//             ////////////////////////
//             // Combined Fragment buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMBINED_FRAGMENT", 

//   
//             ////////////////////////
//             // Package buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PACKAGE", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.Package");
//   
//             ////////////////////////
//             // Activity Diagram buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARAMETERUSAGENODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DATASTORENODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_SIGNALNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_INITIALNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ACTIVITYFINALNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_FLOWFINALNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DECISIONNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_MERGENODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_FORKNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_HORIZONTAL_FORKNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_JOINNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_INVOCATIONNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ACTIVITYEDGE", 
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge ActivityEdge");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_INTERRUPTIBLEACTIVITYREGIONNODE", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ITERATIONACTIVITYGROUP", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_STRUCTUREDACTIVITYGROUP", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMPLEXACTIVITYGROUP", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ACTIVITY", 

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARTITION",  

//         
//             ////////////////////////
//             // Component Diagram buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMPONENT",      

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMPONENTPORT",      

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PORTINTERFACE_INITIALEDGE",      
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge PortProvidedInterface");
//   
//             ////////////////////////
//             // Use Case Diagram buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_USECASE",        

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_INCLUDE",        
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Include");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_EXTEND",        
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Extend");
//   
//             ////////////////////////
//             // Deployment Diagram buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_NODE",           

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_ARTIFACT",       

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_DEPLOYMENTSPEC",       

//   
//             ////////////////////////
//             // State Diagram buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_CHOICE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_ENTRYPOINT",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_DEEPHISTORY",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_SHALLOWHISTORY",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_INITIAL",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_JUNCTION",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_JOIN",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PSEUDOSTATE_JOIN_HORIZONTAL",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_STATE_TRANSITION",  
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Transition");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COMPOSITE_STATE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_SIMPLE_STATE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_SUBMACHINE_STATE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_FINALSTATE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_FINALSTATE_ABORTED",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_STATEMACHINE",  

//             ////////////////////////
//             // Collaboration Diagram buttons
//             ////////////////////////
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COLLABORATIONLIFELINE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_COLLABORATION",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARTFACADE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARTFACADE_INTERFACE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARTFACADE_USECASE",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARTFACADE_ACTOR",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARTFACADE_CLASS",  

//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_PARTFACADELINK",  
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge PartFacade");
//            createButtonEntry(node,
//                              "ID_VIEWNODE_UML_CONNECTOR",
//                              "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Connector");
//         }
      }
      
   }

   

/**
    * Create the DiagramTables Section.
    *
    * This maps a diagram to an id so the diagram name isn't repeated all 
    * over the file.
    *
    * @param rootElement The parent DOM node for this table
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl#createInitStringsTableSection(org.dom4j.Element)
    */
   protected void createInitStringsTableSection(Element rootElement)
   {      
//      if(rootElement != null)
//      {         
//         Element node = XMLManip.createElement(rootElement, getInitStringsTableSectionName());
//         if(node != null)
//         {
//            int index = 1;
//            clearInitStringsTable();
//            
//            ///////////////////////////////
//            // Pure Presentation Elements
//            ///////////////////////////////
//            createInitStringsTableEntry( node, 

//                                         index++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//
//            // Nested Link
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge NestedLink",
//                                        index ++);
//
//            // Comment Link
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge CommentEdge",
//                                        index ++);
//
//            // Qualifiers
//            createInitStringsTableEntry(node,

//                                        index ++);
//
//            ///////////////////////////////
//            // Bridges
//            ///////////////////////////////
//
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssociationClassInitialEdge",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssemblyConnectorInitialEdge",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge",
//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//
//            ///////////////////////////////
//            // Comment Node View
//            ///////////////////////////////
//
//            createInitStringsTableEntry(node,

//                                        index ++);
//
//            ///////////////////////////////
//            // Classifier Node View
//            ///////////////////////////////
//
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,        

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node, 

//                                        index ++);
//            createInitStringsTableEntry(node, 

//                                        index ++);
//            createInitStringsTableEntry(node,   

//                                        index ++);
//            createInitStringsTableEntry(node,   

//                                        index ++);
//            createInitStringsTableEntry(node,     

//                                        index ++);
//            createInitStringsTableEntry(node,     

//                                        index ++);
//            createInitStringsTableEntry(node,   

//                                        index ++);
//            createInitStringsTableEntry(node,   

//                                        index ++);
//            createInitStringsTableEntry(node, 

//                                        index ++);
//            createInitStringsTableEntry(node, 

//                                        index ++);
//            createInitStringsTableEntry(node, 

//                                        index ++);
//            createInitStringsTableEntry(node, 
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Derivation",
//                                        index ++);
//         
//            ///////////////////////////////
//            // Class Diagram & Sequence DiagramRelation EdgeView
//            ///////////////////////////////
//
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge AssociationEnd",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association NN NN",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation CO NN",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation AG NN",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Association NN NA",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation CO NA",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Aggregation AG NA",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Generalization",
//                                        index ++);
//            createInitStringsTableEntry(node, 
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message",
//                                        index ++);
//            createInitStringsTableEntry(node, 
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message asynchronous",
//                                        index ++);
//            createInitStringsTableEntry(node, 
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message create",
//                                        index ++);
//            createInitStringsTableEntry(node, 
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Message result",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Dependency",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge BinaryAssociation",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Implementation",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Realization",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Usage",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Delegate",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Permission",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Abstraction",
//                                        index ++);
//
//            ///////////////////////////////
//            // Package Node View
//            ///////////////////////////////
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.Package",
//                                        index ++);
//
//            ///////////////////////////////
//            // Interaction Fragment Node Views
//            ///////////////////////////////
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//
//            ///////////////////////////////
//            // Label Label View
//            ///////////////////////////////
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.LabelView",
//                                        index ++);
//
//            ///////////////////////////////
//            // Activity Diagram Nodes & Edges
//            ///////////////////////////////
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge ActivityEdge",
//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            ///////////////////////////////
//            // Use Case Diagram Nodes & Edges
//            ///////////////////////////////
//            createInitStringsTableEntry(node,      

//                                        index ++);
//            createInitStringsTableEntry(node,      
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Include",
//                                        index ++);
//            createInitStringsTableEntry(node,      
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Extend",
//                                        index ++);
//            ////////////////////////
//            // Component Diagram Nodes & Edges
//            ////////////////////////
//            createInitStringsTableEntry(node,    

//                                        index ++);
//            createInitStringsTableEntry(node,    

//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge PortProvidedInterface",
//                                        index ++);
//
//            ///////////////////////////////
//            // Deployment Diagram Nodes & Edges
//            ///////////////////////////////
//            createInitStringsTableEntry(node,    

//                                        index ++);
//            createInitStringsTableEntry(node,     

//                                        index ++);
//            createInitStringsTableEntry(node,     

//                                        index ++);
//
//            ///////////////////////////////
//            // State Diagram Nodes & Edges
//            ///////////////////////////////
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Transition",
//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            ////////////////////////
//            // Collaboration Diagram Nodes & Edges
//            ////////////////////////
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,

//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge PartFacade",
//                                        index ++);
//            createInitStringsTableEntry(node,
//                                        "org.netbeans.modules.uml.ui.products.ad.viewfactory.RelationEdge Connector",
//                                        index ++);
//         }
//      }
   }

   

/**
    * Create the DiagramTables Section.
    *
    * This maps a diagram to an id so the diagram name isn't repeated all
    * over the file.
    *
    * @param rootElement The parent DOM node for this table
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl#createDiagramsTableSection(org.dom4j.Element)
    */
   protected void createDiagramsTableSection(Element rootElement)
   {
      if(rootElement != null)
      {
//         Element node = XMLManip.createElement(rootElement, getDiagramsTableSectionName());
//         if(node != null)
//         {
//            int index = 1;
//            clearDiagramTable();
//            createDiagramsTableEntry( node, "Diagram", IDiagramKind.DK_DIAGRAM);
//            createDiagramsTableEntry( node, ACTIVITY_DIAGRAM, IDiagramKind.DK_ACTIVITY_DIAGRAM);
//            createDiagramsTableEntry( node, CLASS_DIAGRAM, IDiagramKind.DK_CLASS_DIAGRAM);
//            createDiagramsTableEntry( node, COLLABORATION_DIAGRAM, IDiagramKind.DK_COLLABORATION_DIAGRAM);
//            createDiagramsTableEntry( node, COMPONENT_DIAGRAM, IDiagramKind.DK_COMPONENT_DIAGRAM);
//            createDiagramsTableEntry( node, DEPLOYMENT_DIAGRAM, IDiagramKind.DK_DEPLOYMENT_DIAGRAM);
//            createDiagramsTableEntry( node, SEQUENCE_DIAGRAM, IDiagramKind.DK_SEQUENCE_DIAGRAM);
//            createDiagramsTableEntry( node, STATE_DIAGRAM, IDiagramKind.DK_STATE_DIAGRAM);
//            createDiagramsTableEntry( node, USECASE_DIAGRAM, IDiagramKind.DK_USECASE_DIAGRAM);
//         }
      }
   }

   

/**
    * Returns the diagram id for the diagramKind.
    *
    * @param nDiagramKind The kind of diagram to convert to an index into the 
    *                     diagram table.  Must be one of the values defined
    *                     int IDiagramKind.
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.PresentationTypesMgrImpl#getDiagramID(int)
    * @see IDiagramKind
    */
   protected long getDiagramID(int nDiagramKind)
   {
      String xDiagramKind ="Diagram";
//
//      switch (nDiagramKind)
//      {
//         case IDiagramKind.DK_ACTIVITY_DIAGRAM : 
//            xDiagramKind = ACTIVITY_DIAGRAM;
//            break;
//         case IDiagramKind.DK_CLASS_DIAGRAM : 
//            xDiagramKind = CLASS_DIAGRAM;
//            break;
//         case IDiagramKind.DK_COLLABORATION_DIAGRAM : 
//            xDiagramKind = COLLABORATION_DIAGRAM;
//            break;
//         case IDiagramKind.DK_COMPONENT_DIAGRAM : 
//            xDiagramKind = COMPONENT_DIAGRAM;
//            break;
//         case IDiagramKind.DK_DEPLOYMENT_DIAGRAM : 
//            xDiagramKind = DEPLOYMENT_DIAGRAM;
//            break;
//         case IDiagramKind.DK_SEQUENCE_DIAGRAM : 
//            xDiagramKind = SEQUENCE_DIAGRAM;
//            break;
//         case IDiagramKind.DK_STATE_DIAGRAM : 
//            xDiagramKind = STATE_DIAGRAM;
//            break;
//         case IDiagramKind.DK_USECASE_DIAGRAM : 
//            xDiagramKind = USECASE_DIAGRAM;
//            break;
//      }
//      return super.getDiagramID(xDiagramKind);
      return 0;
   }
   
   

/* (non-Javadoc)
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.IPresentationTypesMgr#getDefaultConnectorView()
    */
   public String getDefaultConnectorView()
   {
      // TODO Auto-generated method stub
//      return super.getDefaultConnectorView();
       return "";
   }

   

/* (non-Javadoc)
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.IPresentationTypesMgr#getDefaultLabelView()
    */
   public String getDefaultLabelView()
   {
      // TODO Auto-generated method stub
//      return super.getDefaultLabelView();
       return "";
   }

   

/* (non-Javadoc)
    * @see org.netbeans.modules.uml.ui.support.applicationmanager.IPresentationTypesMgr#getPresentationElementMetaType(java.lang.String, java.lang.String)
    */
   public String getPresentationElementMetaType(String sElementType, 
                                                String sInitializationString)
   {
      String retVal = "";
      
      if(sElementType != null)
      {
//         retVal = super.getPresentationElementMetaType(sElementType, sInitializationString);
         
         if (sInitializationString != null && sInitializationString.endsWith("NestedLink"))
         {
            retVal = "NestedLinkPresentation";            
         }
         else if((sInitializationString != null && (sInitializationString.endsWith("PartFacade")) || 
                 (sInitializationString.endsWith("PartFacade Interface"))))
         {
            retVal = "PartFacadeEdgePresentation";            
         }
      }
      else
      {
		retVal = "";
      }
      
      return retVal;
   }

}
