
public class MyThread extends Thread {
	public int counter;
	
	public void run(){
		this.counter++;
		System.out.println("MyThread is running for: " + counter + " times!");
	}
	
	
}
