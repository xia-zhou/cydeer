package com.cydeer.core.utils.http;

import org.apache.http.HttpResponse;

import java.io.IOException;

/**
 * @author Cydeer on 15/9/18.
 */
public interface HttpResult<T> {
	T response(HttpResponse var1) throws IOException;
}
