/*
 * Given an array arr[] of postive and negative integers, 
 * the objective is to find the number of subarrays having a sum exactly equal to a given number k.
 */

import java.util.*;

public class SubArraysEqualsK {
    public static int countSubArrayWithKSum(int arr[], int k){
        Map<Integer,Integer> map = new HashMap<>();
        int pSum =0;
        int count =0;
        for(int i:arr){
            pSum += i;
            if(pSum == k)count++;
            if(map.containsKey(pSum - k)){
                count += map.get(pSum - k);
            }
            map.put(pSum, map.getOrDefault(pSum, 0) + 1);
        }
        return count;
    }
    public static void main(String args[]){
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println("Number of subarrays with sum " + k + ": " + countSubArrayWithKSum(arr, k));
    }
}
