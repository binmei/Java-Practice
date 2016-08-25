import java.util.LinkedHashSet;
import java.util.HashSet;

public class MyLinkedList {
	public class Node{
		Node next = null;
		int data;
		
		public Node(){}
		public Node(int d){
			this.data = d;
		}
	}
	
	Node head; 
	int size;
	
	public MyLinkedList(){
		this.head = null;
		size = 0;
	}
	
	public void addFirst(int d){
		Node newNode = new Node(d);
		head = newNode;
		this.size++;
	}
	
	public void add(int d){
		Node curr = head;
		if(size == 0) addFirst(d);
		else{
			for(;curr.next!=null;){
				curr = curr.next;
			}
			Node newNode = new Node(d);
			curr.next = newNode;
			this.size++;
		}
	}
	
	public Node get(int index){
		Node curr = head;
		if(index == 0) return curr;
		else {
			for(int i = 1; i < index; i++){
				curr=curr.next;
			}
		}
		return curr;
	}
	
	public void delete(int d){
		if(head != null && head.data == d){
			head = head.next;
			this.size--;
		} else {
			Node curr;
			for(curr = head; curr.next.data != d; curr = curr.next){
				
			}
			curr.next = curr.next.next;
			this.size--;
		}
	}
	
	public void insertAt(int index, int d){
		Node curr = head;
		Node newNode = new Node(d);
		if(index == 0){
			newNode.next = head;
			head = newNode;
			this.size++;
		}
		else if(index >= size){
			add(d);
		}
		else {
			for(int i = 1; i < index; i++){
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode;
			this.size++;
		}
	}
	
	public void removeAt(int index){
		Node curr = head;
		if(index == 0){
			curr = curr.next;
			head = curr;
			this.size--;
		} else if (index > this.size){
			System.out.println("Index out of bounds!");
		} else {
			for(int i = 1; i < index-1; i++){
				curr=curr.next;
			}
			curr.next = curr.next.next;
			this.size--;
		}	
	}
	
	public boolean hasLoop(){
		boolean looped = false;
		Node A = head;
		Node B = head.next;
		while(B.next!=null && looped == false){
			A = A.next;
			B = B.next.next;
			if(A.equals(B)){
				looped = true;
				System.out.println("This list has a loop!");
			}
		}
		return looped;
	}
	
	public MyLinkedList removeDuplicate(){
		HashSet hs = new HashSet();
		MyLinkedList tempList = new MyLinkedList();
		for(Node curr = head; curr!=null;curr=curr.next){
			hs.add((int)curr.data);
		}
		for(Object o: hs){
			tempList.add((int)o);
		}
		return tempList;
	}
	
	public void printLoopList(){
		Node curr = head;
		for(int i = 0; i <= this.size + 20; i++){
			System.out.print(curr.data + " ");
			curr=curr.next;
		}
		System.out.println("");
	}
	
	
	public void printList(){
		for(Node curr = head; curr != null; curr = curr.next){
			System.out.print(curr.data + " ");
		}
		System.out.println("");
	}
	
	public void printSize(){
		System.out.println("Size is: "  + this.size);
	}
}
