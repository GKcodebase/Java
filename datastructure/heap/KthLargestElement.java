package datastructure.heap;

import static datastructure.heap.MaxHeap.buildHeap;

/**
 * The type Kth largest element.
 */
public class KthLargestElement {

    /**
     * Find k largest int.
     *
     * @param input the input
     * @param k     the k
     * @return the int
     */
    private static int findKLargest(int[] input, int k) {
        int heapSize = input.length;
        if(k<=heapSize){
            int result[] = new int[k];
            for(int i=0;i<k;i++){
                result[i] = findUsingHeap(input,heapSize);
            }
            return result[k-1];
        }
        return -1;
    }

    /**
     * Find using heap int.
     *
     * @param input    the input
     * @param heapSize the heap size
     * @return the int
     */
    private static int findUsingHeap(int[] input, int heapSize) {
        buildHeap(input,heapSize);
        int max = input[0];
        input[0] = input[heapSize-1];
        return max;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int k =2;
        int output = findKLargest(input, k);
        System.out.println(k+" largest element :: "+output);
    }
    

}
