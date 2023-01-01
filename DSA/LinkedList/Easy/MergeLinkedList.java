package DSA.LinkedList.Easy;

/**
 * The Merge linked list.
 * Merging two sorted linkedlist
 */
public class MergeLinkedList {

}

/**
 * The List node.
 */
class ListNode {
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
     * @param val the val
     */
    ListNode(int val) {
        this.val = val;
    }
}

/**
 * The Solution.
 */
class Solution {
    /**
     * Merge two lists list node.
     *
     * @param l1 the l 1
     * @param l2 the l 2
     * @return the list node
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        while (l1 != null) {
            ptr.next = l1;
            ptr = ptr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ptr.next = l2;
            ptr = ptr.next;
            l2 = l2.next;
        }

        return dummy.next;

    }
}