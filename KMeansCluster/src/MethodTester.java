import java.io.*;
import java.util.Scanner;

public class MethodTester {

	public static void main(String[] args) {
		double result;
		double[] d1Arr = {1, 2, 3, 4, 5};
		double[] d2Arr = {11, 12, 13, 14, 15};
		DataObject d1 = new DataObject(1, d1Arr);
		Centroid c1 = new Centroid(2, d2Arr);
		result = calculateDistance(d1, c1);
		System.out.println("The result is: " + result);
		double SAMPLES[][] = new double[][] {{1.0, 1.0}, 
             {1.5, 2.0}, 
             {3.0, 4.0}, 
             {5.0, 7.0}, 
             {3.5, 5.0}, 
             {4.5, 5.0}, 
             {3.5, 4.5}};
		
		System.out.println(SAMPLES[0][0]);
		System.out.println(SAMPLES[0][1]);
		System.out.println(SAMPLES[1][0]);
		System.out.println(SAMPLES[1][1]);
		
		int array1[] = {1, 2, 3, 4, 5};
		int array2[] = {1, 2, 3, 4, 5};
		
		for(int i = 0; i < array1.length; i ++){
			array1[i] += array2[i];
		}
		
		for (int j : array1){
			System.out.print(j + " ");
		}
		
		System.out.println();
		
		for (int k = 0; k < array1.length; k++){
			array1[k] = array1[k]/2;
		}
		
		for (int j : array1){
			System.out.print(j + " ");
		}
		 
	}
	
	public static double calculateDistance(DataObject d1, Centroid c1){
		double retVal = 0;
		double[] d1Arr = d1.getVector();
		double[] centArr = c1.getVector();
		double temp1, temp2;
		double[] tempArr = new double[60];
		for(int i = 0; i < d1Arr.length; i++){
			temp1 = d1Arr[i];
			temp2 = centArr[i];
			temp1 = temp1-temp2;
			temp1 = (int)Math.pow(temp1, 2);
			tempArr[i]=temp1;
		}
		for(double i : tempArr){
			retVal += i;
		}
		retVal = Math.sqrt(retVal);
		return retVal;
	}
}