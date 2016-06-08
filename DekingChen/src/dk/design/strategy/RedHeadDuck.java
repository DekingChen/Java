package dk.design.strategy;

import dk.design.strategy.lib.FlyWithWin;

public class RedHeadDuck extends Duck {

	public RedHeadDuck(){
		super();
		super.setFlyingStrategy(new FlyWithWin());
	}
	
	@Override
	public void display() {
	System.out.println("I am RedHeadDuck");

	}

}
