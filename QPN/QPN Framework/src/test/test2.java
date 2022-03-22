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

public class test2 {
	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "QPN joined";
		pn.NetworkPort = 1080;

		DataArcMatrix constantValue1 = new DataArcMatrix();
		constantValue1.SetName("A123");
		constantValue1.SetValue(new ArcMatrix(2, 4, 3.0f, 5.0f, 6.0f, 8.0f, 7.0f, 2.0f, 1.0f, 4.0f));
		pn.ConstantPlaceList.add(constantValue1);

		DataComplexVector p1 = new DataComplexVector();
		p1.SetName("p1");
		p1.Value = new ComplexVector(2, new ComplexValue(1.0f, 3.0f), new ComplexValue(5.0f, 2.0f));
		pn.PlaceList.add(p1);

		DataComplexVector p2 = new DataComplexVector();
		p2.SetName("p2");
		p2.Value = new ComplexVector(2, new ComplexValue(2.0f, 3.0f), new ComplexValue(1.0f, 5.0f));
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
		grdT1.Activations.add(new Activation(t1, "p1", "p2", "A123", TransitionOperation.UnitaryMatrixJoin2by1, "p3"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 3000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}

}
