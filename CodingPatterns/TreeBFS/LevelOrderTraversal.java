package CodingPatterns.TreeBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * To implement a Binary Tree Level Order Traversal in Java,
 * you can use a breadth-first search (BFS) approach,
 * which utilizes a queue to traverse the tree level by level.
 * Here's the step-by-step guide and the implementation:.
 */
public class LevelOrderTraversal {

    /**
     * The type Tree node.
     */
    static class TreeNode {
        /**
         * The Value.
         */
        int value;
        /**
         * The Left.
         */
        TreeNode left;
        /**
         * The Right.
         */
        TreeNode right;

        /**
         * Instantiates a new Tree node.
         *
         * @param value the value
         */
        TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * Level order traversal.
     *
     * @param root the root
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.value + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        levelOrderTraversal(root);
    }
}
