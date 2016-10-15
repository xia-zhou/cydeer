package com.xiazhou.base.pattern.observerex;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zhangsong on 16/5/24.
 */
public class TodyBoardObserver implements Observer, DisplayElement {

	WeatherData weatherData;

	Observable observable;

	public TodyBoardObserver(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override public void update(Observable o, Object arg) {
		weatherData = (WeatherData) o;
		display();
	}

	@Override public void display() {
		System.out.println("温度:" + weatherData.getTemperature() + ";湿度:" + weatherData.getHumidity());
	}
}
