package datastructure.trie;

/**
 * The type Trie.
 */
public class Trie {
    /**
     * The Root.
     */
    private TrieNode root;

    /**
     * Instantiates a new Trie.
     */
    Trie(){
        this.root =new TrieNode();
    }

    /**
     * Get index int.
     *
     * @param t the t
     * @return the int
     */
    public int getIndex(char t){
        return t - 'a';
    }

    /**
     * Insert.
     *
     * @param key   the key
     * @param value the value
     */
//Function to insert a key,value pair in the Trie
    public void insert(String key,int value){}

    /**
     * Search boolean.
     *
     * @param key the key
     * @return the boolean
     */
//Function to search given key in Trie
    public boolean search(String key){ return false;}

    /**
     * Delete boolean.
     *
     * @param key the key
     * @return the boolean
     */
//Function to delete given key from Trie
    public boolean delete(String key){ return false;}
}