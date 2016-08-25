/**
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */

import java.util.*;

public class Problem1UniqueCharacters {
	public static void main(String[] args){
		String str = "I like cake and I can't not lie!";
		System.out.println(checkForUnique(str));
		
	}
	
	public static boolean checkForUnique(String str){
		
		boolean[] char_set = new boolean[256];
		
		if(str.length() > 256){
			return false;
		}
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
}
