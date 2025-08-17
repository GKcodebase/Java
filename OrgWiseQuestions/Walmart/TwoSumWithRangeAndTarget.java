/*
 * Given an array of integers nums and two integers target and range, 
 * find all pairs of indices (i, j) (where i < j) 
 * such that the sum of the elements at those indices is within the range [target - range, target + range]. 
 * Return the list of all such index pairs.
 *  
 */

import java.util.*;

public class TwoSumWithRangeAndTarget {

    public static List<int[]> findPairs(int[] nums, int target, int range) {
        int lowerBound = target - range;
        int upperBound = target + range;

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= lowerBound && sum <= upperBound) {
                    result.add(new int[] { i, j });
                }
            }
        }
        return result;
    }

    public static List<int[]> findPairsMap(int nums[], int target, int range) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int lowerBound = target - range - nums[i];
            int upperBound = target + range - nums[i];
            for (int j = lowerBound; j <= upperBound; j++) {
                if (map.containsKey(j) && map.get(j) > i) {
                    result.add(new int[] { i, map.get(j) });
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int target = 10;
        int range = 2;
        List<int[]> pairs = findPairsMap(nums, target, range);
        for (int[] pair : pairs) {
            System.out.println("Pair found: (" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
