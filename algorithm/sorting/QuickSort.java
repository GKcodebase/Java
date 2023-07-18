package algorithm.sorting;

import java.util.Random;

/**
 * The type Quick sort.
 */
public class QuickSort {
    /**
     * The Obj.
     */
    static Helper obj = new Helper();

    /**
     * Sort.
     *
     * @param arr   the arr
     * @param left  the left
     * @param right the right
     */
    public static void sort(int[] arr , int left , int right){
        if(left<right){
            int pi = partition(arr,left,right);
            sort(arr, left, pi - 1);
            sort(arr, pi + 1, right);
        }
    }

    /**
     * Partition int.
     *
     * @param arr   the arr
     * @param left  the left
     * @param right the right
     * @return the int
     */
    public static int partition(int[] arr, int left, int right){
        int pivotInd = choosePivot(left,right);
        obj.swap(arr, right, pivotInd);
        int pivot = arr[right]; // Pivot
        int i = (left - 1); // All the elements less than or equal to the
        // pivot go before or at i
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivot) {
                i++; // increment the index
                obj.swap(arr, i, j);
            }
        }
        obj.swap(arr, i + 1, right); // Putting the pivot back in place
        return (i + 1);
    }

    /**
     * Choose pivot int.
     *
     * @param left  the left
     * @param right the right
     * @return the int
     */
    public static int choosePivot(int left, int right) {
        Random rand = new Random();
        // Pick 3 random numbers within the range of the array
        int i1 = left + (rand.nextInt(right - left + 1));
        int i2 = left + (rand.nextInt(right - left + 1));
        int i3 = left + (rand.nextInt(right - left + 1));

        // Return their median
        return Math.max(Math.min(i1, i2), Math.min(Math.max(i1, i2), i3));
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] array = {2,5,1,7,9,45,0,12,69,-30,100,24,-9};
        int arrSize=array.length;
        obj.printArray(array, arrSize);
        sort(array,0,arrSize-1);
        obj.printArray(array, arrSize);
    }
}
