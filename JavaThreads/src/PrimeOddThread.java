import java.util.*;

public class PrimeOddThread extends Thread{
	
	int num;
	public static void main(String[] args) {
		PrimeOddThread c = new PrimeOddThread();
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		c.num = i;
		c.run();
		if(c.odd()){
			System.out.println("Odd");
		} else {
			System.out.println("Even");
		}
	}
	
	public void run(){
		System.out.println("run method is called!");
		if(prime()){
			System.out.println("Prime");
		} else {
			System.out.println("Non-Prime");
		}
	}
	
	public boolean prime(){
		for(int i = 2; i < num/2; i++)
		{
			if(num % i == 0) {return false;}
		}
		return true;
	}
	
	public boolean odd(){
		if(num%2 == 0) return false;
		else return true;
	}
}

