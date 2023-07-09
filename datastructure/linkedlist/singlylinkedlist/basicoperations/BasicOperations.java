package datastructure.linkedlist.singlylinkedlist.basicoperations;

/**
 * The type Basic operations.
 */
public class BasicOperations {
    public static void main(String[] args){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertAtFront(10);
        singleLinkedList.insertAtFront(20);
        singleLinkedList.insertAtFront(20);
        singleLinkedList.insertAtFront(30);
        singleLinkedList.insertAtEnd(40);
        singleLinkedList.insertAtEnd(40);
        singleLinkedList.insertAtEnd(50);
        singleLinkedList.insertAtEnd(60);
        singleLinkedList.insertAtEnd(60);
        singleLinkedList.insertAtEnd(60);
        singleLinkedList.insertAfter(15,5);
        singleLinkedList.insertAfter(25,6);
        singleLinkedList.printList();
        System.out.println("\nData is present  "+singleLinkedList.search(41));
        singleLinkedList.deleteHead();
        singleLinkedList.deleteTail();
        singleLinkedList.deleteValue(40);
        System.out.print("After Deletion :: ");
        singleLinkedList.printList();
        singleLinkedList.length();
        System.out.println("Middle of the list is :: "+singleLinkedList.getMiddle()+"\n");
        singleLinkedList.removeRepeated();
        singleLinkedList.printList();
        System.out.println();
        SingleLinkedList list2 = new SingleLinkedList();
        list2.insertAtFront(10);
        list2.insertAtFront(40);
        list2.insertAtFront(60);
        list2.insertAtFront(1);
        list2.insertAtFront(19);
        list2.insertAtFront(14);
        list2.printList();
//        singleLinkedList.unionAndIntersection(list2,singleLinkedList);
        System.out.println("\nNth node from end is :: "+singleLinkedList.nthNodeFromEnd(5));



    }

}
