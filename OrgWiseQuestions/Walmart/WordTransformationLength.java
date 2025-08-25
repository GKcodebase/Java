/**
 * Given a string s consisting of lowercase English letters and an integer k, transform the string k times. In each transformation:
 * Every character in the string is replaced by the next alphabetical character (e.g., 'a' becomes 'b', 'b' becomes 'c', ..., 'y' becomes 'z').
 * If the character is 'z', it transforms into 'ab', adding an extra character to the string.
 * Return the length of the resulting string after k transformations.
 */
public class WordTransformationLength {
    private static int getTransformedLength(String s , int k){
    // Initial length
        long result = s.length();
        
        // Count frequency of each character
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // For each character 'c', calculate how many times it becomes 'z'
        for (int c = 0; c < 26; c++) {
            if (freq[c] == 0) continue; // Skip if no occurrences
            
            // When does character c become 'z'? Solve: c + t ≡ 25 (mod 26)
            long offset = (25 - c + 26) % 26;
            
            // Count number of transformations where c becomes 'ab'
            if (offset < k) {
                long count = (((long) k - 1 - offset) / 26) + 1;
                result += freq[c] * count; // Each 'ab' adds 2 to length
            }
        }
        
        return (int)result;
    }
    public static void main(String args[]){
        String s = "a";
        int k = 26;
        System.out.println(getTransformedLength(s,k));
    }
    
}
