package algorithm.greedyalgorithm;

import java.util.Arrays;

/**
 * The type Minimum cost.
 */
public class MinimumCost {

    /**
     * Min cost int.
     *
     * @param pipes the pipes
     * @return the int
     */
    public static int minCost(int[] pipes) {

        int cost = 0;
        int n = pipes.length;

        for (int i = 0; i < n - 1; i++) {
            Arrays.sort(pipes); //Sorting the array
            int prev_cost = cost; // store previous cost for later use
            cost = (pipes[i] + pipes[i + 1]); //find current cost
            pipes[i + 1] = cost; //insert in array
            cost = cost + prev_cost; //add with previous cost
        }
        return cost;
    }
}

/**
 * The type Main.
 */
class Main{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] pipes = {4, 3, 2, 6 };
        System.out.println("Total cost for connecting pipes is " + MinimumCost.minCost(pipes));
        int[] pipes1 = {1, 1, 2, 6};
        System.out.println("Total cost for connecting pipes1 is " + MinimumCost.minCost(pipes1));
    }
}