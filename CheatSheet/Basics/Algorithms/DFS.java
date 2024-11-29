package CheatSheet.Basics.Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * The Dfs.
 */
public class DFS {
    /**
     * Dfs.
     *
     * @param graph the graph
     */
    static void dfs(List<List<Integer>> graph){
        int nodes = graph.size();
        boolean visited[] = new boolean[nodes];

        dfUtil(graph,visited,0);
    }

    /**
     * Df util.
     *
     * @param graph   the graph
     * @param visited the visited
     * @param node    the node
     */
    static void dfUtil(List<List<Integer>> graph, boolean visited[], int node){
        visited[node] = true;
        System.out.println(node+" ");

        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfUtil(graph,visited,neighbour);
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
                {0,1},{0,2},{1,3},{1,4},{2,5}
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
        dfs(graph);

    }
}
