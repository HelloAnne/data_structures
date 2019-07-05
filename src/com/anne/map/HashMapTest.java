package com.anne.map;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        System.out.println(hashMap.get(null));
    }

}
