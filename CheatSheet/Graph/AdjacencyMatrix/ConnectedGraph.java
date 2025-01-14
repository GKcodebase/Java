package CheatSheet.Graph.AdjacencyMatrix;

/**
 * The Connected graph.
 */
public class ConnectedGraph {

    /**
     * Main.
     *
     * @param arg the arg
     */
    public static void main(String[] arg) {
        int numVertices = 8;

        int[][] graph = new int[numVertices][numVertices];
        graph[0][1] = 1;
        graph[1][0] = 1;

        graph[0][2] = 1;
        graph[2][0] = 1;

        graph[3][4] = 1;
        graph[4][3] = 1;

        graph[5][6] = 1;
        graph[6][5] = 1;

        graph[7][7] = 1;

        findConnectedComponent(numVertices, graph);

    }

    /**
     * Dfs.
     *
     * @param start       the start
     * @param visited     the visited
     * @param graph       the graph
     * @param numVertices the num vertices
     */
    private static void dfs(int start, boolean[] visited, int[][] graph, int numVertices) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 0; i < numVertices; i++) {
            if (graph[start][i] == 1 && !visited[i])
                dfs(i, visited, graph, numVertices);
        }

    }

    /**
     * Find connected component.
     *
     * @param numVertices the num vertices
     * @param graph       the graph
     */
    public static void findConnectedComponent(int numVertices, int[][] graph) {
        boolean[] visited = new boolean[numVertices];
        int componentCount = 0;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                componentCount++;
                System.out.print("Component " + componentCount + ": ");
                dfs(i, visited, graph, numVertices);
                System.out.println();
            }
        }
    }
}
