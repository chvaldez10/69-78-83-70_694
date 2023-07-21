public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
