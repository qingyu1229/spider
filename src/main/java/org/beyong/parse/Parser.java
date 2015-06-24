package org.beyong.parse;

import org.apache.commons.lang3.StringUtils;
import org.beyong.fetch.Page;
import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;

/**
 * Created by 梁擎宇 on 15-6-16.
 */
public abstract class Parser implements Runnable {

    protected URLQueue URLQueue;
    protected PageQueue pageQueue;

    public Parser(URLQueue URLQueue,PageQueue pageQueue){
        this.URLQueue=URLQueue;
        this.pageQueue=pageQueue;
    }

    public abstract void parse(Page page);



    @Override
    public void run() {

    }

    protected String convertBytesToString(byte[] contentData){


        return null;
    }


}
