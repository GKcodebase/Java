package CheatSheet.SortingAlgorithm;

/**
 * The Merge sort.
 */
public class MergeSort {
    /**
     * Merge sort.
     *
     * @param arr   the arr
     * @param left  the left
     * @param right the right
     */
    public static void mergeSort(int arr[] , int left, int right){
        if(left<right){
            int mid = (left+right)/2;

            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }

    }

    /**
     * Merge.
     *
     * @param arr   the arr
     * @param left  the left
     * @param mid   the mid
     * @param right the right
     */
    private static void merge(int arr[] , int left, int mid, int right){

        int n1 = mid-left+1;
        int n2 = right-mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;++i)
            L[i] = arr[left+i];
        for(int j=0;j<n2;j++)
            R[j] = arr[mid+j+1];

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i++];
            } else{
                arr[k]=R[j++];
            }
            k++;
        }
        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=R[j++];
        }

    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int arr[] = {10,3,1,2,4,9,5,6,8,7};
        mergeSort(arr,0,arr.length-1);

        for(int num : arr)
            System.out.print(num+" ");
    }
}
