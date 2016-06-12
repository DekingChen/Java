package dk.design.decorator;

public class Decorator implements Component {

	 private Component component;
	    
	 public Decorator(Component component){
	        this.component = component;
	 }

	@Override
	public void sampleOperation() {
		System.out.println("I am Decorator!!");
		component.sampleOperation();

	}

}
