package dk.design.strategy;

import dk.design.strategy.lib.FlyNoWay;

public class YellowDuck extends Duck {

	public YellowDuck(){
		super();
		super.setFlyingStrategy(new FlyNoWay());
	}
	@Override
	public void display() {
		System.out.println("I am YellowDuck£¡");
	}
	
	public void quack(){
		System.out.println("Fuck,Fuck,Fuck....");
	}

}
