package org.beyong.parse;

import org.beyong.org.beyong.task.TaskQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public class Parser implements Runnable {


    private TaskQueue queue;

    public Parser(TaskQueue queue){
        this.queue=queue;
    }

    public void parse(String url){
        System.out.println("parse:"+url);
    }

    @Override
    public void run() {

    }
}
