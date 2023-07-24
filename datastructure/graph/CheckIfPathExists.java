package datastructure.graph;

import java.util.LinkedList;

public class CheckIfPathExists {
    public static boolean checkPath(AdjacencyListGraph graph,int source,int destination){
        boolean flag = false;
        LinkedList<Integer> list =  null;
        if (graph.adjacencyList[source]!=null)
            list=graph.adjacencyList[source];
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(destination)){
                return true;
            }
            else {
               return checkPath(graph, list.get(i),destination);
            }
        }
        return false;
    }
    public static void main(String args[]) {

        AdjacencyListGraph g1 = new AdjacencyListGraph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        AdjacencyListGraph g2 = new AdjacencyListGraph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));
    }
}
