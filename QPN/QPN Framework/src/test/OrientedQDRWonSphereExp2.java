package test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataBoolean;
import DataObjects.DataComplexVector;
import DataObjects.DataComplexVector2D;
import DataObjects.DataComplexVector2DMatrix;
import DataObjects.DataDoubleDouble;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import DataOnly.ComplexVector2D;
import DataOnly.ComplexVector2DMatrix;
import DataOnly.DoubleDouble;
import DataOnly.HalfParameters;
import DataOnly.Shift;
import DataOnly.Sign;
import DataOnly.UnitaryParameters;
import Enumerations.LogicConnector;
import Enumerations.Orientation;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class OrientedQDRWonSphereExp2 {
	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Oriented QDRW on Sphere";
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
		p00.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p00);
		
		DataComplexVector2D p01 = new DataComplexVector2D();
		p01.SetName("p01");
		p01.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p01);
		
		DataComplexVector2D p02 = new DataComplexVector2D();
		p02.SetName("p02");
		p02.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p02);
		
		DataComplexVector2D p03 = new DataComplexVector2D();
		p03.SetName("p03");
		p03.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p03);
		
		DataComplexVector2D p10 = new DataComplexVector2D();
		p10.SetName("p10");
		p10.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p10);
		
		DataComplexVector2D p11 = new DataComplexVector2D();
		p11.SetName("p11");
		p11.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p11);
		
		DataComplexVector2D p12 = new DataComplexVector2D();
		p12.SetName("p12");
		p12.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p12);
		
		DataComplexVector2D p13 = new DataComplexVector2D();
		p13.SetName("p13");
		p13.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p13);
		
		DataComplexVector2D p20 = new DataComplexVector2D();
		p20.SetName("p20");
		p20.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p20);
		
		DataComplexVector2D p21 = new DataComplexVector2D();
		p21.SetName("p21");
		p21.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p21);
		
		DataComplexVector2D p22 = new DataComplexVector2D();
		p22.SetName("p22");
		p22.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p22);
		
		DataComplexVector2D p23 = new DataComplexVector2D();
		p23.SetName("p23");
		p23.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p23);
		
		DataComplexVector2D p30 = new DataComplexVector2D();
		p30.SetName("p30");
		p30.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p30);
		
		DataComplexVector2D p31 = new DataComplexVector2D();
		p31.SetName("p31");
		p31.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p31);
		
		DataComplexVector2D p32 = new DataComplexVector2D();
		p32.SetName("p32");
		p32.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		pn.PlaceList.add(p32);
		
		DataComplexVector2D p33 = new DataComplexVector2D();
		p33.SetName("p33");
		p33.Value = new ComplexVector2D(Orientation.Right,
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
				new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
						new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
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

		GuardMapping grdT0 = new GuardMapping();
		grdT0.condition = T0Ct1;
		grdT0.Activations.add(new Activation(t0, "p0", TransitionOperation.MultiplyByHalf, "p4",
				new HalfParameters(new Sign(-1, 1), new Sign(1, 1), new Sign(1, 1), new Sign(1, 1), 0)));

		t0.GuardMappingList.add(grdT0);

		pn.Transitions.add(t0);

		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.MultiplyByHalf, "p4",
				new HalfParameters(new Sign(1, 1), new Sign(1, -1), new Sign(1, 1), new Sign(1, 1), 1)));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2");

		Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t2, "p2", TransitionOperation.MultiplyByHalf, "p4",
				new HalfParameters(new Sign(1, 1), new Sign(1, 1), new Sign(-1, 1), new Sign(1, 1), 2)));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// T3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p3");

		Condition T3Ct1 = new Condition(t3, "p3", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t3, "p3", TransitionOperation.MultiplyByHalf, "p4",
				new HalfParameters(new Sign(1, 1), new Sign(1, 1), new Sign(1, 1), new Sign(1, -1), 3)));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// T0P ------------------------------------------------
		PetriTransition T0P = new PetriTransition(pn);
		T0P.TransitionName = "T0P";
		T0P.InputPlaceName.add("p4");
		T0P.IsReversible = true;

		Condition T0PCt1 = new Condition(T0P, "p4", TransitionCondition.NotNull);

		GuardMapping grdT0P = new GuardMapping();
		grdT0P.condition = T0PCt1;
		grdT0P.Activations.add(new Activation(T0P, "p4", TransitionOperation.ComplexVector2DMatrixAddition, "p0",
				new HalfParameters(0, new Shift(+1, 0))));

		T0P.GuardMappingList.add(grdT0P);

		pn.Transitions.add(T0P);

		// T1P ------------------------------------------------
		PetriTransition T1P = new PetriTransition(pn);
		T1P.TransitionName = "T1P";
		T1P.InputPlaceName.add("p4");
		T1P.IsReversible = true;

		Condition T1PCt1 = new Condition(T1P, "p4", TransitionCondition.NotNull);

		GuardMapping grdT1P = new GuardMapping();
		grdT1P.condition = T1PCt1;
		grdT1P.Activations.add(new Activation(T1P, "p4", TransitionOperation.ComplexVector2DMatrixAddition, "p1",
				new HalfParameters(1, new Shift(-1, 0))));

		T1P.GuardMappingList.add(grdT1P);

		pn.Transitions.add(T1P);

		// T2P ------------------------------------------------
		PetriTransition T2P = new PetriTransition(pn);
		T2P.TransitionName = "T2P";
		T2P.InputPlaceName.add("p4");
		T2P.IsReversible = true;

		Condition T2PCt1 = new Condition(T2P, "p4", TransitionCondition.NotNull);

		GuardMapping grdT2P = new GuardMapping();
		grdT2P.condition = T2PCt1;
		grdT2P.Activations.add(new Activation(T2P, "p4", TransitionOperation.ComplexVector2DMatrixAddition, "p2",
				new HalfParameters(2, new Shift(0, +1))));

		T2P.GuardMappingList.add(grdT2P);

		pn.Transitions.add(T2P);

		// T3P ------------------------------------------------
		PetriTransition T3P = new PetriTransition(pn);
		T3P.TransitionName = "T3P";
		T3P.InputPlaceName.add("p4");
		T3P.IsReversible = true;

		Condition T3PCt1 = new Condition(T3P, "p4", TransitionCondition.NotNull);

		GuardMapping grdT3P = new GuardMapping();
		grdT3P.condition = T3PCt1;
		grdT3P.Activations.add(new Activation(T3P, "p4", TransitionOperation.ComplexVector2DMatrixAddition, "p3",
				new HalfParameters(3, new Shift(0, -1))));

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

		TVCt3.SetNextCondition(LogicConnector.AND, TVCt4);
		TVCt2.SetNextCondition(LogicConnector.AND, TVCt3);
		TVCt1.SetNextCondition(LogicConnector.AND, TVCt2);

		GuardMapping grdTV = new GuardMapping();
		grdTV.condition = TVCt1;
		grdTV.Activations.add(new Activation(TV, TransitionOperation.SphereVerification, "pv"));

		TV.GuardMappingList.add(grdTV);

		pn.Transitions.add(TV);

		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 3000;

		pn.clearPrint = true;
		pn.PrintingImaginaryNumbers = false;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}
}
