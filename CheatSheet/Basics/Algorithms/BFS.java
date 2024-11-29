package CheatSheet.Basics.Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The type Bfs.
 */
public class BFS {

    /**
     * Bfs.
     *
     * @param graph the graph
     * @param start the start
     */
    static void bfs(List<List<Integer>> graph,int start){
        int nodes = graph.size();
        boolean visited[] = new boolean[nodes];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            System.out.println(curr+" ");
            for(int neighbour : graph.get(curr)){
                if(!visited[neighbour]){
                    queue.offer(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int edges[][] = {
                {0,1},{0,2},{1,3},{1,4}
        };
        int nodes = 6;

        List<List<Integer>> graph = new ArrayList<>();

        // Initialize the graph with empty lists for each node
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }


        for(int [] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        bfs(graph,0);
    }
}
