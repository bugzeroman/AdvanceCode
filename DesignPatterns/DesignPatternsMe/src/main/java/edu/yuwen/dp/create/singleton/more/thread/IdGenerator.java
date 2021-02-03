package edu.yuwen.dp.create.singleton.more.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式的变种，多例模式，实例数量和线程数相等
 * 
 * A.单例模式在进程内唯一，线程内不唯一，多个线程共享同一个单例
 * B.多例模式在进程内唯一，线程内也唯一，可以看做ThreadLocal
 *
 * Demo:唯一递增ID号码生成器,下面的实现了类似ThreadLocal的功能，通过线程ID保证每个线程使用自己的单例
 */
public class IdGenerator {

    private static final ConcurrentHashMap<Long, IdGenerator> instances = new ConcurrentHashMap<>();

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        // 此处可以优化，不用每次都new一个对象，虽然不影响功能
        instances.putIfAbsent(currentThreadId, new IdGenerator());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
