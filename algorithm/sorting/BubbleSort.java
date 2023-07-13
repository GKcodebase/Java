package algorithm.sorting;

/**
 * The type Bubble sort.
 */
public class BubbleSort {
    /**
     * Print.
     *
     * @param array the array
     */
    public static void print(int[] array){
        int l = array.length;
        System.out.print("Array :: ");
        for(int i=0;i<l;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
    }

    /**
     * Sort int [ ].
     *
     * @param array the array
     * @return the int [ ]
     */
    public static int[] sort(int[] array){
        int l = array.length;
        for(int i =0;i<l;i++){
            for(int j=i;j<l;j++){
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] =array[j];
                    array[j]=temp;
                }

            }
        }
        return array;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {2,4,1,5,3,6,7,8,10,9};
        print(arr);
        arr=sort(arr);
        print(arr);
    }
}
