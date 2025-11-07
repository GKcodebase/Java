import java.util.*;
public class DisJointedMatrix {

    public static boolean isConnected(List<List<Integer>> graph , boolean visited[], int source, int destination) {
        if(source == destination)  return true;
        if(visited[source]) return false;// loop prevention
        visited[source] = true;
        for(int neighbor: graph.get(source)){
            if(!visited[neighbor]){
                if(isConnected(graph,visited,neighbor,destination)){
                    return true;
                }
            }
        }
        return false;

    }
    public static void main(String[] args){
        //Unidirectional Graph with Disjointed Components
        int vertex = 7;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i=0;i<vertex;i++){
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyList.get(0).add(1);
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(0);
        adjacencyList.get(3).add(4);
        adjacencyList.get(4).add(5);
        adjacencyList.get(5).add(3);
        //Component 1: 0-1-2
        //Component 2: 3-4-5
        //Component 3: 6 (Isolated Node)    
        for(int i=0;i<vertex;i++){
            System.out.print(i+": ");
            for(int neighbor:adjacencyList.get(i)){
                System.out.print(neighbor+" ");
            }
            System.out.println();
        }
        boolean visited[] = new boolean[vertex];
        int source = 3;
        int destination = 5;
        if(isConnected(adjacencyList, visited, source, destination)){
            System.out.println("There is a path from "+source+" to "+destination);
        }else{
            System.out.println("There is no path from "+source+" to "+destination);
        }
    }
}
