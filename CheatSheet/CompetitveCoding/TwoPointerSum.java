package CheatSheet.CompetitveCoding;

import java.util.Arrays;

/**
 * The Two pointer sum.
 */
public class TwoPointerSum {
    /**
     * Two sum int [ ].
     *
     * @param arr    the arr
     * @param target the target
     * @return the int [ ]
     */
    static int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int tempSum = arr[left] + arr[right];
            if (tempSum == target) {
                return new int[]{left, right};
            } else if (tempSum > target)
                right--;
            else
                left++;
        }


        return new int[]{-1, -1};
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] twoPointerArr = {2, 7, 11, 15};
        int twoPointerTarget = 9;
        int[] twoSumResult = twoSum(twoPointerArr, twoPointerTarget);
        System.out.println("Two Pointers - Two Sum: " +
                Arrays.toString(twoSumResult));

    }
}
