package datastructure.stackandqueue.stack;

import datastructure.stackandqueue.Queue;

/**
 * The type Binary number generation.
 */
public class BinaryNumberGeneration {
    /**
     * Find binary string [ ].
     *
     * @param number the number
     * @return the string [ ]
     */
    public static String[] findBinary(int number){
        String[]  result = new String[number];
        Queue<String> queue = new Queue<String>(number+1);

        queue.enqueue("1");
        for(int i=0; i< number ; i++){
            result[i] = queue.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(s1);
            queue.enqueue(s2);
        }
        return result;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        int count = 8;
        String[] output = findBinary(count);
        for(int i =0;i<count;i++){
            System.out.println(output[i]+" ");
        }
    }
}
