package myLibrary.DataStructures.Arrays;

import java.util.ArrayList;

public class MyArray {
    private int length;
    private ArrayList<Integer> data;

    public MyArray() {
        this.length = 0;
        this.data = new ArrayList<>();
    }

    public int getArrayLength() {
        return this.length;
    }

    public int getArrayElement(int index) {
        return this.data.get(index);
    }

    public void addElement(int data) {
        this.data.add(data);
        this.length += 1;
    }
}
