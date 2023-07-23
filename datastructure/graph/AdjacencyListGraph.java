package datastructure.graph;

import java.util.LinkedList;

/**
 * The type Adjacency list graph.
 */
public class AdjacencyListGraph implements Graph {
    /**
     * The Vertices.
     */
    public int vertices;
    /**
     * The Adjacency list.
     */
    public LinkedList<Integer> adjacencyList[];


    /**
     * Instantiates a new Adjacency list graph.
     *
     * @param vertices the vertices
     */
    public AdjacencyListGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    /**
     * Print graph.
     */
    @Override
    public void printGraph() {
        System.out.println("Adjacency List of Directed Graph");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("|" + i + "| => ");
                for (int j = 0; j < adjacencyList[i].size(); j++) {
                    System.out.print("[" + adjacencyList[i].get(j) + "] -> ");
                }
                System.out.println("null");
            } else {

                System.out.println("|" + i + "| => " + "null");
            }
        }

    }

    /**
     * Add edge.
     *
     * @param source      the source
     * @param destination the destination
     */
    @Override
    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices)
            adjacencyList[source].addLast(destination);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main( String args[] ) {
        AdjacencyListGraph g= new AdjacencyListGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.printGraph();
    }
}
