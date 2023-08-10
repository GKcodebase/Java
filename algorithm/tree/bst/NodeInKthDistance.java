package algorithm.tree.bst;

/**
 * The type Node in kth distance.
 */
public class NodeInKthDistance {
    /**
     * Find nodes string.
     *
     * @param root the root
     * @param k    the k
     * @return the string
     */
    private static String findNodes(Node root, int k){
        StringBuilder result= new StringBuilder();
        result = findK(root,k,result);
        return result.toString();
    }

    /**
     * Find k string builder.
     *
     * @param root   the root
     * @param k      the k
     * @param result the result
     * @return the string builder
     */
    private static StringBuilder findK(Node root, int k, StringBuilder result) {
        if(null==root)
            return null;
        if(k==0){
            result.append(root.data+" , ");
        }else{
            findK(root.left,k-1,result);
            findK(root.right,k-1,result);
        }
        return result;
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

        System.out.println("Nodes in kth distance from root :: "+findNodes(bsT.getRoot(), 2));

    }
}
