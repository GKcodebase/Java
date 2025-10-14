public class NthElementFromEnd {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findNthFromEnd(Node head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        Node mainPtr = head;
        Node refPtr = head;
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                System.out.println("List has fewer than " + n + " nodes.");
                return null;
            }
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr;
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int n = 2; // Example: Find the 2nd element from the end
        Node result = findNthFromEnd(head, n);
        if (result != null) {
            System.out.println("The " + n + "th element from the end is: " + result.data);
        } else {
            System.out.println("The list is shorter than " + n + " elements.");
        }
    }
}
