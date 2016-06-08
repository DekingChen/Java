package dk.design.strategy;

import dk.design.strategy.lib.FlyWithRocket;

public class SkyDuck extends Duck {

	public SkyDuck(){
		super();
		super.setFlyingStrategy(new FlyWithRocket());
	}
	@Override
	public void display() {
		System.out.println("I am SkyDuck!!!");
	}
	
	public void quack(){
		System.out.println("Ha,Ha,Ha....");
	}

}
