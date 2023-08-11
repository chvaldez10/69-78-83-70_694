/**
 *
 *  Class to represent a Stack using linked lists. Containing methods:
 *      - push(), pop(), display(), isEmpty()
 *
 *  Uses: LLNode.java
 *
 * @author Christian Valdez
 */


package myLibrary.GraphAlgo;

public class Stack {
	private int length = 0;
	private int max;
	private LLNode top = null;

	public Stack(int max) {
		this.max = max;
	}

	/**
	 * Insert data at the top of the of stack if the stack is not full.
	 *
	 * @param data
	 */
	public void push(int data)
	{
		if (length >= max) {
			System.out.println("Stack is full.");
			return;
		} else {
			LLNode newNode = new LLNode(data);
			newNode.next = top;
			top = newNode;
			length++;
		}
	}

	/**
	 * Remove an element from the top of the stack if it's not empty.
	 *
	 * @return dequeued data
	 */
	public int pop()
	{
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return 0;
		} else {
			int data = top.data;
			top = top.next;
			length --;
			return data;
		}
	}
	
	// Display stack
	public void display()
	{
		if (isEmpty()) {
			int delta = max-length;
			for (int i=0; i<delta; i++) System.out.print(0 +" ");
			System.out.println();
			return;
		} else {
			LLNode current = top;
			while (current != null) {
				System.out.print(current.data +" ");
				current = current.next;
			}
			System.out.println();
		}
	}
	
	// check if Stack is empty
	public boolean isEmpty() { return top == null; }
}
