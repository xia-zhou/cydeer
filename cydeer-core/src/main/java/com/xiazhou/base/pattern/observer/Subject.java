package com.xiazhou.base.pattern.observer;

/**
 * Created by zhangsong on 16/5/24.
 */
public interface Subject {

	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObserver();
}
