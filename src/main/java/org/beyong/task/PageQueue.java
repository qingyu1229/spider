package org.beyong.task;

import org.beyong.fetch.Page;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-23.
 */
public class PageQueue {

    private static PriorityBlockingQueue<Page> queue =new PriorityBlockingQueue<Page>();

    public synchronized boolean push(Page page){
        return  queue.offer(page);
    }

    public synchronized Page get(){
        return queue.poll();
    }
}
