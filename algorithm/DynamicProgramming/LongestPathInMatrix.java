package algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * Given a n*n matrix where all numbers are distinct,
 * find the maximum length path (starting from any cell) such that all cells along the path are in increasing order with a difference of 1.
 * We can move in 4 directions from a given cell (i, j), i.e.,
 * we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.
 */
public class LongestPathInMatrix {
    /**
     * Gets longest path.
     *
     * @param arr the arr
     * @return the longest path
     */
    public static int getLongestPath(int arr[][]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        int result = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    findLongestFromACell(i, j, arr, dp, n);

                // Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    /**
     * Find longest from a cell int.
     *
     * @param i   the
     * @param j   the j
     * @param arr the arr
     * @param dp  the dp
     * @param n   the n
     * @return the int
     */
    private static int findLongestFromACell(int i, int j, int[][] arr, int[][] dp, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int w = Integer.MIN_VALUE;
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int z = Integer.MIN_VALUE;
        if (j < n - 1 && (arr[i][j] + 1 == arr[i][j + 1]))
            w = dp[i][j] = 1 + findLongestFromACell(i, j + 1, arr, dp, n);
        if (j > 0 && (arr[i][j] + 1 == arr[i][j - 1]))
            x = dp[i][j] = 1 + findLongestFromACell(i, j - 1, arr, dp, n);
        if (i < n - 1 && (arr[i][j] + 1 == arr[i + 1][j]))
            y = dp[i][j] = 1 + findLongestFromACell(i + 1, j, arr, dp, n);
        if (i > 0 && (arr[i][j] + 1 == arr[i - 1][j]))
            z = dp[i][j] = 1 + findLongestFromACell(i - 1, j, arr, dp, n);
        return dp[i][j]
                = Math.max(
                x,
                Math.max(y, Math.max(z, Math.max(w, 1))));
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int mat[][]
                = {{1, 2, 9}, {5, 3, 8}, {4, 6, 7}};
        System.out.println("Length of the longest path is "
                + getLongestPath(mat));
    }
}
