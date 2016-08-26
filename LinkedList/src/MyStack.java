//Implementing a data structure to mimic stack.
//Implement push(), pop(), getMin(), top() in O(1) time.
//How I solved this problem:
//Use LinkedList 
//push() = LinkedList addFirst()
//pop() = LinkedList removeFirst()
//top() = LinkedList get(index = 0);
//getMin() = used int min and push in MyStack class to keep track of min

import java.util.Stack;

public class MyStack {
	Stack stacky = new Stack();
	Stack minStack = new Stack();
	//int min; //wrong implementation, this only works when min isn't popped off the stack.
	
	public MyStack(){
		this.stacky = new Stack();
		this.minStack = new Stack();
	}
	
	public void push(int d){
		if(minStack.size() == 0){
			stacky.push(d);
			minStack.push(d);
		}else{
			stacky.push(d);
			int min = (int)minStack.peek();
			if(d <= min){
				minStack.push(d);
			}
		}
	}
	
	public int pop(){
		if(stacky.size()>=0){
			int i = (int)stacky.peek();
			int min = (int)minStack.peek();
			if(i == min){
				minStack.pop();
			}
			return (int)stacky.pop();
		}
		return -1;
	}
	
	public int getMin(){
		return (int)minStack.peek();
	}
	
	public void top(){
		System.out.println("Top of the stack is: " + stacky.peek());
	}
	
	public void printStack(){
		for(Object i : this.stacky){
			System.out.print((int)i + " ");
		}
		System.out.println("");
	}
	
	public Stack sort(Stack s){
		Stack s2 = new Stack();
		while(!s.isEmpty()){
			int temp = (int) s.pop();
			while(!s2.isEmpty() && (int)s2.peek() > temp){
				s.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2;
	}

	
}
