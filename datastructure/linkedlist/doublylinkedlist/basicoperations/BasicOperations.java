package datastructure.linkedlist.doublylinkedlist.basicoperations;

/**
 * The type Basic operations.
 */
public class BasicOperations {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtHead(50);
        doublyLinkedList.insertAtHead(40);
        doublyLinkedList.insertAtHead(20);
        doublyLinkedList.printList();
    }
}
