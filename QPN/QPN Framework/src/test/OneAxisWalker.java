package test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataArcMatrix;
import DataObjects.DataComplexVector;
import DataObjects.DataDoubleDouble;
import DataOnly.ArcMatrix;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

//QPN of un-oriented QDRW on a circle
public class OneAxisWalker {
	
	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "One Axis Random Walker";
		pn.NetworkPort = 1080;
		
		float DivSqurt2 = (float) ((float) 1.0f/Math.sqrt(2));

		DataArcMatrix constantValue1 = new DataArcMatrix();
		constantValue1.SetName("H");
		constantValue1.SetValue(new ArcMatrix(2, 2,
				DivSqurt2, DivSqurt2, 
				DivSqurt2, -DivSqurt2));
		pn.ConstantPlaceList.add(constantValue1);

		
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
		
		DataComplexVector p1 = new DataComplexVector();
		p1.SetName("p1");
		p1.Value = new ComplexVector(2, 
				new ComplexValue(1.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f));
		pn.PlaceList.add(p1);

		DataComplexVector p2 = new DataComplexVector();
		p2.SetName("p2");
		p2.Value = new ComplexVector(8, 
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
		
			
		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");
		t1.InputPlaceName.add("p2");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t1, "p1", "H", TransitionOperation.UnitaryMatrix, "p1"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);
		
		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2");
				
		Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);
				
		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t2, "p2", TransitionOperation.Move, "p3"));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);		

		// T3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p1");
		t3.InputPlaceName.add("p3");
		
		Condition T3Ct1 = new Condition(t3, "p1", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t3, "p3", TransitionCondition.NotNull);
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);
		
		GuardMapping grdT3= new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t3, "p1", "p3", "MPlus", "MMinus", TransitionOperation.MoveOneAxis, "p2"));
		grdT3.Activations.add(new Activation(t3, "p1",TransitionOperation.Move, "p1"));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		
		

//		System.out.println("Exp1 started \n ------------------------------");
//		pn.Delay = 3000;
//
//		PetriNetWindow frame = new PetriNetWindow(false);
//		frame.petriNet = pn;
//		frame.setVisible(true);
		
		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 3000; //petri delay, for fast execution make it 0

		pn.clearPrint = true;
		pn.PrintingImaginaryNumbers = false;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}

}

