/*
 * Given an array of integers nums and two integers k and buffer, 
 * find the maximum sum of any k consecutive elements in the array 
 * such that the difference between the 
 * maximum and minimum elements in the subarray (the range) does not exceed buffer. 
 * Return the maximum sum, or -1 if no such subarray exists.
 */
public class MaximumSumofKConsecutiveElementswithLimitedBuffer {
    public static int maxSum(int[] nums, int k, int buffer){
        int maxSum = Integer.MIN_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
            minNumber = Math.min(nums[i], minNumber);
            maxNumber = Math.max(nums[i], maxNumber);
        }
        if( maxNumber - minNumber <= buffer){
            maxSum = Math.max(sum, maxSum);
        }

        for(int i=k;i<nums.length;i++){
            sum += nums[i] - nums[i-k];
            if(nums[i-k] == minNumber || nums[i-k] == maxNumber){
                maxNumber = Integer.MIN_VALUE;
                minNumber = Integer.MAX_VALUE;
                for( int j=i-k+1;j<=i;j++){
                    minNumber = Math.min(nums[j], minNumber);
                    maxNumber = Math.max(nums[j], maxNumber);
                }
            }
            if( maxNumber - minNumber <= buffer){
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
    public static void main(String args[]){
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int buffer = 2;
        System.out.println("Maximum sum of " + k + " consecutive elements with buffer " + buffer + " : " + maxSum(nums, k, buffer));

        int[] nums2 = {5, 6, 7, 8, 9};
        k = 2;
        buffer = 0;
        System.out.println("Maximum sum of " + k + " consecutive elements with buffer " + buffer + " : " + maxSum(nums2, k, buffer));
    }
}
