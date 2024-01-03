package myLibrary.DataStructures.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

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

    public int removeLastElement() {
        int lastElement = data.remove(length-1);
        this.length--;
        return lastElement;
    }

    public int removeElement(int index) {
        int deletedElement = data.remove(index);
        this.length--;
        return deletedElement;
    }

    public void display(){
        for (int d : data) System.out.print(d + " ");
        System.out.println();
    }
}
