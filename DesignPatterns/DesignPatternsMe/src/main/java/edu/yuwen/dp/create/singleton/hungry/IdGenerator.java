package edu.yuwen.dp.create.singleton.hungry;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式
 * 
 * 1. 饿汉式
 *
 * Demo:唯一递增ID号码生成器
 */
public class IdGenerator {
    private static final IdGenerator instance = new IdGenerator();

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
