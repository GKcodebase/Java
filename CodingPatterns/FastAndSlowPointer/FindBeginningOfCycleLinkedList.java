package CodingPatterns.FastAndSlowPointer;

/**
 * This problem extends the previous one and asks you to
 * find the exact node where the cycle begins, assuming a cycle exists.
 */
public class FindBeginningOfCycleLinkedList {

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
     * Detect cycle start list node.
     *
     * @param head the head
     * @return the list node
     */
    public ListNode detectCycleStart(ListNode head){
        if (head == null || head.next == null) return null;
        ListNode slow = head; ListNode fast = head;
        while( null!= fast && null!= fast.next){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null; // No cycle
        }
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
