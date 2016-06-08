package dk.design.strategy;

import dk.design.strategy.lib.FlyWithWin;

public class BlueDuck extends Duck {

	
	public BlueDuck(){
		super();
		super.setFlyingStrategy(new FlyWithWin());
	}
	@Override
	public void display() {
		System.out.println("I am BlueDuck");
	}

}
