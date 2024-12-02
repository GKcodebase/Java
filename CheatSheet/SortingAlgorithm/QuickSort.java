package CheatSheet.SortingAlgorithm;

/**
 * The Quick sort.
 */
public class QuickSort {
    /**
     * Quick sort.
     *
     * @param arr  the arr
     * @param low  the low
     * @param high the high
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partition int.
     *
     * @param arr  the arr
     * @param low  the low
     * @param high the high
     * @return the int
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int arr[] = {9,3,1,-2,0,34,5,15};
        quickSort(arr,0,arr.length-1);
        for(int i:arr)
            System.out.print(i+" ");

    }
}
