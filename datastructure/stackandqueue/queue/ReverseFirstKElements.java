package datastructure.stackandqueue.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The type Reverse first k elements.
 */
public class ReverseFirstKElements {

    /**
     * Reverse k.
     *
     * @param <V>   the type parameter
     * @param queue the queue
     * @param k     the k
     */
    public static <V> void reverseK(Queue<V> queue, int k){
        if(queue.isEmpty() || k<=0)
            return;
        Stack<V> stack = new Stack<>();
        while(stack.size() != k){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        int size = queue.size();
        for(int i = 0; i < size - k; i++)
            queue.add(queue.remove());
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        reverseK(queue,5);

        System.out.print("Queue: ");
        while(!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
