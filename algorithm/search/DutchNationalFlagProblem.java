package algorithm.search;


import java.util.Arrays;

/**
 * The type Dutch national flag problem.
 */
public class DutchNationalFlagProblem {

    /**
     * Swap int [ ].
     *
     * @param arr the arr
     * @return the int [ ]
     */
    public static int[] swap(int[] arr){
        int l =arr.length;
        int i =0,j=l-1,mid=0;
        int temp;
        while(mid<=j){
            if(arr[mid]==0){
                temp=arr[mid];
                arr[mid++]=arr[i];
                arr[i++]=temp;
            }
            else if(arr[mid]==2){
                temp=arr[mid];
                arr[mid]=arr[j];
                arr[j--]=temp;
            }
            else
                mid++;
        }
        return arr;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        int[] arr = {0,2, 0, 0, 1, 2, 1};
        swap(arr);
        System.out.println(Arrays.toString(arr)); // import java.util.Arrays; for this functionality
    }
}
