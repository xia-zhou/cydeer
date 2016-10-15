package com.xiazhou.base.pattern.singleton;

/**
 * Created by zhangsong on 16/6/8.
 * <p>
 * 最简单,但是 可能会耗费性能,不需要的时候其实不用创建
 */
public class LineSingleton {
	private final static LineSingleton instance = new LineSingleton();

	private LineSingleton() {

	}

	public static LineSingleton getInstance() {
		return instance;
	}
}
