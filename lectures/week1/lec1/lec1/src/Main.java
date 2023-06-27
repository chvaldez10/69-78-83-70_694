public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int result = maxNum(arr, arr.length);
        System.out.println("max="+result);
    }

    private static int maxNum(int[] arr, int n) {
        int max = arr[0];
        int i = 1;
        while (i < n){
            if (max < arr[i]) {
                max= arr[i];
            }
            i += 1;
        }
        return max;
    }
}