package algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Duplicates.
 */
public class Duplicates {
    /**
     * Find duplicates array list.
     *
     * @param arr the arr
     * @return the array list
     */
    public static ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> duplicates = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int arr[] = {
                7,
                5,
                4,
                3,
                5,
                11,
                7,
                11,
                3,
                11
        };
        ArrayList<Integer> dupes = findDuplicates(arr);
        System.out.println("Duplicates in " + Arrays.toString(arr) + " are " + dupes);

        int arr1[] = {
                6,
                5,
                17,
                17
        };
        dupes = findDuplicates(arr1);
        System.out.println("Duplicates in " + Arrays.toString(arr1) + " are " + dupes);
    }
}