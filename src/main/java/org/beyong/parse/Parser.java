package org.beyong.parse;

import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public abstract class Parser implements Runnable {

    private URLQueue URLQueue;
    private PageQueue pageQueue;

    public Parser(URLQueue URLQueue,PageQueue pageQueue){
        this.URLQueue=URLQueue;
        this.pageQueue=pageQueue;
    }

    public void parse(String url){
        System.out.println("parse:"+url);
    }

    @Override
    public void run() {

    }
}
