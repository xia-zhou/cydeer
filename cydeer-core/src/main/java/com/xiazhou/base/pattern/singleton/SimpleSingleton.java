package com.xiazhou.base.pattern.singleton;

/**
 * Created by zhangsong on 16/6/8.
 * <p>
 * 最直接但是不安全
 */
public class SimpleSingleton {
	private static SimpleSingleton instance;

	private SimpleSingleton() {
	}

	public static SimpleSingleton getInstance() {
		if (instance == null) {
			instance = new SimpleSingleton();
		}
		return instance;
	}
}
