/**
 * CSCD 429 Data Mining - Homework #4: K Means Cluster Analysis Implementation
 * By: Bin Mei
 * March 8th, 2015
 * Description: This is a program that reads in synthetic_control_data.txt and does k means cluster analysis on it. 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KMeansCluster {
	
	private final static int NUM_CLUSTERS = 6;
	private final static int TOTAL_DATA = 600;
	private final static String inputFname = "synthetic_control_data.txt";
	private final static String testFname = "synthetic_control_data_test.txt";
	private final static String resultFname = "Result.txt";
	private static ArrayList<DataObject> dataList = new ArrayList<DataObject>();
	private static ArrayList<DataObject> tempList = new ArrayList<DataObject>();
	private static ArrayList<Centroid> centroidList = new ArrayList<Centroid>();
	private static ArrayList<DataObject> cluster1 = new ArrayList<DataObject>();
	private static ArrayList<DataObject> cluster2 = new ArrayList<DataObject>();
	private static ArrayList<DataObject> cluster3 = new ArrayList<DataObject>();
	private static ArrayList<DataObject> cluster4 = new ArrayList<DataObject>();
	private static ArrayList<DataObject> cluster5 = new ArrayList<DataObject>();
	private static ArrayList<DataObject> cluster0 = new ArrayList<DataObject>();
	
	/**
	 * Main Method.
	 * @param args
	 */
	public static void main(String[] args) {
		dataList = DataReader();
		clusterify(dataList);
		putIntoCluster();
		CSVWriter(cluster0, "cluster0.csv");
		CSVWriter(cluster1, "cluster1.csv");
		CSVWriter(cluster2, "cluster2.csv");
		CSVWriter(cluster3, "cluster3.csv");
		CSVWriter(cluster4, "cluster4.csv");
		CSVWriter(cluster5, "cluster5.csv");
		DataWriter(tempList, resultFname);
		System.out.println("Finished, the result is written to Result.txt and 6 CSV Files!!!");
	}
	
	/**
	 * This method does the cluster analysis on passed in ArrayList of DataObject.
	 * @param theList
	 */
	public static void clusterify(ArrayList<DataObject> theList){
		final double BigNum = 1000;
		double minimum = BigNum;
		boolean isStillMoving = true;
		double distance = 0.0;
		int cluster = 1;
		int sampleNum = 0;
		
		initializeCentroidList();
		
		while(tempList.size() < TOTAL_DATA){
			DataObject tempData = theList.get(sampleNum);
			tempList.add(tempData);
			minimum = BigNum;
			
			for (int i = 0; i < NUM_CLUSTERS; i++){
				distance = calculateDistance(tempData, centroidList.get(i));
				if(distance < minimum){
					minimum = distance;
					cluster = i;
				}
			}
			tempData.setCluster(cluster);
		
			for(int i = 0; i < NUM_CLUSTERS; i++){
				double[] newTotal = new double[60];
				int totalInCluster = 0;
				for (int j = 0; j < tempList.size(); j++){
					if(tempList.get(j).getCluster() == i){
						DataObject tempDataObject = tempList.get(j);
						double[] tempDataVector = tempDataObject.getVector();
						for (int k = 0; k < tempDataVector.length; k++){
							newTotal[k] += tempDataVector[k];
						}
						totalInCluster++;
					}
				}
				if(totalInCluster > 0){
					double[] tempVec2 = centroidList.get(i).getVector();
					for (int x = 0; x < tempVec2.length; x++){
						tempVec2[x] = newTotal[x] / totalInCluster;
					}
					centroidList.get(i).setVector(tempVec2);
				}
			}
			sampleNum++;
		}

		while(isStillMoving){
			for(int i = 0; i < NUM_CLUSTERS; i++){
				double[] newTotal = new double[60];
				int totalInCluster = 0;
				for (int j = 0; j < tempList.size(); j ++){
					if(tempList.get(j).getCluster() == i){
						DataObject tempDataObject = tempList.get(j);
						double[] tempDataVector = tempDataObject.getVector();
						for (int k = 0; k < tempDataVector.length; k++){
							newTotal[k] += tempDataVector[k];
						}
						totalInCluster++;
					}
				}
				if(totalInCluster > 0){
					double[] tempVec2 = centroidList.get(i).getVector();
					for (int x = 0; x < tempVec2.length; x++){
						tempVec2[x] = newTotal[x] / totalInCluster;
					}
					centroidList.get(i).setVector(tempVec2);
				}
			}
		
			isStillMoving = false;
		
			for(int i = 0; i < tempList.size(); i++){
				DataObject tempData2 = tempList.get(i);
				minimum = BigNum;
				for(int j = 0; j < NUM_CLUSTERS; j++){
					distance = calculateDistance(tempData2, centroidList.get(j));
					if(distance < minimum){
						minimum = distance;
						cluster = j;
					}
				}
				tempData2.setCluster(cluster);
				if(tempData2.getCluster() != cluster){
					tempData2.setCluster(cluster);
					isStillMoving = true;
				}
			}
		}
		return;
	}
	
	/**
	 * This method initializes a List of Centroids with randomly chosen data objects.
	 */
	public static void initializeCentroidList(){
		centroidList.add(new Centroid(1, dataList.get(90)));
		centroidList.add(new Centroid(2, dataList.get(180)));
		centroidList.add(new Centroid(3, dataList.get(270)));	
		centroidList.add(new Centroid(4, dataList.get(360)));	
		centroidList.add(new Centroid(5, dataList.get(450)));
		centroidList.add(new Centroid(6, dataList.get(540)));
	}
	
	/**
	 * This method calculates the distance between a DataObject and a Centroid.
	 * @param d1
	 * @param c1
	 * @return
	 */
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
	
	/**
	 * This method reads input files and outputs the data into an ArrayList.
	 * @return
	 */
	public static ArrayList<DataObject> DataReader(){
		ArrayList<DataObject> theList = new ArrayList<DataObject>();
		DataObject dataObj;
		File file = new File(inputFname);
		int rowNum = 0;
		double temp = 0;
		double[] tempArr;
		Scanner sc;
		
		try{
			sc = new Scanner(file);
			while(sc.hasNextLine()){
				tempArr = new double[60];
				String[] s = sc.nextLine().split("\\s+");
			
				for (int j = 0; j < 60; j++){
					tempArr[j] = Double.parseDouble(s[j]);
				}
				rowNum++;
				dataObj = new DataObject(rowNum, tempArr);
				theList.add(dataObj);
				s = null;
			}
		} catch (Exception e){
			System.out.println("File can't be read!");
		}
		return theList;
	}
	
	/**
	 * This method outputs Result.txt as required in the homework prompt.
	 * @param theList
	 * @param fname
	 */
	public static void DataWriter(ArrayList<DataObject> theList, String fname){
		File file = new File(fname);
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(file));
			for(DataObject dObj : theList){
				ps.println("<" + dObj.getRowNum() + ", " + dObj.getCluster() + ">");
			}
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method outputs CSV files for RapidMiner analysis.
	 * @param theList
	 * @param fname
	 */
	public static void CSVWriter(ArrayList<DataObject> theList, String fname){
		File file = new File(fname);
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(file));
			for(DataObject dObj : theList){
				for(double num : dObj.getVector()){
					ps.print(num + ",");
				}
				ps.println("");
			}
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method puts different DataObject into respective clusters for output.
	 */
	public static void putIntoCluster(){
		for(DataObject dObj : tempList){
			if(dObj.getCluster() == 0){
				cluster0.add(dObj);
			}
			if(dObj.getCluster() == 1){
				cluster1.add(dObj);
			}
			if(dObj.getCluster() == 2){
				cluster2.add(dObj);
			}
			if(dObj.getCluster() == 3){
				cluster3.add(dObj);
			}
			if(dObj.getCluster() == 4){
				cluster4.add(dObj);
			}
			if(dObj.getCluster() == 5){
				cluster5.add(dObj);
			}
		}
	}
	
}
