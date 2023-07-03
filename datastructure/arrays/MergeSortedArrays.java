package datastructure.arrays;

/**
 * The type Merge sorted arrays.
 */
public class MergeSortedArrays {

    /**
     * Merge int [ ].
     *
     * @param arr1 the arr 1
     * @param arr2 the arr 2
     * @return the int [ ]
     */
    public int[]  merge(int[] arr1,int[] arr2){
        int l1 = arr1.length;
        int l2 = arr2.length;
        int arr[] = new int[l1+l2];
        int i =0;int j=0; int k=0;
        while(j<l1 && k<l2){
            if(arr1[j]>arr2[k])
                arr[i++] = arr2[k++];
            else
                arr[i++] = arr1[j++];
        }
        while(j<l1)
            arr[i++] = arr1[j++];
        while(k<l2)
            arr[i++] = arr2[k++];
        return arr;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr1 = {1,3,5,7,9,23,56,79};
        int[] arr2 = {2,4,6,38,99,200};
        int[] arr = new MergeSortedArrays().merge(arr1,arr2);
        System.out.print("Output :: ");
        for(int i:arr){
            System.out.print(i+", ");
        }
    }
}
