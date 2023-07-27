package algorithm.graph;


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
    public static String dfs(Graph graph) {
        int vertices = graph.getVertices();
        boolean[] visited = new boolean[vertices];
        String result = "";
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                result += visitdfs(graph, i, visited);
            }
        }
        return result;
    }

    private static String visitdfs(Graph graph, int source, boolean[] visited) {
        String result = "";
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {

            int currentNode = stack.pop();
            result += String.valueOf(currentNode);

            LinkedList<Integer> temp = null;
            if (graph.getAdj()[currentNode] != null) {
                temp = graph.getAdj()[currentNode];
            }

            for (int i = 0; i < temp.size(); i++) {
                if (!visited[temp.get(i)])
                    stack.push(temp.get(i));
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

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(4, 3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}
