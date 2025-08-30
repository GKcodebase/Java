public class CheckifEveryRowandColumnContainsAllNumbers {

    public static boolean check(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            boolean[] colCheck = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                rowCheck[matrix[i][j]] = true;
                colCheck[matrix[j][i]] = true;
            }

            for (int k = 1; k <= n; k++) {
                if (!rowCheck[k] || !colCheck[k]) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args){
        int[][] matrix = {
            {1, 2, 3},
            {3, 1, 2},
            {2, 3, 1}
        };

        System.out.println(check(matrix));  // Output: true

        int[][] invalidMatrix = {
            {1, 2, 3},
            {3, 1, 2},
            {2, 3, 2}
        };
        System.out.println(check(invalidMatrix));  // Output: false
    }
}
