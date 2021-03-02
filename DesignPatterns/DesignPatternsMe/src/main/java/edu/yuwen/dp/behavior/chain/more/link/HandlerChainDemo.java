package edu.yuwen.dp.behavior.chain.more.link;

/**
 * 4.职责链模式（行为型） 变体
 * 
 * 1.用链表存储处理器
 *
 * Demo:多个处理器按照顺序处理请求，直到所有处理器都处理了请求。
 */
public class HandlerChainDemo {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}