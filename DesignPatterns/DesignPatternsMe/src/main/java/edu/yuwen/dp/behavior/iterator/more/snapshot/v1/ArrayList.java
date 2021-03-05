package edu.yuwen.dp.behavior.iterator.more.snapshot.v1;

import edu.yuwen.dp.behavior.iterator.more.snapshot.scene.Iterator;
import edu.yuwen.dp.behavior.iterator.more.snapshot.scene.List;

public class ArrayList<E> implements List<E> {
    // TODO: 成员变量、私有函数等随便你定义

    @Override
    public void add(E obj) {
        // TODO: 由你来完善
    }

    @Override
    public void remove(E obj) {
        // TODO: 由你来完善
    }

    @Override
    public Iterator<E> iterator() {
        return new SnapshotArrayIterator(this);
    }

    public void addAll(ArrayList<E> arrayList) {
        // TODO Auto-generated method stub

    }

    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public E get(int index) {
        // TODO Auto-generated method stub
        return null;
    }
}
