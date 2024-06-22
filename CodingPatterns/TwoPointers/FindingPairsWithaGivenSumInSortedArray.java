package CodingPatterns.TwoPointers;

/**
 * This problem asks you to find two numbers in a sorted array that add up to a specific target sum.
 */
public class FindingPairsWithaGivenSumInSortedArray {

    /**
     * Two sum.
     *
     * @param sum    the sum
     * @param target the target
     */
    public static void twoSum(int sum[], int target){
        int length = sum.length;
        int left =0; int right = length-1;
        while(left<right){
            int currentSum = sum[left]+sum[right];
            if(target==currentSum){
                System.out.println(sum[left] + " and "+sum[right]);
                return;
            }
            else if(currentSum>target)
                right--;
            else
                left++;
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int sum[] = {1,2,4,5,7,8,9,12,43,56,78};
        twoSum(sum,8);
    }
}
