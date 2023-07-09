package datastructure.linkedlist.singlylinkedlist.basicoperations;

import java.util.HashMap;
import java.util.Map;

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
     * Length.
     */
    public void length(){
        //return size;
        int l=0;
        Node temp = headNode;
        while(temp!=null){
            l++;
            temp=temp.nextNode;
        }
        System.out.println("\nLength of th given list is :: "+l);
    }

    /**
     * Get middle string.
     *
     * @return the string
     */
    public String getMiddle(){
        Node fast = headNode;
        Node slow = headNode;
        while(fast.nextNode!=null && slow !=null){
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }
        return slow.data.toString();
    }

    /**
     * Remove repeated.
     */
    public void removeRepeated(){
        Map map = new HashMap();
        Node temp = headNode;
        Node prev = headNode;
        while(temp!=null){
            if(map.containsKey(temp.data)){
                prev.nextNode=temp.nextNode;

            }else{
                map.put(temp.data,1);
            }
            prev=temp;
            temp=temp.nextNode;
        }
    }

    /**
     * Union and intersection.
     *
     * @param list1 the list 1
     * @param list2 the list 2
     */
    public void unionAndIntersection(SingleLinkedList list1, SingleLinkedList list2){
        Map map = new HashMap();
        Node temp = list1.headNode;
        SingleLinkedList intersection  = new SingleLinkedList();
        while(temp!=null){
            map.put(temp.data,1);
            temp=temp.nextNode;
        }
        while(list2.headNode!=null){
            if(map.containsKey(list2.headNode.data)){
                    intersection.insertAtFront((int)list2.headNode.data);
            }else{
                list1.insertAtEnd((int)list2.headNode.data);
            }
            list2.headNode=list2.headNode.nextNode;
        }
        System.out.print("\n Intersection list :: " );
        Node it = intersection.headNode;
        while(it!=null){
            System.out.print(it.data+" ");
            it=it.nextNode;
        }

        System.out.print("\n Union list :: " );
        while(list1.headNode!=null){
            System.out.print(list1.headNode.data+" ");
            list1.headNode=list1.headNode.nextNode;
        }
    }

    /**
     * Nth node from end string.
     *
     * @param n the n
     * @return the string
     */
    public String nthNodeFromEnd(int n){
        Node temp = headNode;
        Node fast  = headNode;
        while(n>0&&fast!=null){
            fast=fast.nextNode;
            n--;
        }
        while(fast!=null){
            fast= fast.nextNode;
            temp=temp.nextNode;
        }
        return temp.data.toString();
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
