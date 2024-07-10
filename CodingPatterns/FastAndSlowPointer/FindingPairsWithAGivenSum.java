package CodingPatterns.FastAndSlowPointer;

/**
 * This classic problem involves finding two numbers in a sorted array that add up to a specific target sum.
 * The fast and slow pointers technique can be applied here as well, leveraging the sorted nature of the array.
 */
public class FindingPairsWithAGivenSum {
    /**
     * Find pair int [ ].
     *
     * @param arr    the arr
     * @param target the target
     * @return the int [ ]
     */
    public int[] findPair(int[] arr,int target){
        int left =0;int right = arr.length-1;
        while(left<right){
            int currentSum = arr[left]+arr[right];
            if(currentSum==target)
                return new int[]{arr[left],arr[right]};
            else if(currentSum<target)
                left++;
            else
                right--;
        }
        return new int[]{};
    }
}
