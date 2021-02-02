package edu.yuwen.dp.create.singleton.lazy;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式
 * 
 * 2. 懒汉式
 *
 * Demo:唯一递增ID号码生成器
 */
public class IdGenerator {
    private static IdGenerator instance;

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
