package myLibrary.DataStructures.LL;

public class SinglyLinkedList {
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
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node currentNode = head;
        int index = 0;

        while (index != position-1 && currentNode != null) {
            currentNode = currentNode.next;
            index++;
        }

        if (currentNode == null) {
            insert(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size ++;
        }
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
