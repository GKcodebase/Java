package datastructure.hashtable;

import java.util.HashMap;

/**
 * The type Two pairs with same sum.
 */
public class TwoPairsWithSameSum {
    /**
     * Find pair string.
     *
     * @param arr the arr
     * @return the string
     */
    public static String findPair(int[] arr) {
        HashMap<Integer, int[]> map = new HashMap<>();
        String result = "";
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new int[]{arr[i], arr[j]});
                else {
                    int prevPair[] = map.get(sum);
                    result += "{" + prevPair[0] + "," + prevPair[1] + "}{" + arr[i] + "," + arr[j] + "}";
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        int[] arr = {3, 4, 7, 1, 12, 9};
        System.out.println(findPair(arr));

    }
}
