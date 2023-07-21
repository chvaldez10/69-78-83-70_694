
/**
 * Stack implemented as a linked list. Uses the Node.java class
 * @author redge santillan
 *
 */
public class Stack {	
	int max_size;			// linked list size
	int topCounter = -1;	// topCounter keeps track of the number of the index so far; i.e. keeps track of where the top is in relation to the stack.
	
	Node top;	// create a top Node to implement the linked list.
	
	/** Initializes Stack object with the specified size.
	 * @param size (int) - linked list size.
	 */
	public Stack(int size) {
		this.max_size = size;
		this.top = null;
	}
	
	/**Stack push operation. This method will check if the Stack is full first, before pushing new Nodes into the Stack.
	 * This new Node will now be the new top Node, then topCounter is incremented.
	 * @param data (String) - new Node data to be stored.
	 */
	public void push(char data) {
		//
		if (topCounter == max_size-1) {
			System.out.println("Stack is Full - Overflow");
			return;
		} else {
			
			Node tempNode = new Node(data);
			tempNode.next = top;
			top = tempNode;
			
			topCounter++;
			
//			System.out.println(data + " Pushed into Stack.");
		}
	}
	
	/**Stack pop operation. This method will check if the Stack is empty first. If Stack is not empty, this method will return the top Node data, then pop the top Node from the Stack.
	 * Afterwards, the next Node is assigned as the top Node, then topCounter is decremented.
	 * @return data (String) - If the Stack is empty, pop() return a blank String. Otherwise, pop() will return the popped Node's data.
	 */
	public char pop() {
		char data;
		if (topCounter < 0) {
			System.out.println("Stack is Empty - Underflow");
			top = null;
			return ' ';
		} else {
			data = top.data;
			top = top.next;
			
			topCounter--;
		}
		
//		System.out.println("Popped from Stack ");
		return data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	/**
	 * Displays the Stack elements right beside each other in one line.
	 */
	public void display() {
		//display method
		
		if (top == null) {	// if the top is empty, that means the stack is empty
			System.out.println("\nStack Underflow");
		} else {
			System.out.println("******Stack******");
			Node tempNode = top;	// store top for now
			while (tempNode != null) {	// until we empty out the stack
				System.out.println(tempNode.data);	// print the data on tempNode (which was the top of the stack)
				tempNode = tempNode.next;			// point tempNode to the next item in the stack
				if (tempNode != null) {				// if tempNode is not empty yet
//					System.out.print(" ");
				}
			}
			System.out.print("*****************\n");
		}
	}
	// Test code
//	public static void main(String[] args) {
//		Stack stack = new Stack(10);
//		stack.push('a');
//		stack.push('y');
////		System.out.println("Top = " + stack.top.data);
//		stack.display();
////		System.out.println("topCounter = " + stack.topCounter);
////		System.out.println("isEmpty() = " + stack.isEmpty());
//		System.out.println(stack.pop());
////		stack.pop();
////		stack.display();
////		stack.push('y');
////		stack.display();
////		System.out.println("topCounter = " + stack.topCounter);
//		
////		Stack stack2 = new Stack(10);
////		stack2.push('a');
////		stack2.push('y');
////		stack2.pop();
////		System.out.println("stack2 isEmpty() = " + stack2.isEmpty());
////		System.out.println("stack2 isEmpty() = " + stack2.isEmpty());
//	}
}