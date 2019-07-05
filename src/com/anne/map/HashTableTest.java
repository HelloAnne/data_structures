package com.anne.map;

import java.util.Hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String > hashtable = new Hashtable<>();
        // key和value都不可以是null
        hashtable.put(null, null);
        System.out.println(hashtable.get(null));
    }

}
