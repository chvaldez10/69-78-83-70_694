/**
 * Class to update adjacency matrix.
 *
 * @author Christian Valdez
 */

package myLibrary.GraphAlgo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AdjacencyMatrix {
    private int numOfVertex;
    private int adjacencyMatrix[][];

    public AdjacencyMatrix(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        adjacencyMatrix = new int[this.numOfVertex][this.numOfVertex];
        for(int i=0; i<this.numOfVertex; i++) {
        	Arrays.fill(adjacencyMatrix[i], 0);
        }
        
    }

    public int[][] getAdjacencyMatrix() { return adjacencyMatrix; }

    public void addEdge(int source, int destination, int cost) {
        adjacencyMatrix[source][destination] = cost;
        adjacencyMatrix[destination][source] = cost;
    }

    public void displayAdjacencyMatrix() {
        for (int i=0; i<numOfVertex; i++) {
            for (int j=0; j<numOfVertex; j++) System.out.print(adjacencyMatrix[i][j] + " ");
            System.out.println();
        }
    }
}

