/**
 * The {@code MergeSortedArray} class provides a method to merge two sorted integer arrays
 * into a single sorted array. The merged result is printed to the standard output.
 *
 * <p>
 * Example usage:
 * <pre>
 * int[] nums1 = {1, 3, 5, 7};
 * int[] nums2 = {2, 4, 6, 8};
 * MergeSortedArray.merge(nums1, nums2);
 * // Output: 1 2 3 4 5 6 7 8
 * </pre>
 * </p>
 *
 * <p>
 * The merging is performed in descending order from the end of both arrays,
 * and the result is stored in a new array before being printed.
 * </p>
 *
 * <p>
 * Note: The original arrays {@code nums1} and {@code nums2} are not modified.
 * </p>
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int[] nums2) {
        int l1 = nums1.length - 1;
        int l2 = nums2.length - 1;
        int i = nums1.length + nums2.length - 1;
        int[] result = new int[i + 1];
        while (l1 >= 0 && l2 >= 0 && i >= 0) {
            if (nums1[l1] > nums2[l2]) {
                result[i--] = nums1[l1--];
            } else {
                result[i--] = nums2[l2--];
            }
        }
        while (l1 >= 0) {
            result[i--] = nums1[l1--];
        }
        while (l2 >= 0) {
            result[i--] = nums2[l2--];
        }
        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j] + " ");
        }

    }

    public static void main(String args[]) {
        int[] nums1 = { 1, 3, 5, 7 };
        int[] nums2 = { 2, 4, 6, 8 };
        merge(nums1, nums2);
    }
}
