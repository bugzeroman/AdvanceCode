package edu.yuwen.dp.create.factory.more.di;

import edu.yuwen.dp.create.factory.more.di.impl.ClassPathXmlApplicationContext;
import edu.yuwen.dp.create.factory.more.di.scene.RateLimiter;

/**
 * 实现一个简单的DI容器，类似Spring的依赖注入容器
 * 核心功能3个：
 * 1.配置解析
 * 2.对象创建
 * 3.对象生命周期管理。
 * 
 */
public class DiDemo {
    public static void main(String[] args) {
        String config = "create/factory/more/di/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();
    }
}