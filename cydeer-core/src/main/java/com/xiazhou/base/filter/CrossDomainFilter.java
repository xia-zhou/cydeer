/*
 * Copyright (C), 2014-2015, 
 * FileName: CrossDomainFilter.java
 * Author:   xia zhou
 * Date:     2015年6月20日 下午7:09:08
 * Description: 
 */
package com.xiazhou.base.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 * 〈一句话是什么〉
 * 〈详细描述做什么〉
 *
 * @author xia zhou
 */
public class CrossDomainFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods",
				"GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers",
				"origin, content-type, accept, x-requested-with");
		response.addHeader("Access-Control-Max-Age", "1800");// 30 min
		filterChain.doFilter(request, response);
	}
	public boolean shouldNotFilterAsyncDispatch() {
		return false;
	}
}