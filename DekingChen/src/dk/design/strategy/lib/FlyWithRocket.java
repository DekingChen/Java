package dk.design.strategy.lib;

import dk.design.strategy.FlyingStrategy;

public class FlyWithRocket implements FlyingStrategy {

	@Override
	public void performFly() {
		System.out.println("I fly with Rocket!");
	}

}
