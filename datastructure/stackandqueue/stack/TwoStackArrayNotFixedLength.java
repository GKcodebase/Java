package datastructure.stackandqueue.stack;

/**
 * The type Two stack array not fixed length.
 *
 * @param <V> the type parameter
 */
public class TwoStackArrayNotFixedLength <V>{
    private int maxSize;
    private int top1, top2; //Store top value indices of Stack 1 and Stack 2
    private V[] array;

    /**
     * Instantiates a new Two stack array not fixed length.
     *
     * @param max_size the max size
     */
    public TwoStackArrayNotFixedLength(int max_size) {
        this.maxSize = max_size;
        this.top1 = -1;
        this.top2 = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    /**
     * Push 1.
     *
     * @param value the value
     */
//insert at top of first stack
    public void push1(V value) {
        if (top1 < top2 - 1) {
            array[++top1] = value;
        }
    }

    /**
     * Push 2.
     *
     * @param value the value
     */
//insert at top of second stack
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        }
    }

    /**
     * Pop 1 v.
     *
     * @return the v
     */
//remove and return value from top of first stack
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        }
        return null;
    }

    /**
     * Pop 2 v.
     *
     * @return the v
     */
//remove and return value from top of second stack
    public V pop2() {
        if (top2 < maxSize) {
            return array[top2++];
        }
        return null;
    }
}
