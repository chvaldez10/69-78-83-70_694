package myLibrary.DataStructures.Tree;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class App {

	public static int getRandomValue(int Min, int Max)
    {
          return ThreadLocalRandom
            .current()
            .nextInt(Min, Max + 1);
    }

	public static int[] generateRandomArray(int length)
	{
        int leftLimit = 1;
        int rightLimit = 100;

        int[] arr = new int[length];

        for (int i = 0; i < length; i++)
        {
            arr[i] = getRandomValue(leftLimit, rightLimit);
        }

        return arr;
    }

	public static void main(String[] args) {

		BST b = new BST();

		int min = 10;
		int max = 100;

		int arr_size = getRandomValue(min, max); // Generating a random array size for input array
		int key = getRandomValue(min, max); //Generating a random integer search key

		int[] arr_bst = generateRandomArray(arr_size); //Generating a random array for tree nodes

		// BST Output

		System.out.println("\nBINARY SEARCH TREE------------------------------------------------------------------------------");

		System.out.println("Tree Size: "+arr_size);
		System.out.println("Input Nodes: "+Arrays.toString(arr_bst));

		// Create a BST
		Node root = null;

		// Insert nodes in the BST
		for(int i = 0; i < arr_size; i++)
		{
			root = b.insert(arr_bst[i], root);
		}

		// SHow all traversal
		System.out.println("\nInorder Traversal (left-root-right) of the Tree: ");
		b.inOrder(root);

		System.out.println("\nPreorder Traversal (root-left-right) of the Tree: ");
		b.preOrder(root);

		System.out.println("\nPostorder Traversal (left-right-root) of the Tree: ");
		b.postOrder(root);

		System.out.println("\nBreadth First Traversal of the Tree: ");
		b.breadthFirstTraversal(root);

		// Search for the key in the BST
		Node node_search = null;

		node_search = b.searchBinarySearchTree(root, key);

		System.out.println("\n\nSearch key: "+key);

		if(node_search != null)
		{
			System.out.println("Search Key FOUND");
		}
		else
		{
			System.out.println("Search Key NOT FOUND");
		}

		// Generate a random index fromt he array to get the value to delete
		int delete_index = getRandomValue(0, arr_size-1);
		int delete_value = arr_bst[delete_index];

		// Delete the node from the BST
		root = b.deleteNode(root, delete_value);

		// Show all traversal for the current tree
		System.out.println("\nAfter deleting "+ delete_value + " from the tree: ");
		System.out.println("Inorder Traversal (left-root-right) of the Tree: ");
		b.inOrder(root);

		System.out.println("\nPreorder Traversal (root-left-right) of the Tree: ");
		b.preOrder(root);

		System.out.println("\nPostorder Traversal (left-right-root) of the Tree: ");
		b.postOrder(root);

		System.out.println("\nBreadth First Traversal of the Tree: ");
		b.breadthFirstTraversal(root);
	}

}
