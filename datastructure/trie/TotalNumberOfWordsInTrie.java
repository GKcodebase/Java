package datastructure.trie;

import java.util.Arrays;

/**
 * The type Total number of words in trie.
 */
public class TotalNumberOfWordsInTrie {
    /**
     * Count word int.
     *
     * @param root the root
     * @return the int
     */
    public static int countWord(TrieNode root){
        int count =0;
        if(root.isEndWord())
            count++;
        for(int i =0;i<26;i++){
            if(null!=root.getChildren()[i])
                count+=countWord(root.getChildren()[i]);
        }
        return count;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        System.out.println("Number of words in the Trie :: "+countWord(t.getRoot()));
    }
}
