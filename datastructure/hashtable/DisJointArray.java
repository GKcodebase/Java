package datastructure.hashtable;

import java.util.HashSet;

/**
 * The type Dis joint array.
 */
public class DisJointArray {
    /**
     * Is dis joint boolean.
     *
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the boolean
     */
    public static boolean isDisJoint(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1)
            set.add(i);
        for (int i : arr2)
            if (set.contains(i)) return false;
        return true;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int arr1[] = {1, 3, 6, 9, 12, 15, 18, 21};
        int arr2[] = {5, 10, 19};
        System.out.println("Is Disjoint :: " + isDisJoint(arr1, arr2));
    }
}
