package datastructure.trie;

import java.util.Locale;

/**
 * The type Trie.
 */
public class Trie {

    /**
     * The Root.
     */
    private TrieNode root;

    /**
     * Gets root.
     *
     * @return the root
     */
    public TrieNode getRoot() {
        return root;
    }

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
     * @param key the key
     */
//Function to insert a key,value pair in the Trie
    public void insert(String key){

        if(null==key){
            System.out.println("Null Key can not be Inserted!");
            return;
        }
        key=key.toLowerCase();
        TrieNode node = this.root;
        int index =0;

        for(int level =0 ;level<key.length();level++){
            index=getIndex(key.charAt(level));
            if(null==node.getChildren()[index]){
                node.getChildren()[index]=new TrieNode();
            }
            node=node.getChildren()[index];
        }
        node.markAsLeaf();
    }

    /**
     * Search boolean.
     *
     * @param key the key
     * @return the boolean
     */
//Function to search given key in Trie
    public boolean search(String key){
        if(null==key)
            return false;
        key=key.toLowerCase();
        TrieNode currentNode = this.root;
        int index =0;

        for(int level =0;level<key.length();level++){
            index = getIndex(key.charAt(level));
            if(currentNode.getChildren()[index]==null)
                return false;
            currentNode=currentNode.getChildren()[index];
        }
        return currentNode.isEndWord();
    }

    /**
     * Delete boolean.
     *
     * @param key the key
     * @return the boolean
     */
//Function to delete given key from Trie
    public boolean delete(String key){
        if(null==root || null == key)
            return false;
        return deleteHelper(key,root,key.length(),0);
    }

    /**
     * Delete helper boolean.
     *
     * @param key         the key
     * @param currentNode the current node
     * @param length      the length
     * @param level       the level
     * @return the boolean
     */
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
        boolean deletedSelf = false;

        if (currentNode == null) {
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length) {
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)) {
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        } else {
            TrieNode childNode = currentNode.getChildren()[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                //Making children pointer also null: since child is deleted
                currentNode.getChildren()[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord()) {
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)) {
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else {
                    currentNode = null;
                    deletedSelf = true;
                }
            } else {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    /**
     * Has no children boolean.
     *
     * @param currentNode the current node
     * @return the boolean
     */
    private boolean hasNoChildren(TrieNode currentNode) {
        for (int i = 0; i < currentNode.getChildren().length; i++) {
            if ((currentNode.getChildren()[i]) != null)
                return false;
        }
        return true;
    }
}
