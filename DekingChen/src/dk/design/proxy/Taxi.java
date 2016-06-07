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
		System.out.println("������ʼ��ʹ��"+startime);
		car.move();
		long endtime = System.currentTimeMillis();
		System.out.println("������ʹ��������ʹʱ�䣺"+(endtime-startime));
	}

}
