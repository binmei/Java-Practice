import java.util.ArrayList;
import java.util.Arrays;

public class Centroid {
	private double[] centVector = new double[60];
	private int centNum = 0;
	
	public Centroid(){ }
	
	public Centroid(int num, double[] vec){
		this.centNum = num;
		this.centVector = vec;
	}
	
	public Centroid (int num, DataObject d){
		this.centNum = num;
		this.centVector = d.getVector();
	}
	
	public double[] getVector(){
		return this.centVector;
	}
	
	public int getNum(){
		return this.centNum;
	}
	
	public String toString(){
		ArrayList al = new ArrayList(Arrays.asList(this.centVector));
		return this.centNum + ", " + al;
	}

	public void setVector(double[] tempVec2) {
		this.centVector = tempVec2;
	}
}
