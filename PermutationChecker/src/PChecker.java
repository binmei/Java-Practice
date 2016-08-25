
public class PChecker {

	public static void main(String[] args) {
		int[] A = {2, 1, 3, 5, 4};
		System.out.println(solution(A));

	}
	
	 public static final int NOT_PERMUTATION = 0;
	  public static final int PERMUTATION = 1;
	  // (4,1,3,2) = 1
	  // (4,1,3) = 0
	  // (1) = 1
	  // () = 1
	  // (2) = 0
	  public static int solution(int[] A){
	        int indexCount = 0;
	        int valueCount = 0;
	        int prefixCount = 0;

	        for(int i = 0; i< A.length; i++){
	            indexCount+= i + 1;
	            valueCount += A[i];
	            if(indexCount == valueCount){
	                prefixCount++;
	            }
	        }
	        return prefixCount;

	    }

}
