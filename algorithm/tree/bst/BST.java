package algorithm.tree.bst;


import static algorithm.tree.bst.Helper.printTree;
import static algorithm.tree.bst.Traversal.*;

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
     * Delete boolean.
     *
     * @param value       the value
     * @param currentNode the current node
     * @return the boolean
     */
    public static boolean delete(int value, Node currentNode) {
        Node root = currentNode;
        if (null == currentNode)
            return false;
        Node parent = null;
        while (null != currentNode && value != Integer.valueOf(currentNode.data.toString())) {
            parent = currentNode;
            if (Integer.valueOf(currentNode.data.toString()) > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        if (null == currentNode)
            return false;
        else if (null == currentNode.left && null == currentNode.right) {
            if (root.data == currentNode.data) {
                root = null;
                return true;
            } else if (Integer.valueOf(currentNode.data.toString()) < Integer.valueOf(parent.data.toString())) {
                parent.left = null;
                return true;
            } else {
                parent.right = null;
                return true;
            }
        } else if (currentNode.right == null) {
            if (root.data == currentNode.data) {
                currentNode.right = null;
                return true;
            } else if (Integer.valueOf(currentNode.data.toString()) < Integer.valueOf(parent.data.toString())) {
                parent.left = (currentNode.right);
                return true;
            } else {
                parent.right = (currentNode.right);
                return true;
            }
        } else {
            Node leastNode = findLeastNode(currentNode.right);
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = (int) leastNode.data;
            delete(temp, root);
            currentNode.data = (temp);
            //Delete the leafNode which had the least value
            return true;
        }
    }

    private static Node findLeastNode(Node currentNode) {

        Node temp = currentNode;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp;

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Node root = new Node<>(6);
        insert(4, root);
        insert(2, root);
        insert(5, root);
        insert(9, root);
        insert(8, root);
        insert(12, root);
        System.out.println("\nIs 22 present in BST " + search(22, root));
        System.out.println("Is 25 present in BST " + search(25, root));
        System.out.print("PreOrder Traversal in Tree : ");
        preOrderTraversal(root);
        System.out.print("\nInOrder Traversal in Tree : ");
        inOrderTraversal(root);
        System.out.print("\nPostOrder Traversal in Tree : ");
        postOrderTraversal(root);
        System.out.println();
        printTree(root);
        delete(9,root);
        System.out.println();
        printTree(root);


    }
}
