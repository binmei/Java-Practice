public class MyLinkedListWithNodeArbitPointer {
	
	public class aNode{
		aNode next = null;
		aNode arbi = null;
		int data;
		
		public aNode(){};
		public aNode(int d){
			this.data = d;
		}
	}
	
	aNode head = null;
	int size = 0;
	
	public MyLinkedListWithNodeArbitPointer(){
		this.head = null;
		this.size = 0;
	}
	

	
	public aNode get(int index){
		aNode curr = head;
		if(index == 0) return curr;
		else {
			for(int i = 1; i < index; i++){
				curr=curr.next;
			}
		}
		return curr;
	}
	
	public void printList(){
		for(aNode curr = head; curr != null; curr = curr.next){
			System.out.print(curr.data + " ");
		}
		System.out.println("");
	}
}
