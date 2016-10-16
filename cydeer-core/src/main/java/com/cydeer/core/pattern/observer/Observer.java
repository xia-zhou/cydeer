package com.cydeer.core.pattern.observer;

/**
 * @author Cydeer on 16/5/24.
 */
public interface Observer {
	void update(double temperature, double pressure, double humidity);
}
