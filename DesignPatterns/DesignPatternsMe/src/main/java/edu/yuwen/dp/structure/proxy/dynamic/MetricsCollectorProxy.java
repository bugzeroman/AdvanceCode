package edu.yuwen.dp.structure.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1.代理模式（结构性）
 * 
 * 1.动态代理 动态生成需要代理的类，而不需要针对每个业务接口或者实现类单独写一个代理类
 *
 * Demo:性能统计，给业务接口增加调用耗时统计等功能
 */
public class MetricsCollectorProxy {

    public MetricsCollectorProxy() {
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 调用开始时间
            long startTimestamp = System.currentTimeMillis();

            // 委托：调用具体业务类方法
            Object result = method.invoke(proxiedObject, args);

            // 调用结束时间
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            System.out.println("apiName=" + apiName + ", responseTime=" + responseTime);
            return result;
        }
    }
}
