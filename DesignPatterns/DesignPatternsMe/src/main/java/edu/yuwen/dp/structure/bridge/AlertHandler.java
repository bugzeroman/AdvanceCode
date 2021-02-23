package edu.yuwen.dp.structure.bridge;

/**
 * 2.桥接模式（结构型）
 * 
 * Demo: API 接口监控告警的例子：根据不同的告警规则，触发不同类型的告警。
 */
public class AlertHandler {
    private NotificationEmergencyLevel rule;

    private Notification notification;

    public AlertHandler(NotificationEmergencyLevel rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    // 检查信息是否满足规则，满足一定规则则需要告警
    public void check(String apiStatInfo) {
        // 这里简单处理，在传入的信息中包含对应规则的字符串，则认为匹配成功
        if (apiStatInfo.contains(rule.toString())) {
            notification.notify("Message=" + apiStatInfo + " matched rule=" + rule);
        }
    }
}