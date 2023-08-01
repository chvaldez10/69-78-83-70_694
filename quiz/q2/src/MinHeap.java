import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int length;
    private int max;

    public MinHeap(int max) {
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

    public void insert(int value) {
        if (length == max) {
            System.out.println("Heap is full.");
            return;
        }

        heap[length] = value;
        heapifyUp(length);
        length++;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int minIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < length && heap[left] < heap[minIndex]) minIndex = left;
        if (right < length && heap[right] < heap[minIndex]) minIndex = right;
        if (minIndex != index) {
            swap(index, minIndex);
            heapifyDown(minIndex);
        }
    }

    public void heapSort() {
        int originallength = length;
        int[] tmpArr = new int[originallength];
        int j = 0;

        for (int i = length / 2 - 1; i >= 0; i--) heapifyDown(i);
        for (int i = length - 1; i >= 0; i--) {
            swap(0, i);
            tmpArr[j] = heap[i];
            length--;
            heapifyDown(0);
            j++;
        }

        System.out.println("tmp Array = " + Arrays.toString(tmpArr));
        length = originallength;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(8);
        int[] arr = {82, 90, 10, 12, 15, 77, 55, 23};
        for (int i : arr) minHeap.insert(i);
        System.out.println("Min Heap: " + Arrays.toString(minHeap.getHeap()));
        minHeap.heapSort();
        System.out.println("Min Heap Sorted: " + Arrays.toString(minHeap.getHeap()));
    }
}
