package algorithm.DynamicProgramming.reccurssion;

/**
 * The type Longest common sub sequence.
 */
public class LongestCommonSubSequence {
    /**
     * Get sub sequences int.
     *
     * @param m the m
     * @param n the n
     * @param a the a
     * @param b the b
     * @return the int
     */
    public static int getSubSequences(int m, int n , String a , String b){
        return getSubSequencesUtil(m,n,a,b);
    }

    /**
     * Gets sub sequences util.
     *
     * @param m the m
     * @param n the n
     * @param a the a
     * @param b the b
     * @return the sub sequences util
     */
    private static int getSubSequencesUtil(int m, int n, String a, String b) {
        if(m==0 || n==0)
            return 0;
        if(a.charAt(m-1) == b.charAt(n-1))
            return 1+getSubSequencesUtil(m-1,n-1,a,b);
        else {
            return Math.max(getSubSequencesUtil(m-1,n,a,b),getSubSequencesUtil(m,n-1,a,b));
        }
    }
}
