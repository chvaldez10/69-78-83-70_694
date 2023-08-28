package myLibrary.DataStructures.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private int[] arr = {1, 2, 3, 4, 5};
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

    @Test
    void getMax() {
        Queue q = new Queue(arr.length);
        assertEquals(5, q.getMax());
    }

    @Test
    void getLength() {
        Queue q = new Queue(arr.length);
        assertEquals(0, q.getLength()); // 0 at the start
    }

    @Test
    void enqueue() {
        Queue q = new Queue(arr.length);
        for (int i : arr) q.enqueue(i);
        String newLine = System.lineSeparator();
        String expectedOutput = "Stack Overflow." + newLine;

        // queue should have length of 5
        assertFalse(q.isEmpty());
        assertEquals(5, q.getLength());

        q.enqueue(6);
        assertEquals(expectedOutput, output.toString());

    }

    @Test
    void isEmpty() {
        Queue q = new Queue(arr.length);
        assertTrue(q.isEmpty());
    }
}