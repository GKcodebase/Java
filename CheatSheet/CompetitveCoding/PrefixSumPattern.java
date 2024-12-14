package CheatSheet.CompetitveCoding;

import java.util.HashMap;
import java.util.Map;

/**
 * The Prefix sum pattern.
 */
public class PrefixSumPattern {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] prefixSumArr = {1, 1, 1};
        int prefixSumTarget = 2;
        System.out.println("Prefix Sum - Sub Array Count: " +
                subArraySum(prefixSumArr, prefixSumTarget));
    }

    /**
     * Sub array sum int.
     *
     * @param prefixSumArr    the prefix sum arr
     * @param prefixSumTarget the prefix sum target
     * @return the int
     */
    private static int subArraySum(int[] prefixSumArr, int prefixSumTarget) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int num : prefixSumArr) {
            sum += num;
            if (sumMap.containsKey(sum - prefixSumTarget)) {
                count += sumMap.get(sum - prefixSumTarget);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
