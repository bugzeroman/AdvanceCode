package edu.yuwen.dp.create.singleton.staticclass;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式
 * 
 * 4. 静态内部类
 *
 * Demo:唯一递增ID号码生成器
 */
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    private static class SingletonHolder {
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
