package datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;

import static datastructure.graph.DFS.dfs;

/**
 * The type Mother vertex.
 */
public class MotherVertex {
    /**
     * Find mother vertex int.
     *
     * @param graph the graph
     * @return the int
     */
    public static int findMotherVertex(AdjacencyListGraph graph) {
        int vertices = graph.vertices;
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited, false);

        // To store last finished vertex (or mother vertex)
        int lastV = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFS(graph, i, visited);
                lastV = i;
            }
        }

        // If there exist mother vertex (or vetices) in given
        // graph, then lastV must be one (or one of them)

        // Now check if lastV is actually a mother vertex (or graph
        // has a mother vertex). We basically check if every vertex
        // is reachable from lastV or not.

        // Reset all values in visited[] as false and do
        // DFS beginning from lastV to check if all vertices are
        // reachable from it or not.
        Arrays.fill(visited, false);
        DFS(graph, lastV, visited);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        return lastV;

    }

    /**
     * Dfs.
     *
     * @param g       the g
     * @param node    the node
     * @param visited the visited
     */
// A recursive function to print DFS starting from v
    public static void DFS(AdjacencyListGraph g, int node, boolean[] visited) {
        if(node<0)
            return;
        visited[node] = true;
        LinkedList<Integer> temp = null;
        if (g.adjacencyList[node] != null)
            temp = g.adjacencyList[node];

        for (int i = 0; i < temp.size(); i++) {
            if (!visited[temp.get(i)]) {
                visited[temp.get(i)] = true;
                DFS(g, temp.get(i), visited);
            }
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        AdjacencyListGraph g = new AdjacencyListGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 0);
        g.addEdge(3, 1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));

    }
}
