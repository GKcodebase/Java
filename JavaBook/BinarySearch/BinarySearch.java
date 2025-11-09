public class BinarySearch{
    public static boolean binarySearch(int[] arr, int target){
        int l = arr.length;
        int left = 0;
        int right = l - 1;
        while(left<=right){
            int mid  = left + (right - left) / 2;
            if(arr[mid] == target){
                return true;
            } else if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 7;
        boolean found = binarySearch(arr, target);
        if(found){
            System.out.println("Element " + target + " found in the array.");
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }   
    }
}