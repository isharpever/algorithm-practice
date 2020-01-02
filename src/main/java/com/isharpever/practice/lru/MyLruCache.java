package com.isharpever.practice.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyLruCache<K, V> {

    private final Map<K, V> map = new HashMap<>();
    private final LinkedList<K> list = new LinkedList<>();
    private final int capacity;

    public MyLruCache(int capacity) {
        this.capacity = capacity;
    }

    public synchronized Object get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        list.remove(key);
        list.addFirst(key);
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        V oldValue = map.put(key, value);
        if (oldValue != null) {
            list.remove(key);
        } else if (map.size() > this.capacity) {
            K oldKey = list.removeLast();
            if (oldKey != null) {
                map.remove(oldKey);
            }
        }
        list.addFirst(key);
    }

    public static void main(String[] args) {
        MyLruCache<String, String> cache = new MyLruCache<>(2);
        cache.put("a", "a1");
        System.out.println(cache.get("a"));

        cache.put("b", "b2");
        System.out.println(cache.get("b"));
        System.out.println(cache.get("a"));

        cache.put("c", "c3");
        System.out.println(cache.get("a"));
        System.out.println(cache.get("b"));
        System.out.println(cache.get("c"));
    }
}
