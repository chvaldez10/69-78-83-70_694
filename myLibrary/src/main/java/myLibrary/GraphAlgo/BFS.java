/**
 * Traverse graph using breadth-first traversal (BFS).
 * The graph is represented as an adjacency matrix.
 * Note: implementation can not handle disconnected graphs.
 */

package myLibrary.GraphAlgo;

import java.util.Arrays;

class BFS {
    private int numOfVertex;
    int[][] adjMatrix;

    public BFS(int numOfVertex) {
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
     * Performs BFS from starting vertex.
     *
     * @param start
     */
    public void BFS_Algo(int start) {
        boolean[] visited = new boolean[numOfVertex];
        Arrays.fill(visited, false);
        Queue q = new Queue(numOfVertex);
        visited[start] = true;
        q.enqueue(start);

        while(!q.isEmpty()){
            int vis = q.dequeue();
            System.out.print(vis + " - ");

            for(int i=0; i<numOfVertex; i++) {
                if(adjMatrix[vis][i] == 1 && (!visited[i])) {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println();
        System.out.println("Visited nodes: " + Arrays.toString(visited));
    }
}
