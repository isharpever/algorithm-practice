package com.isharpever.practice.lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MyLruCache3<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    Node<K, V> first, last;

    public MyLruCache3(int capacity) {
        this.capacity = capacity;
    }

    public synchronized V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        moveToFirst(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        Node<K, V> old = map.put(key, node);
        if (old != null) {
            remove(old);
        } else if (map.size() > this.capacity) {
            map.remove(last.key);
            remove(last);
        }
        addFirst(node);
    }

    private synchronized void moveToFirst(Node<K, V> node) {
        if (first == node) {
            return;
        }
        remove(node);
        addFirst(node);
    }

    private synchronized void remove(Node<K, V> node) {
        if (first == node) {
            first = node.next;
            node.next = null;
        } else {
            node.pre.next = node.next;
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (last == node) {
                last = node.pre;
            }
            node.pre = null;
        }
    }

    private synchronized void addFirst(Node<K, V> node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.pre = null;
            node.next = first;
            first.pre = node;
            first = node;
        }
    }

    public static void main(String[] args) {
        MyLruCache3<String, String> cache = new MyLruCache3<>(2);
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

    class Node<K, V> {
        Node<K, V> pre;
        Node<K, V> next;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
