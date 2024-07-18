package CodingPatterns.TreeBFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * To implement a zigzag level order traversal of a binary tree in Java,
 * you can use a breadth-first search (BFS) approach combined with a deque
 * to alternate the order of traversal at each level.
 */
class TreeNode {
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
 * The type Zig zag.
 */
public class ZigZag {

    /**
     * Zig zag level order traversal list.
     *
     * @param head the head
     * @return the list
     */
    public static List<List<Integer>> zigZagLevelOrderTraversal(TreeNode head){
        List<List<Integer>> zigZag =  new ArrayList<>();
        if(null == head)
            return zigZag;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(head);
        boolean leftToRight = true;
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int i=0;i<levelSize;i++){
                if (leftToRight) {
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.value);
                    if (currentNode.left != null) {
                        deque.offerLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.offerLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.value);
                    if (currentNode.right != null) {
                        deque.offerFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.offerFirst(currentNode.left);
                    }
                }
            }
            zigZag.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return zigZag;

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Creating the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Get zigzag level order traversal
        List<List<Integer>> result = zigZagLevelOrderTraversal(root);

        // Print zigzag level order traversal
        System.out.println("Zigzag Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

}
