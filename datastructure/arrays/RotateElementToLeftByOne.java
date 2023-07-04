package datastructure.arrays;

/**
 * The type Rotate element to left by one.
 */
public class RotateElementToLeftByOne {
    /**
     * Rotate int [ ].
     *
     * @param arr the arr
     * @return the int [ ]
     */
    public static int[] rotate(int[] arr){
        int n = arr.length;
        int rElement = arr[n-1];
        for(int i =n-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0]=rElement;
        return arr;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        arr = rotate(arr);
        System.out.println("Rotated Array :: ");
        for(int i:arr){
            System.out.print(i+", ");
        }
    }
}
