import java.util.*;

public class Join implements Runnable{

	int num;
	
	public void run()
	{
		if(prime()) System.out.print("Prime");
		else System.out.print("Non-Prime"); 
	}
		
	public boolean prime()
	{
		for(int i = 2; i < num/2; i++){
			if(num%i == 0) return false;
		}
		return true;
	}
	
	 public boolean odd(){
		 if(num%2==0) return false;
		 else return true;
	 }
	 
	 public static void main(String[] args){
		 Join s = new Join();
		 Thread t = new Thread(s);
		 s.num = 52;
		 t.start();
		 try{ t.join(); }
		 catch(InterruptedException e){}
		 boolean b = s.odd();
		 if(b){
			 System.out.print(" and Odd");
		 } else {
			 System.out.print(" and Even");
		 }
	 }
}

