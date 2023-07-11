public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 9;
        int res = bS(arr, 0, arr.length-1, target);
        System.out.println("res="+res);
    }

    private static int binarySearch(int[] n, int target) {
        int low = 0;
        int high = n.length - 1;
        int mid;

        while(low<=high) {
            mid = (low+high)/2;
            if (n[mid] == target) {
                return mid;
            } else if (n[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int bS(int[] a, int low, int high, int target){
        if (low<=high) {
            int mid = (low+high)/2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                return bS(a, mid+1, high, target);
            } else {
                return bS(a, low, mid-1, target);
            }
        }
        return -1;
    }
}