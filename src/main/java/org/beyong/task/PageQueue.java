package org.beyong.task;

import org.beyong.config.Config;
import org.beyong.fetch.Page;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-23.
 */
public class PageQueue {

    private static PriorityBlockingQueue<Page> queue =new PriorityBlockingQueue<Page>(Config.PAGEQUEUESIZE);

    public  boolean push(Page page){
        System.out.println("-");
        queue.put(page);
        return true;
    }

    public  Page get(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
