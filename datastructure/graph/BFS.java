package datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The type Bfs.
 */
public class BFS {

    /**
     * Bfs string.
     *
     * @param graph the graph
     * @return the string
     */
    public static String bfs(AdjacencyListGraph graph){
        String result="";
        boolean[] visited = new boolean[graph.vertices];
        for(int i=0;i< graph.vertices;i++){
            if(!visited[i]){
                result = result+bfsVisit(graph,i,visited);
            }
        }
        return result;
    }

    private static String bfsVisit(AdjacencyListGraph graph, int source, boolean[] visited) {
        String result = "";
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int currentNode = queue.remove();
            LinkedList<Integer> temp = null;
            result += String.valueOf(currentNode);

            if(graph.adjacencyList[currentNode] != null){
                temp=graph.adjacencyList[currentNode];
            }
            for(int i=0;i<temp.size();i++){
                if (!visited[temp.get(i)]) {
                    queue.add(temp.get(i));
                    visited[temp.get(i)] = true; //Visit the current Node
                }
            }

        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        AdjacencyListGraph g = new AdjacencyListGraph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        AdjacencyListGraph g2 = new AdjacencyListGraph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
}
