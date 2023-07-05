package datastructure.linkedlist.basicoperations;

/**
 * The type Linked list template.
 */
public class LinkedListTemplate {

    /**
     * The type Node.
     *
     * @param <T> the type parameter
     */
    public class Node<T>{
        /**
         * The Data.
         */
        public T data;
        /**
         * The Next node.
         */
        public Node nextNode;
    }

    /**
     * The Head node.
     */
    public Node headNode;
    /**
     * The Size.
     */
    public int size;

    /**
     * Instantiates a new Linked list template.
     */
    LinkedListTemplate(){
        headNode=null;
        size=0;
    }
}
