package CodingPatterns.CyclicSort;

import java.util.ArrayList;
import java.util.List;

import static CodingPatterns.CyclicSort.SortingAnArrayWithNumbersFrom1ToN.cyclicSort;

/**
 * While Cyclic Sort doesn't directly find missing numbers,
 * it can be used to identify potential missing numbers in an array with modifications.
 * If the array contains missing numbers within the range 1 to n,
 * some elements might not be swapped during the sorting process.
 */
public class FindingMissingNumbersInArray {
    /**
     * Find missing numbers list.
     *
     * @param arr the arr
     * @return the list
     */
    public static List<Integer> findMissingNumbers(int arr[]) {
        int i = 0;
        cyclicSort(arr);
        List<Integer> missingIntegers = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                missingIntegers.add(i + 1);
        }
        return missingIntegers;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 6, 7, 8, 9, 10, 12,1,3,5};
        List<Integer> missingNumber = findMissingNumbers(arr);
        System.out.print("Missing Numbers are :: ");
        for (int i : missingNumber) {
            System.out.print(i + " ");
        }
    }
}
