package datastructure.graph;

import java.util.LinkedList;

/**
 * The type Cycle detection in directed graph.
 */
public class CycleDetectionInDirectedGraph {

    /**
     * Detect cycle boolean.
     *
     * @param graph the graph
     * @return the boolean
     */
    public static boolean detectCycle(AdjacencyListGraph graph){
        int vertices = graph.vertices;
        boolean visited[] = new boolean[vertices];
        boolean stackFlag[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++){
            //Check cyclic on each node
            if (cyclic(graph, i, visited, stackFlag)){
                return true;
            }
        }
        return false;
    }

    private static boolean cyclic(AdjacencyListGraph graph, int v, boolean[] visited, boolean[] stackFlag) {
        //if node is currently in stack that means we have found a cycle
        if(stackFlag[v])
            return true;

        //if it is already visited (and not in Stack) then there is no cycle
        if (visited[v])
            return false;

        visited[v]=true;
        stackFlag[v]=true;

        LinkedList<Integer> temp = null;
        if(graph.adjacencyList[v]!=null)
            temp=graph.adjacencyList[v];

        for(int i=0;i<temp.size();i++){
            //run cyclic function recursively on each out go    ing path
            if(cyclic(graph,temp.get(i),visited,stackFlag)){
                return true;
            }
        }

        stackFlag[v] = false;
        return false;

    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        AdjacencyListGraph g1 = new AdjacencyListGraph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        AdjacencyListGraph g2 = new AdjacencyListGraph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }
}
