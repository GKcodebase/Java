package CheatSheet.CompetitveCoding;

import java.util.ArrayList;
import java.util.List;

/**
 * The Backtracking.
 */
public class Backtracking {

    /**
     * Subsets list.
     *
     * @param nums the nums
     * @return the list
     */
    static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * Backtrack.
     *
     * @param result   the result
     * @param tempList the temp list
     * @param nums     the nums
     * @param start    the start
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {

        int[] backtrackNums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(backtrackNums);
        System.out.println("Backtracking - Subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }

    }
}
