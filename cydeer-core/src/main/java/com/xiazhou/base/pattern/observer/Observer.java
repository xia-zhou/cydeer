package com.xiazhou.base.pattern.observer;

/**
 * Created by zhangsong on 16/5/24.
 */
public interface Observer {
	void update(double temperature, double pressure, double humidity);
}
