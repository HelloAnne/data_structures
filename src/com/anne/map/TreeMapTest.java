package com.anne.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1==o2) {
                    return 0;
                }
                if (o1 == null) {
                    return 1;
                } else if (o2 == null) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        };
        TreeMap<String, String> map1 = new TreeMap<>(comparator);
        map1.put(null, null);
        for (String key : map1.keySet()) {
            System.out.println(key);
        }

        TreeMap<CompObject, String> map2 = new TreeMap<>();

        map2.put(new CompObject("Anne"), null);
        map2.put(new CompObject("Sally"), null);
        map2.put(null, null);
        for (CompObject key : map2.keySet()) {
            System.out.println(key);
        }
    }
}
