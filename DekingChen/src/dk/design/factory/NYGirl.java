package dk.design.factory;

import dk.main.Show;

public class NYGirl extends Show implements Girl {

	@Override
	public void drawGirl() {
		show("I am NYGirl!");
	}

}
