package datastructure.graph;

import java.util.LinkedList;

/**
 * The type Remove vertices.
 */
public class RemoveVertices {
    /**
     * Remove.
     *
     * @param graph       the graph
     * @param source      the source
     * @param destination the destination
     */
    public static void remove(AdjacencyListGraph graph,int source,int destination){
        LinkedList<Integer> list = graph.adjacencyList[source];
        list.removeFirstOccurrence(destination);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        AdjacencyListGraph g=new AdjacencyListGraph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);

        System.out.println("Before:");
        g.printGraph();

        remove(g, 1, 3);
        System.out.println("After:");
        g.printGraph();
    }
}
