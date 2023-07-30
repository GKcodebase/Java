package algorithm.tree.bst;

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
}
