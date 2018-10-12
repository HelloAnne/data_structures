package com.anne.linkedlist;

import com.anne.stack.Stack;

/**
 * Author: Anne Zhang
 * Date: 2018/6/12 0012
 * Description:
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> data;

    public LinkedListStack(){
        data = new LinkedList<>();
    }


    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }
}
