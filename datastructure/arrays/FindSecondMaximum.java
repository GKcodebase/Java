package datastructure.arrays;

/**
 * The type Find second maximum.
 */
public class FindSecondMaximum {
    /**
     * Second max int.
     *
     * @param arr the arr
     * @return the int
     */
    public static int secondMax(int[] arr){
        int max = arr[0];
        int temp = arr[0];
        int l = arr.length;
        for(int i : arr){
            if(max<i){
                temp=max;
                max = i;
            }
            if(i<max && i>temp){
                temp=i;
            }
        }
        return temp;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arg = {1,5,9,34,78,90,100};
        System.out.println("Second Max value is :: "+secondMax(arg));
    }
}
