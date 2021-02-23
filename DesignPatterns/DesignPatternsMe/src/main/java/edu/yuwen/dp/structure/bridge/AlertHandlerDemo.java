package edu.yuwen.dp.structure.bridge;

import java.util.Collections;

/**
 * 2.桥接模式（结构型）
 * 
 * Demo: 演示使用方法，把不同的规则和通知组装起来，实现告警，
 * 可以在配置文件中指定不同的告警级别对应的通知渠道，
 * 从而在处理类初始化时，绑定对应类之间的关系。
 */
public class AlertHandlerDemo {
    public static void main(String[] args) {
        // 不同的紧急程度对应不同的通知渠道。比如，SERVE（严重）级别的消息会通过“自动语音电话”告知相关人员。
        // 下面演示TRIVIAL（无关紧要）的级别消息通过微信告警
        WechatMsgSender wechatMsgSender = new WechatMsgSender(Collections.singletonList("yuwen"));
        TrivialNotification trivialNotification = new TrivialNotification(wechatMsgSender);
        AlertHandler normalHanlder = new AlertHandler(NotificationEmergencyLevel.TRIVIAL, trivialNotification);

        String apiStatInfo = "apinStatInfo TRIVIAL";
        normalHanlder.check(apiStatInfo);
    }
}
