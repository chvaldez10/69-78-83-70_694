package myLibrary.DataStructures.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    private MyArray myArray;

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
}