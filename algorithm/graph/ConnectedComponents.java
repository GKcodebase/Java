package algorithm.graph;

import java.util.LinkedList;

/**
 * The type Connected components.
 */
public class ConnectedComponents {
    /**
     * Print connected components.
     *
     * @param g the g
     */
    public static void printConnectedComponents(UnDirectedGraph g) {
        int num_vertices = g.getVertices();
        boolean[] visited = new boolean[num_vertices];
        for (int i = 0; i < num_vertices; ++i) {
            if (!visited[i]) {
                utilityFunction(g, i, visited);
                System.out.println();
            }
        }
    }

    /**
     * Utility function.
     *
     * @param g       the g
     * @param v       the v
     * @param visited the visited
     */
    public static void utilityFunction(UnDirectedGraph g, int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        LinkedList < Integer > Llist[];
        Llist = g.getAdj();
        for (int i: Llist[v]) {
            if (!visited[i]) {
                utilityFunction(g, i, visited);
            }
        }
    }


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        UnDirectedGraph g = new UnDirectedGraph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(3, 6);

        System.out.println("The connected components are:");
        printConnectedComponents(g);

    }
}


