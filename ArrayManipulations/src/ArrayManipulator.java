
public class ArrayManipulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		
		fillArray(arr);

		printArray(arr);
		System.out.println("");
		
		flipArray(arr);
		flipArray(arr);
		flipArray(arr);
		flipArray(arr);
		System.out.println("\n");
		printArray(arr);
	}
	
	public static void flipArray(int[][] arr){
		int n = arr.length;
		int temp;
		for(int i = 0; i < n/2; i++){
			for(int j = i; j < n - i - 1; j++){
				temp = arr[i][j];
				System.out.print(temp + " ");
				arr[i][j] = arr[n-j-1][i];
				System.out.print(arr[i][j] + " ");
				arr[n-j-1][i] = arr[n-i-1][n-j-1];
				System.out.print(arr[n-j-1][i] + " ");
				arr[n-i-1][n-j-1] = arr[j][n-i-1];
				System.out.print(arr[n-i-1][n-j-1] + " ");
				arr[j][n-i-1] = temp;
				//System.out.print(arr[i][n-j-1] + " ");
			}
		}
	}

	public static void fillArray(int[][] arr){
		int num = 0;
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = num++; 
			}
		}
	}

	public static void printArray(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println("");
		}
	}
}
