package com.isharpever.practice.encode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class CharacterEncode {

    public static void main(String[] args) {
        /*try(FileOutputStream fo = new FileOutputStream("E:\\尹晓林\\123.html")) {
            byte[] buff = "<meta http-equiv=\"content-type\" content=\"text/html;charset=gbk\">\r\n肺炎".getBytes("UTF8");
            System.out.println("写入文件的字节数组(UTF8编码的\"肺炎\"二字):" + Arrays.toString(buff));
            fo.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try(FileInputStream fo = new FileInputStream("E:\\尹晓林\\123.html")) {
            byte[] buff = new byte[fo.available()];
            fo.read(buff);
            System.out.println("从文件读到的字节数组(UTF8编码的\"肺炎\"二字)::" + Arrays.toString(buff));
            System.out.println("以UTF8编码输出:" + new String(buff, "UTF8"));
            System.out.println("以UTF16编码输出:" + new String(buff, "UTF16"));
            System.out.println("以UNICODE编码输出:" + new String(buff, "UNICODE"));
            System.out.println("以GB2312编码输出:" + new String(buff, "GB2312"));
            System.out.println("以GBK编码输出:" + new String(buff, "GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
