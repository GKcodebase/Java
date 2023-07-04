package datastructure.arrays;

/**
 * The type Find minimum element.
 */
public class FindMinimumElement {
    /**
     * Find min int.
     *
     * @param arr the arr
     * @return the int
     */
    public static int findMin(int[] arr){
        int min = arr[0];
        for(int i : arr){
            if(i<min)
                min=i;
        }
        return min;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {1,2,3,-1,0,90,-100,9,0};
        System.out.println("Minimum value is :: "+findMin(arr));
    }
}
