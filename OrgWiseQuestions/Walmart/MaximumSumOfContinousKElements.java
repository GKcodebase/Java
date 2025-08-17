/**
 * The {@code MaximumSumOfContinousKElements} class provides a method to find the maximum sum
 * of any contiguous subarray of length {@code k} within a given integer array.
 * <p>
 * This implementation uses the sliding window technique to efficiently compute the result
 * in linear time.
 * </p>
 *
 * <p>Example usage:</p>
 * <pre>
 * int[] nums = {10, 2, 3, 4, 5};
 * int k = 3;
 * int result = MaximumSumOfContinousKElements.maxSum(nums, k);
 * // result == 12
 * </pre>
 */
public class MaximumSumOfContinousKElements {
    
    public static int maxSum(int[] arr, int k){
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        maxSum = sum;
        for(int i=k;i<arr.length;i++){
            sum+=arr[i] - arr[i-k];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int[] nums = {10, 2, 3, 4, 5};
        int k = 3;
        System.out.println("Maximum sum of " + k + " continuous elements: " + maxSum(nums, k));
    }
}
