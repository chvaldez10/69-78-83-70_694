package myLibrary.DataStructures.Linear;

import java.util.concurrent.ThreadLocalRandom;

public class App {
	
	// Generate random integer within the range Min, Max
	public static int getRandomValue(int Min, int Max)
    {
          return ThreadLocalRandom
            .current()
            .nextInt(Min, Max + 1);
    }
	
	// Generate a random integer array of size 'length'
	public static int[] generateRandomArray(int length)
	{
        int leftLimit = 1; // Min value for array cells
        int rightLimit = 100; // Max value for array cells
        
        int[] arr = new int[length];
        
        for (int i = 0; i < length; i++)
        {
            arr[i] = getRandomValue(leftLimit, rightLimit);
        }
        
        return arr;
    }

	public static void main(String[] args) {

		SLL sll = new SLL();
		DLL dll = new DLL();
		
		int min = 10; // Min value for array size
		int max = 100; // Max value for array size
		
		int arr_size = getRandomValue(min, max); // Generating a random array size for input array
		
		int[] arr_sll = generateRandomArray(arr_size); //Generating a random array
		int[] arr_dll = generateRandomArray(arr_size); //Generating a random array
		
		int key = getRandomValue(min, max); //Generating a random integer search key
		
		// SLL Output
		
		System.out.println("\n\nSINGLY LINKED LIST------------------------------------------------------------------------------");
		System.out.println("Number of elements: "+arr_size);
		//  Take each value from array and use as nodes for SLL
		for(int i = 0; i < arr_size; i++)
		{
			sll.addNode(arr_sll[i]);
		}
		
		// Display the SLL
		sll.display();
		
		System.out.println("\nSearch key: "+key);
		// Search the key in SLL
		int out_sll = sll.searchNode(key);
		if (out_sll != -1)
			System.out.println("FOUND at index "+out_sll);
		else System.out.println("NOT FOUND");
		
		// Generate a random index to select which value to delete
		int delete_index_sll = getRandomValue(0, arr_size-1);
		int delete_value_sll = arr_sll[delete_index_sll];
		
		// Delete the node from SLL
		sll.deleteNode(delete_value_sll);
		
		// Display current SLL
		sll.display();
		
		// DLL Output
		
		System.out.println("\n\nDOUBLY LINKED LIST------------------------------------------------------------------------------");
		System.out.println("Number of elements: "+arr_size);	
		//  Take each value from array and use as nodes for DLL
		for(int i = 0; i < arr_size; i++)
		{
			dll.addNode(arr_dll[i]);
		}
				
		dll.display();
				
		System.out.println("\nSearch key: "+key);
		// Search the key in DLL
		int out_dll = dll.searchNode(key);
		if (out_dll != -1)
			System.out.println("FOUND at index "+out_dll);
		else System.out.println("NOT FOUND");
		
		// Generate a random index to select which value to delete
		int delete_index_dll = getRandomValue(0, arr_size-1);
		int delete_value_dll = arr_dll[delete_index_dll];
		
		// Delete the node from DLL
		dll.deleteNode(delete_value_dll);
		
		// Display current DLL
		dll.display();		
		
		
		// Stack Output
		
		System.out.println("\n\nSTACK------------------------------------------------------------------------------");
		
		System.out.println("Number of elements: "+ arr_size);
		
		int[] arr_stack = generateRandomArray(arr_size); //Generating a random array for stack elements
		
		Stack s = new Stack(arr_size);
		
		// Push the values in stack
		for(int i = 0; i < arr_size; i++)
		{
			s.push(arr_stack[i]);
		}
		
		System.out.println("\nAll elements pushed into Stack");
		System.out.println("\nStack:");
		// Display stack
		s.display();
		
		// Pop the values from stack and display in the order they are popped
		System.out.println("\nPopped from Stack: ");
		for(int i = 0; i < arr_size; i++)
		{
			System.out.print(s.pop()+" ");
		}
		// Display current stack
		System.out.println("\nStack:");
		s.display();
		
		// Queue Output
		
		System.out.println("\n\nQUEUE------------------------------------------------------------------------------");
		System.out.println("Number of elements: "+arr_size);
		
		int[] arr_queue = generateRandomArray(arr_size); //Generating a random array for queue elements
		
		Queue q = new Queue(arr_size);
		
		// Enqueue the values in queue
		for(int i = 0; i < arr_size; i++)
		{
			q.enqueue(arr_queue[i]);
		}
		
		System.out.println("\nAll elements enqueued into Queue");
		System.out.println("\nQueue:");
		// Display queue
		q.display();
		
		// Dequeue the values from queue and display in the order they are dequeued
		System.out.println("\nDequeued from Queue: ");
		for(int i = 0; i < arr_size; i++)
		{
			System.out.print(q.dequeue()+" ");
		}
		
		// Display current stack
		System.out.println("\nQueue:");
		q.display();
	}
}
