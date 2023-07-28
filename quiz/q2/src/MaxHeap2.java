import java.util.Arrays;

public class MaxHeap2 {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public int[] getHeap() {
        return heap;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        siftUp(size);
        size++;
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        if (size > 0) {
            siftDown(0);
        }

        return max;
    }

    public void delete(int value) {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            throw new IllegalArgumentException("Value not found in the heap");
        }

        heap[indexToDelete] = heap[size - 1];
        size--;

        if (size > 0) {
            siftUp(indexToDelete);
            siftDown(indexToDelete);
        }
    }

    private void siftUp(int currentIndex) {
        while (currentIndex > 0) {
            int parentIndex = getParentIndex(currentIndex);

            if (heap[parentIndex] < heap[currentIndex]) {
                swap(parentIndex, currentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown(int currentIndex) {
        while (true) {
            int leftChildIndex = getLeftChildIndex(currentIndex);
            int rightChildIndex = getRightChildIndex(currentIndex);
            int largestIndex = currentIndex;

            if (leftChildIndex < size && heap[leftChildIndex] > heap[largestIndex]) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex < size && heap[rightChildIndex] > heap[largestIndex]) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != currentIndex) {
                swap(currentIndex, largestIndex);
                currentIndex = largestIndex;
            } else {
                break;
            }
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap2 maxHeap = new MaxHeap2(10);
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        for (int i : arr) maxHeap.insert(i);
        System.out.println("Max Heap: " + Arrays.toString(maxHeap.getHeap()));
        maxHeap.delete(14);
        System.out.println("Max Heap Delete: " + Arrays.toString(maxHeap.getHeap()));
    }
}
