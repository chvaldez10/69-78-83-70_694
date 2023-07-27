package myLibrary.DataStructures.Tree;

public class Queue {
	private int length = 0;
	private int max=100;
	private QNode front = null;
	private QNode rear = null;

	// Enqueue
	public void enqueue(Node data)
	{
		if (length >= max) {
			System.out.println("Queue is full");
			return;
		}

		QNode newNode = new QNode(data);

		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next= newNode;
			rear= newNode;
		}

		length++;
	}
	
	// Dequeue
	public Node dequeue()
	{
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return null;
		} else {
			Node data = front.nodeData;
			front = front.next;
			if(front == null) rear = null;
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
			QNode current = front;

			while (current != null) {
				System.out.print(current.nodeData.data + " ");
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
