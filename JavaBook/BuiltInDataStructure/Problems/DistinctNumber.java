import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class DistinctNumber {

    public static int countDistinct(long[] arr){
        Set<Long> set = new HashSet<>();
        for(long i:arr)
            set.add(i);

        return set.size();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        System.out.println(countDistinct(arr));
    }
}
