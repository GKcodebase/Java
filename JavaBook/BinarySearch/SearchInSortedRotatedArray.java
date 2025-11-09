public class SearchInSortedRotatedArray {
    public static int search (int[] arr, int target){
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[left]<=arr[mid]){
                if(target>=arr[left] && target<arr[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            else{
                if(target>arr[mid] && target<=arr[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {9,10,14, 15, 18, 2, 3, 6 };
        int target = 3;
        int result = search(arr, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}
