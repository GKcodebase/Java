public class MaximumSubArraySum {
    public static int findMaxSubAraySum(int[] arr){
        int max =Integer.MIN_VALUE;
        int maxSoFar =arr[0];
        for(int i=1;i<arr.length;i++){
            maxSoFar = Math.max(maxSoFar+arr[i],arr[i]);
            max = Math.max(max,maxSoFar);
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int result = findMaxSubAraySum(arr);
        System.out.println("Maximum Sub-array Sum is: " + result);
    }
}
