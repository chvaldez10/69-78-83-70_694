import java.util.Arrays;

public class Search implements Constants{
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        double div;
        int mid;

        while(left <= right) {
            div = ((double)left+right)/2;
            mid = (int) Math.ceil(div);
            if(arr[mid] < target) left = mid + 1;
            else if (target < arr[mid]) right = mid - 1;
            else return mid; //target found
        }

        return defaultSearchKey;
    }

    public static int binarySearchRecursive(int arr[], int left, int right, int target) {
        if(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] < target) return binarySearchRecursive(arr, mid+1, right, target);
            else return binarySearchRecursive(arr, left, mid-1, target);
        }
        return defaultSearchKey;
    }

    public static int interpolationSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int mid, pos;
        int counter=0;
        System.out.println("Array length = " + arr.length);

        while(left <= right) {
            pos = (target-arr[left])/(arr[right]-arr[left]);
            mid = left + (right-left)*pos;

            counter++;
            System.out.println("Counter = " + counter + ", pos = " + pos + ", mid = " + mid);

            if(arr[mid] < target) left = mid + 1;
            else if (target < arr[mid]) right = mid - 1;
            else return mid; //target found
        }

        return defaultSearchKey;
    }

    public static int interpolationSearchRecursive(int[] arr, int left, int right, int target) {
        int mid, pos;

        if(left <= right) {
            pos = (target-arr[left])/(arr[right]-arr[left]);
            mid = left + (right-left)*pos;
            if(arr[mid] < target) return interpolationSearchRecursive(arr, mid+1, right, target);
            else if (target < arr[mid]) return interpolationSearchRecursive(arr, left, mid-1, target);
            else return mid; //target found
        }

        return defaultSearchKey;
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i=0; i< arr.length; i++) if (arr[i] == target) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {12, 19, 23, 24, 25, 32, 41, 45, 57, 58, 67, 72, 76, 89, 93, 94};
        int result = binarySearch(a, 23);
        System.out.println("key at " + result);
    }

}
