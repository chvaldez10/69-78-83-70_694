package myLibrary.DataStructures.Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        public Node getLeft() { return this.left; }

        public Node getRight() { return this.right; }
    }

    private Node createNode( int data) { return new Node(data); }

    public void insert(int data) {
        root = insert(data, root);
    }

    public Node getRoot() { return this.root; }

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

    public ArrayList<Integer> inOrder(Node node, ArrayList list) {
        if (node != null ){
            inOrder(node.getLeft(), list);
            list.add(node.getData());
            inOrder(node.getRight(), list);
        }
        return list;
    }

    public ArrayList<Integer> preOrder(Node node, ArrayList list) {
        if( node != null ) {
            list.add(node.getData());
            preOrder(node.getLeft(), list);
            preOrder(node.getRight(), list);
        }
        return list;
    }

    public ArrayList<Integer> postOrder(Node node, ArrayList list) {
        if (node != null ) {
            postOrder(node.getLeft(), list);
            postOrder(node.getRight(), list);
            list.add(node.getData());
        }
        return list;
    }
}
