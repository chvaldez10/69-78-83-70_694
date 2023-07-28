import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int length;
    private int max;

    public MaxHeap(int max) {
        this.heap = new int[max];
        this.length = 0;
        this.max = max;
    }

    public int[] getHeap() {
        return heap;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[index] > heap[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int maxIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < length && heap[left] > heap[maxIndex]) maxIndex = left;
        if (right < length && heap[right] > heap[maxIndex]) maxIndex = right;
        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void delete(int target) {
        if (length == 0 ) throw new IllegalStateException("Heap is empty.");

        int indexToDelete = -1;
        for (int i=0; i<length; i++) {
            if (heap[i] == target) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            throw new IllegalArgumentException("Value not found in the heap.");
        }

        heap[indexToDelete] = heap[length-1];
        length --;

        if (length > 0) {
            heapifyUp(indexToDelete);
            heapifyDown(indexToDelete);
        }
    }

    public void insert(int value) {
        if (length == max) {
            System.out.println("Heap is full.");
            return;
        }

        heap[length] = value;
        heapifyUp(length);
        length++;
    }

    public void heapSort() {
        int originallength = length;

        for (int i = length / 2 - 1; i >= 0; i--) heapifyDown(i);
        for (int i = length - 1; i >= 0; i--) {
            swap(0, i);
            length--;
            heapifyDown(0);
        }

        length = originallength;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        for (int i : arr) maxHeap.insert(i);
        System.out.println("Max Heap: " + Arrays.toString(maxHeap.getHeap()));
        maxHeap.delete(14);
        System.out.println("Max Heap Delete: " + Arrays.toString(maxHeap.getHeap()));
//        maxHeap.heapSort();
//        System.out.println("Max Heap: " + Arrays.toString(maxHeap.getHeap()));
    }
}