package myLibrary.DataStructures.HashTables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashNodeTest {

    private HashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable(10);
    }

    @Test
    public void testPutAndGet() throws Exception {
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);

        assertEquals(1, hashTable.get("key1"));
        assertEquals(2, hashTable.get("key2"));
    }
}