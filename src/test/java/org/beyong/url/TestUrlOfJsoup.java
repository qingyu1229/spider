package org.beyong.url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by 梁擎宇 on 15-6-26.
 */
public class TestUrlOfJsoup {
    @Test
    public void test_url(){
        String url="http://my.oschina.net/xxiaobian/blog/471417";
        try {
            Document document= Jsoup.connect(url).get();
            Elements elements= document.getElementsByTag("a");
            String baseUri=document.baseUri();
            System.out.println("baseUri"+baseUri);
            for(Element element:elements){
                String href= element.absUrl("href");
                System.out.println(href);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
