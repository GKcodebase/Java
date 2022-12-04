package DSA.Arays.Easy;


/**
 * The type Sub array with given sum.
 */
public class SubArrayWithGivenSum {

    /**
     * Sub array sum.
     * Sub array of given sum with positive numbers, prints fist and last index of sub array.
     *
     * @param list the list
     * @param sum  the sum
     * @param size the size
     */
    public void subArraySum(int[] list, int sum, int size) {

        int start = 0;
        int curr_sum = list[0];
        for (int i = 1; i < size; i++) {
            while (curr_sum > sum && start < i - 1) {
                curr_sum -= list[start];
                start++;
            }
            if (curr_sum == sum) {
                System.out.print("Sum found between indexes ::  " + start + " and " + (i - 1));
                return;
            }
            curr_sum += list[i];

        }
        System.out.println("No array found");
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        int[] list = {15, 2, 4, 8, 9, 5, 2, 10, 23};
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        sum.subArraySum(list, 21, list.length);
    }
}
