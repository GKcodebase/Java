package datastructure.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Check first unique.
 */
public class CheckFirstUnique {
    /**
     * Find first occurrence int.
     *
     * @param arr the arr
     * @return the int
     */
    public static int findFirstOccurrence(int arr[]) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for (int i : arr)
            if (1 == map.get(i))
                result = i;
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        int[] arr = {2, 54, 7, 2, 6, 54};
        System.out.println("Array: " + Arrays.toString(arr));
        int unique = findFirstOccurrence(arr);
        System.out.print("First Unique in an Array: " + unique);

    }
}
