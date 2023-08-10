package algorithm.graph;

public class BipartiteGraph {

    public static Object isBipartite(UnDirectedGraph g, int source, boolean visited[], boolean color[]) {

        // do for every edge
        for (int u: g.getAdj()[source]) {

            // if vertex u was not visited before
            if (visited[u] == false) {

                // mark it as visited
                visited[u] = true;
                // set color as opposite color of parent node
                color[u] = !color[source];
                // if the subtree rooted at vertex 'source' is not bipartite
                if (String.valueOf(isBipartite(g, u, visited, color)) == "false")
                    return false;
            }
            // if the vertex is already been discovered and color of vertex
            // u and source are same, then the graph is not Bipartite
            else if (color[source] == color[u]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {

        UnDirectedGraph g = new UnDirectedGraph(7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 1);


        UnDirectedGraph g2 = new UnDirectedGraph(7);
        g2.addEdge(3, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 1);
        g2.addEdge(5, 3);
        g2.addEdge(6, 2);
        g2.addEdge(3, 1);

        boolean[] discovered = new boolean[8];
        boolean[] color = new boolean[8];
        discovered[1] = true;
        color[1] = false;


        //Example 1
        Object x = isBipartite(g, 1, discovered, color);
        System.out.println("Graph1 is bipartite: " + x);


        //Example 2
        x = isBipartite(g2, 1, discovered, color);
        System.out.println("Graph2 is bipartite: " + x);
    }
}