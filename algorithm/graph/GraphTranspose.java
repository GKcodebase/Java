package algorithm.graph;

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

        Graph transposedGraph = new Graph(numOfVertices); //new graph to store the transpose

        transposedGraph.printGraph(); //calling print function on the final transposed graph
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    }
}
