package algorithm.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * The type Graph.
 */
class Graph {
    private int vertices; //number of vertices
    private LinkedList<Integer> adjacencyList[]; //Adjacency Lists

    /**
     * Instantiates a new Graph.
     *
     * @param vertices the vertices
     */
    public Graph(int vertices) {
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

    /**
     * Gets transpose.
     *
     * @return the transpose
     */
    public Graph getTranspose(Graph graph) {
        Graph g = new Graph(vertices);
        for (int j = 0; j < vertices; j++) {
            Iterator<Integer> i = adjacencyList[j].listIterator();
            while (i.hasNext())
                g.adjacencyList[i.next()].add(j);
        }
        return g;
    }
}

/**
 * The type Main.
 */
class Main {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
    }
}