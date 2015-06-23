
package org.beyong.fetch;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.EOFException;
import java.io.IOException;

public class PageFetchResult {

	protected static final Logger logger = Logger.getLogger(PageFetchResult.class);

	protected int statusCode;
	protected HttpEntity entity = null;
	protected String fetchedUrl = null;
	protected String movedToUrl = null;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public HttpEntity getEntity() {
		return entity;
	}

	public void setEntity(HttpEntity entity) {
		this.entity = entity;
	}

	public String getFetchedUrl() {
		return fetchedUrl;
	}

	public void setFetchedUrl(String fetchedUrl) {
		this.fetchedUrl = fetchedUrl;
	}

	public boolean fetchContent(Page page) {
		try {
			page.load(entity);
			return true;
		} catch (Exception e) {
			logger.info("Exception while fetching content for: " + page.getWebURL().getURL() + " [" + e.getMessage()
					+ "]");
		}
		return false;
	}

	public void discardContentIfNotConsumed() {
		try {
			if (entity != null) {
				EntityUtils.consume(entity);
			}
		} catch (EOFException e) {
			// We can ignore this exception. It can happen on compressed streams
			// which are not
			// repeatable
		} catch (IOException e) {
			// We can ignore this exception. It can happen if the stream is
			// closed.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMovedToUrl() {
		return movedToUrl;
	}

	public void setMovedToUrl(String movedToUrl) {
		this.movedToUrl = movedToUrl;
	}

}
