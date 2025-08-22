/**
 * Given an array of strings strs, 
 * sort the array in ascending order based on the total frequency of 
 * unique characters across all strings. If two strings have the same frequency of unique characters, 
 * sort them lexicographically in ascending order (dictionary order). 
 * Return the sorted array.
 * 
 */
import java.util.*;

public class SortStringsbyFrequencyofCharacters {

    public static void sortStringByFrequency(String [] strings){
        Map<String,Integer> frequencyMap = new HashMap<>();
        for(String str: strings){
            Set<Character> charSet = new HashSet<>();
            for(char c : str.toCharArray()){
                charSet.add(c);
            }
            frequencyMap.put(str,charSet.size());
        }
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
    public static void main(String[] args){
        String[] strings = {"apple", "banana", "cherry", "date"};
        sortStringByFrequency(strings);
    }
}
