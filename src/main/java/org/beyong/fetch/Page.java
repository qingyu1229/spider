package org.beyong.fetch;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.beyong.url.WebURL;

public class Page  implements Comparable{

    /**
     * The URL of this page.
     */
    private WebURL webURL;

    /**
     * The content of this page in binary format.
     */
    private byte[] contentData;

    /**
     * The ContentType of this page.
     * For example: "text/html; charset=UTF-8"
     */
    private String contentType;

    /**
     * The encoding of the content.
     * For example: "gzip"
     */
    private String contentEncoding;

    /**
     * The charset of the content.
     * For example: "UTF-8"
     */
    private String contentCharset;

    /**
     * 是否是非目标页面
     */
    private boolean supportPage;

    public boolean isSupportPage() {
        return supportPage;
    }

    public void setSupportPage(boolean supportPage) {
        this.supportPage = supportPage;
    }

    public Page(WebURL webURL) {
        this.webURL = webURL;
    }

    public WebURL getWebURL() {
        return webURL;
    }

    public void setWebURL(WebURL webURL) {
        this.webURL = webURL;
    }

    /**
     * Loads the content of this page from a fetched
     * HttpEntity.
     */
    public void load(HttpEntity entity) throws Exception {
        contentType = null;
        Header type = entity.getContentType();
        if (type != null) {
            contentType = type.getValue();
        }

        contentEncoding = null;
        Header encoding = entity.getContentEncoding();
        if (encoding != null) {
            contentEncoding = encoding.getValue();
        }

        contentCharset = EntityUtils.getContentCharSet(entity);
        contentData = EntityUtils.toByteArray(entity);
    }




    /**
     * Returns the content of this page in binary format.
     */
    public byte[] getContentData() {
        return contentData;
    }

    public void setContentData(byte[] contentData) {
        this.contentData = contentData;
    }

    /**
     * Returns the ContentType of this page.
     * For example: "text/html; charset=UTF-8"
     */
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Returns the encoding of the content.
     * For example: "gzip"
     */
    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    /**
     * Returns the charset of the content.
     * For example: "UTF-8"
     */
    public String getContentCharset() {
        return contentCharset;
    }

    public void setContentCharset(String contentCharset) {
        this.contentCharset = contentCharset;
    }

    @Override
    public int compareTo(Object o) {



        return 0;
    }
}
