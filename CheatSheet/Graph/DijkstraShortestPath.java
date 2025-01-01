package CheatSheet.Graph;

import java.util.Arrays;

import static CheatSheet.Graph.DijkstraShortestPath.Graph.V;
import static CheatSheet.Graph.DijkstraShortestPath.Graph.shortestPath;

/**
 * The Dijkstra shortest path.
 */
public class DijkstraShortestPath {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[][] graph
                = new int[][]
                {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        // Function call
        V = graph.length;
        int[] dist = shortestPath(graph, 0);
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " " + dist[i]);
    }

    /**
     * The type Graph.
     */
    static class Graph {

        /**
         * The constant V.
         */
        public static int V;

        /**
         * Shortest path int [ ].
         *
         * @param graph the graph
         * @param src   the src
         * @return the int [ ]
         */
        static int[] shortestPath(int[][] graph, int src) {
            int[] dist = new int[V];
            boolean[] visited = new boolean[V];

            // Initialize all distances as INFINITE
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(visited, false);

            // Distance of source to itself is always 0
            dist[src] = 0;

            // Find the shortest path for all vertices
            for (int count = 0; count < V - 1; count++) {
                // Pick the minimum distance vertex from the set of vertices not yet processed.

                // u is always equal to src in first iteration.

                int u = minDistance(dist, visited);
                visited[u] = true;
                // Update dist value of the adjacent vertices of the picked vertex.
                for (int v = 0; v < V; v++) {
                    // Update dist[v] only if is not in sptSet, there is an edge from u to v, and total weight of path from
                    // src to v through u is smaller than current value of dist[v]
                    if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
//                        System.out.println(u+ " -  " + v + " "+dist[v]);
                    }
                }

            }

            return dist;

        }

        /**
         * Min distance int.
         *
         * @param dist    the dist
         * @param septSet the sept set
         * @return the int
         */
// Utility method to find the vertex with minimum distance value
        static int minDistance(int[] dist, boolean[] septSet) {
            int min = Integer.MAX_VALUE, min_index = -1;
            for (int v = 0; v < V; v++) {
                if (!septSet[v] && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }
            }
            return min_index;
        }
    }
}
