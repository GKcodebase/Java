package algorithm.sorting;

/**
 * The type Insertion sort.
 */
public class InsertionSort {
    /**
     * The Obj.
     */
    static Helper obj = new Helper();

    /**
     * Sort int [ ].
     *
     * @param arr the arr
     * @return the int [ ]
     */
    public static int[] sort(int[] arr){
        int arrSize=arr.length;
        int ele, j;
        //Traverse through 1 to size of the array
        for (int i = 1; i < arrSize; i++) {
            ele = arr[i]; // Element to be inserted
            j = i - 1;

            //shifts elements back to create space for the element to be inserted
            while (j >= 0 && arr[j] > ele) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = ele;
        }
        return arr;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        obj.printArray(arr, arr.length);
        sort(arr);
        obj.printArray(arr, arr.length);
    }
}
