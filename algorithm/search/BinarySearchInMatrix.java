package algorithm.search;

/**
 * The type Binary search in matrix.
 */
public class BinarySearchInMatrix {
    /**
     * Find key boolean.
     *
     * @param matrix the matrix
     * @param column the column
     * @param row    the row
     * @param key    the key
     * @return the boolean
     */
    public static boolean findKey(int[][] matrix, int column, int row, int key) {
        int min = 0;
        int max = (row * column) - 1;

        while (min <= max) {
            int middle = (min + max) / 2;
            int r = middle / column;
            int c = middle % column;
            if (key < matrix[r][c]) {
                max = middle - 1;
            } else if (key > matrix[r][c]) {
                min = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int[][] matrix = {
                {10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 50}
        };

        // Example 1
        Object x = findKey(matrix, 4, 4, 80);
        System.out.println("Search for 80 returned: " + x);

        // Example 2
        x = findKey(matrix, 4, 4, 15);
        System.out.println("Search for 15 returned: " + x);
    }
}
