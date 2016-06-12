package dk.design.decorator;

public class Bird extends Change {

	public Bird(TheGreatestSage sage) {
		super(sage);
	}
	 @Override
	public void move() {
		    beforeChange();
	        System.out.println("Bird Move");
	        afterChange();
	 }

}
