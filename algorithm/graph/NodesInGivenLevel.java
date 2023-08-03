package algorithm.graph;

import datastructure.graph.AdjacencyListGraph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * The type Nodes in given level.
 */
public class NodesInGivenLevel {
    /**
     * Gets nodes in given level.
     *
     * @param graph  the graph
     * @param source the source
     * @param level  the level
     * @return the nodes in given level
     */
    public static int getNodesInGivenLevel(AdjacencyListGraph graph, int source, int level) {
        int vertices = graph.vertices;
        int count = 0;
        int[] visited = new int[vertices];
        visited[source] = 1;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        while (queue.size()!=0) {
            source = queue.poll();
            LinkedList<Integer> aList[];
            aList = graph.adjacencyList;
            Iterator<Integer> i = aList[source].listIterator();
            while (i.hasNext()) {
                int t = i.next();
                if (visited[t] != 1) {
                    visited[t] = visited[source] + 1;
                    if (visited[t] < level)
                        queue.add(t);
                }
            }
        }
        for (int i = 0; i < vertices; i++)
            if (visited[i] == level)
                count++;
        return count;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        AdjacencyListGraph g = new AdjacencyListGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(2, 4);

        int answer;

        answer = getNodesInGivenLevel(g, 0, 1);
        System.out.println(answer);
        answer = getNodesInGivenLevel(g, 0, 2);
        System.out.println(answer);
        answer = getNodesInGivenLevel(g, 0, 3);
        System.out.println(answer);
        answer = getNodesInGivenLevel(g, 0, 4);
        System.out.println(answer);
    }
}
