package myLibrary.DataStructures.LL;

public class DoublyLinkedList {
    private class Node{
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int getSize() { return this.size; }

    public int getHeadData() { return this.head.data; }

    public int getTailData() { return this.tail.data; }

    /**
     * Add to the end of the list
     * @param data
     */
    public void append(int data) {
        Node newNode = new Node(data);

        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
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
        Node current = head;

        if (isEmpty()) {
            System.out.println("Linked List is Empty");
            return;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}
