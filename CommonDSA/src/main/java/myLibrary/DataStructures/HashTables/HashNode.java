package myLibrary.DataStructures.HashTables;
public class HashNode {
    public String key;
    public int value;
    private final int hashCode;

    public HashNode next;

    public HashNode(String key, int value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
        this.next = null;
    }

}
