package edu.yuwen.dp.structure.proxy.statics.inherit;

/**
 * 1.代理模式（结构性）
 * 
 * 2.静态代理的实现方式二，通过继承代理
 *
 * Demo:演示代理模式使用方法
 */
public class UserControllerProxyDemo {
    public static void main(String[] args) {
        // UserControllerProxy使用举例
        // new的对象替换为原始类的子类（代理类）
        UserController userController = new UserControllerProxy();
        userController.login("telephone", "password");
    }
}
