package algorithm.tree.bst;

/**
 * The type Kth highest element.
 */
public class KthHighestElement {

    /**
     * The Count.
     */
    static int count;

    /**
     * Find kth max int.
     *
     * @param root the root
     * @param k    the k
     * @return the int
     */
    public static int findKthMax(Node root, int k) {
        int count = 0;
        Node node = findKthMaxHelper(root, k);
        if (null != node)
            return (int) node.data;
        return -1;
    }

    /**
     * Find kth max helper node.
     *
     * @param root the root
     * @param k    the k
     * @return the node
     */
    private static Node findKthMaxHelper(Node root, int k) {
        if (null == root)
            return null;
        Node node = findKthMaxHelper(root.right, k);

        if (count != k) {
            count++;
            node = root;
        }
        if (k == count) {
            return node;
        } else {
            return findKthMaxHelper(root.left, k);
        }

    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        BST bsT = new BST();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);

        System.out.println(findKthMax(bsT.getRoot(), 3));
    }
}
