package datastructure.hashtable;

/**
 * The type Hash entry.
 */
class HashEntry {
    /**
     * The Key.
     */
    String key;
    /**
     * The Value.
     */
    int value;

    /**
     * The Next.
     */
// Reference to next entry
    HashEntry next;

    /**
     * Instantiates a new Hash entry.
     *
     * @param key   the key
     * @param value the value
     */
// Constructor
    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
