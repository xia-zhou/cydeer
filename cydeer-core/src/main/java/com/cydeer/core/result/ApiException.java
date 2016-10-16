/**
 * Copyright (C), 2014-2015, 
 * FileName: AjaxException.java
 * @author Cydeer
 * Date:     2015年6月12日 下午8:44:49
 * Description: 
 */
package com.cydeer.core.result;

/**
 * @author Cydeer
 */
public class ApiException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;

	public ApiException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public ApiException(ErrorMessage errorMessage) {
		this.code = errorMessage.getCode();
		this.message = errorMessage.getMessage();
	}
	
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
