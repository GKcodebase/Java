package datastructure.arrays;

/**
 * The type Re arrange positive and negative numbers.
 */
public class ReArrangePositiveAndNegativeNumbers {
    /**
     * Shift numbers int [ ].
     *
     * @param arr the arr
     * @return the int [ ]
     */
    public static int[] shiftNumbers(int[] arr){
        int i =0 ;int j = arr.length-1;
        while(i<=j){
            if(arr[i]>0&&arr[j]<=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j--;
            }
            else if(arr[i]<=0)i++;
            else j--;
        }
        return arr;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
            int[] arr = {9,0,2,-8,4,5,6-8,-1,2,4,5,-9};
            int[] result  = shiftNumbers(arr);
        System.out.print("Rearranged array :: ");
        for(int i:result){
            System.out.print(i+", ");
        }
    }
}
