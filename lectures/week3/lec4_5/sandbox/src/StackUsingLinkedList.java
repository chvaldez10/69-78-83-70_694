/**
 *  Stack implementation using linked list (LL)
 *
 *  Uses: Node.java
 */


import java.util.EmptyStackException;

public class StackUsingLinkedList {
    public int length;
    public Node top = null;

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length ++;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int pop(){
        if (isEmpty()) throw new EmptyStackException();
        int data = top.data;
        top = top.next;
        length--;
        return data;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Stack  Underflow");
            return;
        } else {
            Node current = top;
            System.out.println("Stack: ");

            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }

            System.out.println("\n\n");
        }
    }

    public void displayReverse(){
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        } else {
            StackUsingLinkedList tmpStack = new StackUsingLinkedList();
            Node current = top;

            while(current != null) {
                tmpStack.push(current.data);
                current = current.next;
            }

            while(!tmpStack.isEmpty()) System.out.print(tmpStack.pop() + " ");
            System.out.println("\n");
        }
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
    }
}
