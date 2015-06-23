package org.beyong.fetch;

import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public abstract class Fetcher implements Runnable {

    protected URLQueue URLQueue;
    protected PageQueue pageQueue;

    public Fetcher(URLQueue URLQueue,PageQueue pageQueue){
        this.URLQueue=URLQueue;
        this.pageQueue=pageQueue;
    }

    public abstract void fetch(String url);

    @Override
    public void run() {

    }

}
