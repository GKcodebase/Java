package datastructure.arrays;


/**
 * The type Remove even integers from array.
 */
public class RemoveEvenIntegersFromArray {
    /**
     * Remove even int [ ].
     *
     * @param arr the arr
     * @return the int [ ]
     */
    public int[] removeEven(int[] arr){
         int length = arr.length;
         int oddCount = 0;
         for(int i : arr){
             if(i%2!=0)oddCount++;
         }
         int [] oddArr = new int[oddCount];
         int j =0;
         for(int i : arr){
             if(i%2!=0){
                 oddArr[j++]=i;
             }
         }
         return oddArr;
     }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
         int[] arr = {1,2,3,4,5,6,7,8,9,10};
         int[] result = new RemoveEvenIntegersFromArray().removeEven(arr);
         System.out.println("Output :: ");
         for(int i:result){
             System.out.print(i+", ");
         }
     }
}
