package edu.yuwen.dp.behavior.template.callback;

/**
 * 2.模板模式（行为型） 回调函数
 * 
 * 同步回调看起来更像模板模式，异步回调看起来更像观察者模式。
 *
 * Demo: A调用B的process方法，同时注册回调函数ICallback，
 * 在B的函数处理过程中会调用ICallback，
 * 此Demo是同步回调。
 */
public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        // 回调对象
        b.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }
}
