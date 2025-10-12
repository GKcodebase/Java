import java.util.*;
public class AdjacencyListWeightedGraph {
    int vertices;
    int edges;
    public static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    @SuppressWarnings("unchecked")
    List<Edge>[] adjacencyList = new ArrayList[vertices];
    public void addEdge(int u, int v, int weight){
        adjacencyList[u].add(new Edge(v, weight));
        adjacencyList[v].add(new Edge(u, weight));
        edges++;
    }
    public static void main(String[] args){
        AdjacencyListWeightedGraph graph = new AdjacencyListWeightedGraph();
        graph.vertices = 5;
        graph.edges = 0;
        graph.adjacencyList = new ArrayList[graph.vertices];
        for(int i=0; i<graph.vertices; i++){
            graph.adjacencyList[i] = new ArrayList<>();
        }
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 20);
        graph.addEdge(1, 4, 30);
        graph.addEdge(1, 3, 40);
        graph.addEdge(1, 2, 50);
        graph.addEdge(2, 3, 60);
        for(int i=0; i<graph.vertices; i++){
            System.out.print(i + ": ");
            for(Edge edge : graph.adjacencyList[i]){
                System.out.print("-> (to: " + edge.to + ", weight: " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}
