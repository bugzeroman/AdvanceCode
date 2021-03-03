package edu.yuwen.dp.behavior.state.clazz;

/**
 * 5.状态模式（行为型）
 * 
 * 3.状态类法 把状态通过接口，分为多个状态接口实现类，在对应的类方法中实现事件处理。
 *
 * Demo:超级马里奥游戏，马里奥可以在不同的状态直接切换，通过在游戏中触发不同的事件。
 */
public class MarioDemo {

    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + state);
    }
}
