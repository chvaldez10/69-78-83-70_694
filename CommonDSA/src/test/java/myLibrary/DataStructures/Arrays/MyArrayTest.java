package myLibrary.DataStructures.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    private MyArray myArray;
    private  final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    String newLine = System.lineSeparator();

    @BeforeEach
    public void setUpStreams() {
        myArray = new MyArray();
        System.setOut(new PrintStream(output));

        myArray.addElement(1);
        myArray.addElement(2);
        myArray.addElement(3);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @BeforeEach
    void setUp() {
        myArray = new MyArray();
        myArray.addElement(1);
        myArray.addElement(2);
        myArray.addElement(3);
    }

    @Test
    void testGetArrayElement(){
        assertEquals(1, myArray.getArrayElement(0), "First element should be 1");
        assertEquals(2, myArray.getArrayElement(1), "First element should be 2");
        assertEquals(3, myArray.getArrayElement(2), "First element should be 3");
        assertEquals(3, myArray.getArrayLength(), "The length of the array should be 3");
    }

    @Test
    void testRemoveLastElement() {
        assertEquals(3 , myArray.removeLastElement(), "The removed element should be 3.");
        assertEquals(2, myArray.getArrayLength(), "The length of the array should now be 2.");
    }

    @Test
    void testRemoveElement(){
        String expectedOutput = "1 3 " + newLine;

        assertEquals(2, myArray.removeElement(1), "The removed element should 2.");
        assertEquals(2, myArray.getArrayLength(), "The length of the array should be 2.");

        myArray.display();
        assertEquals(expectedOutput, output.toString());
    }
}