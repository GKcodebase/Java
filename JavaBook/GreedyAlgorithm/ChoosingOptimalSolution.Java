/***
 * Greedy algorithms are used to solve optimization problems.
 * We go step by step, choosing the best option at each step.
 * If we make the best choice at each step, we will end up with the best overall solution.
 * This approach works well for problems where local optimal choices lead to a global optimal solution.
 */
public class ChoosingOptimalSolution {
   public static void main (String[] args){
    int time =15;
    int[] algorithmTime = {3,4,2,1,10,3};
    int minutes =0;
    int i=0;
    java.util.Arrays.sort(algorithmTime);
    while(minutes +algorithmTime[i]<=time){
        minutes +=algorithmTime[i];
        i++;
    }
    System.out.println("Number of algorithms that can be executed: "+i);
   }
}