package algorithm.search;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Count occurrence.
 */
public class countOccurrence {
    /**
     * Count int.
     *
     * @param arr the arr
     * @param key the key
     * @return the int
     */
    public static int count(int[] arr , int key){
        Map<Integer,Integer> map = new HashMap();
        for(int i =0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        return map.get(key);
    }

    /**
     * Get frequency int.
     *
     * @param arr the arr
     * @param key the key
     * @return the int
     */
    public static int getFrequency(int[] arr,int key){
        int arrSize =arr.length;
        int start =0, end = arrSize-1, mid , result =-1;
        //Modify binary search to find left occurrence
        while(start<end){
            mid = (start + end) / 2;
            if(arr[mid]==key){
                result = mid;
                end = mid-1;
            }else if(arr[mid]>key){
                end = mid-1;
            }else if(arr[mid]<key){
                start=mid+1;
            }
        }

        //Modify binary search to find ri8 occurrence
        int start1 = 0, end1 = arrSize - 1, mid1, result1 = -1;
        while (start1 <= end1) {
            mid1 = (start1 + end1) / 2;
            if (arr[mid1] == key) {
                result1 = mid1;
                start1 = mid1 + 1;
            } else if (arr[mid1] > key) {
                end1 = mid1 - 1;
            } else if (arr[mid1] < key) {
                start1 = mid1 + 1;
            }
        }

        //Get difference of ri8 and left
        if (result == -1 || result1 == -1)
            return (result1 - result);

        return (result1 - result + 1);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int arr[] = {-5,-3,0,1,3,3,3,3,4,5};
        int key = 3;
        System.out.println("The key \""+ key + "\" occurs " + getFrequency(arr, key) + " times in the Array.");
    }
}
