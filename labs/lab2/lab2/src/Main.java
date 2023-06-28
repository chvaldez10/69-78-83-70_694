import java.util.Scanner;
import java.util.Arrays;
import java.lang.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] userArr;
        int userSearchKey, linIndex, interpolationSearch;
//        int userArrSize = askUserForArraySize();
//        userArr = new int[userArrSize];
//        userArr = fillArr(userArrSize);
//        userSearchKey = getUserSearchKey();

        int userArrSize = 1000;
        userArr = new int[userArrSize];
        userArr = randomGen(1000);
        userSearchKey = 69;

        long linearStartTime = System.nanoTime();
        linIndex = searchLinear(userArr, userSearchKey);
        long linearStopTime = System.nanoTime();
        System.out.println("Time taken for the linear search in nano seconds: "
                + (linearStopTime - linearStartTime));

        long linearStartTime2 = System.nanoTime();
        Arrays.sort(userArr);
        linIndex = searchLinear(userArr, userSearchKey);
        long linearStopTime2 = System.nanoTime();
        System.out.println("Time taken for the linear search when the array is sorted in nano seconds: "
                + (linearStopTime2 - linearStartTime2));

        long interStartTime = System.nanoTime();
        interpolationSearch = getInterpolationSearch(userArr, userSearchKey);
        long interStopTime = System.nanoTime();
        System.out.println("Time taken for the interpolation search in nano seconds: "
                + (interStopTime - interStartTime));

        System.out.println("Using Linear Search: \nSearch key FOUND at index " + linIndex);
        System.out.println("Using Interpolation Search: \nSearch key FOUND at index " + interpolationSearch);
    }

    private static int[] randomGen(int s) {
        int[] arr = new int[s];
        Random rd = new Random();

        for(int i=0; i<arr.length; i++) {
            arr[i] = rd.nextInt();
            System.out.print(arr[i] + " ");
        }

        return arr;
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
        int userIndex;
        int counter = 0;

        for (int num: userArr) {
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