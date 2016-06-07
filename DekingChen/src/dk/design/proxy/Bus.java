package dk.design.proxy;

public class Bus extends Car {

	public void move(){
		long startime = System.currentTimeMillis();
		System.out.println("汽车开始行使："+startime);
		super.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车行使结束，行使时间："+(endtime-startime));
	}
}
