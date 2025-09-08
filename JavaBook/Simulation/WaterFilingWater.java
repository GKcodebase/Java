/***
 *  There are N buckets (5 < N < 105), each with a certain capacity Ci (1 ≤ Ci < 100). One
    day, after a rainstorm, each bucket is filled with Ai units of water (1 ≤ Ai < Ci). Charlie
    then performs the following process: he pours bucket 1 into bucket 2, then bucket 2 into
    bucket 3, and so on, up until pouring bucket N - 1 into bucket N. When Charlie pours
    bucket B into bucket B + 1, he pours as much as possible until bucket B is empty or bucket
    B + 1 is full. Find out how much water is in each bucket once Charlie is done pouring.
 */
public class WaterFilingWater {

    public static void fillAndShiftWater(int[] water, int[] bucket){
        int n = water.length;
        for(int i = 0; i < n - 1; i++){
            int pourable = Math.min(water[i], bucket[i+1] - water[i+1]);
            water[i] -= pourable;
            water[i+1] += pourable;
        }
        for(int w : water){
            System.out.print(w + " ");
        }

    }
    public static void main(String args[]){
        int[] bucket = {10, 5, 20, 15, 30};
        int[] water = {5, 3, 10, 5, 20};
        fillAndShiftWater(water, bucket);
    }
}
