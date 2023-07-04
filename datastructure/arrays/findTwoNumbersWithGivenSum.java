package datastructure.arrays;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

/**
 * The type Find two numbers with given sum.
 */
public class FindTwoNumbersWithGivenSum {

    /**
     * Find numbers int [ ].
     *
     * @param arr the arr
     * @param n   the n
     * @return the int [ ]
     */
    public int[] findNumbers(int[] arr, int n){
        int[] result = new int[2];
        int l = arr.length;
        Map intMap = new HashMap();
        for(int i : arr){
                intMap.putIfAbsent(i,1);
                if(null != intMap.get(Math.abs(n-i))){
                    result[0] = i;
                    result[1] = n-i;
                    return result;
                }
        }
        return result;
    }

    /**
     * Quick sort and find sum int [ ].
     *
     * @param arr the arr
     * @param n   the n
     * @return the int [ ]
     */
    public int[] quickSortAndFindSum(int[] arr , int n){
        //Helper sort function that uses the Quicksort Algorithm
        sort(arr,0,arr.length-1);

        int Pointer1 = 0;    //Pointer 1 -> At Start
        int Pointer2 = arr.length - 1;   //Pointer 2 -> At End
        int[] result = new int[2];
        int sum = 0;

        while (Pointer1 != Pointer2) {

            sum = arr[Pointer1] + arr[Pointer2];  //Calulate Sum of Pointer 1 and 2

            if (sum < n)
                Pointer1++;  //if sum is less than given value => Move Pointer 1 to Right
            else if (sum > n)
                Pointer2--;
            else {
                result[0] = arr[Pointer1];
                result[1] = arr[Pointer2];
                return result; // containing 2 number
            }
        }
        return arr;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {1,21,3,14,5,60,7,6};
        int[] ans =  new FindTwoNumbersWithGivenSum().findNumbers(arr,27);
        System.out.print("Output :: ");
        for(int i:ans){
            System.out.print(i+", ");
        }


        int[] ans2 =  new FindTwoNumbersWithGivenSum().quickSortAndFindSum(arr,27);
        System.out.print("\n"+"Solution with QuickSort :: ");
        for(int i:ans2){
            System.out.print(i+", ");
        }
    }
}
