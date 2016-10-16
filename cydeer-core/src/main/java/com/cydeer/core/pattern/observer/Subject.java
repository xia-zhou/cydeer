package com.cydeer.core.pattern.observer;

/**
 * @author Cydeer on 16/5/24.
 */
public interface Subject {

	void registerObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObserver();
}
