package com.ll.arraylist;

public class MyArrayList<T> {
    private int size = 0;
    private String[] data = new String[2];

    public int size() {
        return size;
    }

    public boolean add(T element) {
        makeNewDataIfNotEnough();
        data[size] = (String) element;
        size++;
        return true;
    }

    private void makeNewDataIfNotEnough() {
        if (ifNotEnough()) {
            makeNewData();
        }
    }

    private void makeNewData() {
        String[] newData = new String[data.length * 2];

        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private boolean ifNotEnough() {
        return size >= data.length;
    }

    public void remove(T element) {
        size--;
    }

    public String get(int idx) {
        return data[idx];
    }
}
