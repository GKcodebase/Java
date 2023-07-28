package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Check tree.
 */
public class CheckTree {
    /**
     * Check if graph is tree boolean.
     *
     * @param graph the graph
     * @return the boolean
     */
    public static boolean checkIfGraphIsTree(AdjacencyListGraph graph) {
        int root = 0;
        int vertices = graph.vertices;
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[root] = true;
        queue.add(root);
        int numberOfVisited = 1;

        while (!queue.isEmpty()) {

            int currentNode = queue.remove();
            LinkedList<Integer> temp = null;

            if (graph.adjacencyList[currentNode] != null)
                temp = graph.adjacencyList[currentNode];

            for (int i = 0; i < temp.size(); i++) {
                if (!visited[temp.get(i)]) {
                    queue.add(temp.get(i));
                    visited[temp.get(i)] = true;
                    numberOfVisited++;
                } else
                    return false;
            }
        }
        return numberOfVisited == vertices;

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
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.printGraph();
        System.out.println("isTree : " + checkIfGraphIsTree(g));

        AdjacencyListGraph g2 = new AdjacencyListGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(3, 2);
        g2.printGraph();
        System.out.println("isTree : " + checkIfGraphIsTree(g2));

        AdjacencyListGraph g3 = new AdjacencyListGraph(6);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(0, 3);
        g3.addEdge(4, 5);
        g3.printGraph();
        System.out.println("isTree : " + checkIfGraphIsTree(g3));
    }
}
