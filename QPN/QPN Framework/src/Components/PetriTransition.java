package Components;

import java.io.Serializable;
import java.util.ArrayList;

import DataObjects.DataBoolean;
import DataObjects.DataComplexVector;
import DataObjects.DataComplexVector2D;
import DataObjects.DataComplexVector2DMatrix;
import DataObjects.DataDoubleDouble;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
import Utilities.Functions;

public class PetriTransition implements PetriObject, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void Execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.PetriTransition;
	}

	@Override
	public Object GetValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SetValue(Object value) {
		// TODO Auto-generated method stub
	}

	public Functions util;

	public PetriTransition(PetriNet Parent) {
		util = new Functions();
		this.Parent = Parent;
		TempMarking = new ArrayList<PetriObject>();
		InputPlaceName = new ArrayList<String>();

		GuardMappingList = new ArrayList<GuardMapping>();
		Delay = 1;
	}

	public String TransitionName = "";

	@Override
	public String GetName() {
		return TransitionName;
	}

	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SetName(String name) {
		this.TransitionName = name;
	}

	public PetriNet Parent;

	// public String TransitionName;

	public int Delay = 0;
	public int InitialDelay = 0;
	public boolean IsReversible = false;

	public ArrayList<PetriObject> TempMarking;

	public ArrayList<String> InputPlaceName;

	public ArrayList<GuardMapping> GuardMappingList;

	private GuardMapping CurrentGuard;

	public void Activate() throws CloneNotSupportedException {
		CurrentGuard.Activate();
		TempMarking.clear();
	}

	public boolean CheckConditions() {
		for (GuardMapping guardMapping : GuardMappingList) {
			if (guardMapping.condition.CheckCondition()) {
				CurrentGuard = guardMapping;
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> BookTokens() throws CloneNotSupportedException {
		TempMarking.clear();
		ArrayList<String> placesToNull = new ArrayList<String>();
		for (String string : InputPlaceName) {
			PetriObject currentInputPlace = util.GetPetriObjectByName(string, Parent.PlaceList);
			PetriObject result = null;

			if (currentInputPlace instanceof DataComplexVector) {
				DataComplexVector currentDataComplexVector = (DataComplexVector) ((DataComplexVector) currentInputPlace)
						.clone();
				result = new DataComplexVector();
				result.SetName(currentDataComplexVector.GetName());
				ComplexVector cv = new ComplexVector(
						currentDataComplexVector.Value.Size,
						currentDataComplexVector.Value.Orientation,
						currentDataComplexVector.Value.ComplexArray);
				result.SetValue(cv);

				TempMarking.add(result);
				if (!IsReversible) {
					placesToNull.add(currentInputPlace.GetName());
				}
				Parent.PlaceList.set(util.GetIndexByName(string, Parent.PlaceList), currentInputPlace);
			}

			if (currentInputPlace instanceof DataDoubleDouble) {
				result = (DataDoubleDouble) ((DataDoubleDouble) currentInputPlace).clone();

				TempMarking.add(result);
				if (!IsReversible) {
					placesToNull.add(currentInputPlace.GetName());
				}
				Parent.PlaceList.set(util.GetIndexByName(string, Parent.PlaceList), currentInputPlace);
			}

			if (currentInputPlace instanceof DataBoolean) {
				result = (DataBoolean) ((DataBoolean) currentInputPlace).clone();

				TempMarking.add(result);
				if (!IsReversible) {
					placesToNull.add(currentInputPlace.GetName());
				}
				Parent.PlaceList.set(util.GetIndexByName(string, Parent.PlaceList), currentInputPlace);
			}
			
			if (currentInputPlace instanceof DataComplexVector2D) {
				result = (DataComplexVector2D) ((DataComplexVector2D) currentInputPlace)
						.clone();
				
				TempMarking.add(result);
				if (!IsReversible) {
					placesToNull.add(currentInputPlace.GetName());
				}
				Parent.PlaceList.set(util.GetIndexByName(string, Parent.PlaceList), currentInputPlace);
			}
			
			if (currentInputPlace instanceof DataComplexVector2DMatrix) {
				result = (DataComplexVector2DMatrix) ((DataComplexVector2DMatrix) currentInputPlace)
						.clone();
				
				TempMarking.add(result);
				if (!IsReversible) {
					placesToNull.add(currentInputPlace.GetName());
				}
				Parent.PlaceList.set(util.GetIndexByName(string, Parent.PlaceList), currentInputPlace);
			}
		}
		return placesToNull;
	}

	@Override
	public void Start() {

	}

	@Override
	public void Stop() {

	}

	public String toString() {
		ArrayList<String> temp1 = new ArrayList<String>();
		for (PetriObject petriObject : TempMarking) {
			if (petriObject == null)
				temp1.add("NULL");
			else
				temp1.add(petriObject.toString());
		}
		return TransitionName + " Temp Marking [" + String.join(",", temp1) + "]";
	}

	public boolean Printable = true;

	@Override
	public boolean IsPrintable() {
		return Printable;
	}

	private boolean token;

	@Override
	public void SetToken(boolean token) {
		this.token = token;
	}

	@Override
	public boolean GetToken() {
		return this.token;
	}

	@Override
	public String ToStringWithParam(boolean b) {
		return toString();
	}
}
