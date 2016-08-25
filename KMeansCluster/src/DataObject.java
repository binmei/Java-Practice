
public class DataObject {

	private double[] vector = new double[60];
	private int rowNum = 0;
	private int cluster = 0;
	
	public DataObject(){
		
	}
	
	public DataObject(int rNum, double[] arr){
		this.rowNum = rNum;
		this.vector = arr;
	}
	
	public double[] getVector(){
		return this.vector;
	}
	
	public int getRowNum(){
		return this.rowNum;
	}
	
	public int getCluster(){
		return this.cluster;
	}
	
	public void setCluster(int i){
		this.cluster = i;
	}
	
	public String toString(){
		return "Row: " + this.rowNum + ", Data: " + this.vector;
	}
	
}
