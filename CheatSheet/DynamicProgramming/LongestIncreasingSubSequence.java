package CheatSheet.DynamicProgramming;

import java.util.Arrays;

/**
 * The Longest increasing sub sequence.
 */
public class LongestIncreasingSubSequence {
    /**
     * Get max length int.
     *
     * @param arr the arr
     * @return the int
     */
    public static int getMaxLength(int arr[]){
        if(null == arr || arr.length ==0) return 0;

        int n = arr.length;
        
        int dp[] = new int[n];
        Arrays.fill(dp,1);

        int maxLen =0;
        for(int i =1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            maxLen = Math.max(maxLen,dp[i]);
        }

        return maxLen;


    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int[] lisArray = { 10, 22, 9, 31, 20, 50, 40, 60 };
        System.out.println("LIS Length: " + getMaxLength(lisArray));
    }
}
