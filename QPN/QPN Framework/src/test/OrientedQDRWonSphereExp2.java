package test;

import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataComplexVector2D;
import DataObjects.DataDoubleDouble;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import DataOnly.ComplexVector2D;
import DataOnly.DoubleDouble;
import DataOnly.HalfParameters;
import DataOnly.Shift;
import DataOnly.Sign;
import Enumerations.LogicConnector;
import Enumerations.Orientation;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class OrientedQDRWonSphereExp2 {
	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Oriented QDRW on Sphere Exp2";
		pn.NetworkPort = 1080;

		DataComplexVector2D p0 = new DataComplexVector2D();
		p0.SetName("p0");
		p0.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p0);

		DataComplexVector2D p1 = new DataComplexVector2D();
		p1.SetName("p1");
		p1.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p1);

		DataComplexVector2D p2 = new DataComplexVector2D();
		p2.SetName("p2");
		p2.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p2);

		DataComplexVector2D p3 = new DataComplexVector2D();
		p3.SetName("p3");
		p3.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p3);

		DataComplexVector2D p00 = new DataComplexVector2D();
		p00.SetName("p00");
		pn.PlaceList.add(p00);

		DataComplexVector2D p01 = new DataComplexVector2D();
		p01.SetName("p01");
		pn.PlaceList.add(p01);

		DataComplexVector2D p02 = new DataComplexVector2D();
		p02.SetName("p02");
		pn.PlaceList.add(p02);

		DataComplexVector2D p03 = new DataComplexVector2D();
		p03.SetName("p03");
		pn.PlaceList.add(p03);

		DataComplexVector2D p10 = new DataComplexVector2D();
		p10.SetName("p10");
		pn.PlaceList.add(p10);

		DataComplexVector2D p11 = new DataComplexVector2D();
		p11.SetName("p11");
		pn.PlaceList.add(p11);

		DataComplexVector2D p12 = new DataComplexVector2D();
		p12.SetName("p12");
		pn.PlaceList.add(p12);

		DataComplexVector2D p13 = new DataComplexVector2D();
		p13.SetName("p13");
		pn.PlaceList.add(p13);

		DataComplexVector2D p20 = new DataComplexVector2D();
		p20.SetName("p20");
		pn.PlaceList.add(p20);

		DataComplexVector2D p21 = new DataComplexVector2D();
		p21.SetName("p21");
		pn.PlaceList.add(p21);

		DataComplexVector2D p22 = new DataComplexVector2D();
		p22.SetName("p22");
		pn.PlaceList.add(p22);

		DataComplexVector2D p23 = new DataComplexVector2D();
		p23.SetName("p23");
		pn.PlaceList.add(p23);

		DataComplexVector2D p30 = new DataComplexVector2D();
		p30.SetName("p30");
		pn.PlaceList.add(p30);

		DataComplexVector2D p31 = new DataComplexVector2D();
		p31.SetName("p31");
		pn.PlaceList.add(p31);

		DataComplexVector2D p32 = new DataComplexVector2D();
		p32.SetName("p32");
		pn.PlaceList.add(p32);

		DataComplexVector2D p33 = new DataComplexVector2D();
		p33.SetName("p33");
		pn.PlaceList.add(p33);

		DataDoubleDouble pv = new DataDoubleDouble();
		pv.SetName("pv");
		pv.Value = new DoubleDouble(0.0f, 0.0f);
		pn.PlaceList.add(pv);
		

		// T0 ------------------------------------------------
		PetriTransition t0 = new PetriTransition(pn);
		t0.TransitionName = "t0";
		t0.InputPlaceName.add("p0");

		Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
		ArrayList<String> t0Output = new ArrayList<String>();
		t0Output.add("p00");
		t0Output.add("p01");
		t0Output.add("p02");
		t0Output.add("p03");

		GuardMapping grdT0 = new GuardMapping();
		grdT0.condition = T0Ct1;
		grdT0.Activations.add(new Activation(t0, "p0", TransitionOperation.MultiplyByHalfMultiPlaces, t0Output,
				new HalfParameters(new Sign(-1, -1), new Sign(1, 1), new Sign(1, 1), new Sign(1, 1), 0)));

		t0.GuardMappingList.add(grdT0);

		pn.Transitions.add(t0);

		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		ArrayList<String> t1Output = new ArrayList<String>();
		t1Output.add("p10");
		t1Output.add("p11");
		t1Output.add("p12");
		t1Output.add("p13");

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.MultiplyByHalfMultiPlaces, t1Output,
				new HalfParameters(new Sign(1, 1), new Sign(-1, -1), new Sign(1, 1), new Sign(1, 1), 1)));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2");

		Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);
		ArrayList<String> t2Output = new ArrayList<String>();
		t2Output.add("p20");
		t2Output.add("p21");
		t2Output.add("p22");
		t2Output.add("p23");

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t2, "p2", TransitionOperation.MultiplyByHalfMultiPlaces, t2Output,
				new HalfParameters(new Sign(1, 1), new Sign(1, 1), new Sign(-1, -1), new Sign(1, 1), 2)));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// T3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p3");

		Condition T3Ct1 = new Condition(t3, "p3", TransitionCondition.NotNull);
		ArrayList<String> t3Output = new ArrayList<String>();
		t3Output.add("p30");
		t3Output.add("p31");
		t3Output.add("p32");
		t3Output.add("p33");

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t3, "p3", TransitionOperation.MultiplyByHalfMultiPlaces, t3Output,
				new HalfParameters(new Sign(1, 1), new Sign(1, 1), new Sign(1, 1), new Sign(-1, -1), 3)));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// T0P ------------------------------------------------
		PetriTransition T0P = new PetriTransition(pn);
		T0P.TransitionName = "T0P";
		T0P.InputPlaceName.add("p00");
		T0P.InputPlaceName.add("p10");
		T0P.InputPlaceName.add("p20");
		T0P.InputPlaceName.add("p30");
		
		Condition T0PCt1 = new Condition(T0P, "p00", TransitionCondition.NotNull);
		Condition T0PCt2 = new Condition(T0P, "p10", TransitionCondition.NotNull);
		Condition T0PCt3 = new Condition(T0P, "p20", TransitionCondition.NotNull);
		Condition T0PCt4 = new Condition(T0P, "p30", TransitionCondition.NotNull);
		T0PCt3.SetNextCondition(LogicConnector.AND, T0PCt4);
		T0PCt2.SetNextCondition(LogicConnector.AND, T0PCt3);
		T0PCt1.SetNextCondition(LogicConnector.AND, T0PCt2);

		GuardMapping grdT0P = new GuardMapping();
		grdT0P.condition = T0PCt1;

		ArrayList<String> T0PInput = new ArrayList<String>();
		T0PInput.add("p00");
		T0PInput.add("p10");
		T0PInput.add("p20");
		T0PInput.add("p30");

		grdT0P.Activations.add(new Activation(T0P, T0PInput, TransitionOperation.ComplexVector2DAdditionMultiPlaces,
				"p0", new HalfParameters(0, new Shift(+1, +1))));

		T0P.GuardMappingList.add(grdT0P);

		pn.Transitions.add(T0P);

		// T1P ------------------------------------------------
		PetriTransition T1P = new PetriTransition(pn);
		T1P.TransitionName = "T1P";
		T1P.InputPlaceName.add("p01");
		T1P.InputPlaceName.add("p11");
		T1P.InputPlaceName.add("p21");
		T1P.InputPlaceName.add("p31");
		
		Condition T1PCt1 = new Condition(T1P, "p01", TransitionCondition.NotNull);
		Condition T1PCt2 = new Condition(T1P, "p11", TransitionCondition.NotNull);
		Condition T1PCt3 = new Condition(T1P, "p21", TransitionCondition.NotNull);
		Condition T1PCt4 = new Condition(T1P, "p31", TransitionCondition.NotNull);
		T1PCt3.SetNextCondition(LogicConnector.AND, T1PCt4);
		T1PCt2.SetNextCondition(LogicConnector.AND, T1PCt3);
		T1PCt1.SetNextCondition(LogicConnector.AND, T1PCt2);

		ArrayList<String> T1PInput = new ArrayList<String>();
		T1PInput.add("p01");
		T1PInput.add("p11");
		T1PInput.add("p21");
		T1PInput.add("p31");

		GuardMapping grdT1P = new GuardMapping();
		grdT1P.condition = T1PCt1;
		grdT1P.Activations.add(new Activation(T1P, T1PInput, TransitionOperation.ComplexVector2DAdditionMultiPlaces,
				"p1", new HalfParameters(1, new Shift(-1, +1))));

		T1P.GuardMappingList.add(grdT1P);

		pn.Transitions.add(T1P);

		// T2P ------------------------------------------------
		PetriTransition T2P = new PetriTransition(pn);
		T2P.TransitionName = "T2P";
		T2P.InputPlaceName.add("p02");
		T2P.InputPlaceName.add("p12");
		T2P.InputPlaceName.add("p22");
		T2P.InputPlaceName.add("p32");
		
		Condition T2PCt1 = new Condition(T2P, "p02", TransitionCondition.NotNull);
		Condition T2PCt2 = new Condition(T2P, "p12", TransitionCondition.NotNull);
		Condition T2PCt3 = new Condition(T2P, "p22", TransitionCondition.NotNull);
		Condition T2PCt4 = new Condition(T2P, "p32", TransitionCondition.NotNull);
		T2PCt3.SetNextCondition(LogicConnector.AND, T2PCt4);
		T2PCt2.SetNextCondition(LogicConnector.AND, T2PCt3);
		T2PCt1.SetNextCondition(LogicConnector.AND, T2PCt2);

		ArrayList<String> T2PInput = new ArrayList<String>();
		T2PInput.add("p02");
		T2PInput.add("p12");
		T2PInput.add("p22");
		T2PInput.add("p32");

		GuardMapping grdT2P = new GuardMapping();
		grdT2P.condition = T2PCt1;
		grdT2P.Activations.add(new Activation(T2P, T2PInput, TransitionOperation.ComplexVector2DAdditionMultiPlaces,
				"p2", new HalfParameters(2, new Shift(+1, -1))));

		T2P.GuardMappingList.add(grdT2P);

		pn.Transitions.add(T2P);

		// T3P ------------------------------------------------
		PetriTransition T3P = new PetriTransition(pn);
		T3P.TransitionName = "T3P";
		T3P.InputPlaceName.add("p03");
		T3P.InputPlaceName.add("p13");
		T3P.InputPlaceName.add("p23");
		T3P.InputPlaceName.add("p33");
		
		Condition T3PCt1 = new Condition(T3P, "p03", TransitionCondition.NotNull);
		Condition T3PCt2 = new Condition(T3P, "p13", TransitionCondition.NotNull);
		Condition T3PCt3 = new Condition(T3P, "p23", TransitionCondition.NotNull);
		Condition T3PCt4 = new Condition(T3P, "p33", TransitionCondition.NotNull);
		T3PCt3.SetNextCondition(LogicConnector.AND, T3PCt4);
		T3PCt2.SetNextCondition(LogicConnector.AND, T3PCt3);
		T3PCt1.SetNextCondition(LogicConnector.AND, T3PCt2);

		ArrayList<String> T3PInput = new ArrayList<String>();
		T3PInput.add("p03");
		T3PInput.add("p13");
		T3PInput.add("p23");
		T3PInput.add("p33");

		GuardMapping grdT3P = new GuardMapping();
		grdT3P.condition = T3PCt1;
		grdT3P.Activations.add(new Activation(T3P, T3PInput, TransitionOperation.ComplexVector2DAdditionMultiPlaces,
				"p3", new HalfParameters(3, new Shift(-1, -1))));

		T3P.GuardMappingList.add(grdT3P);

		pn.Transitions.add(T3P);

		// TV ------------------------------------------------
		PetriTransition TV = new PetriTransition(pn);
		TV.TransitionName = "TV";
		TV.InputPlaceName.add("p0");
		TV.InputPlaceName.add("p1");
		TV.InputPlaceName.add("p2");
		TV.InputPlaceName.add("p3");
		
		TV.IsReversible = true;
		

		Condition TVCt1 = new Condition(TV, "p0", TransitionCondition.NotNull);
		Condition TVCt2 = new Condition(TV, "p1", TransitionCondition.NotNull);
		Condition TVCt3 = new Condition(TV, "p2", TransitionCondition.NotNull);
		Condition TVCt4 = new Condition(TV, "p3", TransitionCondition.NotNull);
		
		GuardMapping grdTV = new GuardMapping();
		grdTV.condition = TVCt1;
		grdTV.Activations.add(new Activation(TV, TransitionOperation.SphereVerification, "pv"));

		TV.GuardMappingList.add(grdTV);

		pn.Transitions.add(TV);


		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 0; //petri delay 

		pn.clearPrint = true;
		pn.PrintingImaginaryNumbers = false;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}
}
