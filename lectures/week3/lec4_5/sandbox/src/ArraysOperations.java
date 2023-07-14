import java.util.Arrays;

public class ArraysOperations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("pre insert " + Arrays.toString(arr));
        deleteArr(arr,0, 2);
        System.out.println("post insert " + Arrays.toString(arr));
    }

    public static void insertArr(int[] arr, int newInt, int index) {
        for(int i=arr.length-1; i>index; i--) arr[i] = arr[i - 1];
        arr[index] = newInt;
    }

    public static void deleteArr(int[] arr, int newInt, int index) {
        for(int i=index+1; i<arr.length; i++) arr[i-1] = arr[i];
        arr[arr.length-1] = newInt;
    }
}
