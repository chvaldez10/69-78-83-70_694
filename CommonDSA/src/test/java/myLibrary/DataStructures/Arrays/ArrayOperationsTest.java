package myLibrary.DataStructures.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private int[] arr = {1, 2, 3, 4, 5};

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testTraverse() {
        String newLine = System.lineSeparator();
        String expectedOutput = "1 2 3 4 5 " + newLine;
        ArrayOperations.traverse(arr);
        assertEquals(expectedOutput, output.toString());
    }

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
}