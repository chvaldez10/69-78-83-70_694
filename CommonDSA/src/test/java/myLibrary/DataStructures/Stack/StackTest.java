package myLibrary.DataStructures.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private int[] arr = {1, 2, 3, 4, 5};

    @Test
    public void testGetLength(){
        Stack stack = new Stack(5);
        assertEquals(0, stack.getLength());
    }

    @Test
    public void testIsEmpty(){
        Stack stack = new Stack(5);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testGetMax(){
        Stack stack = new Stack(5);
        assertEquals(5, stack.getMax());
    }

    @Test
    public void testPush() {
        Stack stack = new Stack(5);
        for(int i : arr) stack.push(i);

        // stack should not be empty, length of 5,
        assertFalse(stack.isEmpty());
        assertEquals(5, stack.getLength());
    }

    @Test
    public void testPop(){
        Stack stack = new Stack(5);
        for(int i : arr) stack.push(i);

        for (int i=arr.length-1; i>=0; i--){
            assertEquals(arr[i], stack.pop());
        }

        // list should be empty
        assertEquals(stack.getLength(), 0);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull(){
        Stack stack = new Stack(5);
        assertFalse(stack.isFull());
        for(int i : arr) stack.push(i);
        assertTrue(stack.isFull());
    }

    @Test
    public void testPeek(){
        Stack stack = new Stack(5);
        for(int i : arr) stack.push(i);
        assertEquals(5, stack.peek());
        assertEquals(5, stack.getLength());
    }
}