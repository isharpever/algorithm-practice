package com.isharpever.practice.letter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 统计文件并排序<br>
 * cat /home/admin/logs/webx.log | grep "Login" | uniq -c | sort -nr
 */
public class LetterSort {

    public static void main(String[] args) {
        String path = "E:\\123.txt";

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // 过滤目标行并统计次数(相邻重复合并)
        String line = null;
        List<Node> list = new ArrayList<>();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.contains("Login")) {
                    continue;
                }
                if (list.size() == 0 || !line.equals(list.get(list.size() - 1).key)) {
                    list.add(new Node(line, 1));
                } else {
                    list.get(list.size() - 1).value++;
                }
            }
        } catch (Exception e) {
            try {
                bufferedReader.close();
            } catch (IOException e1) {
            }
            return;
        }

        // 倒序
        list.sort((e1, e2) -> {
            int result = Integer.compare(e2.value, e1.value);
            if (result == 0) {
                result = e2.key.compareTo(e1.key);
            }
            return result;
        });

        // 输出
        for (Node node : list) {
            System.out.println(String.format("%d %s", node.value, node.key));
        }
    }

    static class Node {
        String key;
        int value;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
