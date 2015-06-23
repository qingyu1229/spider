package org.beyong.fetch.impl;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.beyong.fetch.Fetcher;
import org.beyong.fetch.PageFetchResult;
import org.beyong.task.PageQueue;
import org.beyong.task.URLQueue;
import org.beyong.url.URLCanonicalizer;

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
    public void fetch(String url) {
        HttpGet httpGet = new HttpGet(url);
        PageFetchResult fetchResult = new PageFetchResult();
        httpGet.addHeader("Accept-Encoding", "gzip");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                if (statusCode != HttpStatus.SC_NOT_FOUND) {
                    if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
                        Header header = response.getFirstHeader("Location");
                        if (header != null) {
                            String movedToUrl = header.getValue();
                            movedToUrl = URLCanonicalizer.getCanonicalURL(movedToUrl, url);
                            URLQueue.posh(movedToUrl);
                            // fetchResult.setMovedToUrl(movedToUrl);
                        }
                        //fetchResult.setStatusCode(statusCode);
                        return;
                    }
                }else{
                    HttpEntity entity= response.getEntity();
                    fetchResult.setEntity(entity);
                    //String content= entity.toString();


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private HttpClient getClient() {
        httpClient = HttpClientBuilder.create().build();
        return httpClient;
    }

}
