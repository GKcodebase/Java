package CheatSheet.Basics;

import java.util.*;

/**
 * The  Sorting and searching.
 */
public class SortingAndSearching {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){

        int[] arr = {3, 1, 4, 2};
        Arrays.sort(arr); // sorts in ascending order
        // Wont work need Integer
        // Arrays.sort(arr, Collections.reverseOrder()); // sorts in descending order

        Integer[] intArray = {39,0,23,4,12,8,5};
        Arrays.sort(intArray,Collections.reverseOrder());
        // Sorting using lambda
        Arrays.sort(intArray,(a,b)->{
            return b-a;
        });
        // Searching in array
        int target = 0;
        int index = Arrays.binarySearch(arr,target);

        //Sorting Collections
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        Collections.sort(list,Collections.reverseOrder()); // Descending

        //Searching in Collections
        list.contains(target);
        Collections.binarySearch(list,target);

        //Searching in HashMap
        HashMap<Strings,Integer> hashMap = new HashMap<>();
        hashMap.containsKey("key");
        hashMap.containsValue(10);
        //Looping in HashMap
        for(Map.Entry<Strings,Integer> entry: hashMap.entrySet()){
            entry.getValue();
            entry.getKey();
        }
        // For looping over key and values
        hashMap.keySet();
        hashMap.values();

        // Sorting Interval using Comparator interface
        int interval [][] = {{1,2},{4,5},{9,10},{4,2}};
        Arrays.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[0];
            }
        });
        // Reverse order using lambda
        Arrays.sort(interval,(a,b)->{
            return b[0]-a[1];
        });
        for (int[] intervalArray : interval) {
            System.out.println(Arrays.toString(intervalArray));
        }
    }
}
