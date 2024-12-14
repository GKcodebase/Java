package CheatSheet.CompetitveCoding;

/**
 * The Fast and slow pointer.
 */
public class FastAndSlowPointer {
    /**
     * Has cycle boolean.
     *
     * @param head the head
     * @return the boolean
     */
    public static boolean hasCycle(ListNode head) {
        if (null == head) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        // Fast & Slow Pointers (Cycle Detection)
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle

        System.out.println("Fast & Slow Pointers - Cycle Detection: " +
                hasCycle(head));
    }
}
