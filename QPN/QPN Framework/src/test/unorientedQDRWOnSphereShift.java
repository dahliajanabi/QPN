package test;
import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataArcMatrix;
import DataObjects.DataComplexVector;
import DataOnly.ArcMatrix;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

//un-oriented QDRW on a sphere with shifts
public class unorientedQDRWOnSphereShift {

	public static void main (String [] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Walker";
		pn.NetworkPort = 1080;
		float Ro = (float) (1 / Math.sqrt(2));

		DataArcMatrix constantValue1 = new DataArcMatrix();
		constantValue1.SetName("G");
		constantValue1.SetValue(new ArcMatrix(4, 4,
				Ro, Ro, 0.0f, 0.0f, 
				Ro, -Ro, 0.0f, 0.0f,
				0.0f, 0.0f, Ro, Ro,
				0.0f, 0.0f, Ro, -Ro));
		pn.ConstantPlaceList.add(constantValue1);
		
		DataComplexVector p1 = new DataComplexVector();
		p1.SetName("p1");
		p1.Value = new ComplexVector(4, 
				new ComplexValue(1.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f),
				new ComplexValue(1.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f));
		pn.PlaceList.add(p1);

		DataComplexVector p2 = new DataComplexVector();
		p2.SetName("p2");
		p2.Value = new ComplexVector(8, 
				new ComplexValue(1.0f, 1.0f),
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
		p4.Value = new ComplexVector(8, 
				new ComplexValue(1.0f, 1.0f),
				new ComplexValue(0.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f),
				new ComplexValue(0.0f, 0.0f));
		pn.PlaceList.add(p4);
		
			
		DataComplexVector p5 = new DataComplexVector();
		p5.SetName("p5");
		pn.PlaceList.add(p5);
	
			
		
		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");
		t1.InputPlaceName.add("p2");
		t1.InputPlaceName.add("p4");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.NotNull);
		Condition T1Ct3 = new Condition(t1, "p4", TransitionCondition.NotNull);
		T1Ct2.SetNextCondition(LogicConnector.AND, T1Ct3);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t1, "p1", "G", TransitionOperation.UnitaryMatrix, "p1"));

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
		t3.InputPlaceName.add("p3");
		t3.InputPlaceName.add("p1");
		
		Condition T3Ct1 = new Condition(t3, "p1", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t3, "p3", TransitionCondition.NotNull);
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);
		
		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t3, "p1", "p3","", TransitionOperation.ShiftXMultiplyByCoin, "p2"));
		grdT3.Activations.add(new Activation(t3, "p1", TransitionOperation.Move, "p1"));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);
		
	// T4 ------------------------------------------------
			PetriTransition t4 = new PetriTransition(pn);
			t4.TransitionName = "t4";
			t4.InputPlaceName.add("p4");
			
			Condition T4Ct1 = new Condition(t4, "p4", TransitionCondition.NotNull);
			
			GuardMapping grdT4 = new GuardMapping();
			grdT4.condition = T4Ct1;
			grdT4.Activations.add(new Activation(t4, "p4", TransitionOperation.Move, "p5"));

			t4.GuardMappingList.add(grdT4);

			pn.Transitions.add(t4);

		// T5 ------------------------------------------------
		PetriTransition t5 = new PetriTransition(pn);
		t5.TransitionName = "t5";
		t5.InputPlaceName.add("p1");
		t5.InputPlaceName.add("p5");
		
		Condition T5Ct1 = new Condition(t5, "p1", TransitionCondition.NotNull);
		Condition T5Ct2 = new Condition(t5, "p5", TransitionCondition.NotNull);
		T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);
		
		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition = T5Ct1;
		grdT5.Activations.add(new Activation(t5, "p1", "p5","", TransitionOperation.ShiftYMultiplyByCoin, "p4"));
		grdT5.Activations.add(new Activation(t5, "p1", TransitionOperation.Move, "p1"));

		t5.GuardMappingList.add(grdT5);

		pn.Transitions.add(t5);
		
		
		
		


		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 3000;

		pn.clearPrint = true;
		pn.PrintingImaginaryNumbers = false;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}

}
