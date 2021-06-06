package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;


public class ComplexVector implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Overriding clone() method of Object class
	public ComplexVector clone() throws CloneNotSupportedException {
		return (ComplexVector) super.clone();
	}

	public ArrayList<ComplexValue> ComplexArray = new ArrayList<ComplexValue>();
	public Integer Size = 2;

	public ComplexVector(int size,ComplexValue...complexs) {
		Size= size;
		for (ComplexValue complexValue : complexs) {
			ComplexArray.add(complexValue);
		}
	}
	
	public ComplexVector(int size, ArrayList<ComplexValue> complexArray) {
		Size= size;
		for (ComplexValue complexValue : complexArray) {
			ComplexArray.add(complexValue);
		}
	}


	public String toString() {
		ArrayList<String> temp1 = new ArrayList<String>();
		for (ComplexValue c : ComplexArray) {
			if (c == null)
				temp1.add("NULL");
			else
				temp1.add(c.toString());
		}

		return "(" + String.join(",", temp1) + ")";
	}
};

