package CheatSheet.Graph;

/**
 * The type Floyd warshall all pairs shortest path.
 */
public class FloydWarshallAllPairsShortestPath {

    /**
     * The constant INF.
     */
    final static int INF = 99999;

    /**
     * Floyd warshall shortest path.
     *
     * @param graph the graph
     * @param V     the v
     */
    static void floydWarshallShortestPath(int[][] graph, int V) {

        int i, j, k;

        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                for (k = 0; k < V; k++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        printSolution(graph);
    }

    /**
     * Print solution.
     *
     * @param dist the dist
     */
    static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println(
                "The following matrix shows the shortest "
                        + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[][] graph = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};

        // Function call
        floydWarshallShortestPath(graph, graph.length);
    }
}
