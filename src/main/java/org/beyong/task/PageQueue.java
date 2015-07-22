package org.beyong.task;

import org.beyong.config.Config;
import org.beyong.fetch.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by 梁擎宇 on 15-6-23.
 */
public class PageQueue {
    private static final Logger logger = LoggerFactory.getLogger(PageQueue.class);
    private static PriorityBlockingQueue<Page> queue =new PriorityBlockingQueue<Page>(Config.PAGEQUEUESIZE);

    public  boolean push(Page page){
        logger.info("PageQueue Pushing page,page's url:" + page.getWebURL().getURL());
        queue.put(page);
        return true;
    }

    public  Page get(){
        try {
            Page page=queue.take();
            logger.info("PageQueue get page,page's url:" + page.getWebURL().getURL());
            return page;
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
