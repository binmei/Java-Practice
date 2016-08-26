
public class MyLinkedListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList myList = new MyLinkedList();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList.add(7);
		myList.add(8);
		myList.add(9);
		myList.add(9);
		myList.add(9);
		myList.add(9);
		myList.add(10);
		myList.add(10);
		myList.add(10);
		myList.add(10);
		myList.printList();
		myList.printSize();
		myList.insertAt(2, 10);
		myList.printList();
		myList.printSize();
		myList.removeAt(3);
		myList.printList();
		myList.printSize();
		MyLinkedList.Node n10 = myList.get(10);
		MyLinkedList.Node n5 = myList.get(5);
		n10.next = n5;
		System.out.println("The list is now looped: ");
		myList.printLoopList();
		myList.hasLoop();
		System.out.println("The head of the loop is: ");
		System.out.println(myList.findLoopHead());
		System.out.println("Breaking the loop.");
		n10.next = null;
		myList.printList();
		System.out.println(myList.hasLoop());
		
		MyLinkedList list2 = new MyLinkedList();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(4);
		list2.add(5);
		list2.add(5);
		list2.add(6);
		list2.add(6);
		list2.add(6);
		list2.add(7);
		list2.add(8);
		list2.add(9);
		list2.add(10);
		list2.printList();
		list2 = list2.removeDuplicate();
		System.out.println("Duplicates are removed!");
		list2.printList();
	}

}
