package CodingPatterns.FastAndSlowPointer;


/**
 * This problem asks you to determine if a singly linked list has a cycle (loop).
 * The fast and slow pointer approach effectively tackles this challenge.
 */
public class CheckCyclicLinkedList {
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
     * Check is cyclic boolean.
     *
     * @param head the head
     * @return the boolean
     */
    public boolean checkIsCyclic(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer)
                return true;
        }
        return false;
    }
}
