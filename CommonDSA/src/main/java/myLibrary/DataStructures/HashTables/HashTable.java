package myLibrary.DataStructures.HashTables;
import java.util.ArrayList;
import myLibrary.DataStructures.HashTables.HashNode;

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

    private int hash(String key){
        int hash = 0;
        for(int i=0; i<key.length(); i++){
            hash = (hash + key.charAt(i)*i) % numBuckets;
        }
        return hash;
    }
}
