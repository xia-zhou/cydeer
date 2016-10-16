package com.cydeer.core.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @author Cydeer on 16/6/10.
 */
public class MainTest {
	public static void main(String[] args) {
		Person person = new PersonImpl(12, "qingka");
		Person own = (Person) Proxy
				.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(),
						new OwnInvocationHandler(person));
		Person other = (Person) Proxy
				.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(),
						new OtherInvocationHandler(person));
		own.setName("zhangsong");
		own.setSlary(180);
		System.out.println(own);
		other.setName("hubei");
		other.setSlary(1000);
		System.out.println(other);
	}
}
