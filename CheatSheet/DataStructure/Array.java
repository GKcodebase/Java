package CheatSheet.DataStructure;

import java.util.HashSet;

/**
 * The Array.
 */
public class Array {
    /**
     * Two sum problem int [ ].
     *
     * @param nums   the nums
     * @param target the target
     * @return the int [ ]
     */
//Get the pair of elements with given sum
    public static int[] twoSumProblem(int nums[], int target){
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(target-num))
                return new int[]{num,target-num};
            set.add(num);
        }
        return new int[]{-1,-1};
    }

    /**
     * Maximum sub array int.
     *
     * @param arr the arr
     * @return the int
     */
    public static int maximumSubArray(int arr[]){
        int maxSum = arr[0];
        int currSum = arr[0];
        for(int i =1;i<arr.length; i++){
            currSum = Math.max(arr[i],currSum+arr[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    /**
     * Rotate array.
     *
     * @param arr the arr
     * @param k   the k
     */
    public static void rotateArray(int arr[], int k){
        int l = arr.length;
        k%= l;
        reverse(arr,0,l-1);
        reverse(arr,0,k-1);
        reverse(arr,k,l-1);
    }

    /**
     * Reverse.
     *
     * @param nums  the nums
     * @param start the start
     * @param end   the end
     */
    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        //Two Sum
        int arr[] = {4,5,12,9,10,23,19};
        int target = 14;
        int res[] = twoSumProblem(arr,target);
        System.out.println("Array is having two sum pair :: " +arr[0]+", "+arr[1]);


        //Maximum Sum Sub Array
        int nums[] = {-10,0,4,-1,9,8,-100,10};
        System.out.println("Maximum sum of sub array is :: " +String.valueOf(maximumSubArray(nums)));


        // Rotating array
        int array[] = {1,2,3,4,5,6,7,8,9,10};
        rotateArray(array,5);
        System.out.println("Rotated Array :");
        for(int num:array)
            System.out.print(num+" ");


    }
}
