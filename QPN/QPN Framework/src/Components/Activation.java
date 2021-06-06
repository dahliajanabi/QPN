package Components;

import java.io.Serializable;
import java.util.ArrayList;

import DataObjects.DataArcMatrix;
import DataObjects.DataComplexVector;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import DataObjects.DataTransfer;
import DataObjects.DataSubPetriNet;
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
	public ArrayList<String> InputPlaceNames;
	public String OutputPlaceName;
	public ArrayList<String> OutputPlaceNames;
	public TransitionOperation Operation;
	public Functions util;
	public String ConstantValueName;

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
		this.ConstantValueName = ConstantValueName;
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

		if (Operation == TransitionOperation.UnitaryMatrix)
			UnitaryMatrix();

		if (Operation == TransitionOperation.SendOverNetwork)
			SendOverNetwork();

		if (Operation == TransitionOperation.SendPetriNetOverNetwork)
			SendPetriNetOverNetwork();

		if (Operation == TransitionOperation.ActivateSubPetri)
			ActivateSubPetri();

		if (Operation == TransitionOperation.StopPetriNet)
			Parent.Parent.Stop();

		if (Operation == TransitionOperation.MakeNull)
			MakeNull();
	}

	private void UnitaryMatrix() throws CloneNotSupportedException {

		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataComplexVector)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataArcMatrix)) {
			return;
		}
		DataArcMatrix A = (DataArcMatrix) constantValue;
		DataComplexVector result = (DataComplexVector) ((DataComplexVector) input).clone();
		ComplexVector resC = (ComplexVector) result.GetValue();
		ComplexVector resD = new ComplexVector(resC.Size,resC.ComplexArray);
		
		for (int i = 0; i < A.Value.Matrix[0].length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);
		
			for (int j = 0; j < A.Value.Matrix[1].length; j++) {
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

		if (temp instanceof DataSubPetriNet) {
			result.SetValue((PetriObject) ((DataSubPetriNet) temp).clone());
		}

	}

	private void SendPetriNetOverNetwork() throws CloneNotSupportedException {

		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);

		PetriObject result = null;

		if (output instanceof DataTransfer) {
			result = (PetriObject) ((DataTransfer) output).clone();
		}

		if (inputIndex == -1)
			return;

		PetriObject temp = Parent.TempMarking.get(inputIndex);

		if (temp instanceof DataSubPetriNet) {
			PetriObject ob = ((DataSubPetriNet) temp).clone();
			DataSubPetriNet sub = (DataSubPetriNet) ob;
			result.SetValue((PetriObject) util.PetriNetToPetriData(sub.Value.Petri));
		}
	}

	private void ActivateSubPetri() throws CloneNotSupportedException {
		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.Parent.PlaceList);
		if (temp == null)
			return;

		if (temp instanceof DataSubPetriNet) {
			((DataSubPetriNet) temp).Value.StartSubPetri();
		}
	}

}
