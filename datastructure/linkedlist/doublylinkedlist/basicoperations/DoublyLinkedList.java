package datastructure.linkedlist.doublylinkedlist.basicoperations;

/**
 * The type Doubly linked list.
 */
public class DoublyLinkedList {
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
        public Node(T data){
            this.data=data;
            this.prevNode=null;
            this.nextNode=null;
        }

    }

    /**
     * The Size.
     */
    int size=0;
    /**
     * The Head node.
     */
    Node headNode;

    /**
     * Instantiates a new Doubly linked list.
     */
    DoublyLinkedList(){
        this.headNode=null;
    }

    /**
     * Print list.
     */
    public void printList(){
        Node temp = headNode;
        while(null != temp){
            System.out.print(temp.data+" ");
            temp=temp.nextNode;
        }
    }

    /**
     * Insert at head.
     *
     * @param data the data
     */
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if(headNode==null)
            headNode=newNode;
        else{
            newNode.nextNode=headNode;
            headNode.prevNode=newNode;
            headNode=newNode;
        }
    }

    /**
     * Insert at end.
     *
     * @param data the data
     */
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        Node temp = headNode;
        if(headNode==null)
            headNode=newNode;
        else{
            while(temp.nextNode!=null){
                temp = temp.nextNode;
            }
            temp.nextNode=newNode;
            newNode.prevNode=temp;
        }
    }
}
