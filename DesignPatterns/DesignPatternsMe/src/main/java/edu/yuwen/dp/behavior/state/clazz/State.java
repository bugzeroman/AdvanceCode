package edu.yuwen.dp.behavior.state.clazz;

/**
 * 马里奥可以变身为多种形态，
 * 比如小马里奥（Small Mario）、
 * 超级马里奥（Super Mario）、
 * 火焰马里奥（Fire Mario）、
 * 斗篷马里奥（Cape Mario）
 *
 */
public enum State {
    SMALL(0), SUPER(1), FIRE(2), CAPE(3);

    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
