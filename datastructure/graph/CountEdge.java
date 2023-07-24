package datastructure.graph;

/**
 * The type Count edge.
 */
public class CountEdge {
    /**
     * Count int.
     *
     * @param graph the graph
     * @return the int
     */
    public static int count(AdjacencyListGraph graph){
        int count =0;
        int vertices = graph.vertices;
        for(int i=0;i<vertices;i++){
            count+=graph.adjacencyList[i].size();
        }
        //return count as this is a directed graph.
        return count;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        AdjacencyListGraph g = new AdjacencyListGraph(9);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(5,3);
        g.addEdge(5,6);
        g.addEdge(3,6);
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.addEdge(6,4);
        g.addEdge(7,8);


        g.printGraph();
        System.out.println("Number of edges: " + count(g));
        System.out.println();

        AdjacencyListGraph g2 = new AdjacencyListGraph(7);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(3,4);
        g2.addEdge(3,5);
        g2.addEdge(2,5);
        g2.addEdge(2,4);
        g2.addEdge(4,6);
        g2.addEdge(4,5);
        g2.addEdge(6,5);


        g2.printGraph();
        System.out.println("Number of edges: " + count(g2));
    }
}
