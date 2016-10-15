package com.xiazhou.base.pattern.singleton;

/**
 * Created by zhangsong on 16/6/8.
 */
public class FactorySingleton {

	private FactorySingleton() {
	}

	private static class SingletonFactory {
		private final static FactorySingleton instance = new FactorySingleton();

	}

	public static FactorySingleton getInstance() {
		return SingletonFactory.instance;
	}
}
