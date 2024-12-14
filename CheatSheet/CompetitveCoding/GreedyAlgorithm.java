package CheatSheet.CompetitveCoding;

/**
 * The Greedy algorithm.
 */
public class GreedyAlgorithm {
    /**
     * Jump game int.
     *
     * @param nums the nums
     * @return the int
     */
    public static int jumpGame(int[] nums) {
        int maxReach = 0;
        int jumps = 0;
        int lastJumped = 0;

        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == lastJumped) {
                jumps++;
                lastJumped = maxReach;
            }

        }
        return jumps;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] jumpGameArr = {2, 3, 1, 1, 4};
        System.out.println("Greedy Algorithm - Jump Game Minimum Jumps: " +
                jumpGame(jumpGameArr));
    }
}
