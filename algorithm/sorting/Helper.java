package algorithm.sorting;


/**
 * The type Helper.
 */
class Helper {
    /**
     * Print array.
     *
     * @param arr     the arr
     * @param arrSize the arr size
     */
    static void printArray(int[] arr, int arrSize) {
        for (int i = 0; i < arrSize; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /**
     * Find min int.
     *
     * @param arr   the arr
     * @param start the start
     * @param end   the end
     * @return the int
     */
    static int findMin(int[] arr, int start, int end) {
        if (end <= 0 || start < 0)
            return 0;

        int minInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[minInd] > arr[i])
                minInd = i;
        }
        return minInd;
    }

    /**
     * Find max int.
     *
     * @param arr   the arr
     * @param start the start
     * @param end   the end
     * @return the int
     */
    int findMax(int[] arr, int start, int end) {
        if (end <= 0 || start < 0)
            return 0;

        int maxInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[maxInd] < arr[i])
                maxInd = i;
        }
        return maxInd;
    }

    /**
     * Swap.
     *
     * @param array the array
     * @param i     the
     * @param j     the j
     */
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}