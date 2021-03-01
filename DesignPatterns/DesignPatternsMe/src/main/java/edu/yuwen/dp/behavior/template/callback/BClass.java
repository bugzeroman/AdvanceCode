package edu.yuwen.dp.behavior.template.callback;

public class BClass {
    // 调用回调函数的模板方法
    public void process(ICallback callback) {
        System.out.println("Call back before <-");
        // ...
        callback.methodToCallback();
        // ...
        System.out.println("Call back after ->");
    }
}
