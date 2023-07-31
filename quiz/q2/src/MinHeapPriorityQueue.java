import java.util.Arrays;

public class MinHeapPriorityQueue {
    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MinHeapPriorityQueue() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int minValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return minValue;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < size && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    public static void main(String[] args) {
        MinHeapPriorityQueue priorityQueue = new MinHeapPriorityQueue();

        priorityQueue.insert(5);
        priorityQueue.insert(2);
        priorityQueue.insert(8);
        priorityQueue.insert(1);
        priorityQueue.insert(10);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.extractMin());
        }
    }
}
