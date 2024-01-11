package myLibrary.DataStructures.HashTables;
public class HashNode {
    private String key;
    private int value;
    private final int hashCode;

    private HashNode next;

    public HashNode(String key, int value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
        this.next = null;
    }

}
