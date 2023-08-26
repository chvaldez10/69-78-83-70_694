package myLibrary.DataStructures.Stack;

public class Stack {
    /**
     * Node class for Stack
     */
    private class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data  = data;
            this.next = null;
        }
    }

    // instant variables
    private int length = 0;
    private int max;
    private Node top = null;

    public Stack(int max) {
        this.max = max;
    }

    public int getLength(){ return this.length; }

    public int getMax() {return this.max; }

    /**
     * Add data at the top of stack.
     * @param data node data
     */
    public void push(int data){

        if( length >= max ) {
            System.out.println("Stack Overflow.");
        } else {
            Node newNode = new Node(data);
            newNode.next= top;
            top = newNode;
            length++;
        }
    }

    /**
     * Return data at the top of stack.
     *
     * @return data at the top of stack
     */
    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return 0;
        } else {
            int data = top.data;
            top = top.next;
            length--;
            return data;
        }
    }

    /**
     * Checks if Stack is empty.
     * @return true if stack is empty.
     */
    public boolean isEmpty(){
        return top == null;
    }
}
