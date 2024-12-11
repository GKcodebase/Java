package CheatSheet.CompetitveCoding;

/**
 * The Sliding window pattern.
 */
public class SlidingWindowPattern {
    /**
     * Get max sum array int.
     *
     * @param arr the arr
     * @param k   the k
     * @return the int
     */
    public static  int getMaxSumArray(int arr[] , int k){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i=0;i<arr.length;i++){
            currentSum+=arr[i];

            if(i>=k-1){
                maxSum = Math.max(currentSum,maxSum);
                currentSum-=arr[i-(k-1)];
            }
        }

        return maxSum;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int[] arr = {1, 4, 2, 10, 23, 3, 9, 0, 20};
        System.out.println("Max Subarray Sum (k=3): " + getMaxSumArray(arr, 3));
    }
}
