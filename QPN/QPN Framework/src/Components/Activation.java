package Components;

import java.io.Serializable;
import java.util.ArrayList;

import DataObjects.DataArcMatrix;
import DataObjects.DataComplexVector;
import DataObjects.DataDoubleDouble;
import DataOnly.ArcMatrix;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import DataOnly.DoubleDouble;
import DataObjects.DataTransfer;
import Enumerations.TransitionOperation;
import Interfaces.PetriObject;
import Utilities.Functions;

public class Activation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetriTransition Parent;

	public String InputPlaceName;

	public String InputPlaceName1;
	public String InputPlaceName2;
	public ArrayList<String> InputPlaceNames;
	public String OutputPlaceName;
	public ArrayList<String> OutputPlaceNames;
	public TransitionOperation Operation;
	public Functions util;
	public String ConstantValueName1;
	public String ConstantValueName2;

	public Activation(PetriTransition Parent) {
		util = new Functions();
	}

	public Activation(PetriTransition Parent, String InputPlaceName, String ConstantValueName,
			TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.ConstantValueName1 = ConstantValueName;
	}

	public Activation(PetriTransition Parent, String InputPlaceName1, String InputPlaceName2, String ConstantValueName,
			TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName1 = InputPlaceName1;
		this.InputPlaceName2 = InputPlaceName2;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.ConstantValueName1 = ConstantValueName;
	}

	public Activation(PetriTransition Parent, String InputPlaceName1, String InputPlaceName2, String ConstantValueName1,
			String ConstantValueName2, TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName1 = InputPlaceName1;
		this.InputPlaceName2 = InputPlaceName2;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.ConstantValueName1 = ConstantValueName1;
		this.ConstantValueName2 = ConstantValueName2;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, ArrayList<String> InputPlaceNames, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceNames = InputPlaceNames;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			ArrayList<String> OutputPlaceNames) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceNames = OutputPlaceNames;
		this.Operation = Condition;
	}

	public void Activate() throws CloneNotSupportedException {

		if (Operation == TransitionOperation.Move)
			Move();

		if (Operation == TransitionOperation.UnitaryMatrix)
			UnitaryMatrix();

		if (Operation == TransitionOperation.UnitaryMatrixJoin2by1)
			UnitaryMatrixJoin2by1();

		if (Operation == TransitionOperation.SendOverNetwork)
			SendOverNetwork();

		if (Operation == TransitionOperation.StopPetriNet)
			Parent.Parent.Stop();

		if (Operation == TransitionOperation.MakeNull)
			MakeNull();

		if (Operation == TransitionOperation.MoveX)
			MoveX();

		if (Operation == TransitionOperation.MoveY)
			MoveY();

		if (Operation == TransitionOperation.NormalizationFormula)
			NormalizationFormula();

	}

	private void Move() throws CloneNotSupportedException {

		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (temp == null) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		}
		PetriObject result = null;

		if (temp instanceof DataArcMatrix) {
			result = (PetriObject) ((DataArcMatrix) temp).clone();
		}

		if (temp instanceof DataComplexVector) {
			result = (PetriObject) ((DataComplexVector) temp).clone();
		}

		if (temp instanceof DataDoubleDouble) {
			result = (PetriObject) ((DataDoubleDouble) temp).clone();
		}

		if (result == null) {
			return;
		}

		if (OutputPlaceName.contains("-")) {
			result.SetName(OutputPlaceName.split("-")[1]);
		} else {
			result.SetName(OutputPlaceName);
		}

		result.SetValue(temp.GetValue());

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void MoveX() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataComplexVector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataComplexVector)) {
			return;
		}

		PetriObject constantValue1 = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue1 == null && !(constantValue1 instanceof DataArcMatrix)) {
			return;
		}

		PetriObject constantValue2 = util.GetFromListByName(ConstantValueName2, Parent.Parent.ConstantPlaceList);
		if (constantValue2 == null && !(constantValue2 instanceof DataArcMatrix)) {
			return;
		}

		DataComplexVector coin = (DataComplexVector) ((DataComplexVector) input1).clone();
		ComplexVector coinC = (ComplexVector) coin.GetValue();

		ComplexValue coinv1 = coinC.ComplexArray.get(0);
		DataArcMatrix MP = (DataArcMatrix) constantValue1;
		ArcMatrix ResultMP = new ArcMatrix(MP.Value.Matrix.length, MP.Value.Matrix[0].length);
		for (int i = 0; i < MP.Value.Matrix.length; i++) {
			for (int j = 0; j < MP.Value.Matrix[0].length; j++) {
				ResultMP.Matrix[i][j] = MP.Value.Matrix[i][j] * coinv1.Real;
			}
		}

		// ComplexValue coinv2 = coinC.ComplexArray.get(1);
		ComplexValue coinv2 = coinC.ComplexArray.get(2);
		DataArcMatrix MM = (DataArcMatrix) constantValue2;
		ArcMatrix ResultMM = new ArcMatrix(MM.Value.Matrix.length, MM.Value.Matrix[0].length);
		for (int i = 0; i < MM.Value.Matrix.length; i++) {
			for (int j = 0; j < MM.Value.Matrix[0].length; j++) {
				ResultMM.Matrix[i][j] = MM.Value.Matrix[i][j] * coinv2.Real;
			}
		}

		for (int i = 0; i < MP.Value.Matrix.length; i++) {
			for (int j = 0; j < MP.Value.Matrix[0].length; j++) {
				ResultMP.Matrix[i][j] = MP.Value.Matrix[i][j] + MM.Value.Matrix[i][j];
				ResultMP.Matrix[i][j] = ResultMP.Matrix[i][j] * 0.5f;
			}
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input2).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();
		ComplexVector resD = new ComplexVector(resC.Size, resC.ComplexArray);

		for (int i = 0; i < MP.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < MP.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = MP.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = MP.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void MoveY() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataComplexVector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataComplexVector)) {
			return;
		}

		PetriObject constantValue1 = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue1 == null && !(constantValue1 instanceof DataArcMatrix)) {
			return;
		}

		PetriObject constantValue2 = util.GetFromListByName(ConstantValueName2, Parent.Parent.ConstantPlaceList);
		if (constantValue2 == null && !(constantValue2 instanceof DataArcMatrix)) {
			return;
		}

		DataComplexVector coin = (DataComplexVector) ((DataComplexVector) input1).clone();
		ComplexVector coinC = (ComplexVector) coin.GetValue();

		// ComplexValue coinv1 = coinC.ComplexArray.get(2);
		ComplexValue coinv1 = coinC.ComplexArray.get(1);
		DataArcMatrix MP = (DataArcMatrix) constantValue1;
		ArcMatrix ResultMP = new ArcMatrix(MP.Value.Matrix.length, MP.Value.Matrix[0].length);

		for (int i = 0; i < MP.Value.Matrix.length; i++) {
			for (int j = 0; j < MP.Value.Matrix[0].length; j++) {
				ResultMP.Matrix[i][j] = MP.Value.Matrix[i][j] * coinv1.Real;
			}
		}

		ComplexValue coinv2 = coinC.ComplexArray.get(3);
		DataArcMatrix MM = (DataArcMatrix) constantValue2;
		ArcMatrix ResultMM = new ArcMatrix(MM.Value.Matrix.length, MM.Value.Matrix[0].length);
		for (int i = 0; i < MM.Value.Matrix.length; i++) {
			for (int j = 0; j < MM.Value.Matrix[0].length; j++) {
				ResultMM.Matrix[i][j] = MM.Value.Matrix[i][j] * coinv2.Real;
			}
		}

		for (int i = 0; i < MP.Value.Matrix.length; i++) {
			for (int j = 0; j < MP.Value.Matrix[0].length; j++) {
				ResultMP.Matrix[i][j] = MP.Value.Matrix[i][j] + MM.Value.Matrix[i][j];
				ResultMP.Matrix[i][j] = ResultMP.Matrix[i][j] * 0.5f;
			}
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input2).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();
		ComplexVector resD = new ComplexVector(resC.Size, resC.ComplexArray);

		for (int i = 0; i < MP.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < MP.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = MP.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = MP.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void UnitaryMatrix() throws CloneNotSupportedException {

		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataComplexVector)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataArcMatrix)) {
			return;
		}
		DataArcMatrix A = (DataArcMatrix) constantValue;
		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();
		ComplexVector resD = new ComplexVector(resC.Size, resC.ComplexArray);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void UnitaryMatrixJoin2by1() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataComplexVector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataComplexVector)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataArcMatrix)) {
			return;
		}

		DataArcMatrix A = (DataArcMatrix) constantValue;
		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input1).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();
		resC.ComplexArray.addAll(((DataComplexVector) input2).Value.ComplexArray);
		ComplexVector resD = new ComplexVector(resC.Size * 2, resC.ComplexArray);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void MakeNull() throws CloneNotSupportedException {
		PetriObject temp = util.GetFromListByName(OutputPlaceName, Parent.Parent.PlaceList);
		if (temp == null) {
			util.SetNullToListByName(OutputPlaceName, Parent.Parent.ConstantPlaceList);
		} else {
			util.SetNullToListByName(OutputPlaceName, Parent.Parent.PlaceList);
		}
	}

	private void SendOverNetwork() throws CloneNotSupportedException {
		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);

		PetriObject temp;
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);
		if (inputIndex == -1) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		} else {
			temp = Parent.TempMarking.get(inputIndex);
		}

		if (temp == null) {
			return;
		}
		PetriObject result = null;
		if (output instanceof DataTransfer) {
			result = (PetriObject) ((DataTransfer) output).clone();
		}

		if (temp instanceof DataComplexVector) {
			result.SetValue((PetriObject) ((DataComplexVector) temp).clone());
		}
	}

	private void NormalizationFormula() throws CloneNotSupportedException {
		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		PetriObject result = null;
		if (temp == null) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		}

		DataComplexVector coin = (DataComplexVector) ((DataComplexVector) temp).clone();
		ComplexVector coinC = (ComplexVector) coin.GetValue();

		ComplexValue coinv0 = coinC.ComplexArray.get(0);
		ComplexValue coinv2 = coinC.ComplexArray.get(2);

		double v1 = Math.pow(Math.pow((double) coinv0.Real, 2.0) + (Math.pow((double) coinv2.Real, 2.0)), 0.5);
		double v2 = Math.pow((Math.pow((double) coinv0.Real, 2.0) + (Math.pow((double) coinv2.Real, 2.0))), 0.5);
		DoubleDouble dd = new DoubleDouble(((double) coinv0.Real) / v1, ((double) coinv2.Real) / v2);
		
		result = new DataDoubleDouble();

		result.SetValue(dd);
		result.SetName(OutputPlaceName);
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}
}
