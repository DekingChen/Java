package dk.design.observer.weather;

public class ConcreteObserver implements Observer {

	private String observerName;
	private String weatherContents;
	private String remindContents;
	private String observerState;
	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
	public String getWeatherContents() {
		return weatherContents;
	}
	public void setWeatherContents(String weatherContents) {
		this.weatherContents = weatherContents;
	}
	public String getRemindContents() {
		return remindContents;
	}
	public void setRemindContents(String remindContents) {
		this.remindContents = remindContents;
	}
	public String getObserverState() {
		return observerState;
	}
	public void setObserverState(String observerState) {
		this.observerState = observerState;
	}
	@Override
	public void update(WeatherSubject subject) {
		weatherContents = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+" ’µΩ¡À"+weatherContents+","+remindContents);
	}

}
