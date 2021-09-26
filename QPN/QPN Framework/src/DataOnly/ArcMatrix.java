package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;

public class ArcMatrix implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public ArcMatrix clone() throws CloneNotSupportedException {
		return (ArcMatrix) super.clone();
	}

	public Float[][] Matrix;

	public ArcMatrix(int rowCount, int ColCount) {
		Matrix = new Float[rowCount][ColCount];
	}
	
	public ArcMatrix(int rowCount, int ColCount, Float... arguments) {
		if (arguments.length != rowCount * ColCount) {
			System.err.print("ArcMatrix parameters are wrong the number of values doesnt match the matrix");
			return;
		}
		Matrix = new Float[rowCount][ColCount];
		int index = 0;
		if (arguments.length == rowCount * ColCount)
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < ColCount; j++) {
					Matrix[i][j] = arguments[index++];
				}
			}
	}

	public String toString() {
		String toPrint = "";
		ArrayList<String> temp1 = new ArrayList<String>();
		for (int i = 0; i < Matrix.length; i++) {
			for (int j = 0; j < Matrix[0].length; j++) {
				if (Matrix[i][j] == null)
					temp1.add("NULL");
				else
					temp1.add(Matrix[i][j].toString());
			}
			toPrint += "(" + String.join(",", temp1) + ")";
			temp1.clear();
		}
		return "{" + toPrint + "}";
	}
}
