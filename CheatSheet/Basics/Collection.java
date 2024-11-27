package CheatSheet.Basics;

import java.util.*;

/**
 * The Collection.
 */
public class Collection {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        //ArrayList (Dynamic array)
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = 0;
        arrayList.add(10);           // Add element
        arrayList.get(index);        // Get element
        arrayList.remove(index);     // Remove by index
        arrayList.size();            // Get size

        //LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.addFirst(1);         // Add to start
        linkedList.addLast(2);          // Add to end

        //HashSets (No Duplicates Allowed)
        HashSet<Integer> set = new HashSet<>();
        set.add(10);            // Add element
        set.contains(10);       // Check existence
        set.remove(10);      // Remove element

        // TreeSet (Sorted Set)
        TreeSet<Integer> treeSet = new TreeSet<>();
        int element = 100;
        treeSet.first();           // Smallest element
        treeSet.last();            // Largest element
        treeSet.lower(element);    // Strictly smaller
        treeSet.higher(element);   // Strictly larger
        treeSet.contains(element);

        //HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", 10);     // Add key-value
        map.get("key");         // Get value
        map.containsKey("key"); // Check key exists
        map.remove("key"); // Remove entry
        map.getOrDefault("key", 0);

        //TreeMap Sorted Tree map
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        //Priority Queue (Min Heap)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);         // Add element
        priorityQueue.poll();              // Remove & return top
        priorityQueue.peek();              // View top element
        priorityQueue.add(100);

        //Priority Queue (Max Heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //Stack (LIFO)
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.pop();
        stack.peek();
        stack.contains(100);

        //Queue (FIFO)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(100);
        queue.offer(200);
        queue.poll();

    }
}
