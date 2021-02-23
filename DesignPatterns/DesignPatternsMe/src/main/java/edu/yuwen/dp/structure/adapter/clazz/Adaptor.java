package edu.yuwen.dp.structure.adapter.clazz;

import edu.yuwen.dp.structure.adapter.scene.Adaptee;
import edu.yuwen.dp.structure.adapter.scene.ITarget;

/**
 * 4.适配器模式（结构型）
 * 
 * 1.类适配器: 基于继承
 *
 * Demo:ITarget表示要转化成的接口定义，
 * Adaptee是一组不兼容 ITarget接口定义的接口，
 * Adaptor将 Adaptee转化成一组符合 ITarget接口定义的接口。
 */
public class Adaptor extends Adaptee implements ITarget {
    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        // 重新实现f2()
    }

    // 这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
}
