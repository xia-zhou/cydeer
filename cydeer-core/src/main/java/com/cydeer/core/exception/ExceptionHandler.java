package com.cydeer.core.exception;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Cydeer on 15/7/5.
 */
public interface ExceptionHandler {
    ModelAndView getModelAndView(Exception var1, HttpServletRequest var2, HandlerMethod var3);
}
