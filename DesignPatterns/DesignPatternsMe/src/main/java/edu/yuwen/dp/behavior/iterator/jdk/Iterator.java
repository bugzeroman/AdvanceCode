package edu.yuwen.dp.behavior.iterator.jdk;

//接口定义方式一
public interface Iterator<E> {
    boolean hasNext();

    void next();

    E currentItem();
}

/**
//接口定义方式二
public interface Iterator<E> {
boolean hasNext();
E next();
}
 */
