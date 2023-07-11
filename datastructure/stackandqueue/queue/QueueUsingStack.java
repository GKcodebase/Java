package datastructure.stackandqueue.queue;

import java.util.Stack;

/**
 * The type Queue using stack.
 *
 * @param <V> the type parameter
 */
public class QueueUsingStack<V> {
    /**
     * The Stack 1.
     */
    Stack<V> stack1 = new Stack<>();
    /**
     * The Stack 2.
     */
    Stack<V> stack2 = new Stack<>();

    /**
     * Enqueue.
     *
     * @param value the value
     */
    public void enqueue(V value){
        stack1.push(value);
    }

    /**
     * Dequeue v.
     *
     * @return the v
     */
    public V dequeue(){
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        V result = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        QueueUsingStack q = new QueueUsingStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println("Dequeue result is :: "+q.dequeue());
        q.enqueue(5);
        System.out.println("Dequeue result is :: "+q.dequeue());
        System.out.println("Dequeue result is :: "+q.dequeue());
    }
}
