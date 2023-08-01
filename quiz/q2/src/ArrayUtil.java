public class ArrayUtil {
    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] testArr = {1, 2, 3, 4, 5 , 6};
        arrayUtil.traverse(testArr);
        arrayUtil.insert(testArr, 2, 7);
        arrayUtil.traverse(testArr);
        arrayUtil.delete(testArr, 2);
        arrayUtil.traverse(testArr);
    }

    public void traverse(int[] arr) {
        for(int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public void insert(int[] arr, int index, int newItem) {
        for (int i=arr.length-1; i>index; i--) arr[i] = arr[i-1];
        arr[index] = newItem;
    }

    public void delete(int[] arr, int index) {
        for (int i=index; i<arr.length-1; i++) arr[i] = arr[i+1];
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
