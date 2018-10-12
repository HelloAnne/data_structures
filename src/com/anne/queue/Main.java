package com.anne.queue;

import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>(5);
        for (int i=0; i<12; i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
        for (int i=0; i<8; i++){
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }
        for (int i=0; i<10; i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        Set set = new HashSet<>();
    }
}
