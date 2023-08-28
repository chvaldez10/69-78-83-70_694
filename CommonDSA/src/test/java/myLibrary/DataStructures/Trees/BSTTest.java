package myLibrary.DataStructures.Trees;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTest {
    private int[] arr = {30, 23, 43, 54, 12, 50, 45, 97};
    private BST bst;

    @BeforeEach
    public void setUp(){
        bst = new BST();
    }

    @Test
    public void testInsert() {
        for (int i : arr) bst.insert(i);

        for (int i: arr) {
            assertTrue(bst.contains(i));
        }

        assertFalse(bst.contains(99));
    }

}