package edu.yuwen.dp.structure.proxy.dynamic;

import edu.yuwen.dp.structure.proxy.scene.IUserController;
import edu.yuwen.dp.structure.proxy.scene.UserController;

/**
 * 1.代理模式（结构性）
 * 
 * 1.动态代理
 *
 * Demo:动态代理模式使用演示
 */
public class MetricsCollectorProxyDemo {
    public static void main(String[] args) {
        // MetricsCollectorProxy使用,使用基于接口的业务实现类，动态代理模式会动态创建对应的代理类
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.login("telephone", "password");
    }
}
