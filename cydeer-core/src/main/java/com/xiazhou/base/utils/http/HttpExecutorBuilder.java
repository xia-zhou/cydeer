package com.xiazhou.base.utils.http;

import com.xiazhou.base.utils.IUtilsBuilder;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * Created by zhangsong on 15/9/18.
 */
public class HttpExecutorBuilder implements IUtilsBuilder<HttpExecutor> {
	// http 连接池的总大小
	private int poolMaxTotal = 50;
	// 设计每个站点路由下允许的最大连接占用数（底层默认值为2）
	private int poolMaxPerRoute = 50;
	// 网络失败后，重试请求的次数，默认值3次
	private int retryTimes = 3;
	// 与目标站点创建连接的最大时间（底层默认值无限等待）
	private int connectTimeout = 10 * 1000;
	// 设置与目标站点的等待数据的最大时间，包括连续数据传输的时间（底层默认值为-1，表示操作系统默认）
	private int socketTimeout = 30 * 1000;
	// 从池中获取请求连接的时间（底层默认值无限等待）
	private int connectionRequestTimeout = 5 * 1000;


	@Override
	public String getConfName() {
		return "utils";
	}

	@Override
	public HttpExecutor build() {
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal(poolMaxTotal);
		connManager.setDefaultMaxPerRoute(poolMaxPerRoute);

		// HttpRequestRetryHandler retryHandler = new
		// HttpRequestRetryHandlerExtend(retryTimes, false, httpRetryExtend);
		HttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(retryTimes, false);

		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)
		                                           .setSocketTimeout(socketTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();

		CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(connManager)
		                                              .setRetryHandler(retryHandler).setDefaultRequestConfig(requestConfig).build();
		return new HttpExecutorImpl(client);
	}

	public void setPoolMaxTotal(int poolMaxTotal) {
		this.poolMaxTotal = poolMaxTotal;
	}

	public void setPoolMaxPerRoute(int poolMaxPerRoute) {
		this.poolMaxPerRoute = poolMaxPerRoute;
	}

	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public void setConnectionRequestTimeout(int connectionRequestTimeout) {
		this.connectionRequestTimeout = connectionRequestTimeout;
	}
}
