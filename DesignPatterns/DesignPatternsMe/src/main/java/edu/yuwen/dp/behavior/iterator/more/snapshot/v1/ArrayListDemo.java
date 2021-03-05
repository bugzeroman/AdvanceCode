package edu.yuwen.dp.behavior.iterator.more.snapshot.v1;

import edu.yuwen.dp.behavior.iterator.more.snapshot.scene.Iterator;
import edu.yuwen.dp.behavior.iterator.more.snapshot.scene.List;

/**
 * 6.迭代器模式（行为型） 又名游标模式 更多示例
 * 
 * 1.解决方案一，在迭代器类中定义一个成员变量 snapshot来存储快照
 *
 * Demo:使用迭代器实现List的快照功能
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(2);

        Iterator<Integer> iter1 = list.iterator();// snapshot: 3, 8, 2
        list.remove(new Integer(2));// list：3, 8
        Iterator<Integer> iter2 = list.iterator();// snapshot: 3, 8
        list.remove(new Integer(3));// list：8
        Iterator<Integer> iter3 = list.iterator();// snapshot: 8

        // 输出结果：3 8 2
        while (iter1.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();

        // 输出结果：3 8
        while (iter2.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();

        // 输出结果：8
        while (iter3.hasNext()) {
            System.out.print(iter1.next() + " ");
        }
        System.out.println();
    }
}
