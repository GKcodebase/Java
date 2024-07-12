package CodingPatterns.CyclicSort;

/**
 * This is the most common application of Cyclic Sort.
 * Given an unsorted array containing distinct integers from 1 to n (where n is the array length),
 * Cyclic Sort rearranges the elements such that each element is at its correct index (i - 1).
 */
public class SortingAnArrayWithNumbersFrom1ToN {
    /**
     * Swap.
     *
     * @param arr the arr
     * @param i   the
     * @param j   the j
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Cyclic sort.
     *
     * @param arr the arr
     */
    public static void cyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if(arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }else{
                i++;
            }
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int arr[] = {9,10,2,3,1,4,8,7,6,5};
         cyclicSort(arr);
         for(int i : arr){
             System.out.print(i+" ");
         }
    }
}
