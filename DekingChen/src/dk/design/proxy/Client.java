/**
 * 
 */
package dk.design.proxy;

/**
 * @author Administrator
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String args[]){
		Car car = new Car();
		car.move();
		
		Bus bus = new Bus();
		bus.move();
		
		Taxi taxi = new Taxi(car);
		taxi.move();
		
		CarTimeProxy proxy = new CarTimeProxy(car);
		CarLogProxy  logproxy = new CarLogProxy(proxy);
		logproxy.move();
		
	}

}
