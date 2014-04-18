package com.runescape.revised.weather;

public class WeatherSystem {

	private static WeatherSystem weatherSystem;

	public static void setWeatherSystem(WeatherSystem weatherSystem) {
		WeatherSystem.weatherSystem = weatherSystem;
	}

	public static WeatherSystem getWeatherSystem() {
		return WeatherSystem.weatherSystem;
	}
}