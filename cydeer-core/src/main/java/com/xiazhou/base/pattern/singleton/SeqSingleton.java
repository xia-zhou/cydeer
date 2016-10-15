package com.xiazhou.base.pattern.singleton;

/**
 * Created by zhangsong on 16/6/8.
 * <p> 双锁校验,安全,使用才会创建
 * 安全模式
 */
public class SeqSingleton {

	private volatile static SeqSingleton instance;

	private SeqSingleton() {

	}

	public static SeqSingleton getInstance() {
		if (instance == null) {
			synchronized (SeqSingleton.class) {
				if (instance == null) {
					instance = new SeqSingleton();
				}
			}
		}
		return instance;
	}
}
