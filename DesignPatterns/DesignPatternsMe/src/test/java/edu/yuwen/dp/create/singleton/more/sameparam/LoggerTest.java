package edu.yuwen.dp.create.singleton.more.sameparam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class LoggerTest {

    @Test
    public void testGetInstance() {
        // 测试获取单例， 参数相同则返回同一个单例，期望l1==l2, l1!=l3
        Logger log1 = Logger.getInstance("User.class");
        Logger log2 = Logger.getInstance("User.class");
        Logger log3 = Logger.getInstance("Order.class");

        assertEquals(log1, log2);
        assertNotEquals(log3, log2);
    }
}
