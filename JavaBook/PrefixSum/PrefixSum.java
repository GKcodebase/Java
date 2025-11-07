public class PrefixSum {
    public static int[] computePrefixSum(int[] arr){
        for(int i=1;i<arr.length; i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        for(int num : arr){
            System.out.print(num + " ");
        }
        int[] prefixSumArr = computePrefixSum(arr);
        System.out.println("\nPrefix Sum Array:");
        for(int num : prefixSumArr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
