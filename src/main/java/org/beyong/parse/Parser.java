package org.beyong.parse;

import org.apache.commons.lang3.StringUtils;
import org.beyong.fetch.Page;
import org.beyong.parse.rule.RuleType;
import org.beyong.parse.rule.SupportUrlRule;
import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;
import org.beyong.url.WebURL;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

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

    protected List<WebURL> digUrls(SupportUrlRule supportUrlRule,Document document,Page page){
        List<WebURL> urlList=new ArrayList<WebURL>();
        Elements aElements= document.getElementsByTag("a");
        for(Element element:aElements){
            String href=element.attr("href");
            //element.baseUri();

            if(href==null||"#".equals(href)||href.startsWith("#")||href.startsWith("javascript:")){
                continue;
            }else{

                WebURL url=new WebURL();

                url.setDepth((short)(page.getWebURL().getDepth()+1));
                url.setParentUrl(page.getWebURL().getURL());
                //url.setPriority();
                url.setURL(href);


                //urlList.
            }
        }


       /* switch (supportUrlRule.getRuleType()) {
            RuleType.CONTAINS:

        }*/


        return urlList;
    }



}
