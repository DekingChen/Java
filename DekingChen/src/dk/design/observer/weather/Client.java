/**
 * 
 */
package dk.design.observer.weather;

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
		ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
		//2.创建观察者
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("DekingChen's GF");
		observerGirl.setRemindContents("Fuck your ass !");
		
		ConcreteObserver observerMun = new ConcreteObserver();
		observerMun.setObserverName("DekingChen's Mun");
		observerMun.setRemindContents("I love your Mother!");
		//3.注册观察者
		weather.attach(observerGirl);
		weather.attach(observerMun);
		//4.目标发布天气
		weather.setWeatherContent("Today is Good Day!Have a nice day!");
	}

}
