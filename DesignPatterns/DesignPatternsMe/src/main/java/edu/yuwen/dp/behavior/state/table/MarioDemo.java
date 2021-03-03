package edu.yuwen.dp.behavior.state.table;

/**
 * 5.状态模式（行为型）
 * 
 * 1.查表法 初始状态（第一维）对应遇到的事件（第二维）确定转移后的状态以及操作。
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
