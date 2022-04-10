package test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataArcMatrix;
import DataObjects.DataBoolean;
import DataObjects.DataComplexVector;
import DataObjects.DataDoubleDouble;
import DataOnly.ArcMatrix;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import DataOnly.UnitaryParameters;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

//QPN of oriented QDRW on a circle with M+ and M-
public class OrientationWalker {
	
	public static void main(String[] args) {
	PetriNet pn = new PetriNet();
	pn.PetriNetName = "Walker";
	pn.NetworkPort = 1080;
	
	
	DataBoolean constantValueTrue = new DataBoolean();
	constantValueTrue.SetName("constantValueTrue");
	constantValueTrue.SetValue(true);
	pn.ConstantPlaceList.add(constantValueTrue);
	
	DataArcMatrix constantValueMPlus = new DataArcMatrix();
	constantValueMPlus.SetName("MPlus");
	constantValueMPlus.SetValue(new ArcMatrix(8, 8,
			0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 
			1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f));
	pn.ConstantPlaceList.add(constantValueMPlus);
			
	DataArcMatrix constantValueMMinus = new DataArcMatrix();
	constantValueMMinus.SetName("MMinus");
	constantValueMMinus.SetValue(new ArcMatrix(8, 8,
			0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 
			0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 
			1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
	pn.ConstantPlaceList.add(constantValueMMinus);
	
	DataBoolean p1 = new DataBoolean();
	p1.SetName("p1");
	p1.Value = true;
	pn.PlaceList.add(p1);

	DataComplexVector p2 = new DataComplexVector();
	p2.SetName("p2");
	p2.Value = new ComplexVector(8, 1,
			new ComplexValue(1.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f));
	pn.PlaceList.add(p2);

	DataComplexVector p3 = new DataComplexVector();
	p3.SetName("p3");
	pn.PlaceList.add(p3);
	
	
	DataComplexVector p4 = new DataComplexVector();
	p4.SetName("p4");
	pn.PlaceList.add(p4);
	
	DataComplexVector p5 = new DataComplexVector();
	p5.SetName("p5");
	pn.PlaceList.add(p5);
	
	DataComplexVector p6 = new DataComplexVector();
	p6.SetName("p6");
	p6.Value = new ComplexVector(8, 1,
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f));
	pn.PlaceList.add(p6);
	
	DataComplexVector p7 = new DataComplexVector();
	p7.SetName("p7");
	p7.Value = new ComplexVector(8, 0,
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f),
			new ComplexValue(0.0f, 0.0f));
	pn.PlaceList.add(p7);
	
	// T1 ------------------------------------------------
	PetriTransition t1 = new PetriTransition(pn);
	t1.TransitionName = "t1";
	t1.InputPlaceName.add("p1");
	t1.InputPlaceName.add("p2");

	Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.Equal, "constantValueTrue");
	Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.NotNull);
	T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);
	
	GuardMapping grdT1 = new GuardMapping();
	grdT1.condition = T1Ct1;
	grdT1.Activations.add(new Activation(t1, "p2", "MPlus", TransitionOperation.UnitaryMatrixWithOrientation, "p3", new UnitaryParameters(+1, 0)));
	grdT1.Activations.add(new Activation(t1, "p2", "MMinus", TransitionOperation.UnitaryMatrixWithOrientation, "p4", new UnitaryParameters(+1, 1)));

	t1.GuardMappingList.add(grdT1);

	pn.Transitions.add(t1);

	// T2 ------------------------------------------------
	PetriTransition t2 = new PetriTransition(pn);
	t2.TransitionName = "t2";
	t2.InputPlaceName.add("p1");
	t2.InputPlaceName.add("p5");
	
	Condition T2Ct1 = new Condition(t2, "p1", TransitionCondition.Equal, "constantValueTrue");
	Condition T2Ct2 = new Condition(t2, "p5", TransitionCondition.NotNull);
	T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);
	
	GuardMapping grdT2 = new GuardMapping();
	grdT2.condition = T2Ct1;
	
	grdT2.Activations.add(new Activation(t2, "p5", "MPlus", TransitionOperation.UnitaryMatrixWithOrientation, "p7", new UnitaryParameters(+1, 0)));
	grdT2.Activations.add(new Activation(t2, "p5", "MMinus", TransitionOperation.UnitaryMatrixWithOrientation, "p6", new UnitaryParameters(-1, 1)));

	
	t2.GuardMappingList.add(grdT2);

	pn.Transitions.add(t2);

	// T3 ------------------------------------------------
	PetriTransition t3 = new PetriTransition(pn);
	t3.TransitionName = "t3";
	t3.InputPlaceName.add("p3");
	t3.InputPlaceName.add("p7");
	
	Condition T3Ct1 = new Condition(t3, "p3", TransitionCondition.NotNull);
	Condition T3Ct2 = new Condition(t3, "p7", TransitionCondition.NotNull);
	T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);
	
	GuardMapping grdT3 = new GuardMapping();
	grdT3.condition = T3Ct1;
	grdT3.Activations.add(new Activation(t3, "p3", "p7","", TransitionOperation.ComplexVectorAddition, "p2"));
	grdT3.Activations.add(new Activation(t3, "constantValueTrue", TransitionOperation.Move, "p1"));

	t3.GuardMappingList.add(grdT3);

	pn.Transitions.add(t3);
	
	// T4 ------------------------------------------------
	PetriTransition t4 = new PetriTransition(pn);
	t4.TransitionName = "t4";
	t4.InputPlaceName.add("p4");
	t4.InputPlaceName.add("p6");
	
	Condition T4Ct1 = new Condition(t4, "p4", TransitionCondition.NotNull);
	Condition T4Ct2 = new Condition(t4, "p6", TransitionCondition.NotNull);
	T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);
	
	
	GuardMapping grdT4 = new GuardMapping();
	grdT4.condition = T4Ct1;
	grdT4.Activations.add(new Activation(t4, "p4", "p6","", TransitionOperation.ComplexVectorAddition, "p5"));
	grdT4.Activations.add(new Activation(t4, "constantValueTrue", TransitionOperation.Move, "p1"));

	
	t4.GuardMappingList.add(grdT4);

	pn.Transitions.add(t4);
	

	System.out.println("Exp1 started \n ------------------------------");
	pn.Delay = 3000;

	
	pn.clearPrint=true;
	PetriNetWindow frame = new PetriNetWindow(false);
	frame.petriNet = pn;
	frame.setVisible(true);
}
	}
