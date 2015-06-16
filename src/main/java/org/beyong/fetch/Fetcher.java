package org.beyong.fetch;

import org.beyong.org.beyong.task.TaskQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public class Fetcher implements Runnable {

    private TaskQueue queue;

    public Fetcher(TaskQueue queue){
        this.queue=queue;
    }
    public void fetch(String url) {
        System.out.println("fetch:" + url);
    }

    @Override
    public void run() {

    }

}
