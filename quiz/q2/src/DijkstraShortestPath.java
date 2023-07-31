import java.util.*;

public class DijkstraShortestPath {
    private int vertices;
    private List<List<DijNode>> graph;

    public DijkstraShortestPath(int vertices) {
        this.vertices = vertices;
        graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        graph.get(source).add(new DijNode(destination, weight));
        graph.get(destination).add(new DijNode(source, weight)); // If the graph is undirected
    }

    public int[] dijkstra(int start) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        int[] previous = new int[vertices];
        Arrays.fill(previous, -1);

        PriorityQueue<DijNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(DijNode -> DijNode.weight));
        minHeap.offer(new DijNode(start, 0));

        while (!minHeap.isEmpty()) {
            DijNode currentDijNode = minHeap.poll();
            int u = currentDijNode.vertex;

            for (DijNode neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    previous[v] = u;
                    minHeap.offer(new DijNode(v, distance[v]));
                }
            }
        }

        return previous;
    }

    public List<Integer> shortestPath(int start, int end, int[] previous) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        while (current != -1) {
            path.add(current);
            current = previous[current];
        }

        Collections.reverse(path);
        return path;
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
        int[] previous = dijkstra.dijkstra(startVertex);

        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + dijkstra.shortestPath(startVertex, i, previous));
        }
    }
}

class DijNode {
    int vertex;
    int weight;

    public DijNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
