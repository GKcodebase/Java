package algorithm.search;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Two number with given sum.
 */
public class TwoNumberWithGivenSum {
    /**
     * Two numbers int [ ].
     *
     * @param arr the arr
     * @param sum the sum
     * @return the int [ ]
     */
    public static int[] twoNumbers(int[] arr, int sum){
        int[] ans = new int[2];
        Map map = new HashMap();
        int l = arr.length;
        for(int i=0;i<l;i++){
            map.put(arr[i],1);
            if(null != map.get(sum-arr[i])){
                ans[0] = arr[i];
                ans[1] = sum - arr[i];
                return ans;
            }
        }
        return ans;
    }

    /**
     * Quick sort and binary search int [ ].
     *
     * @param arr the arr
     * @param sum the sum
     * @return the int [ ]
     */
    public static int[] quickSortAndBinarySearch(int[] arr, int sum){
        int[] ans = new int[2];
        return ans;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr =  {1,21,3,14,5,60,7,6};
        int sum = 81;
        int[] ans  =  twoNumbers(arr,sum);
        System.out.println("The two numbers are :: "+ans[1]+" and "+ans[0]);
    }
}
