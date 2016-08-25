
public class Problem7SetColAndRowToZero {

	public static void main(String[] args) {
		int[][] arr = new int[][]{{ 1,  2,  3,  4,  0},
								  { 6,  7,  8,  9, 10},
								  {11,  0, 13, 14, 15},
								  {1, 2, 9, 8,  4}};
		System.out.println("Row number: " + arr.length);
		System.out.println("Col number: " + arr[0].length);
		
		 changeToZero(arr);
		 for(int i = 0; i < arr.length; i++){
				for(int j = 0; j < arr[0].length; j++){
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
	}
	
	public static void changeToZero(int[][] arr){
		boolean[] row = new boolean[5];
		boolean[] col = new boolean[5];
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				if(arr[i][j]==0){
					row[i]=true;
					col[j]=true;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				if(row[i] || col[j]){
					arr[i][j]=0;
				}
			}
		}
	}

}

