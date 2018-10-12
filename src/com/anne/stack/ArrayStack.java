package com.anne.stack;

import com.anne.array.Array;

/**
 * Author: Anne Zhang
 * Date: 2018/5/30 0030
 * Description:
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayStack() {
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: \n");
        res.append("[");
        for (int i=0; i<array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize()-1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
