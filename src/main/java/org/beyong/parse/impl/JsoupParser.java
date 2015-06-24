package org.beyong.parse.impl;

import org.beyong.fetch.Page;
import org.beyong.parse.Parser;
import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;

/**
 * Created by 梁擎宇 on 15-6-24.
 */
public class JsoupParser extends Parser {


    public JsoupParser(URLQueue URLQueue, PageQueue pageQueue) {
        super(URLQueue, pageQueue);
    }

    @Override
    public void parse(Page page) {

        try {
            String content=new String(page.getContentData(),page.getContentCharset());

            Document doc= Jsoup.parse(content,page.getWebURL().getURL());





        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
