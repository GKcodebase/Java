package CodingPatterns.TwoPointers;

/**
 * Sorting Colors (Dutch National Flag Problem):
 * <p>
 * This problem involves sorting an array containing elements with only three distinct values (0, 1, and 2)
 * without using additional sorting algorithms.
 */
public class SortingColour {

    /**
     * Swap.
     *
     * @param arr the arr
     * @param i   the
     * @param j   the j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Sort colour.
     *
     * @param nums the nums
     */
    public static void sortColour(int[] nums){
        int l = nums.length;
        int left =0; int mid =0; int right =l-1;
        while(mid<right){
            switch (nums[mid]){
                case 0:
                    swap(nums,left,mid);
                    mid++;
                    left++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums,mid,right);
                    right--;
                    break;
            }
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int colours[] = {1,2,1,0,0,0,2,1,1,1,2,2,0,2};
        sortColour(colours);
        for(int i : colours)
            System.out.print(i+" ");
    }
}
