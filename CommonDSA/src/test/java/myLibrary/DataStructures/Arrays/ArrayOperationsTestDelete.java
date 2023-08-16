package myLibrary.DataStructures.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayOperationsTestDelete {
    private int[] arr = {1, 2, 3, 4, 5};

    @Test
    public void testDelete(){
        ArrayOperations.delete(arr, 0);
        assertArrayEquals(new int[] {2, 3, 4, 5, 0}, arr);

        ArrayOperations.delete(arr, 1);
        assertArrayEquals(new int[] {2, 4, 5, 0, 0}, arr);

        ArrayOperations.delete(arr, arr.length-1);
        assertArrayEquals(new int[] {2, 4, 5, 0, 0}, arr);
    }

    @Test
    public void testArrayIsNull(){
        assertThrows(NullPointerException.class, () -> {
            ArrayOperations.delete(null, 1);
        });
    }

    @Test
    public void testArrayIndexNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ArrayOperations.delete(arr, -1);
        });
    }

    @Test
    public void testArrayIndexNOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ArrayOperations.delete(arr, arr.length);
        });
    }
}
