package CheatSheet.DataStructure;

/**
 * The Linked list.
 */
public class LinkedList {
    /**
     * Reverse node.
     *
     * @param root the root
     * @return the node
     */
    public static Node reverse(Node root) {
        Node prev = null;
        Node curr = root;

        while (curr != null) {
            Node tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        return prev;
    }

    /**
     * Merge list node.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     * @return the node
     */
    public static Node mergeList(Node list1, Node list2) {
        Node curr = new Node(0);
        Node temp = curr;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }

        temp.next = (list1 == null) ? list2 : list1;

        return curr.next;
    }

    /**
     * Is cyclic boolean.
     *
     * @param root the root
     * @return the boolean
     */
    public static boolean isCyclic(Node root) {
        Node slow = root;
        Node fast = root.next;
        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * Print list.
     *
     * @param root the root
     */
    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

    /**
     * The entry point of application.
     *
     * @param arg the input arguments
     */
    public static void main(String[] arg) {
        Node root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(40);
        root.next.next.next.next = new Node(50);

        printList(root);
        root = reverse(root);
        printList(root);
        root = reverse(root);
        Node root2 = new Node(5);
        root2.next = new Node(15);
        root2.next.next = new Node(25);
        root2.next.next.next = new Node(35);
        root2.next.next.next.next = new Node(45);
        printList(root2);

        Node merged = mergeList(root, root2);
        printList(merged);

        System.out.println("Is cyclic " + isCyclic(root));
        root2.next.next.next.next = root;
        System.out.println("Is cyclic " + isCyclic(root2));


    }

    /**
     * The type Node.
     */
    static class Node {
        /**
         * The Val.
         */
        int val;
        /**
         * The Next.
         */
        Node next;

        /**
         * Instantiates a new Node.
         *
         * @param val the val
         */
        Node(int val) {
            this.val = val;
        }
    }
}
