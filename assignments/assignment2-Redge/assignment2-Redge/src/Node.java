/**
 * This Node class is used to initialize Nodes of a LinkedList used in the Stack.java class.
 * Catered towards char type.
 * @author redge santillan
 *
 */
public class Node {
	
//	String data; // Data
	char data; // Data
	Node next; // Pointer
	//Initialize the head and tail node
	
	int size;
	
	public Node(char d) {// Constructor method 
		this.data = d; 
		this.next = null;	// next is a pointer that points to the 
	} 
}