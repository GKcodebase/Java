import java.util.*;

/**
 * DisjointedGraphTraversal
 *
 * Utility class that demonstrates traversal algorithms (DFS and BFS) for a graph
 * that may consist of multiple disjoint components. The graph is represented as
 * an adjacency list: a List<List<Integer>> where each index represents a node
 * (0..n-1) and the inner lists contain neighboring node indices.
 *
 * Notes and conventions:
 * - The class methods print traversal order to standard output.
 * - The graph is treated as an undirected graph in the example usage, but the
 *   traversal code itself works for any directed/undirected adjacency-list
 *   representation.
 * - All methods expect a non-null List<List<Integer>> of size n. Each inner
 *   list may be empty when a node has no neighbors.
 *
 * Public methods:
 * - dfs(boolean[] visited, List<List<Integer>> graph)
 *     Performs a complete depth-first traversal over all nodes in the graph,
 *     visiting each connected component starting from the smallest unvisited
 *     index. This method uses the recursive helper dfsUtil to visit nodes in a
 *     component. The provided visited array is mutated to record visited nodes.
 *
 *     @param visited boolean array of length >= graph.size(); visited[i] is true
 *                    when node i has already been visited. The array is
 *                    modified by the method.
 *     @param graph   adjacency list representation of the graph
 *
 * - getCountOfComponents(boolean[] visited, List<List<Integer>> graph)
 *     Traverses the graph and counts the number of connected components. Each
 *     time an unvisited node is found, it starts a DFS (via dfsUtil) to mark all
 *     nodes in that component. The method prints each visited node (as a side
 *     effect) and prints the final count of connected components.
 *
 *     @param visited boolean array to track visited nodes; this array is
 *                    modified by the method.
 *     @param graph   adjacency list representation of the graph
 *
 * - bfs(boolean[] visited, List<List<Integer>> graph)
 *     Performs a complete breadth-first traversal over all nodes in the graph.
 *     Note: this implementation reinitializes the visited array internally to a
 *     new boolean[graph.size()], so the visited parameter passed in by the
 *     caller is effectively ignored. The method prints nodes in BFS order.
 *
 *     @param visited boolean array (ignored and overwritten in current
 *                    implementation)
 *     @param graph   adjacency list representation of the graph
 *
 * - main(String[] args)
 *     Example/demo entry point that builds a small disjoint graph, prints the
 *     adjacency lists, and demonstrates DFS-based component counting and BFS
 *     traversal.
 *
 * Helper (private) method:
 * - dfsUtil(int node, boolean[] visited, List<List<Integer>> graph)
 *     Recursive helper that performs the standard DFS visit for a single
 *     connected component, printing nodes as they are discovered.
 *
 *     @param node    index of the start node to visit
 *     @param visited boolean array that is updated as nodes are visited
 *     @param graph   adjacency list representation of the graph
 *
 * Complexity:
 * - Time: O(V + E) for full traversal of the graph (V = number of nodes,
 *         E = number of edges) for both DFS and BFS.
 * - Space: O(V) for the visited array; DFS additionally uses recursion stack
 *          space up to O(V) in the worst case.
 *
 * Usage hints:
 * - If you want the bfs method to respect an externally-provided visited array,
 *   remove the internal reinitialization (visited = new boolean[graph.size()]).
 * - To adapt for 1-based node indices or non-integer node labels, map labels to
 *   contiguous integer indices before constructing the adjacency list.
 */
public class DisjointedGraphTraversal {

    public static void dfs(boolean visited[], List<List<Integer>> graph) {
        // Connected components traversal
        // for(List<Integer> neigbhour : graph){
        // for(int node: neigbhour){
        // if(!visited[node]){
        // visited[node] = true;
        // System.out.print(node+" ");
        // dfs(visited, graph);
        // }
        // }
        // }
        // Complete traversal of disjointed graph
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfsUtil(i, visited, graph);
            }
        }
    }

    private static void dfsUtil(int node, boolean visited[], List<List<Integer>> graph) {
        System.out.print(node + " ");
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited, graph);
            }
        }
    }

    public static void getCountOfComponents(boolean visited[], List<List<Integer>> graph) {
        int count = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                count++;
                dfsUtil(i, visited, graph);
            }
        }
        System.out.println("\nNumber of connected components: " + count);
    }

    public static void bfs(boolean visited[], List<List<Integer>> graph) {
        visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    System.out.print(node + " ");
                    for (int neighbor : graph.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> disjointedGraph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            disjointedGraph.add(new ArrayList<>());
        }
        disjointedGraph.get(0).add(1);
        disjointedGraph.get(1).add(0);
        disjointedGraph.get(0).add(4);
        disjointedGraph.get(4).add(0);

        disjointedGraph.get(1).add(4);
        disjointedGraph.get(4).add(1);
        disjointedGraph.get(1).add(3);
        disjointedGraph.get(3).add(1);
        for (int i = 0; i < 5; i++) {
            System.out.print(i + ": ");
            for (int neighbor : disjointedGraph.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        boolean visited[] = new boolean[5];
        System.out.println("DFS Traversal of Disjointed Graph:");
        // dfs(visited, disjointedGraph);
        visited = new boolean[5];
        getCountOfComponents(visited, disjointedGraph);
        System.out.println("BFS Traversal of Disjointed Graph:");
        bfs(visited, disjointedGraph);

    }
}
