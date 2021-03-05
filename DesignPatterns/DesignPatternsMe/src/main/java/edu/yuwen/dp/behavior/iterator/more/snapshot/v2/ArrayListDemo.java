package edu.yuwen.dp.behavior.iterator.more.snapshot.v2;

import edu.yuwen.dp.behavior.iterator.more.snapshot.scene.Iterator;
import edu.yuwen.dp.behavior.iterator.more.snapshot.scene.List;

/**
 * 6.迭代器模式（行为型） 又名游标模式 更多示例
 * 
 * 2.解决方案二，使用时间戳来区分新增的和删除的元素
 *
 * Demo:使用迭代器实现List的快照功能
 * 
 * TODO:代码实现有问题，仅做思路参考：
 * 1.代码貌似跑得不对，只有justNext方法自增了cursorInAll，假设第一个元素没有被删除，那么总是cursorInAll总是0；
 * 2.时间戳获取有点问题，连续操作获取时间戳很有可能都是一样的，应该将时间戳进行递增操作，防止相等
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
            System.out.print(iter2.next() + " ");
        }
        System.out.println();

        // 输出结果：8
        while (iter3.hasNext()) {
            System.out.print(iter3.next() + " ");
        }
        System.out.println();
    }
}