package algorithm.tree.bst;

/**
 * The type Helper.
 */
public class Helper {
    /**
     * Print tree.
     *
     * @param current the current
     */
    public static void printTree(Node current) {
        if (current == null) return;

        System.out.print(current.data + ",");
        printTree(current.left);
        printTree(current.right);

    }
}
