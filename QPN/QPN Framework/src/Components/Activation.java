package Components;

import java.io.Serializable;
import java.util.ArrayList;

import DataObjects.DataArcMatrix;
import DataObjects.DataBoolean;
import DataObjects.DataComplexVector;
import DataObjects.DataComplexVector2D;
import DataObjects.DataComplexVector2DMatrix;
import DataObjects.DataDoubleDouble;
import DataOnly.ArcMatrix;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import DataOnly.ComplexVector2D;
import DataOnly.DoubleDouble;
import DataOnly.HalfParameters;
import DataOnly.UnitaryParameters;
import DataObjects.DataTransfer;
import Enumerations.Orientation;
import Enumerations.TransitionOperation;
import Interfaces.PetriObject;
import Utilities.Functions;
import java.lang.Math;

public class Activation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetriTransition Parent;
	float Ro = (float) (1 / Math.sqrt(2));

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
	public UnitaryParameters uParam;
	public HalfParameters hParam;

	public Activation(PetriTransition Parent) {
		util = new Functions();
	}

	public Activation(PetriTransition Parent, TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
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

	public Activation(PetriTransition Parent, String InputPlaceName, String ConstantValueName,
			TransitionOperation Condition, String OutputPlaceName, UnitaryParameters uParam) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.ConstantValueName1 = ConstantValueName;
		this.uParam = uParam;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			String OutputPlaceName, UnitaryParameters uParam) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.uParam = uParam;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			ArrayList<String> OutputPlaceNames, HalfParameters hParam) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceNames = OutputPlaceNames;
		this.Operation = Condition;
		this.hParam = hParam;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			String OutputPlaceName, HalfParameters hParam) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.hParam = hParam;
	}

	public Activation(PetriTransition Parent, ArrayList<String> InputPlaceNames, TransitionOperation Condition,
			String OutputPlaceName, HalfParameters hParam) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceNames = InputPlaceNames;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.hParam = hParam;
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
			UnitaryMatrix(0);

		if (Operation == TransitionOperation.UnitaryMatrixWithOrientation)
			UnitaryMatrixWithOrientation();

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

		if (Operation == TransitionOperation.MoveOneAxis)
			MoveOneAxis();

		if (Operation == TransitionOperation.NormalizationFormula)
			NormalizationFormula();

		if (Operation == TransitionOperation.ComplexVectorAddition)
			ComplexVectorAddition();

		if (Operation == TransitionOperation.ShiftPlus)
			ShiftPlus();

		if (Operation == TransitionOperation.ShiftMinus)
			ShiftMinus();

		if (Operation == TransitionOperation.MultiplyByRo)
			MultiplyByRo();

		if (Operation == TransitionOperation.ComplexVectorAdditionWithShiftPlus)
			ComplexVectorAdditionWithShiftPlus();

		if (Operation == TransitionOperation.ComplexVectorAdditionWithShiftMinus)
			ComplexVectorAdditionWithShiftMinus();

		if (Operation == TransitionOperation.MultiplyByHalf)
			MultiplyByHalf();

		if (Operation == TransitionOperation.MultiplyByHalfMultiPlaces)
			MultiplyByHalfMultiPlaces();

		if (Operation == TransitionOperation.ComplexVector2DMatrixAddition)
			ComplexVector2DMatrixAddition();

		if (Operation == TransitionOperation.ComplexVector2DAdditionMultiPlaces)
			ComplexVector2DAdditionMultiPlaces();

		if (Operation == TransitionOperation.SphereVerification)
			SphereVerification();
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

		if (temp instanceof DataBoolean) {
			result = (PetriObject) ((DataBoolean) temp).clone();
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

		for (int i = 0; i < ResultMP.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < ResultMP.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = ResultMP.Matrix[i][j] * cv1.Real;
				Float imaginary = ResultMP.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);

		float sum = util.GetProbabilitySum(resD);

		if (sum == 1) {
			result.SetValue(resD);
		}
		if (sum > 1) {
			result.SetValue(new ComplexVector(8, new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		}

		if (sum < 1) {
			result.SetValue(new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f)));
		}

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

		for (int i = 0; i < ResultMP.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < ResultMP.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = ResultMP.Matrix[i][j] * cv1.Real;
				Float imaginary = ResultMP.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);

		float sum = util.GetProbabilitySum(resD);

		if (sum == 1) {
			result.SetValue(resD);
		}
		if (sum > 1) {
			result.SetValue(new ComplexVector(8, new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		}

		if (sum < 1) {
			result.SetValue(new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f)));
		}

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void MoveOneAxis() throws CloneNotSupportedException {

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

		ComplexValue coinv2 = coinC.ComplexArray.get(1);
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

		for (int i = 0; i < ResultMP.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < ResultMP.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = ResultMP.Matrix[i][j] * cv1.Real;
				Float imaginary = ResultMP.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);

		float sum = util.GetProbabilitySum(resD);

		if (sum == 1) {
			result.SetValue(resD);
		}
		if (sum > 1) {
			result.SetValue(new ComplexVector(8, new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f)));
		}

		if (sum < 1) {
			result.SetValue(new ComplexVector(8, new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f),
					new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f)));
		}

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);

	}

	private void UnitaryMatrix(int orientation) throws CloneNotSupportedException {

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
		resD.Orientation = orientation;
		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void UnitaryMatrixWithOrientation() throws CloneNotSupportedException {

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
			sum.Real *= Ro * uParam.Sign;
			sum.Imaginary *= Ro * uParam.Sign;

			resD.ComplexArray.set(i, sum);
		}
		resD.Orientation = uParam.Orientation;
		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void ComplexVectorAddition() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataComplexVector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataComplexVector)) {
			return;
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input1).clone();

		for (int i = 0; i < result.Value.ComplexArray.size(); i++) {

			ComplexValue cv = new ComplexValue(
					result.Value.ComplexArray.get(i).Real + ((DataComplexVector) input2).Value.ComplexArray.get(i).Real,
					result.Value.ComplexArray.get(i).Imaginary
							+ ((DataComplexVector) input2).Value.ComplexArray.get(i).Imaginary);
			result.Value.ComplexArray.set(i, cv);
		}

		result.SetName(OutputPlaceName);
		result.SetValue(result);

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

	private void ShiftPlus() throws CloneNotSupportedException {
		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataComplexVector)) {
			return;
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();

		util.ShiftRight(result);

//		for (int i = 0; i < resC.ComplexArray.size(); i++) {
//			ComplexValue cv1 = resC.ComplexArray.get(i);
//			cv1.Real *= Ro * uParam.Sign;
//			cv1.Imaginary *= Ro * uParam.Sign;
//		}

		resC.Orientation = uParam.Orientation;
		result.SetName(OutputPlaceName);
		result.SetValue(resC);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);

	}

	private void ShiftMinus() throws CloneNotSupportedException {
		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataComplexVector)) {
			return;
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();

		util.ShiftLeft(result);

//		for (int i = 0; i < resC.ComplexArray.size(); i++) {
//			ComplexValue cv1 = resC.ComplexArray.get(i);
//			cv1.Real *= Ro * uParam.Sign;
//			cv1.Imaginary *= Ro * uParam.Sign;
//		}

		resC.Orientation = uParam.Orientation;
		result.SetName(OutputPlaceName);
		result.SetValue(resC);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void MultiplyByRo() throws CloneNotSupportedException {
		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataComplexVector)) {
			return;
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();
		ComplexVector resD = new ComplexVector(resC.Size, resC.ComplexArray);

		for (int i = 0; i < resC.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArray.get(i);

			ComplexValue vl = new ComplexValue(cv1.Real * Ro * uParam.Sign, cv1.Imaginary * Ro * uParam.Sign);
			resD.ComplexArray.set(i, vl);
		}

		resD.Orientation = uParam.Orientation;
		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);

	}

	private void MultiplyByHalf() throws CloneNotSupportedException {
		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataComplexVector2D)) {
			return;
		}

		PetriObject outPutMatrixObj = util.GetFromListByName(OutputPlaceName, Parent.Parent.PlaceList);
		if (outPutMatrixObj == null && !(outPutMatrixObj instanceof DataComplexVector2DMatrix)) {
			return;
		}

		DataComplexVector2DMatrix outPutMatrix = (DataComplexVector2DMatrix) outPutMatrixObj;

		DataComplexVector2D result = (DataComplexVector2D) ((DataComplexVector2D) input).clone();
		ComplexVector2D resC = (ComplexVector2D) result.GetValue();

		ComplexVector2D resD1 = new ComplexVector2D(resC.Orientation, resC.ComplexArrayX, resC.ComplexArrayY);
		ComplexVector2D resD2 = new ComplexVector2D(resC.Orientation, resC.ComplexArrayX, resC.ComplexArrayY);
		ComplexVector2D resD3 = new ComplexVector2D(resC.Orientation, resC.ComplexArrayX, resC.ComplexArrayY);
		ComplexVector2D resD4 = new ComplexVector2D(resC.Orientation, resC.ComplexArrayX, resC.ComplexArrayY);

		// --------------------------resD1------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign1.X, cv1.Imaginary * 0.5F * hParam.Sign1.X);
			resD1.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign1.Y, cv1.Imaginary * 0.5F * hParam.Sign1.Y);
			resD1.ComplexArrayY.ComplexArray.set(i, vl);
		}
		outPutMatrix.Value.Matrix.get(hParam.MatrixIndex).set(0, resD1);

		// --------------------------resD2------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign2.X, cv1.Imaginary * 0.5F * hParam.Sign2.X);
			resD2.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign2.Y, cv1.Imaginary * 0.5F * hParam.Sign2.Y);
			resD2.ComplexArrayY.ComplexArray.set(i, vl);
		}
		outPutMatrix.Value.Matrix.get(hParam.MatrixIndex).set(1, resD2);

		// --------------------------resD3------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign3.X, cv1.Imaginary * 0.5F * hParam.Sign3.X);
			resD3.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign3.Y, cv1.Imaginary * 0.5F * hParam.Sign3.Y);
			resD3.ComplexArrayY.ComplexArray.set(i, vl);
		}
		outPutMatrix.Value.Matrix.get(hParam.MatrixIndex).set(2, resD3);

		// --------------------------resD4------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign4.X, cv1.Imaginary * 0.5F * hParam.Sign4.X);
			resD4.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign4.Y, cv1.Imaginary * 0.5F * hParam.Sign4.Y);
			resD4.ComplexArrayY.ComplexArray.set(i, vl);
		}
		outPutMatrix.Value.Matrix.get(hParam.MatrixIndex).set(3, resD4);
	}

	private void MultiplyByHalfMultiPlaces() throws CloneNotSupportedException {
		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataComplexVector2D)) {
			return;
		}

		DataComplexVector2D result = (DataComplexVector2D) ((DataComplexVector2D) input).clone();
		ComplexVector2D resC = (ComplexVector2D) result.GetValue();

		ArrayList<ComplexValue> arrX1 = new ArrayList<ComplexValue>();
		ArrayList<ComplexValue> arrX2 = new ArrayList<ComplexValue>();
		ArrayList<ComplexValue> arrX3 = new ArrayList<ComplexValue>();
		ArrayList<ComplexValue> arrX4 = new ArrayList<ComplexValue>();

		ArrayList<ComplexValue> arrY1 = new ArrayList<ComplexValue>();
		ArrayList<ComplexValue> arrY2 = new ArrayList<ComplexValue>();
		ArrayList<ComplexValue> arrY3 = new ArrayList<ComplexValue>();
		ArrayList<ComplexValue> arrY4 = new ArrayList<ComplexValue>();

		for (int i = 0; i < resC.ComplexArrayX.Size; i++) {
			arrX1.add(new ComplexValue(0.0f, 0.0f));
			arrX2.add(new ComplexValue(0.0f, 0.0f));
			arrX3.add(new ComplexValue(0.0f, 0.0f));
			arrX4.add(new ComplexValue(0.0f, 0.0f));
			arrY1.add(new ComplexValue(0.0f, 0.0f));
			arrY2.add(new ComplexValue(0.0f, 0.0f));
			arrY3.add(new ComplexValue(0.0f, 0.0f));
			arrY4.add(new ComplexValue(0.0f, 0.0f));
		}

		ComplexVector2D resD1 = new ComplexVector2D(resC.Orientation, new ComplexVector(resC.ComplexArrayX.Size, arrX1),
				new ComplexVector(resC.ComplexArrayY.Size, arrY1));
		ComplexVector2D resD2 = new ComplexVector2D(resC.Orientation, new ComplexVector(resC.ComplexArrayX.Size, arrX2),
				new ComplexVector(resC.ComplexArrayY.Size, arrY2));
		ComplexVector2D resD3 = new ComplexVector2D(resC.Orientation, new ComplexVector(resC.ComplexArrayX.Size, arrX3),
				new ComplexVector(resC.ComplexArrayY.Size, arrY3));
		ComplexVector2D resD4 = new ComplexVector2D(resC.Orientation, new ComplexVector(resC.ComplexArrayX.Size, arrX4),
				new ComplexVector(resC.ComplexArrayY.Size, arrY4));

		// --------------------------resD1------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign1.X, cv1.Imaginary * 0.5F * hParam.Sign1.X);
			resD1.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign1.Y, cv1.Imaginary * 0.5F * hParam.Sign1.Y);
			resD1.ComplexArrayY.ComplexArray.set(i, vl);
		}

		PetriObject out0obj = util.GetFromListByName(OutputPlaceNames.get(0), Parent.Parent.PlaceList);
		if (out0obj == null && !(out0obj instanceof DataComplexVector2D)) {
			return;
		}
		DataComplexVector2D out0 = (DataComplexVector2D) out0obj;
		out0.SetValue(resD1);
		util.SetToListByName(OutputPlaceNames.get(0), Parent.Parent.PlaceList, out0);
		// --------------------------resD2------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign2.X, cv1.Imaginary * 0.5F * hParam.Sign2.X);
			resD2.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign2.Y, cv1.Imaginary * 0.5F * hParam.Sign2.Y);
			resD2.ComplexArrayY.ComplexArray.set(i, vl);
		}

		PetriObject out1obj = util.GetFromListByName(OutputPlaceNames.get(1), Parent.Parent.PlaceList);
		if (out1obj == null && !(out1obj instanceof DataComplexVector2D)) {
			return;
		}
		DataComplexVector2D out1 = (DataComplexVector2D) out1obj;
		out1.SetValue(resD2);
		util.SetToListByName(OutputPlaceNames.get(1), Parent.Parent.PlaceList, out1);
		// --------------------------resD3------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign3.X, cv1.Imaginary * 0.5F * hParam.Sign3.X);
			resD3.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign3.Y, cv1.Imaginary * 0.5F * hParam.Sign3.Y);
			resD3.ComplexArrayY.ComplexArray.set(i, vl);
		}

		PetriObject out2obj = util.GetFromListByName(OutputPlaceNames.get(2), Parent.Parent.PlaceList);
		if (out2obj == null && !(out2obj instanceof DataComplexVector2D)) {
			return;
		}
		DataComplexVector2D out2 = (DataComplexVector2D) out2obj;
		out2.SetValue(resD3);
		util.SetToListByName(OutputPlaceNames.get(2), Parent.Parent.PlaceList, out2);
		// --------------------------resD4------------------------------
		for (int i = 0; i < resC.ComplexArrayX.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayX.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign4.X, cv1.Imaginary * 0.5F * hParam.Sign4.X);
			resD4.ComplexArrayX.ComplexArray.set(i, vl);
		}
		for (int i = 0; i < resC.ComplexArrayY.ComplexArray.size(); i++) {
			ComplexValue cv1 = resC.ComplexArrayY.ComplexArray.get(i);
			ComplexValue vl = new ComplexValue(cv1.Real * 0.5F * hParam.Sign4.Y, cv1.Imaginary * 0.5F * hParam.Sign4.Y);
			resD4.ComplexArrayY.ComplexArray.set(i, vl);
		}

		PetriObject out3obj = util.GetFromListByName(OutputPlaceNames.get(3), Parent.Parent.PlaceList);
		if (out3obj == null && !(out3obj instanceof DataComplexVector2D)) {
			return;
		}
		DataComplexVector2D out3 = (DataComplexVector2D) out3obj;
		out3.SetValue(resD4);
		util.SetToListByName(OutputPlaceNames.get(3), Parent.Parent.PlaceList, out3);
	}

	private void ComplexVectorAdditionWithShiftPlus() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataComplexVector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataComplexVector)) {
			return;
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input1).clone();

		for (int i = 0; i < result.Value.ComplexArray.size(); i++) {

			ComplexValue cv = new ComplexValue(
					result.Value.ComplexArray.get(i).Real + ((DataComplexVector) input2).Value.ComplexArray.get(i).Real,
					result.Value.ComplexArray.get(i).Imaginary
							+ ((DataComplexVector) input2).Value.ComplexArray.get(i).Imaginary);
			result.Value.ComplexArray.set(i, cv);
		}

		util.ShiftRight(result);
		result.SetName(OutputPlaceName);
		result.SetValue(result);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void ComplexVectorAdditionWithShiftMinus() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataComplexVector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataComplexVector)) {
			return;
		}

		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input1).clone();

		for (int i = 0; i < result.Value.ComplexArray.size(); i++) {

			ComplexValue cv = new ComplexValue(
					result.Value.ComplexArray.get(i).Real + ((DataComplexVector) input2).Value.ComplexArray.get(i).Real,
					result.Value.ComplexArray.get(i).Imaginary
							+ ((DataComplexVector) input2).Value.ComplexArray.get(i).Imaginary);
			result.Value.ComplexArray.set(i, cv);
		}

		util.ShiftLeft(result);

		result.SetName(OutputPlaceName);
		result.SetValue(result);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void ComplexVector2DAdditionMultiPlaces() throws CloneNotSupportedException {

//		PetriObject outputObj = util.GetFromListByName(OutputPlaceName, Parent.Parent.PlaceList);
//		if (outputObj == null && !(outputObj instanceof DataComplexVector2D)) {
//			return;
//		}

//		DataComplexVector2D output = (DataComplexVector2D) outputObj;

		DataComplexVector2D input0 = (DataComplexVector2D) util.GetFromListByName(InputPlaceNames.get(0),
				Parent.TempMarking);
		DataComplexVector2D input1 = (DataComplexVector2D) util.GetFromListByName(InputPlaceNames.get(1),
				Parent.TempMarking);
		DataComplexVector2D input2 = (DataComplexVector2D) util.GetFromListByName(InputPlaceNames.get(2),
				Parent.TempMarking);
		DataComplexVector2D input3 = (DataComplexVector2D) util.GetFromListByName(InputPlaceNames.get(3),
				Parent.TempMarking);

		ComplexVector2D resultComplexVector = input0.Value.clone();

		for (int i = 0; i < resultComplexVector.ComplexArrayX.Size; i++) {
			ComplexValue cv = new ComplexValue(
					input0.Value.ComplexArrayX.ComplexArray.get(i).Real
							+ input1.Value.ComplexArrayX.ComplexArray.get(i).Real
							+ input2.Value.ComplexArrayX.ComplexArray.get(i).Real
							+ input3.Value.ComplexArrayX.ComplexArray.get(i).Real,
					input0.Value.ComplexArrayX.ComplexArray.get(i).Imaginary
							+ input1.Value.ComplexArrayX.ComplexArray.get(i).Imaginary
							+ input2.Value.ComplexArrayX.ComplexArray.get(i).Imaginary
							+ input3.Value.ComplexArrayX.ComplexArray.get(i).Imaginary);
			resultComplexVector.ComplexArrayX.ComplexArray.set(i, cv);
		}

		for (int i = 0; i < resultComplexVector.ComplexArrayY.Size; i++) {
			ComplexValue cv = new ComplexValue(
					input0.Value.ComplexArrayY.ComplexArray.get(i).Real
							+ input1.Value.ComplexArrayY.ComplexArray.get(i).Real
							+ input2.Value.ComplexArrayY.ComplexArray.get(i).Real
							+ input3.Value.ComplexArrayY.ComplexArray.get(i).Real,
					input0.Value.ComplexArrayY.ComplexArray.get(i).Imaginary
							+ input1.Value.ComplexArrayY.ComplexArray.get(i).Imaginary
							+ input2.Value.ComplexArrayY.ComplexArray.get(i).Imaginary
							+ input3.Value.ComplexArrayY.ComplexArray.get(i).Imaginary);
			resultComplexVector.ComplexArrayY.ComplexArray.set(i, cv);
		}

		if (hParam.Shift.X > 0) {
			util.ShiftRight(resultComplexVector.ComplexArrayX);
			resultComplexVector.Orientation = Orientation.Right;
		}
		if (hParam.Shift.X < 0) {
			util.ShiftLeft(resultComplexVector.ComplexArrayX);
			resultComplexVector.Orientation = Orientation.Left;
		}
		if (hParam.Shift.Y > 0) {
			util.ShiftRight(resultComplexVector.ComplexArrayY);
			resultComplexVector.Orientation = Orientation.Up;
		}
		if (hParam.Shift.Y < 0) {
			util.ShiftLeft(resultComplexVector.ComplexArrayY);
			resultComplexVector.Orientation = Orientation.Down;
		}

		DataComplexVector2D result = new DataComplexVector2D();
		result.SetName(OutputPlaceName);
		result.SetValue(resultComplexVector);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void ComplexVector2DMatrixAddition() throws CloneNotSupportedException {

		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.Parent.PlaceList);
		if (input == null && !(input instanceof DataComplexVector2DMatrix)) {
			return;
		}

		DataComplexVector2DMatrix matrix = (DataComplexVector2DMatrix) input;

		ComplexVector2D resultComplexVector = matrix.Value.Matrix.get(hParam.MatrixIndex).get(0).clone();

		for (int i = 0; i < resultComplexVector.ComplexArrayX.Size; i++) {
			ComplexValue cv = new ComplexValue(
					matrix.Value.Matrix.get(0).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray.get(i).Real
							+ matrix.Value.Matrix.get(1).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray.get(i).Real
							+ matrix.Value.Matrix.get(2).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray.get(i).Real
							+ matrix.Value.Matrix.get(3).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray.get(i).Real,
					matrix.Value.Matrix.get(0).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray.get(i).Imaginary
							+ matrix.Value.Matrix.get(1).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray
									.get(i).Imaginary
							+ matrix.Value.Matrix.get(2).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray
									.get(i).Imaginary
							+ matrix.Value.Matrix.get(3).get(hParam.MatrixIndex).ComplexArrayX.ComplexArray
									.get(i).Imaginary);
			resultComplexVector.ComplexArrayX.ComplexArray.set(i, cv);
		}

		for (int i = 0; i < resultComplexVector.ComplexArrayY.Size; i++) {
			ComplexValue cv = new ComplexValue(
					matrix.Value.Matrix.get(0).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray.get(i).Real
							+ matrix.Value.Matrix.get(1).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray.get(i).Real
							+ matrix.Value.Matrix.get(2).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray.get(i).Real
							+ matrix.Value.Matrix.get(3).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray.get(i).Real,
					matrix.Value.Matrix.get(0).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray.get(i).Imaginary
							+ matrix.Value.Matrix.get(1).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray
									.get(i).Imaginary
							+ matrix.Value.Matrix.get(2).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray
									.get(i).Imaginary
							+ matrix.Value.Matrix.get(3).get(hParam.MatrixIndex).ComplexArrayY.ComplexArray
									.get(i).Imaginary);
			resultComplexVector.ComplexArrayY.ComplexArray.set(i, cv);
		}

		if (hParam.Shift.X > 0) {
			util.ShiftRight(resultComplexVector.ComplexArrayX);
			resultComplexVector.Orientation = Orientation.Right;
		}
		if (hParam.Shift.X < 0) {
			util.ShiftLeft(resultComplexVector.ComplexArrayX);
			resultComplexVector.Orientation = Orientation.Left;
		}
		if (hParam.Shift.Y > 0) {
			util.ShiftRight(resultComplexVector.ComplexArrayY);
			resultComplexVector.Orientation = Orientation.Up;
		}
		if (hParam.Shift.Y < 0) {
			util.ShiftLeft(resultComplexVector.ComplexArrayY);
			resultComplexVector.Orientation = Orientation.Down;
		}

		DataComplexVector2D result = new DataComplexVector2D();
		result.SetName(OutputPlaceName);
		result.SetValue(resultComplexVector);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void SphereVerification() throws CloneNotSupportedException {
		DoubleDouble resultValue = new DoubleDouble(0.0f, 0.0f);

		for (int i = 0; i < Parent.TempMarking.size(); i++) {
			DoubleDouble currentSum = new DoubleDouble(0.0f, 0.0f);

			DataComplexVector2D current = (DataComplexVector2D) Parent.TempMarking.get(i);
			for (ComplexValue cv : current.Value.ComplexArrayX.ComplexArray) {
				//currentSum.V1 += cv.Real;
				currentSum.V1 += Math.pow(cv.Real, 2); //added
			}
			for (ComplexValue cv : current.Value.ComplexArrayY.ComplexArray) {
				//currentSum.V2 += cv.Real;
				currentSum.V2 += Math.pow(cv.Real, 2); //added
			}

//			currentSum.V1 = Math.pow(currentSum.V1, 2);
//			currentSum.V2 = Math.pow(currentSum.V2, 2);

			resultValue.V1 += currentSum.V1;
			resultValue.V2 += currentSum.V2;
		}

		DataDoubleDouble result = new DataDoubleDouble();
		result.SetName(OutputPlaceName);
		result.SetValue(resultValue);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

}
