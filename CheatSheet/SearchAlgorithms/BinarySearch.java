package CheatSheet.SearchAlgorithms;

/**
 * The Binary search.
 */
public class BinarySearch {
    /**
     * Binary search boolean.
     *
     * @param nums   the nums
     * @param target the target
     * @return the boolean
     */
    public static boolean binarySearch(int nums[], int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;
            else if (target < nums[mid]) {
                end = mid - 1;
            } else
                start = mid + 1;

        }
        return false;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 16, 20, 300};
        System.out.println("Is target available :: " + binarySearch(nums, 9));
    }
}
