package datastructure.stackandqueue.stack;

/**
 * The type Min stack.
 */
public class MinStack {

    /**
     * The Max size.
     */
    int maxSize;
    /**
     * The Main stack.
     */
    Stack<Integer> mainStack;
    /**
     * The Min stack.
     */
    Stack<Integer> minStack;

    /**
     * Instantiates a new Min stack.
     *
     * @param maxSize the max size
     */
//constructor
    public MinStack(int maxSize) {
        //We will use two stacks mainStack to hold original values
        //and minStack to hold minimum values. Top of minStack will always
        //be the minimum value from mainStack
        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);
    }

    /**
     * Pop int.
     *
     * @return the int
     */
//removes and returns value from stack
    public int pop(){
        //1. Pop element from minStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }

    /**
     * Push.
     *
     * @param value the value
     */
//pushes value into the stack
    public void push(Integer value){
        //1. Push value in mainStack and check value with the top value of minStack
        //2. If value is greater than top, then push top in minStack
        //else push value in minStack
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.top() < value)
            minStack.push(minStack.top());
        else
            minStack.push(value);
    }

    /**
     * Min int.
     *
     * @return the int
     */
//returns minimum value in O(1)
    public int min(){
        return minStack.top();
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        MinStack minStack =  new MinStack(10);
        minStack.push(10);
        minStack.push(110);
        minStack.push(20);
        minStack.push(180);
        minStack.push(910);
        System.out.print("Top of a min stack is :: "+minStack.min());

    }
}
