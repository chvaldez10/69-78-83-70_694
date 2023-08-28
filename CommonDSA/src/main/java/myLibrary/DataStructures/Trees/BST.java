package myLibrary.DataStructures.Trees;

public class BST {
    private Node root;

    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node (int data) {
            this.data = data;
        }

        public int getData() { return this.data; }
    }

    private Node createNode( int data) { return new Node(data); }

    public void insert(int data) {
        root = insert(data, root);
    }

    private Node insert(int data, Node currentNode) {
        if (currentNode == null) {
            return createNode(data);
        }

        if (data <= currentNode.getData()) {
            currentNode.left = insert(data, currentNode.left);
        } else {
            currentNode.right = insert(data, currentNode.right);
        }

        return currentNode;
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    public boolean contains(Node currentNode, int data) {
        if(currentNode == null) {
            return false;
        }

        if(currentNode.getData() == data) {
            return true;
        }

        if(data <= currentNode.getData()) {
            return contains(currentNode.left, data);
        } else {
            return contains(currentNode.right, data);
        }


    }
}
