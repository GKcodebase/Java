package datastructure.tree.bst;

/**
 * The type Node.
 *
 * @param <T> the type parameter
 */
public class Node<T> {
    /**
     * The Data.
     */
    T data;
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
     * @param data the data
     */
    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

