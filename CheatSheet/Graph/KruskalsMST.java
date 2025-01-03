package CheatSheet.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Kruskals mst.
 */
public class KruskalsMST {

    /**
     * Kruskal mst.
     *
     * @param edges the edges
     * @param V     the v
     */
// Function to find the MST
    static void kruskalMST(List<Edge> edges, int V) {
        int j = 0;
        int noOfEdges = 0;

        // Allocate memory for creating V subsets
        Subset[] subsets = new Subset[V];

        // Allocate memory for results
        Edge[] results = new Edge[V];

        // Create V subsets with single elements
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        // Sorting edges based on weight
        Collections.sort(edges);

        // Number of edges to be taken is equal to V-1
        while (noOfEdges < V - 1) {

            // Pick the smallest edge. And increment the index for next iteration
            Edge nextEdge = edges.get(j);
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);

            // If including this edge doesn't cause cycle, include it in result and increment the index of result for next edge
            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }
        // Print the contents of result[] to display the built MST
        for (int i = 0; i <= noOfEdges; i++) {
            System.out.println(i+ " "+subsets[i].parent+" "+subsets[i].rank);
        }
        System.out.println(
                "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- "
                    + results[i].dest + " == "
                    + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }

    /**
     * Union.
     *
     * @param subsets the subsets
     * @param x       the x
     * @param y       the y
     */
// Function to unite two disjoint sets
    private static void union(Subset[] subsets, int x,
                              int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank
                < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    /**
     * Find root int.
     *
     * @param subsets the subsets
     * @param i       the
     * @return the int
     */
// Function to find parent of a set
    private static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent
                = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(
                List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                        new Edge(0, 3, 5), new Edge(1, 3, 15),
                        new Edge(2, 3, 4)));


        kruskalMST(graphEdges, V);

    }

    /**
     * The type Edge.
     */
// Defines edge structure
    static class Edge implements Comparable<Edge> {
        /**
         * The Src.
         */
        int src, /**
         * The Dest.
         */
        dest, /**
         * The Weight.
         */
        weight;

        /**
         * Instantiates a new Edge.
         *
         * @param src    the src
         * @param dest   the dest
         * @param weight the weight
         */
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        /**
         * Compare to int.
         *
         * @param o the o
         * @return the int
         */
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    /**
     * The type Subset.
     */
// Defines subset element structure
    static class Subset {
        /**
         * The Parent.
         */
        int parent, /**
         * The Rank.
         */
        rank;

        /**
         * Instantiates a new Subset.
         *
         * @param parent the parent
         * @param rank   the rank
         */
        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

}
