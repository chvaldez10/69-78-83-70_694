/**
 *  Class to represent a Node containing an integer and the next node
 *
 * @uathor Christian Valdez
 */


package myLibrary.DataStructures.Tree;

public class QNode
{
	public Node nodeData;
    public QNode next;

    public QNode(Node nodeData) {
        this.nodeData = nodeData;
        this.next = null;
    }
}
