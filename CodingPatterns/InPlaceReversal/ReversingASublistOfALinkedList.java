package CodingPatterns.InPlaceReversal;

/**
 * This problem extends the previous one and asks you to reverse a specific sublist within the linked list.
 * You can adapt the in-place reversal technique to achieve this.
 */
public class ReversingASublistOfALinkedList {

    /**
     * The type List node.
     */
    public static class ListNode {
        /**
         * The Val.
         */
        int val;
        /**
         * The Next.
         */
        ListNode next;

        /**
         * Instantiates a new List node.
         *
         * @param x the x
         */
        ListNode(int x) {
            val = x;
        }
    }


    /**
     * Reverse linked list list node.
     *
     * @param head  the head
     * @param left  the left
     * @param right the right
     * @return the list node
     */
    public static ListNode reverseLinkedList(ListNode head, int left, int right) {
        ListNode curr = head;
        for (int i = 0; curr != null && i < left - 1; i++) { // Move to the node before the sublist
            curr = curr.next;
        }

        ListNode start = curr.next;
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = curr.next;
            curr.next = then;
            then = start.next;
        }
        return head;
    }

    /**
     * Print list.
     *
     * @param head the head
     */
    public static void printList(ListNode head) {
        System.out.println("Linked List");
        ListNode temp = head;
        while (null != temp) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        printList(head);
        head = reverseLinkedList(head, 1, 7);
        printList(head);


    }

}
