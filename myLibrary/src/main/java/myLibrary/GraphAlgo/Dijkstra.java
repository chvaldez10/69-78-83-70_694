/**
 * Algorithm to find MST where the graph is represented as an adjacency matrix.
 * Note: implementation can not handle disconnected graphs.
 */

package myLibrary.GraphAlgo;
import java.util.Arrays;

public class Dijkstra {
	private static final int INFINITY = Integer.MAX_VALUE;
	/**
	 * Find the vertex with the minimum weight not included in the minimum spanning tree.
	 *
	 * @param visited
	 * @param distance
	 * @return minimum vertex
	 */
	private int findMinKeyVertex(boolean[] visited, int[] distance) {
		int minDistance = INFINITY;
		int minVertex = -1;

		for (int v = 0; v < distance.length; v++) {
			if (!visited[v] && distance[v] < minDistance) {
				minDistance = distance[v];
				minVertex = v;
			}
		}

		return minVertex;
	}

	/**
	 * Driver code to find the minimum spanning tree.
	 *
	 * @param graph
	 * @param startVertex
	 */
	public void Dijkstra_Algo(int[][] graph, int startVertex) {
		int numOfVertices = graph.length;
		boolean[] visited = new boolean[numOfVertices];
		int[] distance = new int[numOfVertices];

		Arrays.fill(distance, INFINITY);
		Arrays.fill(visited, false);

		// start at vertex
		distance[startVertex] = 0;

		for (int i=0; i<numOfVertices-1; i++) {
			int minVertex = findMinKeyVertex(visited, distance);
			visited[minVertex] = true;

			// iteratively add the vertex with the minimum weight
			for (int j = 0; j < numOfVertices; j++) {
				if (!visited[j] && graph[minVertex][j] != 0 &&
						distance[minVertex] != INFINITY &&
						distance[minVertex] + graph[minVertex][j] < distance[j]) {
					distance[j] = distance[minVertex] + graph[minVertex][j];
				}
			}
		}

		printShortestPath(distance, startVertex);
	}

	// displays edges with the shortest length
	private void printShortestPath(int[] distance, int startVertex) {
		for (int i = 0; i < distance.length; i++) {
			System.out.println("Distance from " + startVertex + " to " + distance[i]);
		}
	}
}
