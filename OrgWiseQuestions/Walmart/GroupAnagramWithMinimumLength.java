import java.util.*;

/**
 * The {@code GroupAnagramWithMinimumLength} class provides a method to group strings
 * that are anagrams of each other, with the additional constraint that only strings
 * with a minimum specified length are considered.
 *
 * <p>Anagrams are grouped together if they contain the same characters in any order.
 * The grouping is performed by calculating the sum of the character codes for each string,
 * which is a simplistic approach and may not handle all anagram cases correctly.
 *
 * <p>Usage example:
 * <pre>
 *     String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat", "ta", "at" };
 *     int minLength = 3;
 *     List<List<String>> result = GroupAnagramWithMinimumLength.groupAnagram(strs, minLength);
 * </pre>
 *
 * <p>Only groups with more than one string are included in the result.
 */
public class GroupAnagramWithMinimumLength {

    public static List<List<String>> groupAnagram(String[] strs, int minLength) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            if (str.length() >= minLength) {
                int temp = 0;
                for (char c : str.toCharArray()) {
                    temp += (int) c;
                }
                map.putIfAbsent(temp, new ArrayList<>());
                map.get(temp).add(str);
            }
        }

        for (List<String> group : map.values()) {
            if (group.size() <= 1)
                continue; // Skip groups with less than 1 anagrams
            result.add(group);
        }

        return result;

    }

    public static void main(String args[]) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat", "ta", "at" };
        int minLength = 3;
        List<List<String>> result = groupAnagram(strs, minLength);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
