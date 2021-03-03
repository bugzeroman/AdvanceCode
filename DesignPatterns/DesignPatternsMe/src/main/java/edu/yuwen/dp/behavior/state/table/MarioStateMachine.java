package edu.yuwen.dp.behavior.state.table;

public class MarioStateMachine {
    private int score;
    private State currentState;

    // 查表法，状态转移表
    private static final State[][] transitionTable = { { State.SUPER, State.CAPE, State.FIRE, State.SMALL },
            { State.SUPER, State.CAPE, State.FIRE, State.SMALL }, { State.CAPE, State.CAPE, State.CAPE, State.SMALL },
            { State.FIRE, State.FIRE, State.FIRE, State.SMALL } };

    // 查表法，动作转移表
    private static final int[][] actionTable = { { +100, +200, +300, +0 }, { +0, +200, +300, -100 },
            { +0, +0, +0, -200 }, { +0, +0, +0, -300 } };

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score += actionTable[stateValue][eventValue];
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }

}
