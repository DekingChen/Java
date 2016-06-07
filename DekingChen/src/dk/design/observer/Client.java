/**
 * 
 */
package dk.design.observer;


/**
 * @author Administrator
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				//1.创建一个目标
				WeatherSubject weather = new WeatherSubject();
				//2.创建观察者
				WeatherObserver observerGirl = new WeatherObserver();
				observerGirl.setObserverName("DekingChen's GF");
				observerGirl.setRemindContents("I want to fuck your ass !");
				WeatherObserver observerMun = new WeatherObserver();
				observerMun.setObserverName("DekingChen's Mun");
				observerMun.setRemindContents("I love your Mother!");
				//3.注册观察者
				weather.attach(observerGirl);
				weather.attach(observerMun);
				//4.目标发布天气
				weather.setWeatherContents("Today is Good Day!Have a nice day!");
				//使用Java内部实现的观察者模式
				Weather w = new Weather();
				WeatherObj obj = new WeatherObj();
				w.addObserver(obj);
				obj.setObjName("I am God!");
				w.setWeatherContents("Today is a good day!");

	}

}
