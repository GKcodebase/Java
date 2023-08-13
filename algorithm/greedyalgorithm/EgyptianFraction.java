package algorithm.greedyalgorithm;

public class EgyptianFraction {
    public static void getFractions(int numerator, int denominator) {
        //if either numerator or denominator is zero
        if (denominator == 0 || numerator == 0) {
            return;
        }
        //numerator divides denominator -> fraction in 1/n form
        if (denominator % numerator == 0) {
            System.out.print("1/" + denominator / numerator);
            return;
        }
        //denominator can divide numerator -> number not a fraction
        if (numerator % denominator == 0) {
            System.out.println(numerator / denominator);
            return;
        }
        //if numerator greater than denominator
        if (numerator > denominator) {
            System.out.println(numerator / denominator + " , ");
            getFractions(numerator % denominator, denominator);
            return;
        }
        //denominator  greater than numerator here
        int n = denominator / numerator + 1;
        System.out.print("1/" + n + " , ");
        //call function recursively for remaining part
        getFractions(numerator * n - denominator, denominator * n);

    }
    public static void main(String[] args){

        //Example 1
        int numerator = 6, denominator = 14;
        System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is\n ");
        getFractions(numerator, denominator);
        System.out.println();

        //Example 2
        numerator = 2;
        denominator = 3;
        System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is\n ");
        getFractions(numerator, denominator);

    }
}
