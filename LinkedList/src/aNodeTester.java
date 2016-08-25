
public class aNodeTester {

	public static void main(String[] args) {
		MyLinkedListWithNodeArbitPointer list = new MyLinkedListWithNodeArbitPointer();
		MyLinkedListWithNodeArbitPointer.aNode n1 = list.new aNode(1);
		MyLinkedListWithNodeArbitPointer.aNode n2 = list.new aNode(2);
		MyLinkedListWithNodeArbitPointer.aNode n3 = list.new aNode(3);
		MyLinkedListWithNodeArbitPointer.aNode n4 = list.new aNode(4);
		MyLinkedListWithNodeArbitPointer.aNode n5 = list.new aNode(5);
		MyLinkedListWithNodeArbitPointer.aNode n6 = list.new aNode(6);
		MyLinkedListWithNodeArbitPointer.aNode n7 = list.new aNode(7);
		MyLinkedListWithNodeArbitPointer.aNode n8 = list.new aNode(8);
		MyLinkedListWithNodeArbitPointer.aNode n9 = list.new aNode(9);
		MyLinkedListWithNodeArbitPointer.aNode n10 = list.new aNode(10);
		MyLinkedListWithNodeArbitPointer.aNode n11 = list.new aNode(11);
		list.head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		list.size = 11;
		//list.printList();
		
		n1.arbi = n4;
		n3.arbi = n1;
		n5.arbi = n8;
		n6.arbi = n2;
		n7.arbi = n11;
		n9.arbi = n8;
		n11.arbi = n1;
		
		MyLinkedListWithNodeArbitPointer.aNode cpNode = copy(list);
		System.out.println("Copied list is: ");
		while(cpNode!=null){
			System.out.print(cpNode.data + " ");
			cpNode = cpNode.next;
		}
	}
	
	public static MyLinkedListWithNodeArbitPointer.aNode copy(MyLinkedListWithNodeArbitPointer list){
		MyLinkedListWithNodeArbitPointer.aNode p = list.head;
		MyLinkedListWithNodeArbitPointer.aNode cp;
		while(p!=null){
			MyLinkedListWithNodeArbitPointer.aNode newNode = list.new aNode(p.data);
			newNode.next = p.next;
			p.next = newNode;
			p = newNode.next;
		}
		
		p = list.head;
		while(p!=null){
			if(p.arbi != null){
				p.next.arbi = p.arbi.next;
			}
			p = p.next.next;
		}
		
		p = list.head;
		cp = list.head.next;
		while(p!= null){
			MyLinkedListWithNodeArbitPointer.aNode temp = p.next;
			p.next = temp.next;
			p = p.next;
			if(temp.next!=null){
				temp.next = p.next;
				temp = temp.next;
			}
			
		}
		return cp;
	}
	
	//http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
	

}
