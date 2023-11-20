package algorithm.DynamicProgramming;

/**
 * The type Edit distance.
 */
public class EditDistance {

    /**
     * Edit distance int.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public static int editDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        return editDistanceHelper(s1, s2, s1.length(), s2.length(), dp);
    }

    /**
     * Edit distance helper int.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @param i  the
     * @param j  the j
     * @param dp the dp
     * @return the int
     */
    private static int editDistanceHelper(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0)
            return j;
        else if (j == 0)
            return i;
        if (dp[i - 1][j - 1] != 0)
            return dp[i - 1][j - 1];
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return dp[i - 1][j - 1] = editDistanceHelper(s1, s2, i - 1, j - 1, dp);

        return dp[i - 1][j - 1] = 1 + min(editDistanceHelper(s1, s2, i, j - 1, dp),  // Insertion
                editDistanceHelper(s1, s2, i - 1, j, dp),          // Deletion
                editDistanceHelper(s1, s2, i - 1, j - 1, dp)       // Substitution
        );
    }

    /**
     * Min int.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @return the int
     */
    public static int min(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        if (b <= a && b <= c) return b;
        else return c;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String str1 = "Tuesday";
        String str2 = "Thursday";

        String str3 = "iLoveEducative";
        String str4 = "EducativeIsFun";

        String str5 = "ImLearningAlgorithmsTheseDays";
        String str6 = "ImLearningSwimmingTheseDays";

        System.out.println("Edit Distance of " + str1 + ", " + str2 + " = " + editDistance(str1, str2));
        System.out.println("Edit Distance of " + str3 + ", " + str4 + " = " + editDistance(str3, str4));
        System.out.println("Edit Distance of " + str5 + ", " + str6 + " = " + editDistance(str5, str6));
    }
}
