package org.beyong.fetch;

import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;
import org.beyong.url.WebURL;

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

    public abstract Page fetch(WebURL url);

    @Override
    public void run() {
        WebURL webURL= URLQueue.get();
        Page page=  fetch(webURL);
       // System.out.println(page.getWebURL().getURL());
        if(page!=null){
            //System.out.println("-");
            pageQueue.push(page);
        }
    }
}
