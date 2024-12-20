package CheatSheet.SortingAlgorithm;

/**
 * The Heap sort.
 */
public class HeapSort {

    /**
     * Heap sort.
     *
     * @param arr the arr
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

    }

    /**
     * Heapify.
     *
     * @param arr the arr
     * @param n   the n
     * @param i   the
     */
    public static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (i != largest) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, n, largest);
        }

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arr = {10, 3, 1, 2, 4, 9, 5, 6, 8, 7};
        heapSort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
