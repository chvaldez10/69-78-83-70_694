package myLibrary.GraphAlgo;

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

		int min = 5;
		int max = 20;

		int num_nodes = getRandomValue(min, max); // Generating a random number of nodes for the graph

		// Graph outputs

		System.out.println("\nGRAPH-------------------------------------------------------------");

		int num_edges = getRandomValue(num_nodes, 2*num_nodes); //Generate random number of edges
		System.out.println("Number of nodes: "+num_nodes);
		System.out.println("Number of edges: "+num_edges);

		BFS g_bfs = new BFS(num_nodes);

		DFS g_dfs = new DFS(num_nodes);

		AdjacencyMatrix g_adj = new AdjacencyMatrix(num_nodes);

		Dijkstra g_dijkstra = new Dijkstra();

		int[] source_arr = new int[num_edges];
		int[] dest_arr = new int[num_edges];
		int[] cost_arr = new int[num_edges];

		for (int i = 0; i < num_edges; i++)
		{
			int source_node = getRandomValue(0, num_nodes-1); // Generate random source node of an edge
			int dest_node = getRandomValue(0, num_nodes-1); // Generate random destination node of an edge
			int cost = getRandomValue(1, 100); // Generate random cost/distance for that edge
			int v = 0;

			for (int j = 0; j < i; j++)
			{
				if((source_node==source_arr[j] && dest_node==dest_arr[j]) || (source_node==dest_arr[j] && dest_node==source_arr[j]) || (source_node == dest_node))
				{
					v = 1;
					while (v != 0)
					{
						source_node = getRandomValue(0, num_nodes-1);
						dest_node = getRandomValue(0, num_nodes-1);
						if(((source_node!=source_arr[j] && dest_node!=dest_arr[j]) && (source_node!=dest_arr[j] && dest_node!=source_arr[j]) && (source_node != dest_node)))
						{
							v = 0;
							break;
						}
					}
				}
			}

			System.out.println("Edge " + (i+1) + ": " + source_node + " - " + dest_node + ", distance/cost = " + cost);

			source_arr[i] = source_node;
			dest_arr[i] = dest_node;
			cost_arr[i] = cost;

			// Add the edge to a graph for BFS
			g_bfs.addEdge(source_node, dest_node);

			// Add the edge to a graph for DFS
			g_dfs.addEdge(source_node, dest_node);

			// Add the edge to a graph for Dijkstra
			g_adj.addEdge(source_node, dest_node,cost);
		}

		// Display BFS output
		System.out.println("\nBFS Traversal: ");
		g_bfs.BFS_Algo(0);

		// Display DFS output
		System.out.println("\nDFS Traversal: ");
		g_dfs.DFS_Algo(0);

		System.out.println("\nDijkstra: ");
		System.out.println("\nGraph Cost Adjacency Matrix:");
		// Display cost adjacency matrix
		g_adj.displayAdjacencyMatrix();

		// Get the created adjacency matrix
		int[][] adj = g_adj.getAdjacencyMatrix();
		int source = 0;
		System.out.println("\nSource node: "+source);
		System.out.println("\nDistances/Costs from source node to all other nodes:");
		// Apply Dijkstra on the graph
		g_dijkstra.Dijkstra_Algo(adj, source);

	}

}
