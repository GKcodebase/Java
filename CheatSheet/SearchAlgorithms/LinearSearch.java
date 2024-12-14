package CheatSheet.SearchAlgorithms;

/**
 * The Linear search.
 */
public class LinearSearch {
    /**
     * Is available boolean.
     *
     * @param nums the nums
     * @param t    the t
     * @return the boolean
     */
    public static boolean isAvailable(int[] nums, int t) {
        for (int num : nums) {
            if (t == num)
                return true;
        }
        return false;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] nums = {2, 8, 10, 11, 3, 45, 25, 1, 9};
        System.out.println("Is element available in linear search: " + isAvailable(nums, 10));
    }
}
