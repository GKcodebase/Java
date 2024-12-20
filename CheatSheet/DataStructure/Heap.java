package CheatSheet.DataStructure;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The Heap.
 */
public class Heap {

    /**
     * Get kth largest element int.
     *
     * @param arr the arr
     * @param k   the k
     * @return the int
     */
    public static int getKthLargestElement(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num:arr){
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }

    /**
     * Get kth smallest element int.
     *
     * @param arr the arr
     * @param k   the k
     * @return the int
     */
    public static int getKthSmallestElement(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:arr){
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int arr[] = {10,2,1,4,3,5,6,9,8,7};
        int k = 3;
        System.out.println("Get the "+k+" largest element : "+getKthLargestElement(arr,k));
        System.out.print("Get the "+k+" smallest element : "+getKthSmallestElement(arr,k));

    }
}
