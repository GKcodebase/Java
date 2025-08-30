/**
 * The {@code MergeSort} class provides static methods to perform
 * merge sort on an array of integers.
 * <p>
 * Merge sort is a divide-and-conquer sorting algorithm that recursively
 * splits the array into halves, sorts each half, and then merges the sorted
 * halves.
 * </p>
 *
 * <p>
 * Example usage:
 * </p>
 * 
 * <pre>
 * int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
 * MergeSort.mergeSort(arr, 0, arr.length - 1);
 * </pre>
 *
 * <ul>
 * <li>{@link #mergeSort(int[], int, int)} - Recursively sorts the array using
 * merge sort.</li>
 * <li>{@link #merge(int[], int, int, int)} - Merges two sorted subarrays into a
 * single sorted subarray.</li>
 * </ul>
 */
public class MergeSort {
    public static void mergeSort(int arr[], int start, int end) {
        int mid = start + (end - start) / 2;
        if(start>= end) return;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int arr[], int start, int mid, int end) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        while (i <= mid)
            temp[index++] = arr[i++];

        while (j <= end)
            temp[index++] = arr[j++];

        for (i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }
    }

    public static void main(String args[]) {
        int arr[] = { 38, 27, 43, 3, 9, 82, 10 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
