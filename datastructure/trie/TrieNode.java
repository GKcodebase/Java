package datastructure.trie;

/**
 * The type Trie node.
 */
public class TrieNode {

    /**
     * Get children trie node [ ].
     *
     * @return the trie node [ ]
     */
    public TrieNode[] getChildren() {
        return children;
    }

    /**
     * Is end word boolean.
     *
     * @return the boolean
     */
    public boolean isEndWord() {
        return isEndWord;
    }

    /**
     * The Children.
     */
    private TrieNode children[];
    /**
     * The Is end word.
     */
    private boolean isEndWord;
    /**
     * The Alphabet size.
     */
    static final int ALPHABET_SIZE = 26;

    /**
     * Instantiates a new Trie node.
     */
    TrieNode(){
        this.isEndWord=false;
        this.children= new TrieNode[ALPHABET_SIZE];
    }

    /**
     * Mark as leaf.
     */
//Function to mark the currentNode as Leaf
    public void markAsLeaf(){
        this.isEndWord = true;
    }

    /**
     * Un mark as leaf.
     */
//Function to unMark the currentNode as Leaf
    public void unMarkAsLeaf(){
        this.isEndWord = false;
    }

}
