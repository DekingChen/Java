package dk.design.decorator;

public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}
	 @Override
	public void sampleOperation() {
		 System.out.println("I am ConcreteDecoratorA!!");
		 super.sampleOperation();
	}
}
