import java.util.*;
public class AdjacencyList {
    int edges;
    int vertices;
    List<Integer>[] adjList;

    public AdjacencyList(int v){
        this.vertices = v;
        this.edges = 0;
        adjList = new List[v];
        for(int i=0; i<v; i++){
            adjList[i] = new ArrayList<>();
        }
    }
    public void addEdge(int u, int v){
        adjList[u].add(v);
        adjList[v].add(u);
        edges++;
    }
    public static void main(String[] args){
        AdjacencyList graph = new AdjacencyList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        for(int i=0; i<graph.vertices; i++){
            System.out.print(i + ": ");
            for(int neighbor : graph.adjList[i]){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
