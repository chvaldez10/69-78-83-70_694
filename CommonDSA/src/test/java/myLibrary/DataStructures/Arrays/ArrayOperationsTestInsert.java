package myLibrary.DataStructures.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayOperationsTestInsert {
    private int[] arr = {1, 2, 3, 4, 5};

    @Test
    public void testInsert() {
        // insert at the beginning
        ArrayOperations.insert(arr, 0, 6);
        assertArrayEquals(new int[] {6, 1, 2, 3, 4}, arr);

        // insert at the end
        ArrayOperations.insert(arr, 4, 7);
        assertArrayEquals(new int[] {6, 1, 2, 3, 7}, arr);

        // insert at the middle
        ArrayOperations.insert(arr, 2, 8);
        assertArrayEquals(new int[] {6, 1, 8, 2, 3}, arr);
    }

    @Test
    public void testArrayIsNull(){
        assertThrows(NullPointerException.class, () -> {
            ArrayOperations.insert(null, 1, 9);
        });
    }

    @Test
    public void testArrayIndexNegative(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ArrayOperations.insert(arr, -1, 9);
        });
    }

    @Test
    public void testArrayAboveLength(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ArrayOperations.insert(arr, arr.length+2, 9);
        });
    }

    @Test
    public void testArrayEqualsLength(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ArrayOperations.insert(arr, arr.length, 9);
        });
    }
}
