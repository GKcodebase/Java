package algorithm.greedyalgorithm;

/**
 * The type Largest number.
 */
public class LargestNumber {
    /**
     * Find sum of digits int.
     *
     * @param num the num
     * @return the int
     */
    public static int findSumOfDigits(int num) {

        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    /**
     * Gets largest number.
     *
     * @param size the size
     * @param sum  the sum
     */
    //Brute Force
    public static void getLargestNumber(int size, int sum) {
        int num = 0;
        int startRange = (int) Math.pow(10, (size - 1));
        int endRange = (int) Math.pow(10, size);
        if (sum == 0) {
            if (size == 1)
                System.out.println("Largest number is " + 0);
            else
                System.out.println("Largest number is Not possible");
            return;
        }
        // sumOfDigits is greater than the maximum possible sum.
        if (sum > 9 * size) {
            System.out.println("Largest number is Not possible");
            return;
        }
        while (startRange < endRange) {
            if (findSumOfDigits(startRange) == sum) {
                if (num < startRange)
                    num = startRange;
            }
            startRange++;
        }
        System.out.println("Largest number is " + num);
    }

    /**
     * Find largest number.
     *
     * @param size the size
     * @param sum  the sum
     */
    public static void findLargestNumber(int size, int sum) {
        int[] result = new int[size];
        // If sum of digits is 0, then a number is possible only if number of digits is 1.
        if (sum == 0) {
            if (size == 1) {
                System.out.print(0);
            } else {
                System.out.print("None");
            }
            return;
        }
        // sumOfDigits is greater than the maximum possible sum.
        if (sum > 9 * size) {
            System.out.print("None");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (sum >= 9) {
                result[i] = 9;
                sum -= 9;
            } else {
                result[i] = sum;
                sum = 0;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(result[i]);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int sumOfDigits = 20;
        int numberOfDigits = 3;

        System.out.println("If sum of digits is 20 and number of digits is 3 then ");
        findLargestNumber(numberOfDigits, sumOfDigits);
        System.out.println();

        //Example 2
        sumOfDigits = 100;
        numberOfDigits = 2;

        System.out.println("If sum of digits is 100 and number of digits is 2 then ");
        findLargestNumber(numberOfDigits, sumOfDigits);

        System.out.println("If sum of digits is 5 and number of digits is 2 then ");
        findLargestNumber(2, 5);
    }
}
