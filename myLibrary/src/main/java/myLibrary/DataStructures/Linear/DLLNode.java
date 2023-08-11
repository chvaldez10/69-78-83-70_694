/**
 * Class to represent a node for a doubly linked list
 *
 * @uathor Christian Valdez
 */

package myLibrary.DataStructures.Linear;

public class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}
