package dk.design.observer;

public class WeatherSubject extends Subject {
	private String weatherContents;

	public String getWeatherContents() {
		return weatherContents;
	}

	public void setWeatherContents(String weatherContents) {
		this.weatherContents = weatherContents;
		this.notifyObservers();
	}
	

}
