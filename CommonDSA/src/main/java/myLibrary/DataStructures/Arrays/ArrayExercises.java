package myLibrary.DataStructures.Arrays;

import java.util.Arrays;

public class ArrayExercises {
    public static boolean isString(Object obj){
        return obj instanceof String;
    }

    private static String reverseString(String str) throws Exception {
        // check argument type
        if (!isString(str)) {
            throw new Exception("not a string");
        }

        // split the string
        String[] strSplit = str.split("");
        int length = strSplit.length;

        // reverse the string
        String[] reverseStrSplit = new String[length];
        for(int i=0; i<length; i++) {
            reverseStrSplit[i] = strSplit[length-i-1];
        }

        return String.join("", reverseStrSplit);
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // check the arrays
        if(arr1.length == 0){
            return arr2;
        }

        if(arr2.length == 0) {
            return arr1;
        }

        // create new array
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int newArrayLength = arr1Length + arr2Length;

        int[] newArray = new int[newArrayLength];
        int i = 0, j=0, k=0;

        while(i<arr1Length && j<arr2Length){
            // if the element in arr1 is smaller than arr2, append to array
            if(arr1[i] < arr2[j]){
                newArray[k] = arr1[i];
                i++;
            } else {
                newArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i < arr1Length) {
            newArray[k] = arr1[i];
            i++;
        }

        while(j < arr2Length) {
            newArray[k] = arr2[j];
            j++;
        }

        return newArray;
    }

    public static void main(String[] args) {
        try {
            int[] mergeArray;
            int[] arr1 = new int[] {0, 3, 4, 31};
            int[] arr2 = new int[] {4, 6, 30};

            mergeArray = mergeSortedArrays(arr1, arr2);

            System.out.println(Arrays.toString(mergeArray));

        } catch (Exception e) {
            e.printStackTrace();
        }
        }

}
