package edu.yuwen.dp.behavior.observer.basic;

/**
 * 1.观察者模式（行为型）
 * 
 * 1.基础模板
 *
 * Demo:一个主题，有多个观察者注册，然后通知消息发布到所有观察者
 */
public class SubjectObserverDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
}