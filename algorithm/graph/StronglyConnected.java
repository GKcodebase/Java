package algorithm.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * The type Strongly connected.
 */
public class StronglyConnected {

    /**
     * Utility function.
     *
     * @param g       the g
     * @param v       the v
     * @param visited the visited
     */
    public static void utilityFunction(Graph g, int v, boolean visited[]) {

        visited[v] = true;
        int temp;
        LinkedList<Integer> Llist[];
        Llist = g.getAdj();
        Iterator<Integer> i = Llist[v].iterator();
        while (i.hasNext()) {

            temp = i.next();
            if (!visited[temp])
                utilityFunction(g, temp, visited);
        }
    }

    /**
     * Is strongly connected object.
     *
     * @param graph the graph
     * @return the object
     */
    public static Object isStronglyConnected(Graph graph) {
        int vertices = graph.getVertices();
        boolean[] visited = new boolean[vertices];
        utilityFunction(graph, 0, visited);
        for (int i = 0; i < vertices; i++)
            if (visited[i] == false)
                return false;

        Graph g1 = graph.getTranspose(graph);

        for (int i = 0; i < vertices; i++)
            visited[i] = false;

        // check transposed graph for non visited vertices
        utilityFunction(g1, 0, visited);

        // if transpose of graph has any unvisited nodes return false
        for (int i = 0; i < vertices; i++)
            if (visited[i] == false)
                return false;

        return true;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

        Object x = StronglyConnected.isStronglyConnected(g1);
        System.out.println("Graph g1 is strongly connected? " + x);


        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        x = StronglyConnected.isStronglyConnected(g2);
        System.out.println("Graph g2 is strongly connected? " + x);
    }

}
