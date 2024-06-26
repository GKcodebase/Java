package CodingPatterns.TwoPointers;

/**
 * The type Finding middle of linked list.
 */
public class FindingMiddleOfLinkedList {
    /**
     * The type List node.
     */
    class ListNode{
        /**
         * The Data.
         */
        int data;
        /**
         * The Next.
         */
        ListNode next;
    }

    /**
     * Find middle list node.
     *
     * @param head the head
     * @return the list node
     */
    public static ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
