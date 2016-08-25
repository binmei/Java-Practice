import java.util.Scanner;
import java.util.Stack;

class WordCounter {
    int maxlen = 0;
    static Stack maxStack = new Stack();
    
    public static void main(String[] args){
    	String s = "I love cars and cake. But I also? What. Okkkkkay";
    	System.out.println(solution(s));
    }
    
    public static int solution(String S) {
        char[] cArr = S.toCharArray();
        int wordCount = 0, index = 0;
        for(int i = 0; i < cArr.length; i++){
            if(cArr[0] == ' '){
            	wordCount = 0;
            }
        	if(cArr[i] == ' '){
            	wordCount++;
            }
            if(cArr[i] == '!' || cArr[i] == '.'  || cArr[i] == '?'){
            	if(maxStack.size()==0){
            		maxStack.push(wordCount);
            		wordCount = 0;
            	} else {
            		if(wordCount>=(int)maxStack.peek()){
            			maxStack.push(wordCount);
            			wordCount = 0;
            		}
            	}
            }
        }
        
        return (int)maxStack.peek();
    }
}