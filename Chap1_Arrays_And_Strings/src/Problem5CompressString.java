
public class Problem5CompressString {

	public static void main(String[] args) {
		String str = countCharInString("AAABBBCCAAAADDDAAAEEFFFFFF");
		System.out.println(str);
	}
	
	public static String countCharInString(String str){
		String resStr = "";
		int count = 1;
		char c = str.charAt(0);
		
		for(int i = 1; i < str.length(); i++){
			if(c==str.charAt(i)){
				count++;
			}else{
				resStr += c + "" + count;
				c=str.charAt(i);
				count=1;
			}
		}
		return resStr + c + count;
	}
}
