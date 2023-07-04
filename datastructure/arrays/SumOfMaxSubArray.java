package datastructure.arrays;

public class SumOfMaxSubArray {
    public static int maxSum(int[] arr){
        int sum=arr[0];
        int preSum=arr[0];
        int n = arr.length;
        int start =0;int end =0;int start_temp=0;
        for(int i=0;i<n;i++){
            preSum+=arr[i];
            if(preSum<0){
                preSum=0;
                start_temp=i+1;
            }else if(sum<preSum) {
                sum=preSum;
                start=start_temp;
                end=i;
            }
        }
        System.out.println("Start of max sum sub array :: "+start+" , and end is :: "+end);
        return sum;
    }
    public static void main(String[] args){
        int[] arr = {-100,0,1,6,-2,10,-190,200,-300};
        System.out.println("Max Sum of sub array :: "+maxSum(arr));
    }
}
