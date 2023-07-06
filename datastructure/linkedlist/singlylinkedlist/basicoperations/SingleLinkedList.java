package datastructure.linkedlist.singlylinkedlist.basicoperations;

/**
 * The type Single linked list.
 */
public class SingleLinkedList {
    private class Node<T> {
        /**
         * The Data.
         */
        public T data;
        /**
         * The Next node.
         */
        public Node nextNode;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        Node(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    private Node headNode;
    private int size = 0;

    /**
     * Instantiates a new Single linked list.
     */
    SingleLinkedList() {
        headNode = null;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return headNode == null;
    }

    /**
     * Insert at front.
     *
     * @param data the data
     */
    public void insertAtFront(int data) {
        size++;
        Node node = new Node(data);
        if (null == headNode)
            headNode = node;
        else {
            node.nextNode=headNode;
            headNode=node;
        }
    }

    /**
     * Insert at end.
     *
     * @param data the data
     */
    public void insertAtEnd(int data) {
        size++;
        Node node = new Node(data);
        if (null == headNode)
            headNode = node;
        else {
           Node temp = headNode;
           while(null != temp.nextNode){
               temp=temp.nextNode;
           }
           temp.nextNode=node;
        }
    }

    /**
     * Insert after.
     *
     * @param data     the data
     * @param position the position
     */
    public void insertAfter(int data,int position) {
        size++;
        Node node = new Node(data);
        if (null == headNode)
            headNode = node;
        else {
            Node temp = headNode;
            while(0< position--){
                temp=temp.nextNode;
            }
            node.nextNode=temp.nextNode;
            temp.nextNode=node;
        }
    }

    /**
     * Search boolean.
     *
     * @param q the q
     * @return the boolean
     */
    public boolean search(int q){
        Node temp = headNode;
        int l =0;
        while(temp!=null ){
            if(temp.data.equals(q)){
                return true;
            }
            l++;
            temp=temp.nextNode;
        }
        return false;
    }

    public void deleteHead(){
        size--;
        headNode = headNode.nextNode;
    }
    public void deleteTail(){
        size--;
        Node temp = headNode;
        while(temp.nextNode.nextNode!=null){
            temp=temp.nextNode;
        }
        temp.nextNode=null;
    }

    /**
     * Delete value.
     *
     * @param data the data
     */
    public void deleteValue(int data){
        size--;
        Node temp = headNode;
        Node prev = headNode;
        while(!temp.data.equals(data)){
            prev = temp;
            temp=temp.nextNode;
        }
        prev.nextNode=temp.nextNode;
    }

    /**
     * Print list.
     */
    public void printList(){
        Node temp = headNode;
        while(null!= temp){
            System.out.print(temp.data+" ");
            temp=temp.nextNode;
        }
    }

}