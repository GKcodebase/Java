package algorithm.DynamicProgramming;

/**
 * The type Tabulation.
 */
class Tabulation
{
    /**
     * Fib int.
     *
     * @param n           the n
     * @param lookupTable the lookup table
     * @return the int
     */
    public static int fib(int n, int[] lookupTable)
    {
        lookupTable[0] = 0; // Set zeroth and first values
        lookupTable[1] = 1;

        for (int i = 2; i <= n; i++)
            lookupTable[i] = lookupTable[i-1] + lookupTable[i-2]; // Fill up the table by summing up previous two values

        return lookupTable[n]; // Return the nth Fibonacci number
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int n = 6;
        int[] lookupTable = new int[n+1];
        System.out.print(fib(n, lookupTable));
    }
}