/**
 * Given a string s having lowercase characters, 
 * find the length of the longest substring without repeating characters. 
 */
public class LongestSubStringWithoutRepeatingChars {
    public static int getMaxLengthString(String s){
        int maxLength =0;
        boolean visitedChar[] = new boolean[26];
        int left =0, right =0;
        String maxString = "";
        for( right =0;right<s.length();right++){
            char c = s.charAt(right);
            if(visitedChar[c-'a']){
                while(left<right && visitedChar[c-'a']){
                    visitedChar[s.charAt(left)-'a'] = false;
                    left++;
                }
            }
            visitedChar[c-'a'] = true;
            if(maxLength<(right-left+1)){
                maxLength = right - left +1;
                maxString= s.substring(left,right+1);
            }
        }
        System.out.println("Longest substring without repeating characters: " + maxString);
        return maxLength;
    }
    public static void main(String args[]){
        String s = "abcabcdabc";
        System.out.println("Length of longest substring without repeating characters: " + getMaxLengthString(s));
    }
}
