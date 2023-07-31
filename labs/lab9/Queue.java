
public class Queue {
    private int length = 0;
    private int max = 101;
    private GraphNode front = null;
    private GraphNode rear = null;

    // Enqueue
    public void enqueue(int data)
    {
        if (length >= max) {
            System.out.println("Queue is full");
            return;
        }

        GraphNode newNode = new GraphNode(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next= newNode;
            rear= newNode;
        }

        length++;
    }

    public GraphNode getFront(){
        return this.front;
    }

    // Dequeue
    public int dequeue()
    {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return 0;
        } else {
            int data = front.data;
            front = front.next;
            length--;
            return data;
        }
    }

    // Display queue
    public void display()
    {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        } else {
            GraphNode current = front;

            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }

            System.out.println();
        }
    }

    // check if Queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}
