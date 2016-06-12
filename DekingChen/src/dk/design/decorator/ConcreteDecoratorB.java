package dk.design.decorator;

public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB(Component component) {
		super(component);
	}
	public void sampleOperation(){
		
		System.out.println("I am ConcreteDecoratorB!!");
		super.sampleOperation();
	}
}
