package myLibrary.DataStructures.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTestTraverse {
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
}