package datastructure.hashtable;

import java.util.HashMap;

/**
 * The type Find symmetric.
 */
public class FindSymmetric {

    /**
     * Find symmetric string.
     *
     * @param arr the arr
     * @return the string
     */
    public static String findSymmetric(int[][] arr){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        String result = "";
        for(int i=0;i< arr.length;i++){
            int first = arr[i][0];
            int second = arr[i][1];

            Integer value = hashMap.get(second);
            if(null!= value && value == first){
                result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
            }else {
                hashMap.put(first, second);
            }
        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        int[][] arr = {{1, 2}, {3, 3}, {5, 9}, {4, 2}, {9, 5}};
        String symmetric = findSymmetric(arr);
        System.out.println(symmetric);

    }
}
