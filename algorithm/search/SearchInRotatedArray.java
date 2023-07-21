package algorithm.search;

/**
 * The type Search in rotated array.
 */
public class SearchInRotatedArray {
    /**
     * Search boolean.
     *
     * @param array the array
     * @param a     the a
     * @param left  the left
     * @param right the right
     * @return the boolean
     */
    public static boolean search(int[] array, int a ,int left, int right){
        int mid = (left+right)/2;
        if(a==array[mid])
            return true;
        if (right < left)
            return false;

        if(array[left]<array[mid]){
            if(a>=array[left] && a<array[mid]){
                return search(array,a,left,mid-1);
            }else{
                return search(array,a,mid+1,right);
            }
        }else if(array[mid]<array[left]){
            if(a>=array[mid] && a<array[right]){
                return search(array,a,mid+1,right);
            }else{
                return search(array,a,left,mid-1);
            }
        }else{// Otherwise, search both halves
            boolean result = search(array,a, left, mid - 1); // Search in left
            if (!result)
                return search(array, a,mid + 1, right); // Search in right
            else
                return result;
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        int arr[] = {40,40,40,100,-100,40,0,24,40};
        System.out.println( "The index is: " + search(arr, -100,0, 8));
    }
}
