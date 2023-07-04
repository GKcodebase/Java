package datastructure.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * The type First unique element.
 */
public class FirstUniqueElement {
    /**
     * Find unique int.
     *
     * @param arr the arr
     * @return the int
     */
    public static int findUnique(int[] arr){
        Map intMap = new HashMap();
        int ans=0;
            for(int i: arr){
                if(intMap.containsKey(i)){
                    intMap.put(i,Integer.valueOf((Integer) intMap.get(i)+1));
                }else{
                    intMap.put(i,1);
                }
            }
            for(int i: arr){
                if("1".equals(intMap.get(i).toString()))
                    return i;
            }
        return ans;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int[] arr = {0,0,2,4,5,3,5,4,9,2,3};
        System.out.println("First non repeating element is  :: "+findUnique(arr));
    }
}
