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

    private Node head = null;
    private Node tail = null;

    /**
     * Inserts a new node with the given data at the end of the list.
     * @param data The data of the new node.
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) head = newNode;
        else tail.next = newNode;
        tail = newNode;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() { return head == null; }
}
