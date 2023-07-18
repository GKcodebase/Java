package algorithm.sorting;

/**
 * The type Merge sort.
 */
public class MergeSort {

    /**
     * The Obj.
     */
    static Helper obj = new Helper();

    /**
     * Merge sort.
     *
     * @param arr        the arr
     * @param leftIndex  the left index
     * @param rightIndex the right index
     */
    public static void mergeSort(int[] arr, int leftIndex, int rightIndex){
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
     * Merge.
     *
     * @param arr   the arr
     * @param left  the left
     * @param mid   the mid
     * @param right the right
     */
    public static void merge(int arr[], int left, int mid, int right) {
        int i,j,k;
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Initializing temporary arrays
        int leftArr[] = new int[sizeLeft];
        int rightArr[] = new int[sizeRight];

        for (i = 0; i < sizeLeft; i++)
            leftArr[i] = arr[left + i];
        for (j = 0; j < sizeRight; j++)
            rightArr[j] = arr[mid + 1 + j];

        i=0;
        j=0;
        k=left;

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
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
            int[] array = {2,5,1,7,9,45,0,12,69,-30,100,24,-9};
            int arrSize=array.length;
            obj.printArray(array, arrSize);
            mergeSort(array,0,arrSize-1);
            obj.printArray(array, arrSize);

        }
}
