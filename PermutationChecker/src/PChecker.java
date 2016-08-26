import java.util.*;

public class PChecker {
	private static final int MAX_LENGTH = 100000;
	 
	public static void main(String[] args) {
		int[] A = {2, 1, 3, 5, 4};
		System.out.println(solution(A));

	}
	
	  // (4,1,3,2) = 1
	  // (4,1,3) = 0
	  // (1) = 1
	  // () = 1
	  // (2) = 0
	  public static int solution(int[] A) {
		    Map<Integer, Boolean> hashMap = new HashMap<Integer, Boolean>();
		    long len = A.length;
		    if (len > MAX_LENGTH) {
		      return -1;
		    }
		    long actSum = 0;
		    long expSum = len * (len + 1) / 2; // sum(1, 2, .. n) => n(n+1)/2
		    for (int a : A) {
		      actSum = actSum + a;
		      Boolean isThere = hashMap.get(a);
		      if (isThere == null) {
		        hashMap.put(a, true);
		      } else {
		        return 0;
		      }
		    }
		    return actSum == expSum ? 1 : 0;
	  }
}
