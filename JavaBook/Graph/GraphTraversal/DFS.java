import java.util.List;

/**
 * The DFS class provides methods to perform Depth-First Search (DFS) traversal on graphs
 * represented using either adjacency lists or adjacency matrices. It includes both recursive
 * and iterative (using stack) implementations.
 *
 * <p>
 * Methods:
 * <ul>
 *   <li>{@link #dfs(int, boolean[], List[])} - Performs recursive DFS traversal on a graph represented by an adjacency list.</li>
 *   <li>{@link #dfsWithStack(int, int, List[])} - Performs iterative DFS traversal using a stack on a graph represented by an adjacency list.</li>
 *   <li>{@link #dfs(int, boolean[], int[][])} - Performs recursive DFS traversal on a graph represented by an adjacency matrix.</li>
 * </ul>
 * </p>
 *
 * <p>
 * The {@code main} method demonstrates the usage of these DFS methods on a sample undirected graph.
 * </p>
 */
public class DFS {
    public static void dfs(int node, boolean[] visited, List<Integer>[] adjacencyList) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adjacencyList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjacencyList);
            }
        }
        System.out.println();
    }

    public static void dfsWithStack(int startNode, int vertices, List<Integer>[] adjacencyList) {
        boolean[] visited = new boolean[vertices];
        java.util.Stack<Integer> st = new java.util.Stack<>();
        st.push(startNode);
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                for (int neighbor : adjacencyList[node]) {
                    if (!visited[neighbor]) {
                        st.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void dfs(int node, boolean[] visited, int[][] adjacencyMatrix) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[node][i] == 1 && !visited[i]) {
                dfs(i, visited, adjacencyMatrix);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Adjacency List representation of the graph
        int vertices = 5;
        List<Integer>[] adjacencyList = new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new java.util.ArrayList<>();
        }
        adjacencyList[0].add(1);
        adjacencyList[1].add(0);
        adjacencyList[0].add(4);
        adjacencyList[4].add(0);
        adjacencyList[1].add(4);
        adjacencyList[4].add(1);
        adjacencyList[1].add(3);
        adjacencyList[3].add(1);
        adjacencyList[1].add(2);
        adjacencyList[2].add(1);
        adjacencyList[2].add(3);
        adjacencyList[3].add(2);
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS Traversal starting from vertex 0:");
        dfs(0, visited, adjacencyList);

        // Adjacency Matrix representation of the graph
        int[][] adjacencyMatrix = new int[vertices][vertices];
        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[1][0] = 1;
        adjacencyMatrix[0][4] = 1;
        adjacencyMatrix[4][0] = 1;
        adjacencyMatrix[1][4] = 1;
        adjacencyMatrix[4][1] = 1;
        adjacencyMatrix[1][3] = 1;
        adjacencyMatrix[3][1] = 1;
        adjacencyMatrix[1][2] = 1;
        adjacencyMatrix[2][1] = 1;
        adjacencyMatrix[2][3] = 1;
        adjacencyMatrix[3][2] = 1;
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        visited = new boolean[vertices];
        System.out.println("DFS Traversal using Adjacency Matrix starting from vertex 0:");
        dfs(0, visited, adjacencyMatrix); // Using adjacencyMatrix for DFS as the function

        // Dfs implementation using stack
        System.out.println("DFS Traversal using Stack starting from vertex 0:");
        dfsWithStack(0, vertices, adjacencyList); // Using adjacencyList for DFS as
    }
}
