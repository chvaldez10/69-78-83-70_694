import java.util.*;

class PrimMinimumSpanningTree {
    private int vertices;
    private List<List<Edge>> adjacencyList;

    public PrimMinimumSpanningTree(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an undirected edge to the graph
    public void addEdge(int source, int destination, int weight) {
        Edge edge1 = new Edge(destination, weight);
        Edge edge2 = new Edge(source, weight);
        adjacencyList.get(source).add(edge1);
        adjacencyList.get(destination).add(edge2);
    }

    // Helper class to represent an edge with destination and weight
    private class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Helper class to represent a node with distance from the MST and the vertex itself
    private class Node {
        int vertex;
        int key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    public void findMinimumSpanningTree() {
        boolean[] inMST = new boolean[vertices];
        int[] parent = new int[vertices];
        int[] key = new int[vertices];

        // Initialize key values to positive infinity
        Arrays.fill(key, Integer.MAX_VALUE);

        // Start from vertex 0
        key[0] = 0;
        parent[0] = -1;

        // Create a priority queue (min heap) to keep track of the nodes with minimum key value
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.key));
        pq.add(new Node(0, key[0]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            inMST[u] = true;

            for (Edge edge : adjacencyList.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                    pq.add(new Node(v, key[v]));
                }
            }
        }

        // Print the edges of the Minimum Spanning Tree
        printMinimumSpanningTree(parent);
    }

    private void printMinimumSpanningTree(int[] parent) {
        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        PrimMinimumSpanningTree graph = new PrimMinimumSpanningTree(vertices);
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 8);
        graph.addEdge(1, 0, 7);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 5, 5);
        graph.addEdge(2, 0, 8);
        graph.addEdge(2, 1, 3);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 1, 6);
        graph.addEdge(3, 2, 4);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 3, 5);
        graph.addEdge(4, 5, 2);
        graph.addEdge(5, 1, 5);
        graph.addEdge(5, 2, 3);
        graph.addEdge(5, 3, 2);
        graph.addEdge(5, 4, 2);
        graph.findMinimumSpanningTree();
    }
}
