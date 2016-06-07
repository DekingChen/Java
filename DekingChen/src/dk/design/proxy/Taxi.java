package dk.design.proxy;

public class Taxi implements Moveable {

	private Car car;
	
	public Taxi(Car car) {
		super();
		this.car = car;
	}


	@Override
	public void move() {
		long startime = System.currentTimeMillis();
		System.out.println("汽车开始行使："+startime);
		car.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车行使结束，行使时间："+(endtime-startime));
	}

}
