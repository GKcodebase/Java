package CheatSheet.DataStructure;

/**
 * The Tree.
 */
public class Tree {
    /**
     * Invert tree node.
     *
     * @param root the root
     * @return the node
     */
    public static Node invertTree(Node root) {
        if (root == null)
            return null;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    /**
     * Validate binary search tree boolean.
     *
     * @param root the root
     * @return the boolean
     */
    static boolean validateBinarySearchTree(Node root) {
        return validate(root, null, null);
    }

    /**
     * Validate boolean.
     *
     * @param root the root
     * @param low  the low
     * @param high the high
     * @return the boolean
     */
    static boolean validate(Node root, Integer low, Integer high) {
        if (root == null)
            return true;
        if ((low != null && low >= root.val) ||
                (high != null && high <= root.val))
            return false;
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);

        System.out.println("Is it valid Bst : " + validateBinarySearchTree(root));
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
         * The Left.
         */
        Node left;
        /**
         * The Right.
         */
        Node right;

        /**
         * Instantiates a new Node.
         *
         * @param val the val
         */
        Node(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }
}
