package com.cydeer.core.utils.http;

import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cydeer on 15/9/18.
 */
public class HttpExecutorImpl implements HttpExecutor {
	private static final Logger log = LoggerFactory.getLogger(HttpExecutorImpl.class);
	private CloseableHttpClient client;

	protected HttpExecutorImpl(CloseableHttpClient client) {
		this.client = client;
	}

	/**
	 * GET 请求入口
	 *
	 * @param url
	 * @return
	 */
	public GetExecutor get(String url) {
		return new GetExecutorImpl(client, url);
	}

	/**
	 * POST 请求入口
	 *
	 * @param url
	 * @return
	 */
	public PostExecutor post(String url) {
		return new PostExecutorImpl(client, url);
	}

	public static abstract class ExecutorImpl<T> implements Executor<T> {
		protected static final String METHOD_GET = "get";
		protected static final String METHOD_POST = "post";
		protected CloseableHttpClient client;
		protected HttpRequestBase request;
		// protected CloseableHttpResponse response;
		protected List<NameValuePair> paramList = new ArrayList<NameValuePair>();
		protected Charset reqCharset = Charsets.UTF_8;
		protected Charset respCharset = Charsets.UTF_8;
		protected boolean gzip = true;

		private ExecutorImpl(CloseableHttpClient client) {
			this.client = client;
		}

		/**
		 * 添加头信息
		 *
		 * @param header {@link HttpHeaders}
		 * @return
		 */
		public T addHeader(final Header header) {
			this.request.addHeader(header);
			return extracted();
		}

		/**
		 * 添加头信息
		 *
		 * @param name  {@link HttpHeaders}
		 * @param value
		 * @return
		 */
		public T addHeader(String name, String value) {
			this.request.addHeader(name, value);
			return extracted();
		}

		/**
		 * 请求各种参数扩展
		 *
		 * @param config 参见{@link RequestConfig}
		 * @return
		 */
		public T setConfig(final RequestConfig config) {
			this.request.setConfig(config);
			return extracted();
		}

		/**
		 * @param charset 输入参数编码设置
		 * @return
		 */
		public T reqCharset(Charset charset) {
			this.reqCharset = charset;
			return extracted();
		}

		/**
		 * @param charset 响应数据编码设置
		 * @return
		 */
		public T respCharset(Charset charset) {
			this.respCharset = charset;
			return extracted();
		}

		/**
		 * 设置是否支持GZip
		 *
		 * @param gzip
		 * @return
		 */
		public T gzip(boolean gzip) {
			this.gzip = gzip;
			return extracted();
		}

		/**
		 * 添加参数
		 *
		 * @param name
		 * @param value
		 * @return
		 */
		public T addParam(String name, String value) {
			if (StringUtils.isBlank(name))
				return extracted();
			paramList.add(new BasicNameValuePair(name, value));
			return extracted();
		}

		/**
		 * @return 以字符串形式返回body结果集
		 */
		public String executeAsString() {
			return this.execute(new HttpResult<String>() {
				@Override
				public String response(HttpResponse resp) throws IOException {
					return EntityUtils.toString(resp.getEntity(), respCharset);
				}
			});
		}

		/**
		 * @return 以二进制形式返回body结果集
		 */
		public byte[] executeAsByte() {
			return this.execute(new HttpResult<byte[]>() {
				@Override
				public byte[] response(HttpResponse resp) throws IOException {
					return EntityUtils.toByteArray(resp.getEntity());
				}
			});
		}

		/**
		 * @return 以数据集{#link HttpResultData}形式返回结果集，返回对象永远不会为空，可通过 ioe
		 * 属性获取失败的 IOException 异常信息
		 */
		public HttpResultData executeAsData() {
			CloseableHttpResponse response = null;
			HttpResultData result = HttpResultData.build();
			try {
				response = realExecute();
				result.setStatusCode(response.getStatusLine().getStatusCode())
				      .setHeaders(response.getHeaders(HttpHeaders.CONTENT_TYPE))
				      .setBody(EntityUtils.toString(response.getEntity(), respCharset));
			} catch (IOException e) {
				log.error("", e);
				result.setIoe(e);
			} finally {
				try {
					if (response != null)
						response.close();
				} catch (IOException e) {
					log.error("", e);
				}
			}
			return result;
		}

