package myLibrary.GraphAlgo;

import java.util.*;

public class DijkstraShortestPath {
    private int vertices;
    private List<List<Node>> graph;

    public DijkstraShortestPath(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        graph.get(source).add(new Node(destination, weight));
    }

    public int[] dijkstra(int start) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.offer(new Node(start, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int u = currentNode.vertex;

            for (Node neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    minHeap.offer(new Node(v, distance[v]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int numVertices = 6;
        DijkstraShortestPath dijkstra = new DijkstraShortestPath(numVertices);

        dijkstra.addEdge(0, 1, 4);
        dijkstra.addEdge(0, 2, 2);
        dijkstra.addEdge(1, 2, 5);
        dijkstra.addEdge(1, 3, 10);
        dijkstra.addEdge(2, 4, 3);
        dijkstra.addEdge(3, 5, 6);
        dijkstra.addEdge(4, 3, 2);
        dijkstra.addEdge(4, 5, 1);

        int startVertex = 0;
        int[] shortestDistances = dijkstra.dijkstra(startVertex);

        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + shortestDistances[i]);
        }
    }
}

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
