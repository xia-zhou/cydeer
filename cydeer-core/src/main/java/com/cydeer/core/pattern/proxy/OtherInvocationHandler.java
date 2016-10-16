package com.cydeer.core.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Cydeer on 16/6/10.
 */
public class OtherInvocationHandler implements InvocationHandler {
	private Person person;

	public OtherInvocationHandler(Person person) {
		this.person = person;
	}

	@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("setName")) {
			System.out.println("不能设置别人的名字");
			return null;
		}
		return method.invoke(person, args);
	}
}
