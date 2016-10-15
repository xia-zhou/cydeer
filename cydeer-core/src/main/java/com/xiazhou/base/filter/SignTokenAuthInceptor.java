package com.xiazhou.base.filter;

import com.xiazhou.base.result.AjaxException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangsong on 15/7/5.
 */
public class SignTokenAuthInceptor extends HandlerInterceptorAdapter implements InitializingBean {


    private static final String HEADER_CUSTOMER_ID = "customerId";
    private static final String HEADER_CUSTOMER_TOKEN = "token";
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {// 可能处理的是静态资源。无需登录检测
            return true;
        }
        // 获取是否需要签名及Token验证的标注信息
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        SignTokenAuth signTokenAuth = handlerMethod.getMethodAnnotation(SignTokenAuth.class);// 从方法中获取
        if (signTokenAuth == null) {// 从类定义中获取
            signTokenAuth = handlerMethod.getBeanType().getAnnotation(SignTokenAuth.class);
        }
        boolean shouldToken = true;// 是否需要Token验证
        if (signTokenAuth != null) {
            shouldToken = signTokenAuth.token();
        }
        if (shouldToken) {
            Long customerId = NumberUtils.toLong(request.getHeader(HEADER_CUSTOMER_ID), 0);
            String headerToken = request.getHeader(HEADER_CUSTOMER_TOKEN);
            if (customerId == 0 || StringUtils.isBlank(headerToken)) {// 请求头中必须包含customerId信息
                throw new AjaxException("","token或者用户ID为空");
            }
            String token = "";
            if (!StringUtils.equals(headerToken, token)) {// 请求头中必须包含customerId信息
                throw new AjaxException("","token验证失败");
            }
            return true;
        }
        return true;
    }
}
