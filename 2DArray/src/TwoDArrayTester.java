
public class TwoDArrayTester {
	public static void main(String[] args){
		int[][] arr = generateArray();
		printArray(arr);
	}
	
	public static int[][] generateArray(){
		int[][] retArr = new int[5][5];
		int num = 0;
		for(int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				retArr[i][j] = num++;
			}
		}
		return retArr;
	}
	
	public static void printArray(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
