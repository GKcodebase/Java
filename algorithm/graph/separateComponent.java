package algorithm.graph;

import java.util.LinkedList;

/**
 * The type Separate component.
 */
public class separateComponent {
    /**
     * Separate components boolean.
     *
     * @param graph       the graph
     * @param source      the source
     * @param destination the destination
     * @return the boolean
     */
    public static boolean separateComponents(Graph graph,int source,int destination){
        graph.getAdj()[source].remove(graph.getAdj()[source].indexOf(destination));
        return !isConnected( graph);
    }

    /**
     * Is connected boolean.
     *
     * @param graph the graph
     * @return the boolean
     */
    private static boolean isConnected(Graph graph) {
        int vertices = graph.getVertices();
        boolean[] visited = new boolean[vertices];
        graph.dfsTraversal(0,visited);
        for(int i=0;i<vertices;i++)
            if(!visited[i])
                return false;
        return true;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);

        // remove edge 3 -> 4
        Object x = separateComponents(g, 3, 4);
        System.out.println("Separate components created due to deletion of edge 3 -> 4? " + x);

        // remove edge 1 -> 2
        x = separateComponents(g, 1, 2);
        System.out.println("Separate components created due to deletion of edge 1 -> 2? " + x);

    }
}
