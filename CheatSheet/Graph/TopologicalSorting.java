package CheatSheet.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * The type Topological sorting.
 */
public class TopologicalSorting {

    /**
     * Topological sort util.
     *
     * @param v       the v
     * @param adj     the adj
     * @param visited the visited
     * @param stack   the stack
     */
// Function to perform DFS and topological sorting
    static void topologicalSortUtil(int v, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all adjacent vertices
        for (int i : adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }
        // Push current vertex to stack which stores the
        // result
        stack.push(v);
    }

    /**
     * Topological sort.
     *
     * @param adj the adj
     * @param V   the v
     */
//Topological Sorting
    static void topologicalSort(List<List<Integer>> adj, int V) {

        // Stack to store result
        Stack<Integer> stack = new Stack<>();
        //Visited array to track visited Nodes
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);

        }
        System.out.print(
                "Topological sorting of the graph: ");

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int V = 4;

        // Edges
        List<List<Integer> > edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(3, 2));

        // Graph represented as an adjacency list
        List<List<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }

        topologicalSort(adj, V);
    }
}
