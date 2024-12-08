package CheatSheet.DynamicProgramming;

/**
 * The Maximum sum sub array.
 */
public class MaximumSumSubArray {
    /**
     * Gets max sum.
     *
     * @param arr the arr
     * @return the max sum
     */
    static int getMaxSum(int[] arr) {
        int maxSum = 0;
        int maxPreSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int maxtempSum = Math.max(arr[i], arr[i] + maxPreSum);
            maxPreSum = maxtempSum;
            maxSum = Math.max(maxPreSum, maxSum);
        }
        return maxSum;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] subArrayNums = {2, 3, -8, 7, -1, 2, 3};
        System.out.println("Max Subarray Sum: " + getMaxSum(subArrayNums));

    }
}
