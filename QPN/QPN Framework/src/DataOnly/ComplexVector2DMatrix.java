package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;

public class ComplexVector2DMatrix implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public ComplexVector2D clone() throws CloneNotSupportedException {
		return (ComplexVector2D) super.clone();
	}

	public ArrayList<ArrayList<ComplexVector2D>> Matrix = new ArrayList<ArrayList<ComplexVector2D>>();
	private int rows;
	private int columns;

	public ComplexVector2DMatrix(int rows, int columns, int elementSize) {
		this.rows = rows;
		this.columns = columns;
		for (int i = 0; i < rows; i++) {
			ArrayList<ComplexVector2D> array = new ArrayList<ComplexVector2D>();
			for (int j = 0; j < columns; j++) {
				array.add(new ComplexVector2D(elementSize));
			}
			Matrix.add(array);
		}
	}

	public String toString(boolean PrintImaginary) {
		ArrayList<String> temp1 = new ArrayList<String>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (Matrix.get(i).get(j) == null)
					temp1.add("NULL");
				else
					temp1.add(Matrix.get(i).get(j).toString(PrintImaginary));
			}
		}
		return "(" + String.join(",", temp1) + ")";
	}
};
