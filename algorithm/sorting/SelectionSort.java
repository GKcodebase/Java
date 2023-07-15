package algorithm.sorting;

/**
 * The type Selection sort.
 */
public class SelectionSort {
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
        int l = arr.length;
        int minInd;
        for(int i=0;i<l;i++){
            minInd=obj.findMin(arr,i,l-1);
            int temp = arr[minInd];
            arr[minInd]=arr[i];
            arr[i]=temp;
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
        int arrSize = 10;
        obj.printArray(arr, arrSize);
        sort(arr);
        obj.printArray(arr, arrSize);
    }
}
