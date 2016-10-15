package com.xiazhou.base.pattern.observerex;

import java.util.Observable;

/**
 * Created by zhangsong on 16/5/24.
 */
public class WeatherData extends Observable {
	private double temperature;

	private double pressure;

	private double humidity;

	private void measureChange() {
		setChanged();
		notifyObservers();
		notifyObservers(this);
	}

	public void setData(double temperature, double pressure, double humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measureChange();
	}

	public double getTemperature() {
		return temperature;
	}

	public double getPressure() {
		return pressure;
	}

	public double getHumidity() {
		return humidity;
	}
}
