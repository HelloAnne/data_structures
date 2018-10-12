package com.anne.array;

/**
 * Author: Anne Zhang
 * Date: 2018/5/29 0029
 * Description:
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 有参构造函数
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在index索引的位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("GetElement fail. Require index >= 0 and index <= size.");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast() {
        return get(size-1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst() {
        return get(0);
    }
    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("GetElement fail. Require index >= 0 and index <= size.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return find(e) != -1;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for(int i = 0; i <size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail. Require index >= 0 and index <= size.");
        }
        E ret = data[index];
        for (int i = index; i < size-1; i++ ) {
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        if (size == data.length/2){
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     * @return
     */
    public E removeLast() {
        return remove(size);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0; i<size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d \n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
