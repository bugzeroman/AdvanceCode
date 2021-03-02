package edu.yuwen.dp.behavior.chain.link;

/**
 * 4.职责链模式（行为型）
 * 
 * 1.用链表存储处理器
 *
 * Demo:多个处理器按照顺序处理请求，不能处理就往下传递，能处理就返回处理结果。
 */
public class HandlerChainDemo {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}