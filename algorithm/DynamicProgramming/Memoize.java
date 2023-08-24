package algorithm.DynamicProgramming;

/**
 * The type Memoize.
 */
class Memoize
{
    /**
     * Fib int.
     *
     * @param n the n
     * @param lookupTable the lookup table
     * @return the int
     */
    public static int fib(int n, int lookupTable[])
    {
        if (lookupTable[n] == -1) { // Check if already present
            // Adding entry to table when not present
            if (n <= 1)
                lookupTable[n] = n;
            else
                lookupTable[n] = fib(n - 1, lookupTable) + fib(n - 2, lookupTable);
        }
        return lookupTable[n];
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        int n = 6; // Finding the nth Fibonacci number
        int [] lookupTable = new int[n+1];
        for (int i = 0; i < n+1; i++)
            lookupTable[i] = -1; // Initializing the look up table to have -1

        System.out.println(fib(n, lookupTable));
    }
}