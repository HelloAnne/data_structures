package com.anne.map;

public class CompObject implements Comparable  {

    private String name;

    public CompObject(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((CompObject)o).name);
    }
}
