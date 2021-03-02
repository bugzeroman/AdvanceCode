package edu.yuwen.dp.behavior.chain.more.link;

public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        doHandle();
        if (successor != null) {
            successor.handle();
        }
    }

    protected abstract void doHandle();
}
