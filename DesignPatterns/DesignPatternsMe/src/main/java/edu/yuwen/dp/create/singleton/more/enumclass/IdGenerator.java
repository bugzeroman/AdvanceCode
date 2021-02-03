package edu.yuwen.dp.create.singleton.more.enumclass;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式的变种，多例模式，通过枚举值的数量，限制多例模式的数量
 * 
 * 5.枚举  有多个有限的枚举值
 *
 * Demo:唯一递增ID号码生成器
 */
public enum IdGenerator {
    INSTANCE1, INSTANCE2, INSTANCE3;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
