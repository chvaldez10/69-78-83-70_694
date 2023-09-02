package myLibrary.DataStructures.Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    // instance variables
    private Node root;

    /**
     * Node class for BST
     */
    private class Node {
        private final int data;
        private Node left;
        private Node right;

        public Node (int data) {
            this.data = data;
        }

        public int getData() { return this.data; }

        public Node getLeft() { return this.left; }

        public Node getRight() { return this.right; }
    }

    /**
     * Getters and setters
     */
    public Node getRoot() { return this.root; }

    /**
     * Customer exception class
     */
    public class EmptyRootException extends Exception {
        public EmptyRootException(String message) {
            super(message);
        }
    }

    /**
     * Create a BST node
     * @param data
     * @return new BST node
     */
    private Node createNode( int data) { return new Node(data); }

    /**
     * Driver function to insert a new node.
     * @param data
     */
    public void insert(int data) {
        root = insert(data, root);
    }

    /**
     * Helper function append to BST
     * @param data
     * @param currentNode
     * @return
     */
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

    /**
     * Driver code to check for first time a target data is detected.
     * @param data
     * @return
     */
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

    /**
     * BST in order traversal (left, root, right)
     * @param node
     * @param list
     * @return
     */
    public ArrayList<Integer> inOrder(Node node, ArrayList list) {
        if (node != null ){
            inOrder(node.getLeft(), list);
            list.add(node.getData());
            inOrder(node.getRight(), list);
        }
        return list;
    }

    /**
     * BST pre order traversal (root, left, right)
     * @param node
     * @param list
     * @return
     */
    public ArrayList<Integer> preOrder(Node node, ArrayList list) {
        if( node != null ) {
            list.add(node.getData());
            preOrder(node.getLeft(), list);
            preOrder(node.getRight(), list);
        }
        return list;
    }

    /**
     * BST pre order traversal (left, right, root)
     * @param node
     * @param list
     * @return
     */
    public ArrayList<Integer> postOrder(Node node, ArrayList list) {
        if (node != null ) {
            postOrder(node.getLeft(), list);
            postOrder(node.getRight(), list);
            list.add(node.getData());
        }
        return list;
    }

    /**
     * BFS for BST
     * @param node
     * @return
     * @throws EmptyRootException
     */
    public ArrayList<Integer> breathFirstTraversal(Node node) throws EmptyRootException{
        if (root == null) {
            throw new EmptyRootException("Root is empty.");
        }

        ArrayList<Integer> bftResult = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            Node tmpNode = q.remove();
            bftResult.add(tmpNode.getData());

            if (tmpNode.getLeft() != null ) q.add(tmpNode.getLeft());
            if (tmpNode.getRight() != null ) q.add(tmpNode.getRight());
        }

        return bftResult;
    }
}
