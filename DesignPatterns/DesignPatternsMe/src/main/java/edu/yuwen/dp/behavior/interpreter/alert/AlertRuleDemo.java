package edu.yuwen.dp.behavior.interpreter.alert;

import java.util.HashMap;
import java.util.Map;

/**
 * 10.解释器模式（行为型） 
 *
 * 
 * Demo: 自定义告警规则
 * 1.自定义的告警规则只包含“||、&&、>、<、==”这五个运算符，
 * 2.其中，“>、<、==”运算符的优先级高于“||、&&”运算符，“&&”运算符优先级高于“||”。
 * 3.在表达式中，任意元素之间需要通过空格来分隔。
 * 4.用户可以自定义要监控的 key
 */
public class AlertRuleDemo {

    public static void main(String[] args) {
        String rule = "key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88";
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        Map<String, Long> stats = new HashMap<>();
        stats.put("key1", 101l);
        stats.put("key3", 121l);
        stats.put("key4", 88l);
        boolean alert = interpreter.interpret(stats);
        System.out.println(alert);
    }
}