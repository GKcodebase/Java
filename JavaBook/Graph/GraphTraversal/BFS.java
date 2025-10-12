import java.util.List;
import java.util.Queue;

/**
 * Implements Breadth-First Search (BFS) traversal for an undirected graph.
 * <p>
 * The BFS algorithm visits all vertices of a graph in breadthward motion starting from a given node.
 * It uses a queue to keep track of the next vertex to visit and a boolean array to mark visited vertices.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * int vertex = 5;
 * List<Integer>[] adjacencyList = new List[vertex];
 * // ... initialize adjacencyList ...
 * BFS.bfs(0, adjacencyList, vertex);
 * </pre>
 * </p>
 *
 * @param start         the starting vertex for BFS traversal
 * @param adjacencyList the adjacency list representing the graph
 * @param vertex        the total number of vertices in the graph
 */
public class BFS {
    public static void bfs(int start, List<Integer>[] adjacencyList, int vertex) {
        boolean[] visisted = new boolean[vertex];
        Queue<Integer> queue = new java.util.LinkedList<>();
        visisted[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            if (adjacencyList[node] != null) {
                for (int neighbor : adjacencyList[node]) {
                    if (!visisted[neighbor]) {
                        visisted[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        List<Integer>[] adjacencyList = new List[vertex];
        for (int i = 0; i < vertex; i++) {
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
        for (int i = 0; i < 5; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        bfs(0, adjacencyList, vertex);
    }
}
