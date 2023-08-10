package datastructure.tree.bst;

/**
 * The type Traversal.
 */
public class Traversal {
    /**
     * Pre order traversal.
     *
     * @param root the root
     */
    public static void preOrderTraversal(Node root){
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * In order traversal.
     *
     * @param root the root
     */
    public static void inOrderTraversal(Node root){
        if(null == root)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    /**
     * Post order traversal.
     *
     * @param root the root
     */
    public static void postOrderTraversal(Node root){
        if(null==root)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
}
