package edu.yuwen.dp.structure.decorator.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 1.装饰器模式（结构性）
 * 
 * 1.仅介绍JDK的文件IO的例子，没有实现的例子
 *
 * Demo:DK的文件IO的读写都用到了装饰器模式
 */
public class InputStreamDemo {
    // 演示读取文件，使用装饰器，先嵌套了缓冲功能，又嵌套了按照类型读取功能
    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("src/main/resources/structure/decorator/io/test.txt");
        InputStream bin = new BufferedInputStream(in);
        DataInputStream din = new DataInputStream(bin);
        String data = din.readUTF();
        System.out.println(data);
    }
}
