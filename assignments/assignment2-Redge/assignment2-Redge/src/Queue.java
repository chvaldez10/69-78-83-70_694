
/** Queue implementation using 2 Stacks.
 * @author redge
 *
 */
public class Queue {
	
	Node head;
	Node tail;
	
	int headCounter;
	int tailCounter = -1;
	
	Stack inbox;
	Stack outbox;
	
	int maxSize;
	
	public Queue(int size) {
		this.maxSize = size;
		inbox = new Stack(maxSize);
		outbox = new Stack(maxSize);
		head = null;
		tail = null;
		headCounter = 0;
		tailCounter = 0;
	}
	
	public void enQueue(char c) {
//		if (head == null && tail == null) {
//			tailCounter = 0;
//		} else {
//			tailCounter++;
//		}
		Node tempNode = new Node(c);
		tempNode.next = tail;
		tail = tempNode;
		inbox.push(c);
		tailCounter++;
//		System.out.println(c + " has been enqueued.");
		
	}
	
	public char deQueue() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				
				outbox.push(inbox.pop());
			}
		}
		Node tempNode = new Node(outbox.pop());
		head = tempNode;
//		System.out.println(tempNode.data + " was dequeued from queue.");
		return tempNode.data;
	}

	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		Node current = head;
		System.out.println("Queue elements:");
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return head == null;
	}

	// Test Code
	public static void main(String[] args) {
		Queue queue = new Queue(4);

		queue.enQueue('a');
		queue.enQueue('y');
		queue.enQueue('v');
		queue.display();
//		queue.deQueue();
		System.out.println(queue.deQueue());
		queue.display();
	}
}
