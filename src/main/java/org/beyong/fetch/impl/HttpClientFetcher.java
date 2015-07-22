package org.beyong.fetch.impl;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.beyong.fetch.Fetcher;
import org.beyong.fetch.Page;
import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;
import org.beyong.url.URLCanonicalizer;
import org.beyong.url.WebURL;

import java.io.IOException;

/**
 * Created by 梁擎宇 on 15-6-23.
 */
public class HttpClientFetcher extends Fetcher {

    protected CloseableHttpClient httpClient;

    public HttpClientFetcher(URLQueue URLQueue, PageQueue pageQueue) {
        super(URLQueue, pageQueue);
    }

    @Override
    public Page fetch(WebURL webURL) {
        httpClient= HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(webURL.getURL());
        httpGet.addHeader("Accept-Encoding", "gzip");
        Page page=new Page(webURL);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                if (statusCode != HttpStatus.SC_NOT_FOUND) {
                    if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {

                        Header header = response.getFirstHeader("Location");
                        if (header != null) {
                            String movedToUrl = header.getValue();
                            movedToUrl = URLCanonicalizer.getCanonicalURL(movedToUrl, webURL.getURL());
                            webURL.setURL(movedToUrl);
                            URLQueue.push(webURL);
                            // fetchResult.setMovedToUrl(movedToUrl);
                        }
                        //fetchResult.setStatusCode(statusCode);
                        return null;
                    }
                }
            }else{
                System.out.println(statusCode);
                HttpEntity entity= response.getEntity();
                page.load(entity);
                return page;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private HttpClient getClient() {
        httpClient = HttpClientBuilder.create().build();
        return httpClient;
    }

}
