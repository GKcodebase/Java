package algorithm.graph;

import java.util.LinkedList;

/**
 * The type Count path bw 2 nodes.
 */
public class CountPathBw2Nodes {
    /**
     * Count int.
     *
     * @param graph       the graph
     * @param source      the source
     * @param destination the destination
     * @return the int
     */
    public static int count(Graph graph, int source, int destination) {
        int count = 0;
        return countRecursive(graph, source, destination, count);
    }

    private static int countRecursive(Graph graph, int source, int destination, int count) {
        LinkedList<Integer>[] list = graph.getAdj();
        if (source == destination)
            count++;
        else {
            for (int i = 0; i < list[source].size(); i++) {
                int adjVertices = list[source].get(i);
                count =  countRecursive(graph, adjVertices, destination, count);
            }
        }
        return count;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        int answer;
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 3);
        g1.addEdge(4, 5);

        answer = count(g1, 0, 5);
        System.out.println(answer);

        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 5);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(5, 3);
        g2.addEdge(5, 6);
        g2.addEdge(3, 6);

        answer = count(g2, 0, 3);
        System.out.println(answer);
    }
}
