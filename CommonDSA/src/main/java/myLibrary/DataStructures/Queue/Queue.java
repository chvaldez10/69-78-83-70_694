package myLibrary.DataStructures.Queue;

import org.w3c.dom.Node;

public class Queue {
    /**
     * Node class for Queue
     */
    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    private int length = 0;
    private int max;
    private Node front = null;
    private Node rear = null;

    public Queue(int max) { this.max = max; }

    public int getMax() { return this.max; }

    public int getLength() { return this.length; }

    public void enqueue(int data) {
        if (length >= max) {
            System.out.println("Stack Overflow.");
            return;
        }

        Node newNode = new Node(data);
        if(isEmpty()) front = newNode;
        else rear.next = newNode;
        rear = newNode;
        length++;
    }

    public boolean isEmpty() { return front == null; }

}
