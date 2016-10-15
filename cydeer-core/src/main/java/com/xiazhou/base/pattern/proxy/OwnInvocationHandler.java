package com.xiazhou.base.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhangsong on 16/6/10.
 */
public class OwnInvocationHandler implements InvocationHandler {

	private Person person;

	public OwnInvocationHandler(Person person) {
		this.person = person;
	}

	@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("setSlary")) {
			System.out.println("不能设置自己的工资");
			return null;
		} else {
			return method.invoke(person, args);
		}
	}
}
