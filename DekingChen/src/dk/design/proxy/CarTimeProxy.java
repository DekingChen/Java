package dk.design.proxy;

public class CarTimeProxy implements Moveable {

	private Moveable car;
	
	public CarTimeProxy(Moveable m) {
		super();
		this.car = m;
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
