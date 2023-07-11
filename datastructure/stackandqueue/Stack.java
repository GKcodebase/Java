package datastructure.stackandqueue;

/**
 * The type Stack.
 *
 * @param <V> the type parameter
 */
public class Stack <V>{

    private int maxSize;
    private int top;
    private V arr[];

    /**
     * Instantiates a new Stack.
     *
     * @param maxSize the max size
     */
    public Stack(int maxSize){
        this.maxSize=maxSize;
        this.top=-1;
        arr = (V[]) new Object[maxSize];
    }

    /**
     * Get max size int.
     *
     * @return the int
     */
    public int getMaxSize(){
        return maxSize;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull(){
        return top==maxSize-1;
    }

    /**
     * Top v.
     *
     * @return the v
     */
    public V top(){
        if(isEmpty())
            return null;
        return arr[top];
    }

    /**
     * Push.
     *
     * @param value the value
     */
    public void push(V value){
        if(isFull()){
            System.out.println("Stack is full.");
        }else{
            arr[++top] = value;
        }
    }

    /**
     * Pop v.
     *
     * @return the v
     */
    public V pop(){
        V val=null;
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            val=arr[top--];
        }
        return val;
    }
}
