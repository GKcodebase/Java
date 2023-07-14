package algorithm.search;

/**
 * The type Linear search.
 */
public class LinearSearch {
    /**
     * Search boolean.
     *
     * @param array the array
     * @param a     the a
     * @return the boolean
     */
    public static boolean search(int[] array,int a){
        int l = array.length;
        for(int i=0;i<l;i++){
            if(array[i] == a)
                return true;
        }
        return false;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {1,25,90,8,22,41,38,7,5};
        int a =5;
        System.out.print("Is "+a+" present in array :: "+search(arr,a));
    }
}
