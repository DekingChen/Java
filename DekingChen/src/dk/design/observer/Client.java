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
				//1.����һ��Ŀ��
				WeatherSubject weather = new WeatherSubject();
				//2.�����۲���
				WeatherObserver observerGirl = new WeatherObserver();
				observerGirl.setObserverName("DekingChen's GF");
				observerGirl.setRemindContents("I want to fuck your ass !");
				WeatherObserver observerMun = new WeatherObserver();
				observerMun.setObserverName("DekingChen's Mun");
				observerMun.setRemindContents("I love your Mother!");
				//3.ע��۲���
				weather.attach(observerGirl);
				weather.attach(observerMun);
				//4.Ŀ�귢������
				weather.setWeatherContents("Today is Good Day!Have a nice day!");
				//ʹ��Java�ڲ�ʵ�ֵĹ۲���ģʽ
				Weather w = new Weather();
				WeatherObj obj = new WeatherObj();
				w.addObserver(obj);
				obj.setObjName("I am God!");
				w.setWeatherContents("Today is a good day!");

	}

}
