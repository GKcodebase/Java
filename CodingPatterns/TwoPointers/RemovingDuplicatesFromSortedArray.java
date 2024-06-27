package CodingPatterns.TwoPointers;

/**
 * The type Removing duplicates from sorted array.
 */
public class RemovingDuplicatesFromSortedArray {
    /**
     * Remove duplicate.
     *
     * @param arr the arr
     */
    public static void removeDuplicate(int arr[]){
        int l = arr.length;
        int j=0;
        for(int i=1;i<l;i++){
            if(arr[j]!=arr[i]){
                j++;
                arr[j]=arr[i];
            }

        }
        for(int i=0;i<=j;i++) {
            System.out.println(arr[i]);
        }

        }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
            int array[] = {1,1,2,3,4,4,4,6,7,8,8,8,8,8,9};
            removeDuplicate(array);
    }
}
