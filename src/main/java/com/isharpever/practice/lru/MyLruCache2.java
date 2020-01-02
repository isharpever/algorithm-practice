package com.isharpever.practice.lru;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class MyLruCache2<K, V> {

    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private final int capacity;
    private final LinkedHashMap<K, V> map;

    public MyLruCache2(int capacity) {
        this.capacity = capacity;
        // 最大容量 = (缓存大小 / 负载因子) + 1, 保证不会触发自动扩容
        this.map = new LinkedHashMap<K, V>((int) (this.capacity / DEFAULT_LOAD_FACTOR) + 1,
                DEFAULT_LOAD_FACTOR, true) {
            @Override
            protected boolean removeEldestEntry(Entry<K, V> eldest) {
                return size() > MyLruCache2.this.capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        MyLruCache2<String, String> cache = new MyLruCache2<>(2);
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
