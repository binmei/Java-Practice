import java.util.Scanner;

public class PrimeOddThreadR implements Runnable{
	
	int num;
	public static void main(String[] args) {
		PrimeOddThreadR x = new PrimeOddThreadR();
		Thread c = new Thread(x, "Primezers");
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		x.num = i;
		c.start();
		if(x.odd()){
			System.out.println("Odd");
		} else {
			System.out.println("Even");
		}
		System.out.println("Current Thread name is: " + c.currentThread().getName());
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

