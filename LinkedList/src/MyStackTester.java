public class MyStackTester {

	public static void main(String[] args) {
		MyStack stacky = new MyStack();
		stacky.push(1);
		stacky.push(3);
		stacky.push(51);
		stacky.push(72);
		stacky.push(45);
		stacky.push(79);
		stacky.push(34);
		stacky.push(19);
		
		stacky.printStack();
		stacky.pop();
		stacky.printStack();
//		stacky.pop();
//		stacky.printStack();
//		stacky.pop();
//		stacky.printStack();
//		stacky.pop();
//		stacky.printStack();
//		stacky.top();
		System.out.println("The minimum is: " + stacky.getMin());
	}

}
