package algorithm.search;

/**
 * The type Binary search.
 */
public class BinarySearch {
    /**
     * Search boolean.
     *
     * @param arr the arr
     * @param a   the a
     * @return the boolean
     */
    public static boolean search(int[] arr,int a){
        int l = arr.length;
        int start=0;int end =l-1;
        while(start<=end){
            int mid =(start)+(end-start)/2;
            if(arr[mid]==a){
                return true;
            }else if(arr[mid]<a){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Is 6 is present in the array :: "+search(arr,6));
        System.out.println("Is 5 is present in the array :: "+search(arr,15));

    }
}
