public class Bipartite {
    public boolean isBipartite(int[][] graph){
        int n = graph.length;
        int[] colors = new int[n];
        for(int i=0;i<n;i++){
            if(colors[i] ==0){
                if(!dfsCheck(graph, colors, i, 1)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean dfsCheck(int[][] graph, int[] colors, int node, int color){
        colors[node] = color;
        for(int neighbor : graph[node]){
            if(colors[neighbor] == 0){
                if(!dfsCheck(graph, colors, neighbor, -color)){
                    return false;
                }
            } else if(colors[neighbor] == color){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Bipartite bp = new Bipartite();
        int[][] graph1 = {
            {1,3},
            {0,2},
            {1,3},
            {0,2}
        };
        System.out.println("Graph1 is Bipartite: " + bp.isBipartite(graph1)); // true

        int[][] graph2 = {
            {1,2,3},
            {0,2},
            {0,1,3},
            {0,2}
        };
        System.out.println("Graph2 is Bipartite: " + bp.isBipartite(graph2)); // false      
    }
}
