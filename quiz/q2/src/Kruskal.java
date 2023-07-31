import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class KruskalAlgorithm {
    private int V; // Number of vertices
    private List<Edge> edges;

    public KruskalAlgorithm(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Union-Find data structure
    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);
        parent[yRoot] = xRoot;
    }

    public List<Edge> findMinimumSpanningTree() {
        List<Edge> result = new ArrayList<>();

        // Sort the edges in ascending order based on their weights
        Collections.sort(edges);

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            int srcRoot = find(parent, edge.src);
            int destRoot = find(parent, edge.dest);

            // Check if including this edge causes a cycle in the MST
            if (srcRoot != destRoot) {
                result.add(edge);
                union(parent, srcRoot, destRoot);
            }
        }

        return result;
    }
}

public class Kruskal {
    public static void main(String[] args) {
        int V = 6; // Number of vertices

        KruskalAlgorithm graph = new KruskalAlgorithm(V);

        // Adding edges: (src, dest, weight)
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

        List<Edge> mst = graph.findMinimumSpanningTree();

        System.out.println("Minimum Spanning Tree edges:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " : " + edge.weight);
        }
    }
}
