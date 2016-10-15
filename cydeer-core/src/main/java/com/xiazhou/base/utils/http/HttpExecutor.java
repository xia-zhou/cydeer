package com.xiazhou.base.utils.http;

import com.xiazhou.base.utils.IUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;

import java.nio.charset.Charset;

/**
 * Created by zhangsong on 15/9/18.
 */
public interface HttpExecutor extends IUtils {
	HttpExecutor.GetExecutor get(String var1);

	HttpExecutor.PostExecutor post(String var1);

	public interface PostExecutor extends HttpExecutor.Executor<HttpExecutor.PostExecutor> {
		HttpExecutor.PostExecutor addFormParam(String var1, String var2);

		HttpExecutor.PostExecutor setEntity(HttpEntity var1);
	}

	public interface GetExecutor extends HttpExecutor.Executor<HttpExecutor.GetExecutor> {
	}

	public interface Executor<T> {
		T addHeader(Header var1);

		T addHeader(String var1, String var2);

		T setConfig(RequestConfig var1);

		T reqCharset(Charset var1);

		T respCharset(Charset var1);

		T gzip(boolean var1);

		T addParam(String var1, String var2);

		String executeAsString();

		byte[] executeAsByte();

		HttpResultData executeAsData();

		<E> E execute(HttpResult<E> var1);
	}
}