package CheatSheet.Basics;

import java.math.BigInteger;

/**
 * The Maths.
 */
public class Maths {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int a =10;
        int b =20;

        // Math Class
        Math.max(a, b);         // Maximum
        Math.min(a, b);         // Minimum
        Math.abs(-5);           // Absolute value
        Math.pow(2, 3);         // Power (2^3)
        Math.sqrt(16);          // Square root

        String str = "10";
        int num =10;
        // Number Conversion
        Integer.parseInt(str);  // String to int
        String.valueOf(num);    // Number to String

        //Big Integer - for doing math for big numbers
        BigInteger bigNumber = new BigInteger("1209095900902535");
        bigNumber.add(new BigInteger("234567876543"));
        bigNumber.multiply(new BigInteger("5432"));
    }
}
