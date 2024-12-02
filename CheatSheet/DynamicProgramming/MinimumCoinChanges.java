package CheatSheet.DynamicProgramming;

import java.util.Arrays;

/**
 * The Minimum coin changes.
 */
public class MinimumCoinChanges {
    /**
     * Get minimum changes int.
     *
     * @param coins  the coins
     * @param amount the amount
     * @return the int
     */
    public static int getMinimumChanges(int coins[], int amount){
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i>=coin){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]> amount ? -1 : dp[amount];
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int n = 20;
        int[] coins = {1, 2, 5};
        System.out.println("Minimum Coin Change for : " +n+" is  "+ getMinimumChanges(coins, n));

    }
}
