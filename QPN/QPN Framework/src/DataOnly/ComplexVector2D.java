package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;

public class ComplexVector2D implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public ComplexVector2D clone() throws CloneNotSupportedException {
		return (ComplexVector2D) super.clone();
	}

	public ComplexVector ComplexArrayX;
	public ComplexVector ComplexArrayY;

	public Enumerations.Orientation Orientation;

	public ComplexVector2D(int size) {
		ComplexArrayX = new ComplexVector(size);
		ComplexArrayY = new ComplexVector(size);
	}
	public ComplexVector2D(Enumerations.Orientation orientation, ComplexVector complexArrayX,
			ComplexVector complexArrayY) {
		ComplexArrayX = complexArrayX;
		ComplexArrayY = complexArrayY;
		Orientation = orientation;
	}

	public String toString(boolean PrintImaginary) {
		return "(" + ComplexArrayX.toString(PrintImaginary) + ")" + "(" + ComplexArrayY.toString(PrintImaginary) + ")";
	}
};
