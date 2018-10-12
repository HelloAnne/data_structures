package com.anne.queue;

/**
 * Author: Anne Zhang
 * Date: 2018/5/30 0030
 * Description:
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail+1)%data.length == front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%(data.length);
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        E ret = data[front];
        data[front] = null;
        if (size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        front = (front+1)%data.length;
        size --;
        return ret;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity+1];
        for (int i=0; i<size; i++) {
            newData[i] = data[(front+i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i=0; i<size; i++) {
            res.append(data[(i+front)%data.length]);
            if (i != size-1){
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
