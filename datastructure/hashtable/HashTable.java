package datastructure.hashtable;

import java.util.ArrayList;

/**
 * The type Hash table.
 */
public class HashTable {
    /**
     * The Bucket.
     */
    private static ArrayList<HashEntry> bucket;
    /**
     * The Slots.
     */
    private static int slots;
    /**
     * The Size.
     */
    private static int size;

    /**
     * Instantiates a new Hash table.
     */
//Constructor
    public HashTable() {
        bucket = new ArrayList<HashEntry>();
        slots = 10;
        size = 0;
        //initialize buckets
        for (int i = 0; i < slots; i++)
            bucket.add(null);

    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return size;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Gets index.
     *
     * @param key the key
     * @return the index
     */
    private static int getIndex(String key) {

        //hashCode is a built in function of Strings
        int hashCode = key.hashCode();
        int index = hashCode % slots;
        //Check if index is negative
        if(index<0){
            index=(index + slots) % slots;
        }
        return index;
    }
    public static void insert(String key,int value){
        int bIndex = getIndex(key);
        HashEntry head = bucket.get(bIndex);
        while (head!=null){
            if(head.key.equals(key))
                head.value=value;
            head=head.next;
        }
        size++;
        head=bucket.get(bIndex);
        HashEntry newSlot = new HashEntry(key,value);
        bucket.set(bIndex, newSlot);

        //Checks if array >60% of the array gets filled
        if ((1.0*size)/slots >= 0.6)
        {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList();
            slots = 2 * slots;
            size = 0;
            for (int i = 0; i < slots; i++)
                bucket.add(null);

            for (HashEntry head_Node : temp)
            {
                while (head_Node != null)
                {
                    insert(head_Node.key, head_Node.value);
                    head_Node = head_Node.next;
                }
            }
        }
    }
}