package dk.design.proxy;

public class Bus extends Car {

	public void move(){
		long startime = System.currentTimeMillis();
		System.out.println("������ʼ��ʹ��"+startime);
		super.move();
		long endtime = System.currentTimeMillis();
		System.out.println("������ʹ��������ʹʱ�䣺"+(endtime-startime));
	}
}
