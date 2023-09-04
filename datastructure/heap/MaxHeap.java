package datastructure.heap;

import java.util.Arrays;

/**
 * The type Max heap.
 */
public class MaxHeap {

    /**
     * Build heap.
     *
     * @param heapArray the heap array
     * @param heapSize  the heap size
     */
    public static void buildHeap(int [] heapArray,int heapSize){
        for(int i=(heapSize-1)/2;i>=0;i--){
            maxHeapify(heapArray,i,heapSize);
        }
    }

    /**
     * Max heapify.
     *
     * @param heapArray the heap array
     * @param index     the index
     * @param heapSize  the heap size
     */
    private static void maxHeapify(int[] heapArray, int index, int heapSize) {
        int largest = index;
        while(largest<heapSize/2){
            int left = 2*largest+1;
            int right = 2*largest+2;
            if (left < heapSize && heapArray[left] > heapArray[index]){
                largest = left;
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]){
                largest = right;
            }
            if (largest != index){ // swap parent with the largest child
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            }
            else
                break; // if heap property is satisfied
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
        buildHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));
    }
}
