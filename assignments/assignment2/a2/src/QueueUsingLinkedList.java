public class QueueUsingLinkedList {
    public Node front = null;
    public Node rear = null;
    public int length;

    public void enqueue(char data) {
        Node newNode = new Node(data);

        if(rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        length++;
    }

    public char dequeue() {
        if (front == null) return ' ';
        Node newNode = front;
        char data = front.data;
        front = front.next;
        if (front == null) rear=null;
        length--;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        System.out.println("Queue elements:");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.dequeue();
        queue.display();
    }
}
