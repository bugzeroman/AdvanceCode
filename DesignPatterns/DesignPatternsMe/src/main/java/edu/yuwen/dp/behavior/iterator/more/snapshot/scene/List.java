package edu.yuwen.dp.behavior.iterator.more.snapshot.scene;

public interface List<E> {
    void add(E obj);

    void remove(E obj);

    Iterator<E> iterator();
}
