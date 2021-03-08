package edu.yuwen.dp.behavior.visitor.file;

import java.util.ArrayList;
import java.util.List;

/**
 * 7.访问者模式（行为型） 
 *
 * Demo: * 对三种文件资源进行两种类型的操作，
 * 文件类型为PDF,PPT,Word,
 * 操作分组解析为txt文本和进行压缩，
 * 比如把PDF解析为txt文本。
 */
public class VisitorDemo {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        String directory = "/";
        List<ResourceFile> resourceFiles = listAllResourceFiles(directory);
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }

        Compressor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        // ...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}
