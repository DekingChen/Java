package dk.design.strategy.lib;

import dk.design.strategy.FlyingStrategy;

public class FlyNoWay implements FlyingStrategy{

	@Override
	public void performFly() {
		System.out.println("I can not fly!");
	}

}
