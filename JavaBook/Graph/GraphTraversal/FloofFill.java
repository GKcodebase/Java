public class FloofFill {

    public static void floodFill(int[][] image, int sr, int sc, int newColot){
        int originalColor = image[sr][sc];
        if(originalColor == newColot) return;
        floodFillUtill(image, sr, sc, originalColor, newColot);
    }
    public static void floodFillUtill(int[][] image, int sr, int sc, int originalColor, int newColor){
        if(sr<0 || sr>=image.length || sc<0 || sc>= image[0].length) return;
        if(image[sr][sc] != originalColor) return;
        image[sr][sc] = newColor;
        floodFillUtill(image, sr+1, sc, originalColor, newColor);
        floodFillUtill(image, sr-1, sc, originalColor, newColor);
        floodFillUtill(image, sr, sc+1, originalColor, newColor);
        floodFillUtill(image, sr, sc-1, originalColor, newColor);
    }
    public static int countIslands(int[][] grid){
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfsUtil(grid, i, j, visited);
                    count++;
                }
            }
        }
                return count;
    }
    public static void dfsUtil(int[][] grid, int sr, int sc, boolean visited[][]){
        if(sr<0 || sr>=grid.length || sc<0 || sc>= grid[0].length) return;
        if(visited[sr][sc] || grid[sr][sc] ==0) return;
        visited[sr][sc] = true;
        dfsUtil(grid, sr+1, sc, visited);
        dfsUtil(grid, sr-1, sc, visited);
        dfsUtil(grid, sr, sc+1, visited);
        dfsUtil(grid, sr, sc-1, visited);
    }
    public static void main(String [] args){
        int vertex = 4;
        int[][] adjacencyMatrix = {
            {1, 1, 1, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 2},
            {0, 3, 3, 0}
        };
        System.out.println("Original Image:");
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
        floodFill(adjacencyMatrix, 1, 1, 5);
        System.out.println("Image after Flood Fill:");
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                System.out.print(adjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
        int islandMatrix[][] = {
            {1,1,0,0,0},
            {1,0,0,1,1},
            {0,0,1,0,0},
            {0,1,1,0,0},
            {1,0,0,0,1}
        };
        int islandCount = countIslands(islandMatrix);
        System.out.println("Number of islands in the given matrix: "+islandCount);
    }
}
