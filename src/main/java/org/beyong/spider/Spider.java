package org.beyong.spider;

import org.beyong.config.Config;
import org.beyong.fetch.Fetcher;
import org.beyong.fetch.Page;
import org.beyong.fetch.impl.HttpClientFetcher;
import org.beyong.parse.Parser;
import org.beyong.parse.impl.JsoupParser;
import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;
import org.beyong.url.WebURL;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 梁擎宇 on 15-6-25.
 */
public class Spider {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool( Config.FETCHERNUM+ Config.PARSERNUM);

        PageQueue pageQueue=new PageQueue();
        URLQueue urlQueue=new URLQueue();
        for (int size=0;size< Config.FETCHERNUM;size++){
            Fetcher fetcher=new HttpClientFetcher(urlQueue,pageQueue);
            pool.execute(fetcher);
        }
        for (int size=0;size< Config.PARSERNUM;size++){
            Parser parser=new JsoupParser(urlQueue,pageQueue);
            pool.execute(parser);
        }
        pool.shutdown();
    }



}
