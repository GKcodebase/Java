package datastructure.hashtable;

import java.util.HashSet;

/**
 * The type Find pair to give sum.
 */
public class FindPairToGiveSum {
    /**
     * Gets pair.
     *
     * @param sum the sum
     * @param arr the arr
     */
    public static void getPair(int sum, int arr[]) {
        HashSet visited = new HashSet();
        for (int i : arr) {
            if (visited.contains(Math.abs(sum - i))) {
                System.out.println("The pair are :: " + i + " and " + Math.abs(sum - i));
                return;
            }
            visited.add(i);
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int n = 99;
        int[] arr = {14, 8, 9, 20, 83, 90, 1, 4, 27, 5};
        getPair(n, arr);
    }
}