		/**
		 * 针对高级用户使用
		 *
		 * @return 自定义形式返回body结果集
		 */
		public <E> E execute(HttpResult<E> result) {
			CloseableHttpResponse response = null;
			try {
				response = realExecute();
				return result.response(response);
			} catch (IOException e) {
				log.error("", e);
				return null;
			} finally {
				if (response != null) {
					try {
						response.close();
					} catch (IOException e) {
						log.error("", e);
					}
				}
			}
		}

		/**
		 * 正式执行请求
		 *
		 * @return
		 */
		private CloseableHttpResponse realExecute() throws IOException {
			if (paramList.size() > 0) {// 处理参数
				StringBuffer sb = new StringBuffer(this.request.getURI().toString());
				sb.append(StringUtils.isBlank(this.request.getURI().getRawQuery()) ? "?" : "&").append(
						URLEncodedUtils.format(paramList, reqCharset));
				this.request.setURI(URI.create(sb.toString()));
			}
			if (this.gzip) {// 压缩处理
				this.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
			}
			if (this instanceof PostExecutorImpl) {//如果是POST请求
				PostExecutorImpl self = (PostExecutorImpl) this;
				if (self.postParamList != null && self.postParamList.size() > 0) {//添加表单参数
					if (((HttpPost) self.request).getEntity() != null) {
						throw new IllegalArgumentException("POST请求中的 addFormParam 和 setEntity 不能同时被设置值");
					}
					self.setEntity(new UrlEncodedFormEntity(self.postParamList, Consts.UTF_8));
				}
			}
			if (log.isDebugEnabled()) {// Log日志
				log.debug("HTTP request: {}", this.request.getURI().toString());
				if (StringUtils.equals(this.getMethod(), ExecutorImpl.METHOD_POST)) {
					HttpPost req = (HttpPost) this.request;
					if (req.getEntity() != null && !req.containsHeader("wechat_file")) {
						try {
							log.debug("Request post data is: {}", EntityUtils.toString(req.getEntity()));
						} catch (IOException e) {
							log.error("", e);
						}
					}
				}
			}
			CloseableHttpResponse response = client.execute(request);
			if (this.gzip) {// 解压缩处理
				Header header = response.getEntity().getContentEncoding();
				if (header != null) {
					HeaderElement[] codecs = header.getElements();
					for (int i = 0; i < codecs.length; i++) {
						if (codecs[i].getName().equalsIgnoreCase("gzip")) {
							response.setEntity(new GzipDecompressingEntity(response.getEntity()));
							break;
						}
					}
				}
			}
			return response;
		}

		protected abstract T extracted();

		protected abstract String getMethod();
	}

	public static class GetExecutorImpl extends ExecutorImpl<GetExecutor> implements GetExecutor {

		private GetExecutorImpl(CloseableHttpClient client, String url) {
			super(client);
			this.request = new HttpGet(url);
		}

		protected GetExecutor extracted() {
			return this;
		}

		@Override
		protected String getMethod() {
			return ExecutorImpl.METHOD_GET;
		}

	}

	public static class PostExecutorImpl extends ExecutorImpl<PostExecutor> implements PostExecutor {
		protected List<NameValuePair> postParamList;

		private PostExecutorImpl(CloseableHttpClient client, String url) {
			super(client);
			this.request = new HttpPost(url);
		}

		@Override
		public PostExecutor addFormParam(String name, String value) {
			if (StringUtils.isBlank(name))
				return this;
			if (postParamList == null) {
				synchronized (PostExecutorImpl.class) {
					if (postParamList == null) {
						postParamList = new ArrayList<NameValuePair>();
					}
				}
			}
			postParamList.add(new BasicNameValuePair(name, value));
			return this;
		}

		public PostExecutor setEntity(final HttpEntity entity) {
			((HttpPost) this.request).setEntity(entity);
			return this;
		}

		protected PostExecutor extracted() {
			return this;
		}

		@Override
		protected String getMethod() {
			return ExecutorImpl.METHOD_POST;
		}
	}
}
