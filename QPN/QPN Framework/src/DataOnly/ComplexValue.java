package DataOnly;

import java.io.Serializable;

public class ComplexValue implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public ComplexValue clone() throws CloneNotSupportedException {
		return (ComplexValue) super.clone();
	}

	public Float Real;
	public Float Imaginary;

	public ComplexValue(Float real, Float imaginary) {
		this.Real = real;
		this.Imaginary = imaginary;
	}

	public String toString() {
		return Real + " + i " + Imaginary;
	}
}