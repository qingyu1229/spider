package org.beyong.task;

import org.beyong.config.Config;
import org.beyong.url.WebURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public class URLQueue {
    private static final Logger logger = LoggerFactory.getLogger(URLQueue.class);
    private static PriorityBlockingQueue<WebURL> queue = new PriorityBlockingQueue<WebURL>(Config.URLQUEUESIZE);

    public boolean push(WebURL url) {
        logger.info("URLQueue Pushing url:"+url.getURL());
        queue.put(url);
        return true;
    }

    public boolean push(List<WebURL> webURLList) {
        for (WebURL webURL : webURLList) {
            push(webURL);
        }
        return true;
    }

    public WebURL get() {
        try {
            WebURL webURL=queue.take();
            logger.info("URLQueue get url:"+webURL.getURL());
            return webURL;
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
