package edu.yuwen.dp.behavior.state.clazz;

public class CapeMario implements IMario {
    private static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        // do nothing...
    }
}
