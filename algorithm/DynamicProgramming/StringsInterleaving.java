package algorithm.DynamicProgramming;

import java.util.HashMap;

/**
 * The type Strings interleaving.
 */
public class StringsInterleaving {
    /**
     * Find si object.
     *
     * @param m the m
     * @param n the n
     * @param p the p
     * @return the object
     */
    public static Object findSI(String m, String n, String p) {
        HashMap< String, Boolean > lookupTable = new HashMap < String, Boolean > ();
        return findSIRecursive(lookupTable, m, n, p, 0, 0, 0);
    }

    /**
     * Find si recursive boolean.
     *
     * @param lookupTable the lookup table
     * @param m           the m
     * @param n           the n
     * @param p           the p
     * @param mIndex      the m index
     * @param nIndex      the n index
     * @param pIndex      the p index
     * @return the boolean
     */
    private static boolean findSIRecursive(HashMap<String, Boolean> lookupTable, String m, String n, String p, int mIndex, int nIndex, int pIndex) {
        if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
            return true;

        // if we have reached the end of 'p' but 'm' or 'n' still has some characters left
        if (pIndex == p.length())
            return false;
        String subProblemKey = String.valueOf(mIndex) + "-" + String.valueOf(nIndex) + "-" + String.valueOf(pIndex);
        if (lookupTable.containsKey(subProblemKey) == false) {
            boolean b1 = false, b2 = false;
            if (mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
                b1 = findSIRecursive(lookupTable, m, n, p, mIndex + 1, nIndex, pIndex + 1);

            if (nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
                b2 = findSIRecursive(lookupTable, m, n, p, mIndex, nIndex + 1, pIndex + 1);

            lookupTable.put(subProblemKey, b1 || b2);
        }
        boolean x = false;
        if (lookupTable.containsKey(subProblemKey))
            x = lookupTable.get(subProblemKey);
        return x;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        System.out.println(findSI("abd", "cef", "adcbef"));
        System.out.println(findSI("abc", "def", "abdccf"));
        System.out.println(findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}
