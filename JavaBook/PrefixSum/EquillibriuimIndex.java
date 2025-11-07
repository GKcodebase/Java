public class EquillibriuimIndex {
    public static int findEquillibriumIndex(int[] arr){
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        int leftSum = 0;
        for(int i=0;i<arr.length;i++){
            if(leftSum == totalSum-leftSum-arr[i]){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int equilibriumIndex = findEquillibriumIndex(arr);
        if(equilibriumIndex != -1){
            System.out.println("Equilibrium Index found at: " + equilibriumIndex);
        } else {
            System.out.println("No Equilibrium Index found.");
        }
    }
}
