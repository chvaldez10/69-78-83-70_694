public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        int result = fibonacci(target);
        System.out.println("fibonacci = "+result);
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
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Found the target at index mid
            }

            if (arr[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return -1;
    }

    private static int factorial(int n) {
//        if(n == 1) {
//            return 1;
//        } else {
//            return n * factorial(n-1);
//        }
        int i = 1;
        int result = i;
        while (i<=n) {
            result *= i;
            i++;
        }
        return result;
    }

    private static int fibonacci(int n) {
//        int first = 1;
//        int second = 1;
//        int third;
//        for (int i = 2; i < n; i ++) {
//            third = first + second;
//            first = second;
//            second = third;
//        }
        if (n <= 1){
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}