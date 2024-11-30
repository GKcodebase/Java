package CheatSheet.SortingAlgorithm;

/**
 * The Bubble sort.
 */
public class BubbleSort {
    /**
     * Bubble sort.
     *
     * @param arr the arr
     */
    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int arr[] = {2,9,14,1,0,4,-1,20,34,18,16};
        bubbleSort(arr);
    }
}
