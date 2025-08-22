import java.util.*;
public class BackTrack_Permutation {
    public static List<List<Integer>> generate(int [] arr){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,0,arr);
        return result;
    } 

    public static void backtrack(List<List<Integer>> result , int start, int[] num){
        if(start == num.length){
           List<Integer> temp = new ArrayList<>();
           for(int i: num)
                temp.add(i);
            result.add(temp);
        }

        for(int i = start;i<num.length;i++){
            swap(num, start, i);
            backtrack(result, start + 1, num);
            swap(num, start, i);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permutations = generate(arr);
        for(List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}
