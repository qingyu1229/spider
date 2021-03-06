package org.beyong.parse.impl;

import org.beyong.fetch.Page;
import org.beyong.parse.Parser;
import org.beyong.parse.rule.DataRule;
import org.beyong.parse.rule.RuleLocator;
import org.beyong.parse.rule.SupportUrlRule;
import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;
import org.beyong.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 梁擎宇 on 15-6-24.
 */
public class JsoupParser extends Parser {
    private  final Logger logger = LoggerFactory.getLogger(JsoupParser.class);
    public JsoupParser(URLQueue URLQueue, PageQueue pageQueue) {
        super(URLQueue, pageQueue);
    }

    @Override
    public List<WebURL> parse(Page page) {
        logger.info("Parsing page:"+page.getWebURL().getURL());
        try {
            String content=new String(page.getContentData(),page.getContentCharset());
            Document doc= Jsoup.parse(content,page.getWebURL().getURL());

            boolean isSupportPage=page.isSupportPage();

            if(isSupportPage){
                SupportUrlRule supportUrlRule= RuleLocator.getSupportUrlRule(page.getWebURL().getAbsDomain(),page.getWebURL().getDepth());
                //supportUrlRule.
                //System.out.println("SupportUrl :"+page.getWebURL().getURL());
               return digUrls(supportUrlRule,doc,page);
            }else{
                String domain=page.getWebURL().getAbsDomain();
                Map<String,DataRule> dataRuleMap= RuleLocator.getDataRule(domain);
                Set<String> keys= dataRuleMap.keySet();
                for(String key:keys){
                    DataRule rule=dataRuleMap.get(key);
                    String name= rule.getName();
                    String ruleStr=rule.getCssPath();
                    String dataStr= doc.select(ruleStr).toString();
                    System.out.println(name+":\n"+dataStr);
                }

            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected List<WebURL> digUrls(SupportUrlRule supportUrlRule,Document document,Page page){
        List<WebURL> urlList=new ArrayList<WebURL>();
        Elements aElements= document.getElementsByTag("a");
        for(Element element:aElements){
            if(!isLegalATag(element)){
                continue;
            }

            String href=element.absUrl("href");
            if(href!=null&&href.startsWith("http://")&&checkUrl(supportUrlRule.getRuleType(),supportUrlRule.getRule(),href)){
                WebURL url=new WebURL();
                url.setDepth((short)(page.getWebURL().getDepth()+1));
                url.setParentUrl(page.getWebURL().getURL());
                //url.setPriority();
                url.setURL(href);
                logger.info(href);
                urlList.add(url);
            }
        }
        return urlList;
    }
}
