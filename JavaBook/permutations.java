public class permutations {
    public static void generate(int[] arr, int k){
        if(k ==1)
            check(arr);
        else{
            generate(arr, k-1);
            for(int i=0;i<k-1;i++){
                if(k%2 == 0){
                    swap(arr,i,k-1);
                } else {
                    swap( arr,0,k-1);
                }
                generate(arr,k-1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     public static void check(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generate(arr, arr.length);
    }
}
