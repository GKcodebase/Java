package algorithm.greedyalgorithm;

import java.util.ArrayList;

/**
 * The type Change machine.
 */
public class ChangeMachine {

    /**
     * The Coins.
     */
    private static int[] coins = {25, 10, 5, 1};

    /**
     * Get change array list.
     *
     * @param amount the amount
     * @return the array list
     */
    public static ArrayList<Integer> getChange(int amount){
        ArrayList<Integer> change = new ArrayList<>();
        for (int i = 0; i < coins.length && amount > 0; i++) // traverse through all available coins
        {
            while (amount >= coins[i]) // keep checking if the amount is greater than the max coin
            {
                amount -= coins[i]; // subtract the maximum coin selected from the total amount in every iteration
                change.add(coins[i]); // add the coin to the list of 'change'
            }
        }
        return change;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        // Play around with this amount to see how many coins you get!
        int amount = 1;
        System.out.println(amount + " --> " + getChange(amount));

        amount = 17;
        System.out.println(amount + " --> " + getChange(amount));

        amount = 33;
        System.out.println(amount + " --> " + getChange(amount));

        amount = 99;
        System.out.println(amount + " --> " + getChange(amount));
    }
}
