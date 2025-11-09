public class LCM {
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args){
        int a = 10;
        int b = 20;
        int result = lcm(a, b);
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
        System.out.println("LCM of " + a + " and " + b + " is: " + result);
    }
    public static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }
}
