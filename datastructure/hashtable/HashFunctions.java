package datastructure.hashtable;

/**
 * The type Hash functions.
 */
class HashFunctions
{
    /**
     * Hash fold int.
     *
     * @param key       the key
     * @param chunkSize the chunk size
     * @return the int
     */
    public static int hashFold(int key, int chunkSize) // Define the size of each divided portion
    {
        System.out.println ("Key: "+ key);
        String strKey = Integer.toString(key); // Convert integer into string for slicing
        int hashVal = 0;
        System.out.println("Chunks:");

        for(int i = 0; i < strKey.length(); i+=chunkSize)
        {
            if(i + chunkSize < strKey.length())
            {
                System.out.println(strKey.substring(i,i+chunkSize));
                hashVal += Integer.parseInt(strKey.substring(i,i+chunkSize));
            }
            else
            {
                System.out.println(strKey.substring(i,strKey.length()));
                hashVal+= Integer.parseInt(strKey.substring(i,strKey.length()));
            }
        }
        return hashVal;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main( String args[] )
    {
        int key = 3456789;
        int chunkSize = 2;
        System.out.println("Hash Key: " + hashFold(key, chunkSize));
        //try another case with different values
    }
}