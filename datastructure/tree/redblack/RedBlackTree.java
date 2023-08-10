package datastructure.tree.redblack;

/**
 * The type Red black tree.
 */
public class RedBlackTree {
    /**
     * The type Node.
     */
//TODO
    // Insertion
    // Deletion
    class Node{
        /**
         * The Left.
         */
        Node left;
        /**
         * The Right.
         */
        Node right;
        /**
         * The Is red.
         */
        boolean isRed;
        /**
         * The Data.
         */
        int data;

        /**
         * Instantiates a new Node.
         *
         * @param data  the data
         * @param isRed the is red
         */
        Node(int data,boolean isRed){
            this.data=data;
            this.left=null;
            this.right=null;
            this.isRed=isRed;
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){

    }
}
