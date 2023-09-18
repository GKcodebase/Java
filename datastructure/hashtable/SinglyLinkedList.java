package datastructure.hashtable;

/**
 * The type Singly linked list.
 *
 * @param <T> the type parameter
 */
public class SinglyLinkedList<T> {
    /**
     * The type Node.
     */
//Node inner class for SLL
    public class Node {
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
//head node of the linked list
    public Node headNode;
    /**
     * The Size.
     */
    public int size;

    /**
     * Instantiates a new Singly linked list.
     */
//constructor
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    /**
     * Gets head node.
     *
     * @return the head node
     */
    public Node getHeadNode() {
        return headNode;
    }

    /**
     * Sets head node.
     *
     * @param headNode the head node
     */
    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {

        if (headNode == null) return true;
        return false;
    }

    /**
     * Insert at head.
     *
     * @param data the data
     */
//Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    /**
     * Insert at end.
     *
     * @param data the data
     */
//Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
        //if the list is empty then call insertATHead()
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        //iterate to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //make newNode the next element of the last node
        last.nextNode = newNode;
        size++;
    }

    /**
     * Insert after.
     *
     * @param data     the data
     * @param previous the previous
     */
//inserts data after the given prev data node
    public void insertAfter(T data, T previous) {

        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        //Start from head node
        Node currentNode = this.headNode;
        //traverse the list until node having data equal to previous is found
        while (currentNode != null && currentNode.data != previous) {
            currentNode = currentNode.nextNode;
        }
        //if such a node was found
        //then point our newNode to currentNode's nextElement
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    /**
     * Print list.
     */
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    /**
     * Search node boolean.
     *
     * @param data the data
     * @return the boolean
     */
//Searches a value in the given list.
    public boolean searchNode(T data) {
        //Start from first element
        Node currentNode = this.headNode;

        //Traverse the list till you reach end
        while (currentNode != null) {
            if (currentNode.data.equals(data))
                return true; //value found

            currentNode = currentNode.nextNode;
        }
        return false; //value not found
    }

    /**
     * Delete at head.
     */
//Deletes data from the head of list
    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the nextNode of the headNode equal to new headNode
        headNode = headNode.nextNode;
        size--;
    }

    /**
     * Delete by value.
     *
     * @param data the data
     */
//Deletes data given from the linked list
    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node currentNode = this.headNode;
        Node prevNode = null; //previous node starts from null

        if(currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)){
                prevNode.nextNode = currentNode.nextNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

    /**
     * Reverse.
     */
//Reverses the linked list
    public void reverse() {
        Node prev = null; //To keep track of the previous element, will be used in swapping links
        Node current = this.headNode; //firstElement
        Node next = null;

        //While Traversing the list, swap links
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        //Linking Head Node with the new First Element
        this.headNode = prev;
    }

    /**
     * Remove duplicates.
     */
    public void removeDuplicates() {
        Node current = headNode; // will be used for outer loop
        Node compare = null;     // will be used for inner loop

        while (current != null && current.nextNode != null) {
            compare = current;

            while (compare.nextNode != null) {
                if (current.data == compare.nextNode.data) {
                    compare.nextNode = compare.nextNode.nextNode;
                } else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }
}