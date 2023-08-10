package datastructure.tree.bst;

/**
 * The type Find ancestor of node.
 */
public class FindAncestorOfNode {
    /**
     * Find ancestor string.
     *
     * @param root the root
     * @param k    the k
     * @return the string
     */
    public static String findAncestor(Node root, int k) {
        String result = "";
        Node tempRoot = root;
        while (tempRoot != null && (int) tempRoot.data != k) {
            result = result + tempRoot.data + " , ";
            if (k <= (int) tempRoot.data)
                tempRoot = tempRoot.left;
            else
                tempRoot = tempRoot.right;
        }
        return result;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BST tree = new BST();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(5);
        tree.add(8);
        tree.add(8);
        tree.add(12);
        tree.add(10);
        tree.add(14);

        int key = 10;
        System.out.print(key + " --> ");
        System.out.print(findAncestor(tree.getRoot(), key));

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        System.out.print(findAncestor(tree.getRoot(), key));
    }
}
