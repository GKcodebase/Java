package datastructure.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Trace path.
 */
public class TracePath {
    /**
     * Trace path string.
     *
     * @param map the map
     * @return the string
     */
    public static String tracePath(Map<String, String> map) {

        String result = "";

        //Create a reverse Map of given map i.e if given map has (N,C) then reverse map will have (C,N) as key value pair
        //Traverse original map and see if corresponding key exist in reverse Map
        //If it doesn't exist then we found our starting point.
        //After starting point is found, simply trace the complete path from original map.

        HashMap<String, String> reverseMap = new HashMap<>();

        //To fill reverse map, iterate through the given map
        for (Map.Entry<String, String> entry : map.entrySet())
            reverseMap.put(entry.getValue(), entry.getKey());

        //Find the starting point of itinerary
        String from = "";

        //Check if graph is disconnected
        int count = 0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                count++;
                from = entry.getKey();
                //break;
            }
        }

        if (count > 1) {
            return "null"; // Disconnected graph
        }

        //Trace complete path
        String to = map.get(from);

        while (to != null) {
            result += from + "->" + to + ", ";
            from = to;
            to = map.get(to);
        }
        //System.out.println(result);

        return result;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        HashMap<String, String> hMap = new HashMap<>();

        hMap.put("NewYork", "Chicago");
        hMap.put("Boston", "Texas");
        hMap.put("Missouri", "NewYork");
        hMap.put("Texas", "Missouri");

        String actual_output = tracePath(hMap);

        System.out.println(actual_output);
    }
}
