package CodingPatterns.TwoPointers;

/**
 * Calculate water store in the given levels of heights.
 */
public class TrappingRainWater {
    /**
     * Get trapping water int.
     *
     * @param heights the heights
     * @return the int
     */
    public static int getTrappingWater(int heights[]){
        int l = heights.length;
        int left = 0; int right = l-1;
        int maxRight = 0; int maxLeft = 0;
        int water =0;
        while(left<right){
            if(heights[left]<heights[right]){
                maxLeft = Math.max(maxLeft,heights[left]);
                water+= maxLeft-heights[left];
                left++;
            }
            else{
                maxRight = Math.max(maxRight,heights[right]);
                water+= maxRight-heights[right];
                right--;
            }
        }
        return water;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int water[] = {3, 0, 1, 0, 4, 0, 2};
        System.out.println("Water stored is :: "+getTrappingWater(water));
    }
}
