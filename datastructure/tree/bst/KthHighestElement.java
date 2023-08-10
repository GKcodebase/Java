package datastructure.tree.bst;

import java.util.ArrayList;
import java.util.List;

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

    private static List<Integer> getInorderTraversal(Node root,List<Integer> inorder){
        if(null==root)
            return inorder;
        getInorderTraversal(root.left,inorder);
        inorder.add((Integer) root.data);
        getInorderTraversal(root.right,inorder);

        return inorder;
    }
    public static int findKthMaxInorder(Node root,int k){
        List<Integer> inorderList = new ArrayList<>();
        inorderList=getInorderTraversal(root,inorderList);
        return inorderList.get(inorderList.size()-k);
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

        System.out.println("Get the kth Max element :: "+findKthMaxInorder(bsT.getRoot(), 3));
        System.out.println("Get the kth Max element :: "+findKthMax(bsT.getRoot(), 3));

    }
}
