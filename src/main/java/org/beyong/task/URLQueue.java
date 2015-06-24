package org.beyong.task;

import org.beyong.url.WebURL;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public class URLQueue {

    private static PriorityBlockingQueue<WebURL> queue =new PriorityBlockingQueue<WebURL>();

    public synchronized boolean push(WebURL url){
        return  queue.offer(url);
    }

    public synchronized WebURL get(){
       return queue.poll();
    }

}
