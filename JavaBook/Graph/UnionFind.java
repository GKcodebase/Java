import java.util.*;
public class UnionFind {
    int parent[] ;
    public UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
     public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
     }

     public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            parent[rootX] = rootY;
        }
     }
    public static void main(String[] args){
        List<List<Integer>> disJointGraph = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            disJointGraph.add(new ArrayList<>());
        }
        disJointGraph.get(0).add(1);
        disJointGraph.get(1).add(2);
        disJointGraph.get(3).add(4);
        System.out.println("Graph representation:");
        for(int i = 0; i < disJointGraph.size(); i++){
            for(int neighbor : disJointGraph.get(i)){
                System.out.println(i + " -> " + neighbor);
            }
        }
        System.out.println("Union Find");
        UnionFind uf = new UnionFind(disJointGraph.size());
        for(int i = 0; i < disJointGraph.size(); i++){
            for(int neighbor : disJointGraph.get(i)){
                uf.union(i, neighbor);      
            }
        }
        // Connecting to different component - uf.union(2, 4);      
        for(int i = 0; i < disJointGraph.size(); i++){
            System.out.println("Node " + i + " has parent: " + uf.find(i));
        }
        Set<Integer> uniqueParents = new HashSet<>();
        for(int i = 0; i < disJointGraph.size(); i++){
            uniqueParents.add(uf.find(i));
        }
        System.out.println("Number of connected components: " + uniqueParents.size());
    }
}
