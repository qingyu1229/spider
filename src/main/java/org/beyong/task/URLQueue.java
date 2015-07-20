package org.beyong.task;

import org.beyong.config.Config;
import org.beyong.url.WebURL;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public class URLQueue {

    private static PriorityBlockingQueue<WebURL> queue =new PriorityBlockingQueue<WebURL>(Config.URLQUEUESIZE);

    public  boolean push(WebURL url){
        queue.put(url);
        return true;
    }

    public  boolean push(List<WebURL> webURLList){
        for (WebURL webURL:webURLList){
            push(webURL);
        }
        return true;
    }

    public  WebURL get(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
