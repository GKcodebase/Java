package algorithm.tree.bst;

import javax.swing.plaf.synth.SynthLookAndFeel;

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
        Node temp = root;
        Node newNode = new Node(data);
        if (root == null) {
            return newNode;
        } else if (Integer.valueOf(temp.data.toString()) <= data) {
            root.right = insert(data, temp.right);
        } else {
            root.left = insert(data, temp.left);
        }
        return temp;
    }

    /**
     * Search boolean.
     *
     * @param data the data
     * @param root the root
     * @return the boolean
     */
    public static boolean search(int data, Node root) {
        if (root == null)
            return false;
        else if (root.data.equals(data))
            return true;
        else if (Integer.valueOf(root.data.toString()) < data)
            return search(data, root.right);
        else
            return search(data, root.left);
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
        System.out.println("\nIs 22 present in BST " + search(22,root));
        System.out.println("Is 25 present in BST " + search(25,root));


    }
}
