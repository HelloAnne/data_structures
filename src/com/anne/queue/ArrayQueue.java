package com.anne.queue;

import com.anne.array.Array;

/**
 * Author: Anne Zhang
 * Date: 2018/5/30 0030
 * Description:
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.remove(0);
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }
}
