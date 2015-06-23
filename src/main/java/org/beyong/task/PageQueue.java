package org.beyong.task;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-23.
 */
public class PageQueue {

    private static PriorityBlockingQueue<String> queue =new PriorityBlockingQueue<String>();

    public synchronized boolean posh(String url){
        return  queue.offer(url);
    }

    public synchronized String get(){
        return queue.poll();
    }
}
