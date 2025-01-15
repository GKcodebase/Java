package CheatSheet.Graph.DirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * The Dfs.
 */
public class DFS {

    /**
     * Add edge.
     *
     * @param adj the adj
     * @param s   the s
     * @param d   the d
     */
    static void addEdge(List<List<Integer>> adj, int s, int d) {
        adj.get(s).add(d);
    }

    /**
     * Dfs.
     *
     * @param adj      the adj
     * @param source   the source
     * @param vertices the vertices
     */
    static void dfs(List<List<Integer>> adj, int source, int vertices) {
        boolean[] visited = new boolean[vertices];
        dfsUtill(adj, visited, source);
    }

    /**
     * Dfs utill.
     *
     * @param adj     the adj
     * @param visited the visited
     * @param source  the source
     */
    private static void dfsUtill(List<List<Integer>> adj, boolean[] visited, int source) {
        System.out.print(source + " ");
        visited[source] = true;
        for (int i : adj.get(source)) {
            if (!visited[i]) {
                dfsUtill(adj, visited, i);
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {
                {1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}
        };

        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        int source = 1;
        System.out.println("DFS from source :: " + source);
        dfs(adj, 1, V);

    }
}
