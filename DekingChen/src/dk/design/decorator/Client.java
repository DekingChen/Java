/**
 * 
 */
package dk.design.decorator;

/**
 * @author Administrator
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Component concrete = new ConcreteComponent();
		Component decorator = new ConcreteDecoratorA(concrete);
		decorator.sampleOperation();*/
		TheGreatestSage sage = new Monkey();
        // 第一种写法
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(bird);
        // 第二种写法
        //TheGreatestSage fish = new Fish(new Bird(sage));
        fish.move(); 
		
		
	}

}
