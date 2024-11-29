package CheatSheet.Basics;

/**
 * The Bit manipulation.
 */
public class BitManipulation {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){

        int a =1;
        int b =1;
        int c =0;
        // Bitwise Operations
        c=a & b;     // Bitwise AND
        c=a | b;     // Bitwise OR
        c=a ^ b;     // Bitwise XOR
        c=~a;        // Bitwise NOT
        c=a << 1;    // Left shift (multiply by 2)
        c=a >> 1;    // Right shift (divide by 2)

        int n = 100;
    // Check if number is power of 2
        boolean isPowerOfTwo = (n & (n-1)) == 0;

    // Count set bits
        Integer.bitCount(n);
    }
}
