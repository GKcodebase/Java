/**
 * A single digit from '1' to '9' can be decoded as a letter ('A' to 'I').
 * A pair of digits forming a number from 10 to 26 can be decoded as a letter ('J' to 'Z').
 * A '0' cannot be decoded on its own (as there's no letter for '0'), but it can be part of a valid pair like '10' or '20'.
 * If a digit or pair cannot form a valid letter, the string is invalid for that decoding path.
 */
public class NoOfWaysToDecodeString {

   public static int numDecodings(String s) {
        if( null == s || s.length() == 0) return 0;
        int l = s.length();
        int dp[] = new int[l+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == 0?0:1;

        for(int i=2;i<=l;i++){
            int singleDigit = Integer.parseInt(s.substring(i-1, i));
            int doubleDigit = Integer.parseInt(s.substring(i-2,i));

            if(singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i-1];
            }
            if(doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[l];
   }
    public static void main(String[] args) {
        System.out.println(numDecodings("12")); // 2
        System.out.println(numDecodings("2")); // 1
        System.out.println(numDecodings("226")); // 3
        System.out.println(numDecodings("0")); // 0
        System.out.println(numDecodings("06")); // 0
        System.out.println(numDecodings("100")); // 0
        System.out.println(numDecodings("10")); // 1
        System.out.println(numDecodings("27")); // 1
        System.out.println(numDecodings("123")); // 3


    }
}
