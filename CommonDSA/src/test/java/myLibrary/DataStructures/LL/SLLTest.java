package myLibrary.DataStructures.LL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SLLTest {
    @Test
    public void testInsert(){
        SinglyLinkedList sll = new SinglyLinkedList();
        assertTrue(sll.isEmpty()); // list is empty at the start
        sll.insert(5); // add a Node
        assertFalse(sll.isEmpty()); // list should not be empty
    }
}