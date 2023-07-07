package datastructure.linkedlist.doublylinkedlist.tailnode;

/**
 * The type Linked list with tail node.
 */
public class LinkedListWithTailNode {
    /**
     * The type Node.
     *
     * @param <T> the type parameter
     */
    public class Node<T>{
        /**
         * The Data.
         */
        T data;
        /**
         * The Prev node.
         */
        Node prevNode;
        /**
         * The Next node.
         */
        Node nextNode;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        Node(T data){
            this.prevNode=null;
            this.nextNode=null;
            this.data=data;
        }
    }

    /**
     * The Size.
     */
    int size;
    /**
     * The Head node.
     */
    Node headNode;
    /**
     * The Tail node.
     */
    Node tailNode;

    /**
     * Instantiates a new Linked list with tail node.
     */
    LinkedListWithTailNode(){
        this.size=0;
        this.headNode=null;
        this.tailNode=null;
    }

    /**
     * Insert head.
     *
     * @param data the data
     */
    public void insertHead(int data){
         Node node  = new Node(data);
         node.nextNode=this.headNode;
         node.prevNode=null;
         if(null==headNode){
             tailNode=node;
         }
         else{
             headNode.prevNode=node;
         }
        this.headNode=node;
    }

    /**
     * Insert tail.
     *
     * @param data the data
     */
    public void insertTail(int data){
        if(null==headNode){
            insertHead(data);
            return;
        }
        Node node = new Node(data);
        node.prevNode=tailNode;
        tailNode.nextNode=node;
        tailNode=node;
    }

    /**
     * Delete head.
     */
    public void deleteHead(){
         headNode=headNode.nextNode;
         headNode.prevNode=null;
    }

    /**
     * Delete tail.
     */
    public void deleteTail(){
        tailNode=tailNode.prevNode;
        tailNode.nextNode=null;
    }

    /**
     * Print list.
     */
    public void printList(){
        Node temp = headNode;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.nextNode;
        }
    }


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String [] args){
         LinkedListWithTailNode linkedList = new LinkedListWithTailNode();
         linkedList.insertHead(10);
         linkedList.insertHead(9);
         linkedList.insertHead(5);
         linkedList.insertTail(20);
         linkedList.insertTail(30);
         linkedList.insertTail(35);
         linkedList.printList();
         linkedList.deleteHead();
         linkedList.deleteHead();
         linkedList.deleteTail();
        System.out.print("\n List after deletion :: ");
         linkedList.printList();
    }
}
