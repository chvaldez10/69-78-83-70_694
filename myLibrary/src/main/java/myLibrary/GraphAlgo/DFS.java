/**
 * Traverse graph using depth-first traversal (DFS).
 * The graph is represented as an adjacency matrix.
 * Note: implementation can not handle disconnected graphs.
 */

package myLibrary.GraphAlgo;
import java.util.Arrays;

public class DFS {
    private int numOfVertex;
    int[][] adjMatrix;

    public DFS(int numOfVertex){
        this.numOfVertex = numOfVertex;
        this.adjMatrix = new int[this.numOfVertex][this.numOfVertex];

        for(int row=0; row<this.numOfVertex; row++) {
            Arrays.fill(adjMatrix[row], 0);
        }
    }

    public void addEdge(int start, int dest) {
        adjMatrix[start][dest] = 1;
        adjMatrix[dest][start] = 1;
    }

    /**
     * Performs DFS from starting vertex.
     *
     * @param start
     */
    public void DFS_Algo(int start) {
        boolean[] visited = new boolean[numOfVertex];
        Arrays.fill(visited, false);
        Stack stack = new Stack(numOfVertex);
        stack.push(start);

        while(!stack.isEmpty()) {
            int vis = stack.pop();

            if(!visited[vis]) {
                System.out.print(vis + " - ");
                visited[vis] = true;
                for (int i = numOfVertex-1; i >= 0; i--) {
                    if (adjMatrix[vis][i] == 1 && !visited[i]) stack.push(i);
                }
            }
        }

        System.out.println();
        System.out.println("Visited nodes: " + Arrays.toString(visited));
    }
    
}
