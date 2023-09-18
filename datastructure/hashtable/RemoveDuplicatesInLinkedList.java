package datastructure.hashtable;

import java.util.HashSet;

/**
 * The type Remove duplicates in linked list.
 */
public class RemoveDuplicatesInLinkedList {
    /**
     * Remove duplicates with hashing.
     *
     * @param <V>  the type parameter
     * @param list the list
     */
    public static <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        SinglyLinkedList<V>.Node currentNode = list.headNode;
        SinglyLinkedList<V>.Node prevNode = list.headNode;
        HashSet<V> visitedNodes = new HashSet<V>();

        while (currentNode != null) {
            if (visitedNodes.contains(currentNode.data)) {
                prevNode.nextNode = currentNode.nextNode;
                currentNode = currentNode.nextNode;
            } else {
                visitedNodes.add( currentNode.data);
                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); // created linked list

        for (int i = 1; i <= 8; i++) {
            list.insertAtHead(i);      // inserting data in list
        }
        //inserting duplicates
        list.insertAtHead(2);
        list.insertAtHead(4);
        list.insertAtHead(1);

        System.out.println("List before deleting duplicates from list :");
        list.printList();
        removeDuplicatesWithHashing(list); // calling removeDuplicatesWithHashing function
        System.out.println("List after deleting duplicates from list :");
        list.printList();
    }
}
