package myLibrary.DataStructures.LL;

public class SinglyLinkedList {
    /**
     * Node class for SinglyLinkedList
     */
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // instant variables
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int getSize() { return this.size; }

    public Node getHead() { return this.head; }
    public Node getTail() { return this.tail; }

    public int getHeadData() { return this.head.data; }

    public int getTailData() { return this.tail.data; }

    /**
     * Insert at the end of the list
     * @param data data of the new node
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) head = newNode;
        else tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Insert at the beginning of list
     * @param data data of the new node
     */
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Inserts a new data after the first instance of value
     * @param data data of the new node
     * @param position index of the new node
     */
    public void insertAtPosition(int data, int position) throws IndexOutOfBoundsException{
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Index out of bounds" + position);
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node currentNode = head;
        Node newNode = new Node(data);
        int index = 0;

        while (index != position-1 && currentNode != null) {
            currentNode = currentNode.next;
            index++;
        }

        if (currentNode == null) {
            insert(data);
        } else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }

        if (tail.next != null) { tail = newNode; }
    }

    /**
     * Check to see if data is in the lis
     * @param target data to find
     * @return true if data  is in the list
     */
    public boolean search(int target) {
        Node current = head;

        while(current != null) {
            if (current.data == target) return true;
            current = current.next;
        }

        return false;
    }

    /**
     * Reverse linked list
     */
    public void reverse(){
        Node currentNode = head;
        Node nextNode = null;
        Node prevNode = null;

        tail = head;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        head = prevNode;
    }

    /**
     * Delete a node by redirecting its pointers.
     * @param target delete node with specified data
     */
    public void delete(int target){
        Node currentNode = head;
        Node prevNode = null;

        if (currentNode != null && currentNode.data == target) {
            head = currentNode.next;
            return;
        }

        while (currentNode != null && currentNode.data != target) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return;
        }

        prevNode.next = currentNode.next;
    }

    /**
     * Combine two singly linked list
     * @param otherList
     */
    public void concatenate(SinglyLinkedList otherList) {
        if (isEmpty()) {
            head = otherList.getHead();
        } else {
            tail.next = otherList.getHead();
        }
        tail = otherList.getTail();
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() { return head == null; }

    /**
     * Traverse linked list and print to terminal
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }

        Node current = head;
        while ( current != null ){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
