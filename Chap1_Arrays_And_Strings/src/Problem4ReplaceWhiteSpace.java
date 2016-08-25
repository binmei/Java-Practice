import java.util.*;

public class Problem4ReplaceWhiteSpace {
	public static void main(String[] args){
		String s1 = " booooobs i like a lot lol ooooops       ";
		String s2 = s1.trim();
		String s3 = s1.trim().replace(" ", "\\%20");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
	
}
