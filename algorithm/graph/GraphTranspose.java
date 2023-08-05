package algorithm.graph;

import java.util.LinkedList;

/**
 * The type Graph transpose.
 */
public class GraphTranspose {

    /**
     * Gets transpose.
     *
     * @param g the g
     */
    public static void getTranspose(Graph g) {
        int numOfVertices = g.getVertices(); //getVertices defined in Graph.java file
        LinkedList<Integer> Llist[];
        Llist = g.getAdj();
        Graph transposedGraph = new Graph(numOfVertices); //new graph to store the transpose
        for (int v = 0; v < numOfVertices; v++) {
            for (int i = 0; i < Llist[v].size(); i++) {
                transposedGraph.addEdge(Llist[v].get(i), v);
            }
        }
        transposedGraph.printGraph(); //calling print function on the final transposed graph
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        System.out.println("Given Graph: ");
        g1.printGraph();
        System.out.println("Transpose of given Graph: ");
        getTranspose(g1);
    }
}
