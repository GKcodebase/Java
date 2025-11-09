import java.util.Arrays;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        Arrays.sort(nums);
        int left =0;
        int right = nums.length-1;
        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left, right};
            }else if(sum< target)
            {
                left++;
            } else {
                right--;    
            }
        }
        return null;
    }
    public static void main(String[] args){
        int[] nums = {10,11,1,2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if(result != null){
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}
