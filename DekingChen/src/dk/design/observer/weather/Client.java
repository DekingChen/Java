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
		//1.����һ��Ŀ��
		ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
		//2.�����۲���
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("DekingChen's GF");
		observerGirl.setRemindContents("Fuck your ass !");
		
		ConcreteObserver observerMun = new ConcreteObserver();
		observerMun.setObserverName("DekingChen's Mun");
		observerMun.setRemindContents("I love your Mother!");
		//3.ע��۲���
		weather.attach(observerGirl);
		weather.attach(observerMun);
		//4.Ŀ�귢������
		weather.setWeatherContent("Today is Good Day!Have a nice day!");
	}

}
