package dk.design.decorator;

public class Fish extends Change {

	public Fish(TheGreatestSage sage) {
		super(sage);
	}
    public void move() {
        // ����
    	beforeChange();
        System.out.println("Fish Move");
        afterChange();
    }

}
