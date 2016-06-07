package dk.design.proxy;

public class CarLogProxy implements Moveable {

private Moveable car;
	
	public CarLogProxy(Moveable m) {
		super();
		this.car = m;
	}

	@Override
	public void move() {
		System.out.println("������ʼ��¼��־");
		car.move();
		System.out.println("����������¼��־");
	}

}
