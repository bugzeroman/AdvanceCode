package edu.yuwen.dp.create.singleton.doublecheck;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式
 * 
 * 3. 双重检测
 *
 * Demo:唯一递增ID号码生成器
 */
public class IdGenerator {
    // 用volatile修饰一下更好
    private static IdGenerator instance;

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            // 此处为类级别的锁
            synchronized (IdGenerator.class) {
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
