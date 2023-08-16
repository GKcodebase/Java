package datastructure.trie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Find all words in trie.
 */
public class FindAllWordsInTrie {
    /**
     * Get words array list.
     *
     * @param root the root
     * @return the array list
     */
    public static ArrayList<String> getWords(TrieNode root){
        ArrayList<String> stringArrayList = new ArrayList<>();
        char[] chararr = new char[20];
        getWords(root, stringArrayList, 0, chararr);
        return stringArrayList;
    }

    /**
     * Gets words.
     *
     * @param root            the root
     * @param stringArrayList the string array list
     * @param level           the level
     * @param str             the str
     */
    private static void getWords(TrieNode root, ArrayList<String> stringArrayList, int level, char[] str) {
        if(root.isEndWord()){
            String temp = "";
            for (int x = 0; x < level; x++) {
                temp += Character.toString(str[x]);
            }
            stringArrayList.add(temp);
        }
        for (int i = 0; i < 26; i++) {
            if (root.getChildren()[i] != null) {
                //Non-null child, so add that index to the character array
                str[level] = (char)(i + 'a');
                getWords(root.getChildren()[i], stringArrayList, level + 1, str);
            }
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie
        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        ArrayList < String > list = getWords(t.getRoot());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
