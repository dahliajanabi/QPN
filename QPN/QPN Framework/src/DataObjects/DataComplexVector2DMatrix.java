package DataObjects;

import java.io.Serializable;

import DataOnly.ComplexVector2DMatrix;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;

public class DataComplexVector2DMatrix implements Interfaces.PetriObject, Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		return PetriObjectType.ComplexVector2DMatrix;
	}

	public ComplexVector2DMatrix Value;

	@Override
	public Object GetValue() {
		return Value;
	}

	@Override
	public void SetValue(Object value) {
		if (value == null) {
			Value = null;
			SetToken(false);
		}
		if (value instanceof ComplexVector2DMatrix) {
			Value = (ComplexVector2DMatrix) value;
			SetToken(true);
		}
	}

	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		return (DataComplexVector2DMatrix) super.clone();
	}

	public boolean Printable = true;

	@Override
	public boolean IsPrintable() {
		return Printable;
	}

	public String toString() {
		if (Value != null) {
			return GetName() + "|" +"["+ Value.toString() +"]";
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
	public void AddElement(Object value) {

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
		if (Value != null) {
			return GetName() + "|" +"["+ Value.toString(b) +"]";
		} else {
			return GetName() + "(Null)";
		}
	}
}