package dk.design.proxy;

public class CarLogProxy implements Moveable {

private Moveable car;
	
	public CarLogProxy(Moveable m) {
		super();
		this.car = m;
	}

	@Override
	public void move() {
		System.out.println("汽车开始记录日志");
		car.move();
		System.out.println("汽车结束记录日志");
	}

}
