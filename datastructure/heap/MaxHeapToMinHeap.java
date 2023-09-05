package datastructure.heap;

import java.util.Arrays;

import static datastructure.heap.MInHeap.buildMinHeap;

/**
 * The type Max heap to min heap.
 */
public class MaxHeapToMinHeap {
    /**
     * Convert max.
     *
     * @param heapArray the heap array
     */
    private static void convertMax(int[] heapArray) {
        buildMinHeap(heapArray);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int[] heapArray = {9, 4, 7, 1, -2, 6, 5};
        System.out.println("Max Heap: " + Arrays.toString(heapArray));
        convertMax(heapArray);
        System.out.println("Min Heap: " + Arrays.toString(heapArray));

    }


}
