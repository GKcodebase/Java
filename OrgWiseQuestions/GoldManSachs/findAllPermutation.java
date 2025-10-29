/**
 * Utility class to generate and print all permutations of a given string.
 *
 * <p>
 * This class demonstrates a simple recursive algorithm that builds permutations
 * by selecting each character in turn and recursing on the remaining characters.
 * Each complete permutation is printed to System.out as it is constructed.
 * </p>
 *
 * <p>Behavior:
 * <ul>
 *   <li>The recursive helper {@code findPermutations(String, String)} takes two
 *       arguments: {@code str} (characters left to permute) and {@code ans}
 *       (prefix built so far).</li>
 *   <li>When {@code str} is empty, {@code ans} is a complete permutation and is printed.</li>
 * </ul>
 * </p>
 *
 * <p>Complexity:
 * <ul>
 *   <li>Time: O(n * n!) where n is the length of the input string (n! permutations, each of length n printed).</li>
 *   <li>Space: O(n) additional stack space for recursion depth (not counting output).</li>
 * </ul>
 * </p>
 *
 * <p>Notes:
 * <ul>
 *   <li>The implementation prints permutations directly; it does not return a collection.</li>
 *   <li>If the input contains duplicate characters, duplicate permutations will be produced.</li>
 * </ul>
 * </p>
 *
 * <p>Example usage: call {@code findPermutations("ABC", "")} to print:
 * {@code ABC, ACB, BAC, BCA, CAB, CBA} (each on its own line).</p>
 */
 
/**
 * Recursively generates and prints all permutations of the characters in {@code str}.
 *
 * <p>Algorithm:
 * For each index {@code i} in {@code str}, the character at {@code i} is chosen
 * as the next character in the permutation, removed from {@code str}, appended
 * to {@code ans}, and the method recurses on the remaining characters.</p>
 *
 * @param str the string containing characters yet to be placed in the permutation;
 *            on each recursive call one character is removed (the chosen character)
 *            and the remainder is passed down
 * @param ans the accumulated prefix (characters already chosen for the current permutation)
 *
 * <p>Side effects: Prints each complete permutation to standard output via {@code System.out.println}.</p>
 *
 * <p>Thread-safety: Not thread-safe with respect to output; the method itself uses no shared mutable state.</p>
 */
 
/**
 * Entry point for demonstration.
 *
 * <p>Constructs an example input string (currently "ABC") and invokes
 * {@link #findPermutations(String,String)} to print all permutations to standard output.</p>
 *
 * @param args command-line arguments (ignored)
 */
public class findAllPermutation {

    private  static void findPermutations(String str, String ans){
        if(str.length() ==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            findPermutations(ros, ans + ch);
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        findPermutations(str, "");
    }
}
