package com.xiazhou.base.utils.http;

import org.apache.http.Header;

import java.io.IOException;

/**
 * Created by zhangsong on 15/9/18.
 */
public class HttpResultData {
	private int statusCode;
	private String body;
	private Header[] headers;
	private IOException ioe;

	public HttpResultData() {
	}

	static HttpResultData build() {
		return new HttpResultData();
	}

	public boolean hasError() {
		return this.ioe != null;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public HttpResultData setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public String getBody() {
		return this.body;
	}

	public HttpResultData setBody(String body) {
		this.body = body;
		return this;
	}

	public Header[] getHeaders() {
		return this.headers;
	}

	public HttpResultData setHeaders(Header[] headers) {
		this.headers = headers;
		return this;
	}

	public IOException getIoe() {
		return this.ioe;
	}

	public HttpResultData setIoe(IOException ioe) {
		this.ioe = ioe;
		return this;
	}
}

