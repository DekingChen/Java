package dk.design.factory;

import dk.main.Show;

public class LeftHair  extends Show implements HairInterface{

	@Override
	public void draw() {
		show("This is left hair type£¡");
	}

}
