package dk.design.observer;

import java.util.Observable;

public class Weather extends Observable {
	private String weatherContents;

	public String getWeatherContents() {
		return weatherContents;
	}

	public void setWeatherContents(String weatherContents) {
		this.weatherContents = weatherContents;
		this.setChanged();
		this.notifyObservers(this);
	}
	
}
