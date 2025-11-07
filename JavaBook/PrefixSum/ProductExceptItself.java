public class ProductExceptItself {
    public static int[] productExceptItself(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        int leftProduct =1;
        for(int i=0;i<n;i++){
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        int rightProduct = 1;
        for(int i=n-1;i>=0;i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,-1,4,5,0,1,-1};
        int[] result = productExceptItself(nums);
        System.out.println("Product of array except itself:");
        for(int num : result){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
