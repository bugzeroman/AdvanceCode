package edu.yuwen.dp.structure.bridge;

import java.util.List;

public interface MsgSender {
    void send(String message);
}

class TelephoneMsgSender implements MsgSender {
    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("message=" + message + " send to telephones=" + telephones);
    }
}

class EmailMsgSender implements MsgSender {

    @Override
    public void send(String message) {
        // TODO Auto-generated method stub
    }
}

class WechatMsgSender implements MsgSender {

    private List<String> wechatIds;

    public WechatMsgSender(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    @Override
    public void send(String message) {
        System.out.println("message=" + message + " send to wechatIds=" + wechatIds);
    }
}
