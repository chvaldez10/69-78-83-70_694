public class BST {
    public BST_Node createNode(int data) {
        BST_Node node = new BST_Node();
        node.data = data;
        return node;
    }

    public BST_Node insert(int data, BST_Node root) {
        if (root== null) return createNode(data);

        if(data <=root.data) root.left = insert(data, root.left);
        else if (data > root.data) root.right = insert(data, root.right);
        return root;
    }

    public void inOrder (BST_Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BST A = new BST();
        BST_Node root = null;

        root = A.insert(30, root);
        root = A.insert(23, root);
        root = A.insert(43, root);
        root = A.insert(54, root);
        root = A.insert(12, root);
        root = A.insert(50, root);
        root = A.insert(45, root);
        root = A.insert(97, root);

        System.out.println("Inorder Traversal (left-root-right) of the Tree: ");
        A.inOrder(root);
    }
}