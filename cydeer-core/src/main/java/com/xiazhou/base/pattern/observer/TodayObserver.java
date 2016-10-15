package com.xiazhou.base.pattern.observer;

/**
 * Created by zhangsong on 16/5/24.
 */
public class TodayObserver implements Observer, DisPlayElement {

	private WeatherData weatherData;

	private double temperature;

	private double pressure;

	private double humidity;

	public TodayObserver(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override public void update(double temperature, double pressure, double humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		disPlay();
	}

	@Override public void disPlay() {
		System.out.println("当前的温度是:" + temperature + ",气压是:" + pressure + ";湿度是:" + humidity);
	}
}
