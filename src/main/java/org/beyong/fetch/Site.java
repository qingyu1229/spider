package org.beyong.fetch;

import org.beyong.parse.rule.DataRule;
import org.beyong.parse.rule.SupportUrlRule;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 梁擎宇 on 15-6-25.
 */
public class Site {

    /**
     * 规则说明：
     *
     * Site规则：
     * 属性1：includeBinaryContentInCrawling,是否下载目标区域中的多媒体文件，例如图片视频等
     * 属性2：maxDepath,最大抓取深度
     * 属性3：interval,重新调度的时间间隔
     * 属性4：enable,是否开启本站的抓取
     * 属性5：seedUrl,种子链接
     * 属性6：thread,本站的并发量
     * 属性7：contentEncoding，本站的网页内容字符编码
     * 属性8：sitePriority,站点优先级
     * 属性9：siteName,站点名称
     * 属性10：politenessDelay,两次请求的最小时间间隔
     * 属性11：socketTimeout，socket超时时间
     * 属性12：connectionTimeout，connection超时时间
     * 属性13：maxDownloadSize，允许的最大页面或文件大小
     * 属性14：followRedirects，是否处理重定向
     * 属性15：proxyHost，代理Host
     * 属性16：proxyPort，代理Port
     * 属性17：proxyUsername，代理账号
     * 属性18：proxyPassword，代理账号的密码
     * */



    /**
     * 是否开启本站点的抓取
     */
    private boolean enable;

    /**
     * 网站页面编码
     */
    private String contentEncoding;


    /**
     * 网站的优先级
     */
    private byte sitePriority;

    /**
     * 连续两次请求的最小时间间隔（单位：毫秒），默认不设置限制（-1）
     */
    private int politenessDelay = -1;


    /**
     * 代理Host
     */
    private String proxyHost = null;

    /**
     * 代理Port
     */
    private int proxyPort = 80;

    /**
     * 代理userName
     */
    private String proxyUsername = null;

    /**
     * 代理pwd
     */
    private String proxyPassword = null;



    /**
     * 是否处理页面中的多媒体文件，例如图片视频等
     */
    private boolean downloadBinaryContent;

    /**
     * 同一个网站重新调度时间间隔（单位：秒），默认为一个小时
     */
    private int scheduleInterval=1*60*60;


    /**
     * 最大抓取深度，默认不设置限制（-1）
     */
    private int maxDepthOfCrawling = -1;

    /**
     * 同一时刻的最大连接数
     */
    private int maxTotalConnections = 100;

    /**
     * Socket timeout
     */
    private int socketTimeout = 20000;

    /**
     * Connection timeout
     */
    private int connectionTimeout = 30000;

    /**
     * 每个页面中最多允许提取的URL数，默认为500
     */
    private int maxOutgoingLinksPerPage = 500;

    /**
     * 每个页面中最大允许下载大小
     */
    private int maxDownloadSize = 1048576;

    /**
     * 是否处理重定向
     */
    private boolean followRedirects = true;

    /**
     * 非目标URL发掘规则
     */
    private HashMap<Integer,SupportUrlRule> supportUrlRules;

    /**
     * 数据抽取规则
     */
    private ArrayList<DataRule> dataRules;

    public HashMap<Integer, SupportUrlRule> getSupportUrlRules() {
        return supportUrlRules;
    }

    public void setSupportUrlRules(HashMap<Integer, SupportUrlRule> supportUrlRules) {
        this.supportUrlRules = supportUrlRules;
    }

    public ArrayList<DataRule> getDataRules() {
        return dataRules;
    }

    public void setDataRules(ArrayList<DataRule> dataRules) {
        this.dataRules = dataRules;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public byte getSitePriority() {
        return sitePriority;
    }

    public void setSitePriority(byte sitePriority) {
        this.sitePriority = sitePriority;
    }

    public int getPolitenessDelay() {
        return politenessDelay;
    }

    public void setPolitenessDelay(int politenessDelay) {
        this.politenessDelay = politenessDelay;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public boolean isDownloadBinaryContent() {
        return downloadBinaryContent;
    }

    public void setDownloadBinaryContent(boolean downloadBinaryContent) {
        this.downloadBinaryContent = downloadBinaryContent;
    }

    public int getScheduleInterval() {
        return scheduleInterval;
    }

    public void setScheduleInterval(int scheduleInterval) {
        this.scheduleInterval = scheduleInterval;
    }

    public int getMaxDepthOfCrawling() {
        return maxDepthOfCrawling;
    }

    public void setMaxDepthOfCrawling(int maxDepthOfCrawling) {
        this.maxDepthOfCrawling = maxDepthOfCrawling;
    }

    public int getMaxTotalConnections() {
        return maxTotalConnections;
    }

    public void setMaxTotalConnections(int maxTotalConnections) {
        this.maxTotalConnections = maxTotalConnections;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getMaxOutgoingLinksPerPage() {
        return maxOutgoingLinksPerPage;
    }

    public void setMaxOutgoingLinksPerPage(int maxOutgoingLinksPerPage) {
        this.maxOutgoingLinksPerPage = maxOutgoingLinksPerPage;
    }

    public int getMaxDownloadSize() {
        return maxDownloadSize;
    }

    public void setMaxDownloadSize(int maxDownloadSize) {
        this.maxDownloadSize = maxDownloadSize;
    }

    public boolean isFollowRedirects() {
        return followRedirects;
    }

    public void setFollowRedirects(boolean followRedirects) {
        this.followRedirects = followRedirects;
    }
}
