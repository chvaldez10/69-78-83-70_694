/**
 *  Class to represent a singly linked list containing basic methods:
 *      - addNode(), deleteNode(), searchNode(), display(), isEmpty()
 *
 * @uathor Christian Valdez
 */

package myLibrary.DataStructures.Linear;

public class SLL {
	private LLNode head;
    private LLNode tail;

    public  SLL() {
        head = null;
        tail = null;
    }
    
	// Add node to SLL
    public void addNode(int data) 
    {
        LLNode newNode = new LLNode(data);
        if(isEmpty()) head = newNode;
        else tail.next = newNode;
        tail = newNode;
    }   
    
    // Search node in SLL
    public int searchNode(int key)
    {
        if(isEmpty()) {
            System.out.println("SLL is empty.");
            return -1;
        } else {
            LLNode current = head;
            int i = 0;
            while (current != null) {
                if (current.data == key) return i;
                current = current.next;
                i++;
            }
        }
        return -1;
    }
    
    // Delete node form SLL
    public void deleteNode(int key)
    {
        System.out.println("\nDeleting Node with value " + key);
        LLNode currentNode = head, prevNode=null;

        if(!isEmpty() && currentNode.data == key) {
            head = currentNode.next;
            return;
        }

        while (currentNode != null && currentNode.data != key) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null) return;
        prevNode.next = currentNode.next;

    }
    
    // Display SLL
    public void display() 
    {
        System.out.println("\nCurrent nodes of the singly linked list:");
        if (isEmpty()) {
            System.out.println("SLL is empty.");
            return;
        } else {
            LLNode current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    } 
    
    // Check if SLL empty
    public boolean isEmpty(){
        return head == null;
    }
}
