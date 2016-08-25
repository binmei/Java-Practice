import java.util.*;

public class Problem3UniqueStrings {
	public static void main(String[] args){
		String str1 = "cattaco";
		String str2 = "tacocat";
		
		if(str1.length()!=str2.length()){
			System.out.println("Not permutations");
		}
		
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		String newStr1 = new String(arr1);
		String newStr2 = new String(arr2);
		
		if(newStr1.equals(newStr2)){
			System.out.println("Yes permutations!");
		}
		else {
			System.out.println("Not permutations");
		}
		
	}
}
