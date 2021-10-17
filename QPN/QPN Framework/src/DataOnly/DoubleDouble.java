package DataOnly;

import java.io.Serializable;

public class DoubleDouble implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoubleDouble clone() throws CloneNotSupportedException {
		return (DoubleDouble) super.clone();
	}

	public double V1;
	public double V2;

	public DoubleDouble(double V1, double V2) {
		this.V1 = V1;
		this.V2 = V2;
	}

	public String toString() {
		return "V1=" + V1 + " V2=" + V2;
	}
}
