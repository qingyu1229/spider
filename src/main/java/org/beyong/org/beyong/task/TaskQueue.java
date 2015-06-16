package org.beyong.org.beyong.task;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public class TaskQueue {

    private static PriorityBlockingQueue<String> queue =new PriorityBlockingQueue<String>();

    public synchronized boolean posh(String url){
        return  queue.offer(url);
    }

    public synchronized String get(){
       return queue.poll();
    }

}
