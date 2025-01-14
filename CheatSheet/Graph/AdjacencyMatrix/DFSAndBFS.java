package CheatSheet.Graph.AdjacencyMatrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The DFS.
 */
public class DFSAndBFS {

    /**
     * The Adj.
     */
    static int[][] adj;

    /**
     * The V.
     */
    static int v;

    /**
     * Add edge.
     *
     * @param u the u
     * @param v the v
     */
    static void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    /**
     * Dfs.
     *
     * @param start   the start
     * @param visited the visited
     */
    static void dfs(int start, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 0; i < adj[start].length; i++) {

            if (!visited[i] && adj[start][i] == 1)
                dfs(i, visited);
        }

    }

    /**
     * Bfs.
     *
     * @param start the start
     */
    static void bfs(int start){
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int vis;
        while(!queue.isEmpty()){
            vis=queue.poll();
            System.out.print(vis+" ");

            for(int i=0;i<v;i++){
                if(adj[vis][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        v = 5;
        adj = new int[v][v];
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(0, 4);

        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Depth First Search :: ");
        // Perform DFS
        dfs(0, visited);
        System.out.println();

        System.out.println("Breadth First Search :: ");
        bfs(0);

    }
}
