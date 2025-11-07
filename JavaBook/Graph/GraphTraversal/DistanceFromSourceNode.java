import java.util.*;

public class DistanceFromSourceNode {
    public static int[] distanceFromSource(int start,List<List<Integer>> graph){
        int n = graph.size();
        int distance[] = new int[n];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        distance[start]=0;
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neig:graph.get(node)){
                if(distance[neig] == -1){
                    distance[neig] = distance[node]+1;
                    queue.add(neig);
                }
            }
        }
        return distance;
    }
    public static void main(String[] args){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<5;i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(0).add(4);                
        graph.get(4).add(0);
        graph.get(1).add(4);
        graph.get(4).add(1);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(2);
        for(int i=0;i<5;i++){   
            System.out.print(i+": ");
            for(int neighbor:graph.get(i)){
                System.out.print(neighbor+" ");
            }
            System.out.println();
        }
        int start = 0;
        int distance[] = distanceFromSource(start,graph);
        System.out.println("Distance from source node "+start+":");
        for(int i=0;i<distance.length;i++){
            System.out.println("Node "+i+" -> Distance: "+distance[i]); 
        }
    }
}
