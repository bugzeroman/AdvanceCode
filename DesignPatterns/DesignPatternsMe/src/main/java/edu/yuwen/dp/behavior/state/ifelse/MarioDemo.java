package edu.yuwen.dp.behavior.state.ifelse;

/**
 * 5.状态模式（行为型）
 * 
 * 1.分支逻辑法 if-else对照状态转移图开发
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
