/**
 *  Class to represent a doubly linked list containing basic methods:
 *      - addNode(), deleteNode(), searchNode(), display(), isEmpty()
 *
 * @uathor Christian Valdez
 */

package myLibrary.DataStructures.Linear;

public class DLL {
	private DLLNode head = null;
    private DLLNode tail = null;

    // Add node to DLL
    public void addNode(int data)
    {
        DLLNode newNode = new DLLNode(data);
        if(tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Search node
    public int searchNode(int key)
    {
        if(isEmpty()) {
            System.out.println("DLL is empty.");
            return -1;
        }
        else {
            DLLNode current = head;
            int counter = 0;
            while (current != null) {
                if (current.data == key) return counter;
                current = current.next;
                counter++;
            }
        }
        return -1;
    }
    
    // Delete node
    public void deleteNode(int key) 
    {
        System.out.println("\nDeleting Node with value " + key);
        DLLNode current = head;

        if(!isEmpty() && current.data == key) {
            head = current.next;
        } else {
            while(current != null) {
                if(current.data == key) {
                    current.prev.next = current.next;
                    if (current == tail) tail = current.prev;
                    else current.next.prev = current.prev;
                    return;
                }
                current = current.next;
            }
        }
    }
    
    // Display the DLL
    public void display() {
        System.out.println("\nCurrent nodes of the doubly linked list:");
        if (isEmpty()) {
            System.out.println("DLL is empty.");
            return;
        } else {
            DLLNode current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
        System.out.println();
    }

    // Check if DLL empty
    public boolean isEmpty(){ return head == null; }
}
