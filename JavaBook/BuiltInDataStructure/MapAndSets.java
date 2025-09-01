import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapAndSets {
    public static void main(String args[]) {

        // HashSet example - Unordered collection
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(280);
        set.add(30);
        System.out.println(set.contains(20)); // false
        System.out.println(set.size());       // 3
        set.remove(10);                     // O(1) - remove    
        System.out.println(set.size());       // 2

        for(int i: set){                       // O(n) - iteration
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println(" ------------------------------------ ");

        // TreeSet example - ordered collection
        Set<Integer> treeSet =  new TreeSet<>();
        treeSet.add(10);
        treeSet.add(280);
        treeSet.add(30);
        System.out.println(treeSet.contains(20)); // false
        System.out.println(treeSet.size());       // 3
        treeSet.remove(10);                     // O(log n) - remove
        System.out.println(treeSet.size());       // 2

        for(int i: treeSet){                       // O(n) - iteration
            System.out.print(i + " ");
        }

        System.out.println(" ");
     
        //HashMap - unordered collection
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,100);               // O(1) - put
        map.put(10,20);               // O(1) - put
        map.put(3,3);               // O(1) - put
        map.put(42,410);               // O(1) - put
        map.put(5,50);               // O(1) - put

        System.out.println(map.get(3)); // O(1) - get
        map.remove(4);                   // O(1) - remove

        map.putIfAbsent(1, 100);
        map.putIfAbsent(8,300);

        System.out.println(map.get(8)); // O(1) - get
        System.out.println(map.getOrDefault(9, 1000)); // O(1) - getOrDefault

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.println(e.getKey()+ " " + e.getValue());
        }
        System.out.println(" --------- After Sorting Keys----------------- ");
        // Sorting keys of a map
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println(" --------- After Sorting VALUES----------------- ");
        // Sorting values of a map
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        for(int i : map.keySet()){
            System.out.print(i + " ");
        }
        System.out.println("");
        for(int i : map.values()){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println(" ------------------------------------ ");
        //TreeMap - Ordered Collection based on keys
        Map<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,10);
        treeMap.put(2,6);
        treeMap.put(3,0);
        treeMap.put(4,800);
        treeMap.put(5,20);

        System.out.println(treeMap.get(3)); // O(log n) - get
        treeMap.remove(4);                   // O(log n) - remove

        treeMap.putIfAbsent(1, 100);
        treeMap.putIfAbsent(8,300);

        System.out.println(treeMap.get(8)); // O(log n) - get
        System.out.println(treeMap.getOrDefault(9, 1000)); // O(log n) - getOrDefault

        for(Map.Entry<Integer,Integer> e : treeMap.entrySet()){
            System.out.println(e.getKey()+ " " + e.getValue());
        }

        for(int i : treeMap.keySet()){
            System.out.print(i + " ");
        }
        System.out.println("");
        for(int i : treeMap.values()){
            System.out.print(i + " ");
        }

    }
}
