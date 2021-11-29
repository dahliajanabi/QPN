package DataObjects;

import java.io.Serializable;

import DataOnly.DoubleDouble;

import Enumerations.PetriObjectType;
import Interfaces.PetriObject;

public class DataDoubleDouble implements Interfaces.PetriObject, Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.DataDoubleDouble;
	}

	public DoubleDouble Value = null;

	@Override
	public Object GetValue() {
		return Value;
	}

	@Override
	public void SetValue(Object value) {
		if (value == null)
			Value = null;
		if (value instanceof DoubleDouble) {
			Value = (DoubleDouble) value;
		}
	}

	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		return (DataDoubleDouble) super.clone();
	}

	public boolean Printable = true;

	@Override
	public boolean IsPrintable() {
		return Printable;
	}

	public String toString() {
		if (Value != null) {
			return GetName() + "(" + GetValue().toString() + ")";
		} else {
			return GetName() + "(Null)";
		}
	}

	private String name = "";

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public void SetName(String name) {
		this.name = name;
	}

	@Override
	public void SetToken(boolean token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean GetToken() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String ToStringWithParam(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
}
