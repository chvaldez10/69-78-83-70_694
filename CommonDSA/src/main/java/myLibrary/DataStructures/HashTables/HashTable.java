package myLibrary.DataStructures.HashTables;
import java.util.ArrayList;
import myLibrary.DataStructures.HashTables.HashNode;
import java.util.NoSuchElementException;

public class HashTable {
    private int size;
    private ArrayList<HashNode> bucketArray;
    private int numBuckets;

    public HashTable(int numBuckets) {
        this.numBuckets = numBuckets;
        this.bucketArray = new ArrayList<>(numBuckets);
        for (int i = 0; i<numBuckets; i++) {
            this.bucketArray.add(null);
        }
        this.size = 0;
    }

    private int getHashCode(String key){
        int hash = 0;
        for(int i=0; i<key.length(); i++){
            hash = (hash + key.charAt(i)*i) % numBuckets;
        }
        return hash;
    }

    public void put(String key, int value) {
        // get hash code
        int hashCode = getHashCode(key);

        // add to arraylist
        if (bucketArray.get(hashCode) == null) {
            // add a new HashNode if empty
            bucketArray.add(hashCode, new HashNode(key, value, hashCode));
        } else {
            HashNode head = bucketArray.get(hashCode);

            while(head.next != null) {
                head = head.next;
            }

            head.next = new HashNode(key, value, hashCode);
        }
    }

    public int get(String key) throws Exception {
        int hashCode = getHashCode(key);
        HashNode head = bucketArray.get(hashCode);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head=head.next;
            }
        throw new NoSuchElementException("Key not found: " + key);
    }
}
