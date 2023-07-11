package datastructure.stackandqueue.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * The type Sort stack.
 */
public class SortStack {

    /**
     * The Stack.
     */
    Stack<Integer> stack;

    /**
     * Instantiates a new Sort stack.
     */
    public SortStack(){
        stack=new Stack<Integer>();
    }

    /**
     * Sort with temporary stack.
     */
    //1. Use a second tempStack.
    //2. Pop value from mainStack.
    //3. If the value is greater or equal to the top of tempStack, then push the value in tempStack
    //else pop all values from tempStack and push them in mainStack and in the end push value in tempStack and repeat from step 2.
    //till mainStack is not empty.
    //4. When mainStack will be empty, tempStack will have sorted values in descending order.
    //5. Now transfer values from tempStack to mainStack to make values sorted in ascending order.
    public void sortWithTemporaryStack(){
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!stack.isEmpty()){
            Integer value = stack.pop();
            if (!tempStack.isEmpty() && value >= tempStack.peek()) {
                tempStack.push(value);
            } else {
                while (!tempStack.isEmpty() && tempStack.peek() > value)
                    stack.push(tempStack.pop());
                tempStack.push(value);
            }
        }
        while (!tempStack.isEmpty())
            stack.push(tempStack.pop());
    }

    /**
     * Print stack.
     */
    public void printStack(){
        Iterator<Integer> it = stack.iterator();
        System.out.print("\nStack :: ");
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        SortStack sortStack = new SortStack();
        sortStack.stack.push(10);
        sortStack.stack.push(20);
        sortStack.stack.push(15);
        sortStack.stack.push(40);
        sortStack.stack.push(30);
        sortStack.printStack();
        sortStack.sortWithTemporaryStack();
        sortStack.printStack();

    }
}
