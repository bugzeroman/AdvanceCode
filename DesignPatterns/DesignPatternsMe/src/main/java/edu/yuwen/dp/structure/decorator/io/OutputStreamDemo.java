package edu.yuwen.dp.structure.decorator.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 1.装饰器模式（结构性）
 * 
 * 1.仅介绍JDK的文件IO的例子，没有实现的例子
 *
 * Demo:DK的文件IO的读写都用到了装饰器模式
 */
public class OutputStreamDemo {
    // 使用DataOutputStream写入的文件才能用DataInputStream读取
    public static void main(String[] args) throws Exception {
        OutputStream out = new FileOutputStream("src/main/resources/structure/decorator/io/test.txt");
        DataOutputStream dout = new DataOutputStream(out);

        dout.writeUTF("yuwen");
        dout.close();
    }
}
