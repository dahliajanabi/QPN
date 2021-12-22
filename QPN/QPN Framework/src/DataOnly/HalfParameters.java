package DataOnly;

public class HalfParameters {
	public Sign Sign1;
	public Sign Sign2;
	public Sign Sign3;
	public Sign Sign4;
	public int MatrixIndex;
	public Shift Shift;
	
	public HalfParameters(Sign sign1, Sign sign2, Sign sign3, Sign sign4, int matrixIndex) {
		this.Sign1 = sign1;
		this.Sign2 = sign2;
		this.Sign3 = sign3;
		this.Sign4 = sign4;
		this.MatrixIndex = matrixIndex;
	}
	
	public HalfParameters(int matrixIndex,Shift shift) {
		this.MatrixIndex = matrixIndex;
		this.Shift=shift;
	}
}
