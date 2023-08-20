package algorithm.sorting.problems;

import java.util.Arrays;

/**
 * The type Merge sorted arrays.
 */
public class MergeSortedArrays {

    /**
     * Median float.
     *
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the float
     */
    public static float median(int[] arr1, int[] arr2) {
        int[] array = merge(arr1, arr2);
        int l = array.length;
        if (l % 2 == 0) {
            float num = ((array[l / 2 - 1] + array[l / 2]));
            return num / 2;
        } else {
            return array[l / 2];
        }
    }

    /**
     * Merge int [ ].
     *
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the int [ ]
     */
    public static int[] merge(int[] arr1, int[] arr2) {

        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] array = new int[l1 + l2];
        int i = 0, j = 0, k = 0;
        while (i < l1 && j < l2) {
            if (arr1[i] < arr2[j]) {
                array[k++] = arr1[i++];
            } else if (arr1[i] == arr2[j]) {
                array[k++] = arr1[i++];
                array[k++] = arr2[j++];
            } else {
                array[k++] = arr2[j++];
            }
        }
        while (j < l2) {
            array[k++] = arr2[j++];
        }
        while (i < l1) {
            array[k++] = arr1[i++];
        }
        return array;
    }

    /**
     * Get median using partition array float.
     *
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the float
     */
    public static float getMedianUsingPartitionArray(int[] arr1, int[] arr2){
        return 0.0F;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int array1[] = {
                4,
                5,
                7,
                10
        };
        int array2[] = {
                12,
                13,
                15,
                18,
                20,
                24
        };

        System.out.println("The median of " + Arrays.toString(array1) + " and " + Arrays.toString(array2) + " is " + median(array1, array2));
        int array3[] = {
                1,
                2,
                3,
                4,
                5
        };
        int array4[] = {
                100,
                200,
                300,
                400
        };

        System.out.println("The median of " + Arrays.toString(array3) + " and " + Arrays.toString(array4) + " is " + median(array3, array4));
    }
}
