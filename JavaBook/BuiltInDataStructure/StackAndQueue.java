import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
    public static void main(String args[]) {
        // Stack (LIFO) - backed by Vector, synchronized
        Stack<String> st = new Stack<String>();
        st.push("Hello");           // O(1) - push
        st.push("World");           // O(1) - push
        System.out.println(st.pop()); // O(1) - pop

        st.push("Java");            // O(1) - push
        System.out.println(st.peek()); // O(1) - peek
        System.out.println(st.size()); // O(1) - size
        System.out.println(st.search("Hi")); // O(n) - search
        System.out.println(st.isEmpty()); // O(1) - isEmpty

        // Queue (FIFO) - LinkedList implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(20);                  // O(1) - add
        System.out.println(q.poll()); // O(1) - poll (remove head)
        q.add(30);                  // O(1) - add
        System.out.println(q.peek()); // O(1) - peek (head)
        System.out.println(q.size()); // O(1) - size
        System.out.println(q.isEmpty()); // O(1) - isEmpty

        // Deque (Double-ended queue) - ArrayDeque implementation
        Deque<Integer> dq = new ArrayDeque<>();

        dq.push(20);                // O(1) - push (addFirst)
        System.out.println(dq.peek()); // O(1) - peek (first)

        dq.addFirst(10);            // O(1) - addFirst
        System.out.println(dq.peekLast());  // O(1) - peekLast

        dq.addLast(30);             // O(1) - addLast
        System.out.println(dq.peekFirst()); // O(1) - peekFirst
        System.out.println(dq.peekLast());  // O(1) - peekLast

        dq.removeFirst();           // O(1) - removeFirst
        dq.removeLast();            // O(1) - removeLast
        System.out.println(dq.peek()); // O(1) - peek (first)

        // Priority Queue (min-heap) - PriorityQueue implementation
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);                 // O(log n) - add
        pq.add(20);                 // O(log n) - add
        pq.add(10);                 // O(log n) - add
        System.out.println(pq.poll()); // O(log n) - poll (remove min)
        System.out.println(pq.peek()); // O(1) - peek (min)
        System.out.println(pq.size()); // O(1) - size
        System.out.println(pq.isEmpty()); // O(1) - isEmpty

        for(int i: pq){             // O(n) - iteration (not sorted order)
            System.out.println(i);
        }

    }
}
