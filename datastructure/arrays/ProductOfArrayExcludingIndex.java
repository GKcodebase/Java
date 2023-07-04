package datastructure.arrays;

/**
 * The type Product of array excluding index.
 */
public class ProductOfArrayExcludingIndex {
    /**
     * Find product int [ ].
     *
     * @param arr the arr
     * @return the int [ ]
     */
    public int[] findProduct(int[] arr){
        int[] result = new int[arr.length];
        boolean zeroFlag = false;
        int product = 1;
        for(int i : arr){
            if(i !=0 ){
                product*=i;
            } else {
                zeroFlag=true;
            }
        }
        int j =0;
        for(int i:arr){
            if(zeroFlag && i !=0){
                result[j++] = 0;
            } else if(zeroFlag && i ==0){
                result[j++] = product;
            } else {
                result[j++] = product/i;
            }
        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int[] arr = {4,2,1,5,0,-1,-2};
        int[] result = new ProductOfArrayExcludingIndex().findProduct(arr);
        System.out.println("Output :: ");
        for(int i:result){
            System.out.print(i+", ");
        }
    }
}
