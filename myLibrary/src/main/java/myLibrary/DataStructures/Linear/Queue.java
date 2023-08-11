/**
 *  Class to represent a Queue using linked lists. Containing methods:
 *      - enqueue(), dequeue(), display(), isEmpty()
 *
 *  Uses: LLNode.java
 *
 * @author Christian Valdez
 */


package myLibrary.DataStructures.Linear;

public class Queue {
	private int length = 0;
	private int max;
	private LLNode front = null;
	private LLNode rear = null;

	public Queue(int max) { this.max = max; }

	/**
	 * Insert data at the end of the queue if it's not full.
	 *
	 * @param data
	 */
	public void enqueue(int data) {
		if (length >= max) {
			System.out.println("Queue is full");
			return;
		}

		LLNode newNode = new LLNode(data);
		if (isEmpty()) front = newNode;
		else rear.next = newNode;
		rear = newNode;
		length++;
	}

	/**
	 * Remove data at the beginning of the queue if it's not empty.
	 *
	 * @return dequeued data
	 */
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
			int delta = max-length;
			for (int i=0; i<delta; i++) System.out.print(0 +" ");
			System.out.println();
			return;
		} else {
			LLNode current = front;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	// check if Queue is empty
	public boolean isEmpty() { return front == null; }
}
