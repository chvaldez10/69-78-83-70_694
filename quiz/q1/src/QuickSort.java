import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // Choose any element in the array as the pivot
            int pivotIndex = choosePivot(arr, start, end);

            // Partition the array and get the pivot's final sorted position
            int pivot = partition(arr, start, end, pivotIndex);

            // Recursively sort the sub-arrays
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end, int pivotIndex) {
        int pivotValue = arr[pivotIndex];

        // Move the pivot element to the end
        swap(arr, pivotIndex, end);

        // Pointer to track the elements smaller than the pivot
        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] > pivotValue) {
                swap(arr, i, j);
                i++;
            }
        }

        // Move the pivot element to its final position
        swap(arr, i, end);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int choosePivot(int[] arr, int start, int end) {
        // Choose the first element as the pivot
        return start;
        // If you want to choose a random element as the pivot:
        // return start + (int) (Math.random() * (end - start + 1));
    }

    public static void main(String[] args) {
        int[] arr = {15, 4, 55, 51, 90, 14, 12, 50, 95, 23};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
