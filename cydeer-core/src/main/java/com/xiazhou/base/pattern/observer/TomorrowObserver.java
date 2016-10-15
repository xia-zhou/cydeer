package com.xiazhou.base.pattern.observer;

/**
 * Created by zhangsong on 16/5/24.
 */
public class TomorrowObserver implements Observer, DisPlayElement {

	public TomorrowObserver(WeatherData weatherData) {
		weatherData.registerObserver(this);
	}

	@Override public void update(double temperature, double pressure, double humidity) {
		disPlay();
	}

	@Override public void disPlay() {
		System.out.println("hahahah ");
	}
}
