package dk.design.strategy.lib;

import dk.design.strategy.FlyingStrategy;

public class FlyWithWin implements FlyingStrategy {

	@Override
	public void performFly() {
		System.out.println("I fly with wings");
	}

}
