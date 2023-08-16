package myLibrary.DataStructures.LL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SLLTest {
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
    public void testInsert(){
        SinglyLinkedList sll = new SinglyLinkedList();

        // list is empty at the start, size = 0
        assertTrue(sll.isEmpty());
        assertEquals(sll.getSize(), 0);

        // adding a node, size = 1
        sll.insert(5);
        assertEquals(sll.getSize(), 1);
        assertFalse(sll.isEmpty());
    }

    @Test
    public void testInsertAtBeginning(){
        SinglyLinkedList sll = new SinglyLinkedList();

        // list is empty at the start, size = 0
        assertTrue(sll.isEmpty());
        assertEquals(sll.getSize(), 0);

        // adding two nodes containing 2 and 3
        sll.insert(2);
        sll.insert(3);
        assertEquals(sll.getHeadData(), 2);
        assertEquals(sll.getTailData(), 3);
        assertEquals(sll.getSize(), 2);
        assertFalse(sll.isEmpty());

        // insert at beginning
        sll.insertAtBeginning(1);
        assertEquals(sll.getHeadData(), 1);
        assertEquals(sll.getTailData(), 3);
        assertEquals(sll.getSize(), 3);
    }

        @Test
        public void testTDisplay() {
            String newLine = System.lineSeparator();
            String expectedOutput = "1 2 3 4 5 " + newLine;
            SinglyLinkedList sll = new SinglyLinkedList();

            for (int i : arr ) sll.insert(i);
            sll.display();
            assertEquals(expectedOutput, output.toString());
        }

        @Test
        public void testInsertAtPositionMiddle() {
            SinglyLinkedList sll = new SinglyLinkedList();
            for (int i : arr ) sll.insert(i);

            String newLine = System.lineSeparator();
            String expectedOutputMiddle = "1 2 3 6 4 5 " + newLine;

            // head = 1, tail = 5, size = 5
            assertEquals(sll.getHeadData(), 1);
            assertEquals(sll.getTailData(), 5);
            assertEquals(sll.getSize(), 5);

            // insert after 3, 1 > 2 > 3 > 6 > 4 > 5
            sll.insertAtPosition(6, 3);
            sll.display();
            assertEquals(expectedOutputMiddle, output.toString());
        }

    @Test
    public void testInsertAtPositionBeginning() {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i : arr ) sll.insert(i);

        String newLine = System.lineSeparator();
        String expectedOutputBeginning = "6 1 2 3 4 5 " + newLine;

        // head = 1, tail = 5, size = 5
        assertEquals(sll.getHeadData(), 1);
        assertEquals(sll.getTailData(), 5);
        assertEquals(sll.getSize(), 5);

        // insert at beginning, 6 > 1 > 2 > 3  > 4 > 5
        sll.insertAtPosition(6, 0);
        sll.display();
        assertEquals(expectedOutputBeginning, output.toString());
    }


    @Test
    public void testInsertAtPositionEnd() {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i : arr ) sll.insert(i);

        String newLine = System.lineSeparator();
        String expectedOutputBeginning = "1 2 3 4 5 6 " + newLine;

        // head = 1, tail = 5, size = 5
        assertEquals(sll.getHeadData(), 1);
        assertEquals(sll.getTailData(), 5);
        assertEquals(sll.getSize(), 5);

        // insert at End, 1 > 2 > 3 > 4 > 5 > 6
        sll.insertAtPosition(6, 5);
        sll.display();
        assertEquals(expectedOutputBeginning, output.toString());
    }

    @Test
    public void testInsertAtPositionOutOfBounds() {
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int i : arr ) sll.insert(i);

        String newLine = System.lineSeparator();
        String expectedOutputBeginning = "1 2 3 4 5 6 " + newLine;

        // head = 1, tail = 5, size = 5
        assertEquals(sll.getHeadData(), 1);
        assertEquals(sll.getTailData(), 5);
        assertEquals(sll.getSize(), 5);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.insertAtPosition(6, -1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            sll.insertAtPosition(6, 5);
        });
    }
}