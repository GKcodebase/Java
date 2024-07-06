package CodingPatterns.FastAndSlowPointer;

/**
 * This problem involves efficiently finding the middle element of a
 * singly linked list without measuring its length beforehand.
 * The fast and slow pointers technique is well-suited for this task.
 */
public class FindMiddleOfLinkedList {

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
     * Middle of list list node.
     *
     * @param head the head
     * @return the list node
     */
    public static ListNode middleOfList(ListNode head){
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer.next!=null || fastPointer !=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
