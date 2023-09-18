package datastructure.hashtable;

import java.util.HashSet;

/**
 * The type Check union intersection.
 */
public class CheckUnionIntersection {

    /**
     * Union with hashing singly linked list.
     *
     * @param <T>   the type parameter
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the singly linked list
     */
    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        HashSet<T> visited = new HashSet<T>();
        SinglyLinkedList<T>.Node current = list1.getHeadNode(); //start from list1's head
        while (current != null) {
            //add elements of list1 into the result if they havent been visited before
            if (!visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.add(current.data);
            }
            current = current.nextNode;
        }
        current = list2.getHeadNode();

        //Keep iterating list2
        while (current != null) {
            //add elements of list2 into the result if they havent been visited before
            if (!visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.add(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

    /**
     * Intersection with hashing singly linked list.
     *
     * @param <T>   the type parameter
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the singly linked list
     */
//performs intersection between list
    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        HashSet<T> visited = new HashSet<T>();
        //start from the head of list1
        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        //Keep iterating list1
        while (current != null) {
            //Add elements to visited set if they have not been visited
            if (!visited.contains(current.data)) {
                visited.add(current.data);
            }
            current = current.nextNode;
        }
        //now take head of list2
        current = list2.getHeadNode();
        //iterate list2
        while (current != null) {
            //add the elements which have been visited before into the result
            if (visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.remove(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        for (int i = 7; i > 3; i--) {
            list1.insertAtHead(i);
        }
        System.out.print("1st ");
        list1.printList();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list2.insertAtHead(i);
        }
        System.out.print("2nd ");
        list2.printList();
        System.out.print("After Intersection ");
        intersectionWithHashing(list1, list2).printList();
        System.out.print("After Union ");
        unionWithHashing(list1, list2).printList();
    }
}
