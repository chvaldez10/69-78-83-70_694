package myLibrary.DataStructures.Queue;

import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class Queue {
    /**
     * Node class for Queue
     */
    public class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public class QueueOverflowException extends RuntimeException {

        public QueueOverflowException(String message) {
            super(message);
        }

        public QueueOverflowException(String message, Throwable cause) {
            super(message, cause);
        }
    }


    private int length = 0;
    private int max;
    private Node front = null;
    private Node rear = null;

    public Queue(int max) { this.max = max; }

    public int getMax() { return this.max; }

    public int getLength() { return this.length; }

    /**
     * Add data at the end of the Queue.
     *
     * @param data data at the end of the Queue
     */
    public void enqueue(int data) {
        if (length >= max) {
            throw new QueueOverflowException("Queue is full");
        }

        Node newNode = new Node(data);
        if(isEmpty()) front = newNode;
        else rear.next = newNode;
        rear = newNode;
        length++;
    }

    /**
     * Remove data at the front of the Queue
     *
     * @return data at the front of Queue
     */
    public int dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        } else {
            int data = front.data;
            front = front.next;
            length--;
            return data;
        }
    }

    /**
     * Checks if Queue is empty.
     * @return true if stack is empty.
     */
    public boolean isEmpty() { return front == null; }

    /**
     * @return true if Queue is full
     */
    public boolean isFull() {
        if(length == max) return true;
        else return false;
    }
}
