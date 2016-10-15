package com.xiazhou.base.utils.common;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangsong on 15/11/16.
 */
public class IpUtils {
	/**
	 * 获取客服端IP
	 *
	 * @param request
	 * @return IP地址
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf(',') > 0) { // 多个IP
			String[] ips = ip.split(",");
			return ips[0].trim(); // 返回第一个
		}
		return ip;
	}
}
