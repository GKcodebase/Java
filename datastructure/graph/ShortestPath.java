package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Shortest path.
 */
public class ShortestPath {
    /**
     * Gets shortest path.
     *
     * @param graph       the graph
     * @param source      the source
     * @param destination the destination
     * @return the shortest path
     */
    public static int getShortestPath(AdjacencyListGraph graph, int source, int destination) {
        int distance = 0;
        if (source == destination)
            return distance;
        int vertices = graph.vertices;
        boolean[] visited = new boolean[vertices];
        int[] distanceArray = new int[vertices];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentNode = queue.remove();

            LinkedList<Integer> temp = null;
            if (graph.adjacencyList[currentNode] != null)
                temp = graph.adjacencyList[currentNode];

            for (int i = 0; i < temp.size(); i++) {
                if (!visited[temp.get(i)]) {
                    queue.add(temp.get(i));
                    distanceArray[temp.get(i)] = distanceArray[currentNode] + 1;
                }
                if (temp.get(i) == destination)
                    return distanceArray[temp.get(i)];
            }
        }
        return distance;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        AdjacencyListGraph g = new AdjacencyListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        System.out.println(getShortestPath(g, 0, 4));
    }
}
