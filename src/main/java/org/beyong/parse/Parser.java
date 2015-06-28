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

    public abstract List<WebURL> parse(Page page);

    @Override
    public void run() {
        Page page=pageQueue.get();
        List<WebURL> webURLList=  parse(page);
        URLQueue.push(webURLList);
    }


    protected boolean checkUrl( RuleType ruleType,String rule,String url){
        boolean bl=false;
        if(url==null){
            return false;
        }
        switch (ruleType) {
          case  CONTAINS :
                bl= url.contains(rule);break;
            case REGEX:
                bl=  url.matches(rule);break;
            case STARTWITH:
                bl=url.startsWith(rule);break;
            case ENDWITH:
                bl=url.endsWith(rule);break;
            case EQUAL:
                bl=url.equals(rule);break;
        }
        return bl;
    }

}
