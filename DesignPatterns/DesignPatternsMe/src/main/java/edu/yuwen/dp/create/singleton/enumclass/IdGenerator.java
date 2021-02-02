package edu.yuwen.dp.create.singleton.enumclass;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式
 * 
 * 5.枚举
 *
 * Demo:唯一递增ID号码生成器
 */

public enum IdGenerator {
    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
