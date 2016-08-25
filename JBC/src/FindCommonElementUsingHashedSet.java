import java.util.*;

public class FindCommonElementUsingHashedSet {

	public static void main(String[] args) {
		Integer[] a = {1, 2, 3, 4, 5};
		Integer[] b = {1, 3, 4, 7, 8, 10};
		List<Integer> temp = new ArrayList<Integer>();
		
		Set<Integer> set1 = new LinkedHashSet<Integer>(Arrays.asList(a));
		Set<Integer> set2 = new LinkedHashSet<Integer>(Arrays.asList(b));
		
		for (Integer num : b){
			if(!set1.add(num)){
				temp.add(num);
				temp.add(num);
				System.out.println(num + " ");
			}
		}
		

	}

}
