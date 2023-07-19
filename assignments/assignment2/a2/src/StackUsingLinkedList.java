import java.util.EmptyStackException;

public class StackUsingLinkedList {
    public int length;
    public Node top = null; //same as tail

    public void push(char data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length ++;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public char pop(){
        if (isEmpty()) throw new EmptyStackException();
        char data = top.data;
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

            while(!tmpStack.isEmpty()) {
                System.out.print(tmpStack.pop() + " ");
            }

            System.out.println("\n");
        }
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.displayReverse();
    }

}
