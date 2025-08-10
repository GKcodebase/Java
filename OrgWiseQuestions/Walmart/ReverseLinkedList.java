/**
 * Reverse a singly linked list.
 * 
 */
public class ReverseLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    static Node reverseList(Node head){
        Node next =head;
        Node prev = null;
        while( next != null){
            Node temp = next;
            next = next.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;
    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        System.out.println("Reversing the linked list...");
        head = reverseList(head);
        printList(head);
    }
}
