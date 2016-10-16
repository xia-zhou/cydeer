package com.cydeer.core.pattern.observerex;

/**
 * @author Cydeer on 16/5/24.
 */
public class ObserverTest {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		TodyBoardObserver todyBoardObserver = new TodyBoardObserver(weatherData);
		WarnBoardObserver warnBoardObserver = new WarnBoardObserver(weatherData);
		/*weatherData.setData(18,20,35);
		weatherData.setData(25,38,12);*/
		weatherData.setData(45, 38, 12);

	}
}
