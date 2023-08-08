package algorithm.graph;

import java.util.LinkedList;

/**
 * The type Un directed graph.
 */
public class UnDirectedGraph {
    /**
     * The Vertices.
     */
    private int vertices;
    /**
     * The Adjacency list.
     */
    private LinkedList<Integer> adjacencyList[];

    /**
     * Instantiates a new Graph.
     *
     * @param vertices the vertices
     */
    public UnDirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjacencyList[i] = new LinkedList();
    }

    /**
     * Add edge.
     *
     * @param source      the source
     * @param destination the destination
     */
// Function to add an edge into the graph
    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    /**
     * Gets vertices.
     *
     * @return the vertices
     */
    public int getVertices() {
        return this.vertices;
    }

    /**
     * Get adj linked list [ ].
     *
     * @return the linked list [ ]
     */
    public LinkedList<Integer>[] getAdj() {
        return this.adjacencyList;
    }

    /**
     * Print graph.
     */
    public void printGraph() {
        System.out.println("Adjacency List of Directed Graph");
        for (int i = 0; i < this.vertices; i++) {
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
}
