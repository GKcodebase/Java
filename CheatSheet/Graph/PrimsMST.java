package CheatSheet.Graph;

import java.util.Arrays;

/**
 * The Prims mst.
 */
public class PrimsMST {
    /**
     * Min key int.
     *
     * @param key     the key
     * @param visited the visited
     * @return the int
     */
    static int minKey(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < key.length; v++) {
            if (!visited[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    /**
     * Prim mst.
     *
     * @param graph the graph
     * @param V     the v
     */
    static void primMST(int[][] graph, int V) {

        int[] parent = new int[V];

        int[] key = new int[V];

        boolean[] visited = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, visited);

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v]
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }

    /**
     * Print mst.
     *
     * @param parent the parent
     * @param graph  the graph
     */
    static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                    + graph[i][parent[i]]);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int V = 5;
        int[][] graph = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}};

        primMST(graph, V);
    }
}
