package datastructure.heap;

import java.util.Arrays;

/**
 * The type M in heap.
 */
public class MInHeap {
    /**
     * Build min heap.
     *
     * @param arr the arr
     */
    public static void buildMinHeap(int[] arr) {
        int heapSize = arr.length;
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            minHeapify(arr, i, heapSize);
        }
    }

    /**
     * Min heapify.
     *
     * @param arr      the arr
     * @param index    the index
     * @param heapSize the heap size
     */
    private static void minHeapify(int[] arr, int index, int heapSize) {
        int smallest = index;
        while (smallest < heapSize / 2) {
            int left = 2 * smallest + 1;
            int right = 2 * smallest + 2;
            if (left < heapSize && arr[left] < arr[index])
                smallest = left;
            if (right < heapSize && arr[right] < arr[smallest])
                smallest = right;
            if (index != smallest) {
                int temp = arr[index];
                arr[index] = arr[smallest];
                arr[smallest] = temp;
                index = smallest;
            } else {
                break;
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] heapArray = {31, 11, 7, 12, 15, 14, 9, 2, 3, 16};

        System.out.println("Before heapify: " + Arrays.toString(heapArray));
        buildMinHeap(heapArray);
        System.out.println("After heapify: " + Arrays.toString(heapArray));

    }
}
