package org.beyong.config;

/**
 * Created by 梁擎宇 on 15-6-25.
 */
public class Config {

    private String userAgentString = "spider (http://code.google.com/p/crawler4j/)";

    /**
     * Maximum depth of crawling For unlimited depth this parameter should be
     * set to -1
     */
    private int maxDepthOfCrawling = -1;

    /**
     * Maximum Connections per host
     */
    private int maxConnectionsPerHost = 100;

    /**
     * Maximum total connections
     */
    private int maxTotalConnections = 100;

    /**
     * Socket timeout in milliseconds
     */
    private int socketTimeout = 20000;

    /**
     * Connection timeout in milliseconds
     */
    private int connectionTimeout = 30000;

    /**
     * Max number of outgoing links which are processed from a page
     */
    private int maxOutgoingLinksToFollow = 5000;

    /**
     * Max allowed size of a page. Pages larger than this size will not be
     * fetched.
     */
    private int maxDownloadSize = 1048576;

    /**
     * Should we follow redirects?
     */
    private boolean followRedirects = true;

    public static final int FETCHERNUM=5;

    public static final int PARSERNUM=3;

    public static final int PAGEQUEUESIZE=200;

    public static final int URLQUEUESIZE=1000;

}
