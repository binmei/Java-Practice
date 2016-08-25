
public class ThreadTest {

	public static void main(String[] args) {
//		System.out.println("Hello");
//		System.out.println(Thread.currentThread().getName());
		MyThread t = new MyThread();
		t.start();

		
	}

}
