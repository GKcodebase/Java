package datastructure.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Find two numbers with given sum.
 */
public class findTwoNumbersWithGivenSum {

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
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {1,21,3,14,5,60,7,6};
        int[] ans =  new findTwoNumbersWithGivenSum().findNumbers(arr,27);
        System.out.print("Output :: ");
        for(int i:ans){
            System.out.print(i+", ");
        }
    }
}
