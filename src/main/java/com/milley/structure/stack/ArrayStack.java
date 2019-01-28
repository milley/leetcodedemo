package com.milley.structure.stack;

public class ArrayStack {
    private String[] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    public boolean push(String item) {
        if (count == n) return false;
        items[count] = item;
        ++count;
        return true;
    }

    public String pop() {
        if (count == 0) return null;
        String tmp = items[count - 1];
        --count;
        return tmp;
    }
}
