package edu.yuwen.dp.behavior.iterator.jdk;

public class ArrayList<E> implements List<E> {
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(this);
    }
    // ...省略其他代码

    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public E get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(String string) {
        // TODO Auto-generated method stub

    }
}