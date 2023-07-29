package algorithm.tree.bst;

import static algorithm.tree.bst.Helper.printTree;

/**
 * The type Insertion.
 */
public class BST {
    /**
     * Insert node.
     *
     * @param data the data
     * @param root the root
     * @return the node
     */
    public static Node insert(int data, Node root) {
        Node newNode = new Node(data);
        if (root == null) {
            return newNode;
        } else if (Integer.valueOf(root.data.toString()) <= data) {
            root.right = insert(data, root.right);
        } else {
            root.left = insert(data, root.left);
        }
        return root;
    }
    
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Node root = new Node<>(20);
        insert(10, root);
        insert(30, root);
        insert(25, root);
        insert(40, root);
        insert(5, root);
        insert(15, root);

        printTree(root);

    }
}
