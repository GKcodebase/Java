package datastructure.stackandqueue.stack;

/**
 * The type Stack.
 *
 * @param <V> the type parameter
 */
public class Stack<V> {
    private int maxSize;
    private int top;
    private V[] array;
    private int currentSize;

    /**
     * Instantiates a new Stack.
     *
     * @param maxSize the max size
     */
/*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1; //initially when stack is empty
        array = (V[]) new Object[maxSize];//type casting Object[] to V[]
        this.currentSize = 0;
    }

    /**
     * Gets current size.
     *
     * @return the current size
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * Gets max size.
     *
     * @return the max size
     */
//returns the maximum size capacity
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
//returns true if Stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
//returns true if Stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * Top v.
     *
     * @return the v
     */
//returns the value at top of Stack
    public V top() {
        if (isEmpty())
            return null;
        return array[top];
    }

    /**
     * Push.
     *
     * @param value the value
     */
//inserts a value to the top of Stack
    public void push(V value) {
        if (isFull()) {
            System.err.println("Stack is Full!");
            return;
        }
        array[++top] = value; //increments the top and adds value to updated top
        currentSize++;
    }

    /**
     * Pop v.
     *
     * @return the v
     */
//removes a value from top of Stack and returns
    public V pop() {
        if (isEmpty())
            return null;
        currentSize--;
        return array[top--]; //returns value and top and decrements the top
    }

    /**
     * Peek v.
     *
     * @return the v
     */
    public V peek(){
        if(isEmpty())
            return null;
        return array[top];
    }

}