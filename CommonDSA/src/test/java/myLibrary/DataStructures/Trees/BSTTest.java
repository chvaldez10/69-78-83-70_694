package myLibrary.DataStructures.Trees;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class BSTTest {
    private int[] arr = {30, 23, 43, 54, 12, 50, 45, 97};
    private ArrayList<Integer> expectedInOrderResult =
            new ArrayList<>(Arrays.asList(12, 23, 30, 43, 45, 50, 54, 97));
    private ArrayList<Integer> expectedPreOrderResult =
            new ArrayList<>(Arrays.asList(30, 23, 12, 43, 54, 50, 45, 97));

    private ArrayList<Integer> expectedPostOrderResult =
            new ArrayList<>(Arrays.asList(12, 23, 45, 50, 97, 54, 43, 30));

    private ArrayList<Integer> expectedBFTResult =
            new ArrayList<>(Arrays.asList(30, 23, 43, 12, 54, 50, 97, 45));

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

    @Test
    public void testInOrder() {
        for (int i : arr) bst.insert(i);
        ArrayList<Integer> inOrderResult = new ArrayList<>();
        inOrderResult = bst.inOrder(bst.getRoot(), inOrderResult);
        assertEquals(inOrderResult, expectedInOrderResult);
    }

    @Test
    public void testPreOrder() {
        for (int i : arr) bst.insert(i);
        ArrayList<Integer> preOrderResult = new ArrayList<>();
        preOrderResult = bst.preOrder(bst.getRoot(), preOrderResult);
        assertEquals(preOrderResult, expectedPreOrderResult);
    }

    @Test
    public void testPostOrder() {
        for (int i : arr) bst.insert(i);
        ArrayList<Integer> postOrderResult = new ArrayList<>();
        postOrderResult = bst.postOrder(bst.getRoot(), postOrderResult);
        assertEquals(postOrderResult, expectedPostOrderResult);
    }

    @Test
    public void testBFTTraversal() throws BST.EmptyRootException {
        for (int i : arr) bst.insert(i);
        ArrayList<Integer> bftResult = new ArrayList<>();
        bftResult = bst.breathFirsTraversal(bst.getRoot());
        assertEquals( bftResult, expectedBFTResult);
    }

}