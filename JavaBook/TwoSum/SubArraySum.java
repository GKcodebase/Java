public class SubArraySum {

    public static int[] findSubArrayWithSum(int[] arr, int targetSum){
       int currentSum = arr[0], start =0;
       for(int i=1;i<arr.length;i++){
            while(currentSum> targetSum && start<i-1){
                currentSum -= arr[start];
                start++;
            }
            if(currentSum == targetSum){
                return new int[]{start,i-1};
            }
            currentSum +=arr[i];
       }
       return null;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 7, 5,10};
        int targetSum = 12;
        int[] result = findSubArrayWithSum(arr, targetSum);
        
        if (result != null) {
            System.out.println("Sub-array found from index " + result[0] + " to " + result[1]);
        } else {
            System.out.println("No sub-array with the given sum found.");
        }
    }
}
