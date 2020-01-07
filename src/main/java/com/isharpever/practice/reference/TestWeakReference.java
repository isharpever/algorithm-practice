package com.isharpever.practice.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 测试虚引用被回收
 */
public class TestWeakReference {

    public static void main(String[] args) {
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        String str = new String("hello world");
        Reference<? extends String> reference = new WeakReference<>(str, queue);
        assert (reference.get() != null);

        str = null;
        System.gc();
        while ((reference = queue.poll()) == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assert reference.get() == null;
    }
}
