package myLibrary.DataStructures.LL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private int[] arr = {1, 2, 3, 4, 5};

    @Test
    public void testAppend() {
        DoublyLinkedList dll = new DoublyLinkedList();
        String newLine = System.lineSeparator();
        String expectedOutput = "1 2 3 4 5 " + newLine;

        // list should be empty;
        assertTrue(dll.isEmpty());
        assertEquals(0, dll.getSize());

        // adding elements
        for (int i : arr ) { dll.append(i); }

        // checking elements
        assertFalse(dll.isEmpty());
        assertEquals(5, dll.getSize());
        dll.display();
        assertEquals(output.toString(), expectedOutput);
    }
}