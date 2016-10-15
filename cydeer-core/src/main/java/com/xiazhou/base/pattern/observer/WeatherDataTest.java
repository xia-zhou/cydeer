package com.xiazhou.base.pattern.observer;

/**
 * Created by zhangsong on 16/5/24.
 */
public class WeatherDataTest {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		TodayObserver todayObserver = new TodayObserver(weatherData);
		new TomorrowObserver(weatherData);
		new WarnObserver(weatherData);
		weatherData.setData(23, 45, 23);
		weatherData.setData(46, 54, 65);
		weatherData.setData(12, 32, 43);
		weatherData.setData(6436, 354, 23);
	}
}
