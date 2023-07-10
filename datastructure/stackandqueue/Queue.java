package datastructure.stackandqueue;

/**
 * The type Queue.
 *
 * @param <V> the type parameter
 */
public class Queue <V>{
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    /**
     * Instantiates a new Queue.
     *
     * @param maxSize the max size
     */
    public  Queue(int maxSize){
        this.maxSize=maxSize;
        array = (V[]) new Object[maxSize];
        front =0;
        back =-1;
        currentSize =0;
    }

    /**
     * Get current size int.
     *
     * @return the int
     */
    public int getCurrentSize(){
        return currentSize;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty(){
        return currentSize==0;
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull(){
        return currentSize == maxSize;
    }

    /**
     * Top v.
     *
     * @return the v
     */
    public V top(){
        return array[front];
    }

    /**
     * Enqueue.
     *
     * @param value the value
     */
    public void enqueue(V value){
        if(isFull())
            return;
        back = (back+1)%maxSize;
        array[back] = value;
        currentSize++;
    }

    /**
     * Dequeue v.
     *
     * @return the v
     */
    public V dequeue(){
        if (isEmpty())
            return null;

        V temp = array[front];
        front = (front + 1) % maxSize; //to keep the index in range
        currentSize--;

        return temp;
    }
}
