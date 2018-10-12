package com.anne.linkedlist;

/**
 * Author: Anne Zhang
 * Date: 2018/6/5 0005
 * Description:
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

   public LinkedList(){
       this.dummyHead = new Node();
       this.size = 0;
   }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表头添加新的元素e addFirst
   public void addFirst(E e){
        add(0,e);
   }
    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：） add
    public void add(int index, E e) {
       if(index <0 || index >size) {
           throw new IllegalArgumentException("Fail add. Illegal index.");
       }
        Node pre = dummyHead;
        for(int i=0; i<index; i++){
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;


    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        if(index <0 || index >=size) {
            throw new IllegalArgumentException("Get fail. Illegal index.");
        }
        Node cur = dummyHead;
        for (int i=0; i<=index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index <0 || index >=size) {
            throw new IllegalArgumentException("Set fail. Illegal index.");
        }
        Node cur = dummyHead;
        for (int i=0; i<=index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index <0 || index >=size) {
            throw new IllegalArgumentException("Remove fail. Illegal index.");
        }
        Node pre = dummyHead;
        for(int i=0; i<index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

}
