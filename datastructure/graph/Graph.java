package datastructure.graph;

import java.util.LinkedList;

/**
 * The interface Graph.
 */
public interface Graph {
    /**
     * The constant vertices.
     */
    int vertices = 0;
    /**
     * The constant adjacencyList.
     */
    LinkedList<Integer> adjacencyList[] = new LinkedList[vertices];

    /**
     * Print graph.
     */
    void printGraph();

    /**
     * Add edge.
     *
     * @param source      the source
     * @param destination the destination
     */
    void addEdge(int source, int destination);
    }
