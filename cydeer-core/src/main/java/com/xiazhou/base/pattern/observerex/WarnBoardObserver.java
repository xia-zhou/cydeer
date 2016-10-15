package com.xiazhou.base.pattern.observerex;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zhangsong on 16/5/24.
 */
public class WarnBoardObserver implements Observer, DisplayElement {

	Observable observable;

	WeatherData weatherData;

	public WarnBoardObserver(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override public void display() {
		System.out.println("温度警告:" + weatherData.getTemperature() + ";气压:" + weatherData.getPressure());
		if (weatherData.getTemperature() > 30) {
			System.err.println("温度过高,请注意保湿");
		}
	}

	@Override public void update(Observable o, Object arg) {
		weatherData = (WeatherData) o;
		display();
	}
}
