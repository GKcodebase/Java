package algorithm.search;

/**
 * The type Insert index in sorted array.
 */
public class InsertIndexInSortedArray {
    /**
     * Insert position int.
     *
     * @param arr    the arr
     * @param target the target
     * @return the int
     */
    public static int insertPosition(int[] arr, int target) {
        int arrSize = arr.length;
        int start = 0, end = arrSize - 1;
        int mid = 0, pos = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return target;
            //if mid value greater than target serach in the left half
            else if (arr[mid] > target) {
                end = mid - 1;
                pos = mid;
            }
            //otherwise search in the right half
            else {
                start = mid + 1;
                pos = mid + 1;
            }
        }
        return pos;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        int[]arr = {0, 1, 2, 3, 5, 6};

        // Example 1
        System.out.println("Index to Insert " + "\"5\" is " + insertPosition(arr, 5));

        // Example 2
        System.out.println("Index to Insert " + "\"3\" is " + insertPosition(arr, 3));

        // Example 3
        System.out.println("Index to Insert " + "\"7\" is " + insertPosition(arr, 7));
    }
}
