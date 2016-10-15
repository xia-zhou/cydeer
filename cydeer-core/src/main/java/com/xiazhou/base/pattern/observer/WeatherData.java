package com.xiazhou.base.pattern.observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsong on 16/5/24.
 */
public class WeatherData implements Serializable, Subject {

	private double temperature;

	private double humidity;

	private double pressure;

	private List<Observer> observerList = new ArrayList<>();

	@Override public void registerObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override public void removeObserver(Observer observer) {
		int index = observerList.indexOf(observer);
		if (index >= 0) {
			observerList.remove(index);
		}
	}

	@Override public void notifyObserver() {
		for (Observer observer : observerList) {
			observer.update(temperature, pressure, humidity);
		}
	}

	public void measurementsChanged() {
		notifyObserver();
	}

	public void setData(double temperature, double pressure, double humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementsChanged();
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

}
