package algorithm.sorting;

/**
 * The type Merge.
 */
class Merge {
    /**
     * Merge.
     *
     * @param arr   the arr
     * @param left  the left
     * @param mid   the mid
     * @param right the right
     */
    public static void merge(int arr[], int left, int mid, int right) {
        int i, j, k;

        // Initialzing the sizes of the temporary arrays
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Initializing temporary arrays
        int leftArr[] = new int[sizeLeft];
        int rightArr[] = new int[sizeRight];

        // Copying the given array into the temporary arrays
        for (i = 0; i < sizeLeft; i++)
            leftArr[i] = arr[left + i];
        for (j = 0; j < sizeRight; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Merging the temporary arrays back into the given array
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = left; // Initial index of the given array

        // This is the main part of the algorithm
        // Iterate over both arrays and copy the element that is smaller to the
        // given array.
        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copying the remaining elements of leftArr[], if there are any
        while (i < sizeLeft) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArr[], if there are any
        while (j < sizeRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Merge sort.
     *
     * @param arr        the arr
     * @param leftIndex  the left index
     * @param rightIndex the right index
     */
    public static void mergeSort(int arr[], int leftIndex, int rightIndex) {
        // Sanity checks
        if (leftIndex < 0 || rightIndex < 0)
            return;

        if (rightIndex > leftIndex) {
            // Equivalent to (leftIndex+rightIndex)/2, but avoids overflow
            int mid = leftIndex + (rightIndex - leftIndex) / 2;

            // Sorting the first and second halves of the array
            mergeSort(arr, leftIndex, mid);
            mergeSort(arr, mid + 1, rightIndex);

            // Merging the array
            merge(arr, leftIndex, mid, rightIndex);
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        Helper obj = new Helper();
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        obj.printArray(arr, arrSize);
        mergeSort(arr, 0, arrSize - 1);
        obj.printArray(arr, arrSize);
    }
}