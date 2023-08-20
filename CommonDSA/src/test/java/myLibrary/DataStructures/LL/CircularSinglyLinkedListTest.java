package myLibrary.DataStructures.LL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CircularSinglyLinkedListTest {
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
    private int[] arr2 = {6, 7, 8, 9, 10};

    @Test
    public void testInsert(){
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        String newLine = System.lineSeparator();
        String expectedOutput = "1 2 3 4 5 " + newLine;

        // list is empty at the start, size = 0
        assertTrue(csll.isEmpty());
        assertEquals(csll.getSize(), 0);

        // adding a nodes
        for (int i : arr) csll.insert(i);

        // list is not empty, size = 5
        assertFalse(csll.isEmpty());
        assertEquals(5, csll.getSize());

        // testing display to terminal
        csll.display();
        assertEquals(output.toString(), expectedOutput);
    }

    @Test
    public void testInsertAtBeginning(){
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        String newLine = System.lineSeparator();
        String expectedOutput = "6 1 2 3 4 5 " + newLine;

        // list is empty at the start, size = 0
        assertTrue(csll.isEmpty());
        assertEquals(csll.getSize(), 0);

        // adding a nodes
        for (int i : arr) csll.insert(i);
        csll.insertAtBeginning(6);

        // list is not empty, size = 5
        assertFalse(csll.isEmpty());
        assertEquals(6, csll.getSize());

        // testing display to terminal
        csll.display();
        assertEquals(output.toString(), expectedOutput);
    }
}