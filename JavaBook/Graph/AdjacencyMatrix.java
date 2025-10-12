public class AdjacencyMatrix {
    public static void main(String[] args){
        int vertices = 5;
        int[][] adjacencyMatrix = new int[vertices][vertices];
        int edges = 0;

        // Adding edges
        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[1][0] = 1;
        edges++;

        adjacencyMatrix[0][4] = 1;
        adjacencyMatrix[4][0] = 1;
        edges++;

        adjacencyMatrix[1][4] = 1;
        adjacencyMatrix[4][1] = 1;
        edges++;

        adjacencyMatrix[1][3] = 1;
        adjacencyMatrix[3][1] = 1;
        edges++;

        adjacencyMatrix[1][2] = 1;
        adjacencyMatrix[2][1] = 1;
        edges++;

        adjacencyMatrix[2][3] = 1;
        adjacencyMatrix[3][2] = 1;
        edges++;

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Number of vertices: " + vertices);
        System.out.println("Number of edges: " + edges);
    }
}
