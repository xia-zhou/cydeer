package com.cydeer.core.pattern.observer;

/**
 * @author Cydeer on 16/5/24.
 */
public class WarnObserver implements Observer, DisPlayElement {
	public WarnObserver(WeatherData weatherData) {
		weatherData.registerObserver(this);
	}

	@Override public void update(double temperature, double pressure, double humidity) {
		disPlay();
	}

	@Override public void disPlay() {
		System.out.println("你又逗了吧?");
	}
}
