package edu.yuwen.dp.structure.proxy.statics.interfaces;

import edu.yuwen.dp.structure.proxy.scene.IUserController;
import edu.yuwen.dp.structure.proxy.scene.UserController;

/**
 * 1.代理模式（结构性）
 * 
 * 1.静态代理的实现方式一，通过接口代理
 *
 * Demo:演示代理模式使用方法
 */
public class UserControllerProxyDemo {
    public static void main(String[] args) {
        // UserControllerProxy使用举例
        // 因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        // 将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
        IUserController userController = new UserControllerProxy(new UserController());
        userController.login("telephone", "password");
    }
}
