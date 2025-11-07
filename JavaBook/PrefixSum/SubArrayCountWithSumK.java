import java.util.*;
public class SubArrayCountWithSumK {
    public static int countSubArraysWithSumK(int[] arr, int k){
        int count = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int currentPrefixSum = 0;
        prefixSumCount.put(0, 1); // To handle subarrays starting from index
        for(int num : arr){
            currentPrefixSum += num;
            int requiredPefixSum = currentPrefixSum - k;
            if(prefixSumCount.containsKey(requiredPefixSum)){
                count += prefixSumCount.get(requiredPefixSum);
            }
            prefixSumCount.put(currentPrefixSum, prefixSumCount.getOrDefault(currentPrefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {1, 1, 1};
        int k = 2;
        int result = countSubArraysWithSumK(arr, k);
        System.out.println("Count of subarrays with sum " + k + ": " + result);
    }
}
