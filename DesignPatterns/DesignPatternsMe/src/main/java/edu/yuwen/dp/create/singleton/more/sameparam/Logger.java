package edu.yuwen.dp.create.singleton.more.sameparam;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.单例模式的变种，多例模式，参数相同则返回同一个实例，实例数量取决于参数的取值范围
 * 
 *
 * Demo:同一个 logger name 获取到的对象实例是相同的，不同的 logger name 获取到的对象实例是不同的。
 */
public class Logger {
    private static final ConcurrentHashMap<String, Logger> instances = new ConcurrentHashMap<>();

    private Logger() {
    }

    public static Logger getInstance(String loggerName) {
        instances.putIfAbsent(loggerName, new Logger());
        return instances.get(loggerName);
    }

    public void log() {
        // ...
    }
}
