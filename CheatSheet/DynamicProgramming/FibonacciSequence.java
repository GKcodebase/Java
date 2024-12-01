package CheatSheet.DynamicProgramming;

/**
 * The Fibonacci sequence.
 */
public class FibonacciSequence {
    /**
     * Get fibonacci number int.
     *
     * @param n the n
     * @return the int
     */
    public static  int getFibonacciNumber(int n){
        if(n<=1)
            return 1;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
            dp[i] = dp[i-1]+dp[i-2];
        return dp[n];
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int n =6;
        System.out.println("Fibonacci of n = "+n+" is " + getFibonacciNumber(n));
    }
}
