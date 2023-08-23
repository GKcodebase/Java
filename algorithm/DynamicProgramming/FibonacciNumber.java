package algorithm.DynamicProgramming;

public class FibonacciNumber {

    public static int getFibonacciUsingDynamicProgramming(int n){
        int[] arr = new int[n];
        arr[0]=1;arr[1]=1;
        for(int i =2;i<n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

    public static int fib(int i) {
        if (i <= 1)
            return i;
        return fib(i - 1) + fib(i - 2);
    }

    public static void main(String[] args){
        System.out.println("Fibonacci number of 6 is "+getFibonacciUsingDynamicProgramming(6));
        System.out.println("Fibonacci number of 5 is "+fib(5));

    }
}
