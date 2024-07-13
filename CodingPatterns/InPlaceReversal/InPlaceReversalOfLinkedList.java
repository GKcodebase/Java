package CodingPatterns.InPlaceReversal;

/**
 * This classic problem involves reversing the order of nodes in a singly linked list without creating a new list.
 * The in-place approach using pointers is efficient and avoids extra memory allocation.
 */
public class InPlaceReversalOfLinkedList {
    /**
     * The type List node.
     */
    public class ListNode {
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
     * @param head the head
     * @return the list node
     */
    public static ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while( curr != null){
            ListNode  nextTemp = curr.next; // Store the next node before overwriting
            curr.next = prev; // Reverse the link
            prev = curr; // Move pointers
            curr = nextTemp;
        }
        return prev; // prev becomes the new head after reversal
    }
}
