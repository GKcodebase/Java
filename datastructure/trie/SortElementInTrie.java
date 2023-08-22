package datastructure.trie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Sort element in trie.
 */
public class SortElementInTrie {
    /**
     * Gets words.
     *
     * @param root   the root
     * @param result the result
     * @param level  the level
     * @param str    the str
     */
//Recursive Function to generate all words in alphabetic order
    public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str) {
        //Leaf denotes end of a word
        if (root.isEndWord()) {
            //current word is stored till the 'level' in the character array
            String temp = "";
            for (int x = 0; x < level; x++) {
                temp += Character.toString(str[x]);
            }
            result.add(temp);
        }

        for (int i = 0; i < 26; i++) {
            if (root.getChildren()[i] != null) {
                //Non-null child, so add that index to the character array
                str[level] = (char) (i + 'a');
                getWords(root.getChildren()[i], result, level + 1, str);
            }
        }
    }

    /**
     * Sort array array list.
     *
     * @param arr the arr
     * @return the array list
     */
    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        char[] charArray = new char[20];
        getWords(trie.getRoot(), result, 0, charArray);
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc","ZETA","A"};

        System.out.println("Keys: " + Arrays.toString(keys));

        ArrayList<String> list = sortArray(keys);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
