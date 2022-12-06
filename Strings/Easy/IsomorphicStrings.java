package Strings.Easy;

/**
 * The type Isomorphic strings.
 */
public class IsomorphicStrings {

    /**
     * Is isomorphic boolean.
     * Check whether given two strings are isomorphic
     * eg :: egg and add , paper and title
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character, but a character may map to itself.
     *
     * @param s the s
     * @param t the t
     * @return the boolean
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        /**
         *
         *  use two maps to map the chars from each string,however,
         *  you can use the index information saved inside two strings,
         *  if two chars are 'equal', they should have same index.
         *
         * */
        int[] mMapArray = new int[256];
        int[] tMapArray = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (mMapArray[s.charAt(i)] != tMapArray[t.charAt(i)])
                return false;
            mMapArray[s.charAt(i)] = i + 1;
            tMapArray[t.charAt(i)] = i + 1;
        }
        return true;

    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        /**
         *
         * Driver code to run method.
         * */
        IsomorphicStrings strings = new IsomorphicStrings();
        System.out.println(strings.isIsomorphic("add","egg"));
        System.out.println(strings.isIsomorphic("bar","foo"));
    }
}
