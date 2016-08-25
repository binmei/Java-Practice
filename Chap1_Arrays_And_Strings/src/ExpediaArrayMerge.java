
public class ExpediaArrayMerge {
	public static void main(String[] args) {
		int[] A = {1, 3, 5, 9};
		int[] B = {2, 3, 4, 7, 10};
		int[] temp = new int[9];
		
		int sizeA = 4, sizeB = 5;
		int countA = 0, countB = 0;
		int i = 0;
		
		for (;countA < A.length || countB < B.length;){
			if(countA < A.length && countB < B.length){	
				if(A[countA] < B[countB]){
					temp[i]=A[countA];
					countA++;
				} else {
					temp[i]=B[countB];
					countB++;
				}
			} else if(countA < A.length){
				temp[i]=A[countA];
				countA++;
			} else if(countB < B.length){
				temp[i]=B[countB];
				countB++;
			}
			i++;
		}
		
		for(int j : temp){
			System.out.println(j + " ");
		}
	}
}
