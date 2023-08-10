package algorithm.tree.bst;


/**
 * The type Height of tree.
 */
public class HeightOfTree {
    /**
     * Get height int.
     *
     * @param root the root
     * @return the int
     */
    public static int getHeight(Node root){
        if(null==root)
            return -1;
        else
            return Math.max(getHeight(root.left),getHeight(root.right))+1;
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

        System.out.println("Height of the tree :: "+getHeight(bsT.getRoot()));

    }
}
