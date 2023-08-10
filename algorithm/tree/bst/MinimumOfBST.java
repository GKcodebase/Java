package algorithm.tree.bst;

/**
 * The type Minimum of bst.
 */
public class MinimumOfBST {
    /**
     * Gets minimum.
     *
     * @param root the root
     * @return the minimum
     */
    public static int getMinimum(Node root) {
        while (null != root && null != root.left) {
            root = root.left;
        }
        return (int) root.data;
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
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println("Minimum of given bst is :: " + getMinimum(bsT.getRoot()));

    }
}
