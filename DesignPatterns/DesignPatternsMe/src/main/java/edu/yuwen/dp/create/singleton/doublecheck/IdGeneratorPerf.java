package edu.yuwen.dp.create.singleton.doublecheck;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1.单例模式
 * 
 * 3. 双重检测 性能优化版本
 *
 * Demo:唯一递增ID号码生成器
 */
public class IdGeneratorPerf {

    private static volatile IdGeneratorPerf instance;

    private AtomicLong id = new AtomicLong(0);

    private IdGeneratorPerf() {
    }

    public static IdGeneratorPerf getInstance() {
        // 1.使用局部变量localRef将减少访问volatile变量的次数，也就减少了访问主存的次数，提升性能
        // 如果不使用localRef，那么当不为null的时候将不得不访问volatile变量两次，一次是在检查null，另一次是在方法返回时；
        IdGeneratorPerf localRef = instance;
        if (localRef == null) {
            synchronized (IdGeneratorPerf.class) {
                // 2.在获得锁后，刷新局部变量为最新值，因为此时volatile变量可能已经更改
                localRef = instance;
                if (localRef == null) {
                    localRef = new IdGeneratorPerf();
                    instance = localRef;
                }
            }
        }
        // 3.localRef缓存了volatile变量，如果直接return instance,会比现在需要多访问一次主存
        return localRef;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
