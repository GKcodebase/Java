package datastructure.arrays;

/**
 * The type Re arrange sorted array in min max form.
 */
public class ReArrangeSortedArrayInMinMaxForm {
    /**
     * Shuffle int [ ].
     *
     * @param arr the arr
     * @return the int [ ]
     */
    public static int[] shuffle(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        int i=1;int j=0;
        while(i<n){
            result[i]=arr[j++];
            i=i+2;
        }
        i=0;j=n-1;
        while(i<n){
            result[i]=arr[j--];
            i=i+2;
        }
        return result;
    }

    /**
     * Max min.
     *
     * @param arr the arr
     */
    public static void maxMin(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        arr = shuffle(arr);
        System.out.print("Shuffled array :: ");
        for(int i:arr){
            System.out.print(i+", ");
        }
    }
}
