package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Bfs.
 */
public class BFS {
    /**
     * Bfs string.
     *
     * @param graph the graph
     * @return the string
     */
    public static String bfs(Graph graph) {
        int vertices = graph.getVertices();
        boolean[] visited = new boolean[vertices];
        String result = "";
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                result += vistGraph(graph, i, visited);
            }
        }
        return result;
    }

    private static String vistGraph(Graph graph, int source, boolean[] visited) {
        String result = "";
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNod = queue.remove();
            result += String.valueOf(currentNod);

            LinkedList<Integer> temp = null;
            if (graph.getAdj()[source] != null) {
                temp = graph.getAdj()[source];
            }

            for (int i = 0; i < temp.size(); i++) {
                if (!visited[temp.get(i)]) {
                    queue.add(temp.get(i));
                    visited[temp.get(i)] = true;
                }
            }
        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(3, 4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
}
