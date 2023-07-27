
public class BST {

	// Create node
	public Node createNode(int data){
		Node BSTNode = new Node();
		BSTNode.data = data;
		BSTNode.left = null;
		BSTNode.right = null;
		return BSTNode;
	}

	// Insert new node in BST - you can use recursive or iterative method
	public Node insert(int data, Node root)
	{
		if(root == null) return createNode(data);
		if(data <= root.data) root.left = insert(data, root.left);
		else if (data > root.data) root.right = insert(data, root.right);
		return root;
	}
	
	// Inorder traversal - recursive OR iterative
	public void inOrder(Node BSTNode)
	{
		if (BSTNode == null) return;
		inOrder(BSTNode.left);
		System.out.print(BSTNode.data + " ");
		inOrder(BSTNode.right);
	}

	// Preorder traversal - recursive OR iterative
	public void preOrder(Node BSTNode)
	{
		if (BSTNode == null) return;
		System.out.print(BSTNode.data + " ");
		preOrder(BSTNode.left);
		preOrder(BSTNode.right);
	}

	// Postorder traversal - recursive OR iterative
	public void postOrder(Node BSTNode)
	{
		if (BSTNode == null) return;
		postOrder(BSTNode.left);
		postOrder(BSTNode.right);
		System.out.print(BSTNode.data + " ");
	}

	// Breadth first traversal - recursive OR iterative
	public void breadthFirstTraversal(Node root)
	{
		if (root == null) return;

		Queue q = new Queue();
		q.enqueue(root);

		while(!q.isEmpty()) {
			Node node = q.dequeue();
			System.out.print(node.data + " ");
			if(node.left != null) q.enqueue(node.left);
			if(node.right != null) q.enqueue(node.right);
		}

	}


	// Search in BST
	public Node searchBinarySearchTree(Node BSTNode, int key) {
		return searchRec(BSTNode, key);
	}

	private Node searchRec(Node root, int key) {
		if (root == null)
			return null;

		if (root.data == key)
			return root;

		if (key < root.data)
			return searchRec(root.left, key);
		else
			return searchRec(root.right, key);
	}

	// Delete from BST
	public Node deleteNode(Node root, int key)
	{
		deleteNodeRecursive(root, key);
		return root;
	}

	public Node deleteNodeRecursive(Node root, int key)
	{
		if (root == null) return root;

		if (key < root.data) root.left = deleteNodeRecursive(root.left, key);
		else if (key > root.data) root.right = deleteNodeRecursive(root.right, key);
		else {
			if (root.left == null) return root.right;
			else if (root.right == null) return root.left;
			root.data = minValue(root.right);
			root.right = deleteNodeRecursive(root.right, root.data);
		}

		return root;
	}

	private int minValue(Node root) {
		int minValue = root.data;
		while (root.left != null) {
			minValue = root.left.data;
			root = root.left;
		}
		return minValue;
	}

	// Add any other parts needed
	public static void main(String[] args) {
		BST tree = new BST();
		Node root = null;
		int[] testArr = {30, 23, 43, 54, 12, 50, 45, 97};

		for (int i : testArr) root = tree.insert(i, root);

		System.out.println("\nBreadth first traversal of the Tree");
		tree.breadthFirstTraversal(root);

//		System.out.println("\n\n\nIn order traversal (left-root-right) of Tree1");
//		tree.inOrder(root);
//
//		System.out.println("\nPre order traversal (root-left-right) of Tree1");
//		tree.preOrder(root);
//
//		System.out.println("\nPost order traversal (left-right-root) of Tree1");
//		tree.postOrder(root);
//
//		System.out.println("\n\n\ntesting delete");
//
//		tree.deleteNode(root, 12);
//
//		System.out.println("In order traversal (left-root-right) of Tree1");
//		tree.inOrder(root);
//
//		System.out.println("\nPre order traversal (root-left-right) of Tree1");
//		tree.preOrder(root);
//
//		System.out.println("\nPost order traversal (left-right-root) of Tree1");
//		tree.postOrder(root);
//
//		System.out.println("\n\n\ntesting search");
//
//		Node searchNode = tree.searchBinarySearchTree(root, 50);
//		System.out.println("searchNode data: " + searchNode.data);
//


	}
}
