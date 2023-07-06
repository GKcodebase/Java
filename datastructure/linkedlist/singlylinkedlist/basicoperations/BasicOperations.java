package datastructure.linkedlist.singlylinkedlist.basicoperations;

/**
 * The type Basic operations.
 */
public class BasicOperations {
    public static void main(String[] args){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertAtFront(10);
        singleLinkedList.insertAtFront(20);
        singleLinkedList.insertAtFront(30);
        singleLinkedList.insertAtEnd(40);
        singleLinkedList.insertAtEnd(50);
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

    }

}
