package org.beyong.spider;

import org.beyong.config.Config;
import org.beyong.fetch.Fetcher;
import org.beyong.fetch.Page;
import org.beyong.fetch.impl.HttpClientFetcher;
import org.beyong.parse.Parser;
import org.beyong.parse.impl.JsoupParser;
import org.beyong.parse.rule.DataRule;
import org.beyong.parse.rule.RuleLocator;
import org.beyong.parse.rule.RuleType;
import org.beyong.parse.rule.SupportUrlRule;
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

    static   PageQueue pageQueue=new PageQueue();
   static URLQueue urlQueue=new URLQueue();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool( Config.FETCHERNUM + Config.PARSERNUM);

        init();

        for (int size=0;size< Config.FETCHERNUM;size++){
            Fetcher fetcher=new HttpClientFetcher(urlQueue,pageQueue);
            pool.execute(fetcher);
        }
        for (int size=0;size< Config.PARSERNUM;size++){
            Parser parser=new JsoupParser(urlQueue,pageQueue);
            pool.execute(parser);
        }
        //pool.shutdown();
    }

    public static void init(){
        WebURL url=new WebURL();
        url.setDepth((short)1);
        url.setURL("http://news.ncnews.com.cn/ncxw/jrnc/");

        urlQueue.push(url);

        DataRule titleRule=new DataRule("title","div.read>h3",null);
        DataRule contentRule=new DataRule("content","div#newsread",null);

        SupportUrlRule supportUrlRule=new SupportUrlRule();
        supportUrlRule.setDepth(1);
        supportUrlRule.setRuleType(RuleType.STARTWITH);
        supportUrlRule.setRule("http://news.ncnews.com.cn/ncxw/jrnc/\\d{4}-\\d{2}/\\d{1,2}/content_\\d{1,9}.htm");

        RuleLocator.addDataRule("news.ncnews.com.cn",titleRule);
        RuleLocator.addDataRule("news.ncnews.com.cn",contentRule);

        RuleLocator.addSupportUrlRule(supportUrlRule,"news.ncnews.com.cn");

    }


}
