package datastructure.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * The type Dfs.
 */
public class DFS {
    /**
     * Dfs string.
     *
     * @param graph the graph
     * @return the string
     */
    public static String dfs(AdjacencyListGraph graph){
        int vertices = graph.vertices;
        boolean[] visited = new boolean[vertices];
        String result="";
        for(int i=0;i<vertices;i++){
            if(!visited[i])
                result=result+dfsVisit(graph,i,visited);
        }
        return result;
    }

    private static String dfsVisit(AdjacencyListGraph graph, int source, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        String result="";

        while(!stack.isEmpty()){

            int currentNode = stack.pop();
            result += String.valueOf(currentNode);
            
            LinkedList<Integer> temp = null;
            if(graph.adjacencyList[currentNode]!=null)
                temp = graph.adjacencyList[currentNode];

            for(int i=0;i<temp.size();i++){

                if(!visited[temp.get(i)]){
                    stack.push(temp.get(i));
                }
            }
            visited[currentNode] = true;
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
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        AdjacencyListGraph g2 = new AdjacencyListGraph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}
