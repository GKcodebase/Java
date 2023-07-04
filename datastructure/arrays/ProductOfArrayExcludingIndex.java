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

    public int[] solution(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        int i,temp=1;
        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++)
        {
            result[i] = temp;
            temp *= arr[i];
        }
        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= arr[i];
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
        result = new ProductOfArrayExcludingIndex().solution(arr);
        System.out.println("\n Another Solution :: ");
        for(int i:result){
            System.out.print(i+", ");
        }
    }
}
