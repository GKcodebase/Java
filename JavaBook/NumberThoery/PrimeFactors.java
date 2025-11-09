public class PrimeFactors {
    public static void primeFactors(int n){
        for(int i=2; i<=Math.sqrt(n);i++){
            while(n%i==0){
                System.out.print(i+" ");
                n=n/i;
            }
        }
        if(n>1){
            System.out.print(n+" ");
        }
    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        int n = 125;
        primeFactors(n);
        System.out.println();
        if(isPrime(n)){
            System.out.println(n + " is a prime number.");
        }else{
            System.out.println(n + " is not a prime number.");
        }
    }
}
