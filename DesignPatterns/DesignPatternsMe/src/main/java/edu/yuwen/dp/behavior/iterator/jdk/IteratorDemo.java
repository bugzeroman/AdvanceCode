package edu.yuwen.dp.behavior.iterator.jdk;

/**
 * 6.迭代器模式（行为型） 又名游标模式
 * 
 * 1.Iterator接口定义两种方式，第一种三个接口，Next不返回当前元素
 *
 * Demo:模仿JDK的List和Iterator开发的迭代器
 */
public class IteratorDemo {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}