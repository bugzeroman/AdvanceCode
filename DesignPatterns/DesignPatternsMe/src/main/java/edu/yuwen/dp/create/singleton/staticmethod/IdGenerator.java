package edu.yuwen.dp.create.singleton.staticmethod;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式的替代方法
 * 
 * 1. 静态方法，可以替代单例模式，但是比单例模式更加不灵活
 *
 * Demo:唯一递增ID号码生成器
 */
public class IdGenerator {
    // 全局变量
    private static AtomicLong id = new AtomicLong(0);

    public static long getId() {
        return id.incrementAndGet();
    }
}
