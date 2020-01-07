package com.isharpever.practice.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 测试BufferedInputStream重用
 */
public class TestBufferedInputStream {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "E:\\123.txt";

        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        try {
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            bis.mark(bis.available() + 1);
            while (bis.read(buffer, 0, buffer.length) != -1) {
                bos.write(buffer);
            }
            String str = new String(bos.toByteArray());
            System.out.println(str);
            str = new String(bos.toByteArray());
            System.out.println(str);

            bos.reset();
            while (bis.read(buffer, 0, buffer.length) != -1) {
                bos.write(buffer);
            }
            str = new String(bos.toByteArray());
            System.out.println(str);

            bos.reset();
            bis.reset();
            while (bis.read(buffer, 0, buffer.length) != -1) {
                bos.write(buffer);
            }
            str = new String(bos.toByteArray());
            System.out.println(str);

            bos.reset();
            while (fis.read(buffer, 0, buffer.length) != -1) {
                bos.write(buffer);
            }
            str = new String(bos.toByteArray());
            System.out.println(str);
        } finally {
            bis.close();
        }


    }
}
