package datastructure.linkedlist.doublylinkedlist.basicoperations;

/**
 * The type Doubly linked list template.
 */
public class DoublyLinkedListTemplate {
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
         * The Prev node.
         */
        public Node prevNode;
        /**
         * The Next node.
         */
        public Node nextNode;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        Node(T data){
            this.data=data;
            this.prevNode=null;
            this.nextNode=null;
        }
    }
    private Node headNode;
    private int size;

    /**
     * Instantiates a new Doubly linked list template.
     */
    DoublyLinkedListTemplate(){
        size=0;
    }
}
