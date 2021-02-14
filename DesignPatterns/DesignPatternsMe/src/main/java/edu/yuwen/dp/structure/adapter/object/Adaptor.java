package edu.yuwen.dp.structure.adapter.object;

import edu.yuwen.dp.structure.adapter.scene.Adaptee;
import edu.yuwen.dp.structure.adapter.scene.ITarget;

/**
 * 4.适配器模式（结构性）
 * 
 * 2.对象适配器：基于组合
 *
 * Demo:ITarget表示要转化成的接口定义，
 * Adaptee是一组不兼容 ITarget接口定义的接口，
 * Adaptor将 Adaptee转化成一组符合 ITarget接口定义的接口。
 */
public class Adaptor implements ITarget {
    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        // 委托给Adaptee
        adaptee.fa();
    }

    @Override
    public void f2() {
        // 重新实现f2()
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
