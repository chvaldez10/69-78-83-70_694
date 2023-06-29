import java.util.Scanner;
import java.util.Arrays;
import java.lang.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] userArr;
        int userSearchKey, linIndex, interpolationSearch;
        int userArrSize = askUserForArraySize();
        userArr = new int[userArrSize];
        userArr = fillArr(userArrSize);
        userSearchKey = getUserSearchKey();

        long linearStartTime0 = System.nanoTime();
        linIndex = searchLinearWithSort(userArr, userSearchKey);
        long linearStopTime0 = System.nanoTime();
        System.out.println("Time taken for the linear search with sorting in the function (nano seconds): "
                + (linearStopTime0 - linearStartTime0));

        long linearStartTime = System.nanoTime();
        linIndex = searchLinear(userArr, userSearchKey);
        long linearStopTime = System.nanoTime();
        System.out.println("Time taken for the linear search without sorting (nano seconds): "
                + (linearStopTime - linearStartTime));

        Arrays.sort(userArr);
        long linearStartTime2 = System.nanoTime();
        linIndex = searchLinear(userArr, userSearchKey);
        long linearStopTime2 = System.nanoTime();
        System.out.println("Time taken for the linear search when the array is already sorted (nano seconds): "
                + (linearStopTime2 - linearStartTime2));

        long interStartTime = System.nanoTime();
//        Arrays.sort(userArr);
        interpolationSearch = getInterpolationSearch(userArr, userSearchKey);
        long interStopTime = System.nanoTime();
        System.out.println("Time taken for the interpolation search in nano seconds: "
                + (interStopTime - interStartTime));

        if (linIndex == -1 || interpolationSearch == -1) {
            System.out.println("Search key NOT FOUND");
        } else {
            System.out.println("Using Linear Search: \nSearch key FOUND at index " + linIndex);
            System.out.println("Using Interpolation Search: \nSearch key FOUND at index " + interpolationSearch);
        }
    }

    private static int askUserForArraySize() {
        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Enter the number of elements in the array: ");
            int userArrSize = userInput.nextInt();
            return userArrSize;
        } catch (Exception e) {
            System.out.println("Not a valid integer.");
        }

        return -1;
    }

    private static int[] fillArr(int arrSize) {
        Scanner userInput = new Scanner(System.in);
        int[] arr = new int[arrSize];
        int counter = 0;

        if (arrSize == 0) {
            return arr;
        }
        try {
            System.out.println("Enter the elements in the array:");
            while (counter < arrSize) {
                int userInt = userInput.nextInt();
                arr[counter] = userInt;
                counter ++;
            }
        } catch (Exception e) {
            System.out.println("Not a valid input.");
        }

        return arr;
    }

    private static int getUserSearchKey() {
        Scanner userInput = new Scanner(System.in);
        try {
            System.out.print("Enter the search key: ");
            int userInt = userInput.nextInt();
            return userInt;
        } catch (Exception e) {
            System.out.println("Not a valid input.");
        }
        return -1;
    }

    private static int searchLinear(int[] userArr, int target) {
        int counter = 0;

        for (int num: userArr) {
            if (num == target) return counter;
            counter ++;
        }

        return -1;
    }

    private static int searchLinearWithSort(int[] userArr, int target) {
        int[] tmpArray = new int[userArr.length];
        tmpArray = userArr;
        Arrays.sort(tmpArray);
        int counter = 0;
        for (int num: tmpArray) {
            if (num == target) return counter;
            counter ++;
        }

        return -1;
    }

    private static int getInterpolationSearch(int[] userArray, int key) {
        int low = 0;
        int mid, pos;
        int high = userArray.length - 1;

        while (low <= high)
        {
            pos = (key-userArray[low])/(userArray[high]-userArray[low]);
            mid = low + ((high-low)*pos);
            if(key < userArray[mid])
                high = mid - 1;
            else if(userArray[mid] < key)
                low = mid + 1;
            else
                return mid; //key FOUND and index returned
        }
        return -1;
    }
}