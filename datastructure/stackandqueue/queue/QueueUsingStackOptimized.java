package datastructure.stackandqueue.queue;

import java.util.Stack;

public class QueueUsingStackOptimized<V> {
    /**
     * The Stack 1.
     */
    Stack<V> stack1 = new Stack<>();
    /**
     * The Stack 2.
     */
    Stack<V> stack2 = new Stack<>();

    public boolean isEmpty(){
        return (stack1.isEmpty() && stack2.isEmpty());
    }

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
        //return null if both the stacks are empty
        if(isEmpty())
            return null;
            //if stack2 is empty, we pop all the elements
            //from stack1 and push them to the stack2
        else if(stack2.isEmpty()){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            //finally, we return the top of stack2
            return stack2.pop();
        }else{
            //if none of the above conditions are true
            //we will simply return the top of stack2
            return stack2.pop();
        }
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
