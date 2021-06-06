package Components;

import java.io.Serializable;
import java.util.ArrayList;
import DataObjects.DataComplexVector;
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

	//public String TransitionName;

	public int Delay = 0;
	public int InitialDelay = 0;

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

	public void BookTokens() throws CloneNotSupportedException {
		TempMarking.clear();
		for (String string : InputPlaceName) {
			PetriObject currentInputPlace = util.GetPetriObjectByName(string, Parent.PlaceList);
			PetriObject result = null;
			
				if (currentInputPlace instanceof DataComplexVector) {
				result = (DataComplexVector) ((DataComplexVector) currentInputPlace).clone();

				TempMarking.add(result);
				currentInputPlace.SetValue(null);
				Parent.PlaceList.set(util.GetIndexByName(string, Parent.PlaceList), currentInputPlace);
			}
		}
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
}
