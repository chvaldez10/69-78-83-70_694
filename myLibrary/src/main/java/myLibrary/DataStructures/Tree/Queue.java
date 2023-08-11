/**
 *  Class to represent a Queue using linked lists. Containing methods:
 *      - enqueue(), dequeue(), display(), isEmpty()
 *
 *  Uses: LLNode.java
 *
 * @author Christian Valdez
 */

package myLibrary.DataStructures.Tree;

public class Queue {
	private int length = 0;
	private int max=101;
	private QNode front = null;
	private QNode rear = null;

	/**
	 * Insert data at the end of the queue if it's not full.
	 *
	 * @param data
	 */
	public void enqueue(Node data) {
		if (length >= max) {
			System.out.println("Queue is full");
			return;
		}

		QNode newNode = new QNode(data);
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
	public void display() {
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
